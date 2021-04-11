package com.kaysanshi.design_pattern.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
// 定义一个类加载器

/**
 * ClassLoader类使用委托模型搜索类和资源。 每个ClassLoader实例都有一个关联的父类加载器。 当请求查找类或资源时，
 * ClassLoader实例会将对类或资源的搜索委托给其父类加载器，然后再尝试查找类或资源本身。 虚拟机的内置类加载器（称为“引导类加载器”）本身没有父级，
 * 但可以用作ClassLoader实例的父级
 */
public class KClassLoader extends ClassLoader{

    private File classPathFile;

    public KClassLoader(){
        // 获取KClassLoader类的路径
        String classPath = KClassLoader.class.getResource("").getPath();
        this.classPathFile=new File(classPath);
    }

    /**
     * 查找具有指定的<a href="name">二进制名称<a>的类。该方法应由遵循用于加载类的委托模型的类加载器实现重写，
     * 并且将在检查父类加载器中的所请求类之后由{@link loadClass <tt> loadClass <tt>}方法调用
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取 class的name xxx.package.name
        String className= KClassLoader.class.getPackage().getName()+"."+name;
        if(classPathFile !=null){
            // 创建文件
            File classFile = new File(classPathFile,name.replaceAll("\\.","/")+".class");
            if (classFile.exists()){
                FileInputStream inputStream =null;
                ByteArrayOutputStream outputStream=null;
                try {
                    inputStream = new FileInputStream(classFile);
                    outputStream = new ByteArrayOutputStream();
                    byte [] buffer = new byte[1024];
                    int len;
                    // 读取并写入流中
                    while((len = inputStream.read(buffer))!=-1){
                        outputStream.write(buffer,0,len);
                    }
                    // 将字节数组转换为Class类的实例。 在使用该类之前，必须先对其进行解析。
                    //此方法将默认的ProtectionDomain分配给新定义的类。
                    // Policy.getPolicy().getPermissions(new CodeSource(null, null))时，
                    // 将有效地授予ProtectionDomain相同的权限集。 默认域在第一次调用defineClass创建，并在后续调用中重用
                    return defineClass(className,outputStream.toByteArray(),0,outputStream.size());

                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                    if(inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if(outputStream!=null){
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return null;
    }
}
