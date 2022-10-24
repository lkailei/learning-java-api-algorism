package com.kaysanshi.design_pattern.proxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成源代码的工具类
 */
public class KProxy {
    public static final String ln = "\r\n";

    public static Object newProxyInstance(KClassLoader classLoader, Class<?>[] interfaces, KInVocationHandler inVocationHandler) {
        try {
            // 动态生成源代码 .java文件
            String src = generateSrc(interfaces);

            // java文件输出磁盘输出成$Proxy0.java的文件
            String filePath = KProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();

            // 把生成的.java文件编译成.class文件
            // 获取与此平台一起提供的Java™编程语言编译器。
            JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
            // 获取此工具的标准文件管理器实现的新实例。文件管理器将使用给定的诊断侦听器来生成任何非致命的诊断。致命错误将以适当的例外方式发出信号
            StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
            // 获取表示给定文件的文件对象。
            Iterable<? extends JavaFileObject> iterable = standardFileManager.getJavaFileObjects(file);
            // 使用给定的组件和参数为编译任务创建未来。如CompilationTask界面中所述，编译可能尚未完成
            JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, standardFileManager, null, null, null, iterable);
            // 执行此编译任务。编译只能执行一次。随后对该方法的调用抛出IllegalStateException
            task.call();
            standardFileManager.close();
            // 把编译后生成.class的文件加载到jvm中
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(KInVocationHandler.class);
            // 删除生的文件
            file.delete();
            // 返回字节码重组以后的新的代理对象
            return constructor.newInstance(inVocationHandler);
        } catch (Exception e) {

        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        // 线程安全
        StringBuffer buffer = new StringBuffer();
        // 加入头文件
        buffer.append("package com.kaysanshi.design_pattern.proxy;" + ln)
                .append("import com.kaysanshi.design_pattern.proxy.Person;" + ln)
                .append("import java.lang.reflect.*;" + ln)
                .append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln)
                .append("KInVocationHandler inVocationHandler;" + ln)
                .append("public $Proxy0(KInVocationHandler inVocationHandler) {" + ln)
                .append("this.inVocationHandler = inVocationHandler;" + ln)
                .append("}" + ln);
        for (Method method : interfaces[0].getMethods()) {
            // 反射的中的获取参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class clazz = parameterTypes[i];
                String type = clazz.getName();
                // 返回源代码中给定的基础类的简单名称。如果基础类是匿名的，则返回一个空字符串
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if (i > 0 && i < parameterTypes.length - 1) {
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }
            // 创建方法
            buffer.append(" public  " + method.getReturnType().getName() + " " + method.getName() + "("
                    + paramNames.toString() + ") {" + ln)
                    .append("try{" + ln)
                    .append("Method m=" + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{" +
                            paramClasses.toString() + "});" + ln)
                    .append((hasReturnValue(method.getReturnType()) ? "return " : "") + getCaseCode("this.inVocationHandler.invoke(this,m,new Object[]{" + paramValues + "})", method.getReturnType()) + ";" + ln)
                    .append("}catch(Error _ex){}")
                    .append("catch(Throwable e){"+ln)
                    .append("throw new UndeclaredThrowableException(e);"+ln)
                    .append("}"+ln)
                    .append(getReturnEmptyCode(method.getReturnType()))
                    .append("}");
        }
        buffer.append("}" + ln);
        return buffer.toString();
    }




    private static Map<Class,Class> mappings = new HashMap<>();
    static {
        mappings.put(int.class,Integer.class);
    }
    /**
     * 首字母小写
     *
     * @param simpleName
     * @return
     */
    private static String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 判断是否有返回
     * @param returnType
     * @return
     */
    private static boolean hasReturnValue(Class<?> returnType) {
        return returnType!=void.class;
    }

    /**
     *
     * @param
     * @param returnType
     * @return
     */
    private static String getCaseCode(String code, Class<?> returnType) {
        if(mappings.containsKey(returnType)){
            return "(("+mappings.get(returnType).getName()+")"+code+")."+returnType.getSimpleName()+"Value()";
        }
        return code;
    }
    private static String getReturnEmptyCode(Class<?> returnType) {
        if(mappings.containsKey(returnType)){
            return  "return 0;";
        }else if(returnType == void.class){
            return "";
        }else{
            return "return null;";
        }
    }

}
