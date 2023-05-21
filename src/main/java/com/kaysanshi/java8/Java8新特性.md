# Java8新特性

## lambda

### Lambda表达式

```
Lambda表达式：
* lambda是一个匿名函数可以理解为可传递的代码
* 举例： (o1, o2) -> Integer.compare(o1,o2)
* 格式：
*      -> ：lambda表达式的操作符， 或  箭头函数的操作符
*      (左边)-> ：左边是lambda的形参列表，其实就是接口中的抽象方法的形参列表
*      ->(右边) lambda体，其实就是重写的抽象的方法体 使用{}包裹， 省略{}必须胜率return
*  3.lambda表达式的使用 分6中情况介绍
**     1：无参，无返回值
*     2：需要一个参数，无返回值
*     3：数据类型可省略，由编辑器进行类型推断，“类型推断”
*     4：lambda若只需要一个参数则参数小括号可省
*     5：Lambda需要两个或以上的参数，多条执行语句，并且可有返回值
*     6：Lambda体只有一条语句时，return与大括号若有则都可以省去
*  4.lambda表达式的本质：作为接口的实例
*  函数式接口 java.util.function包：
*  5.如果一个接口中，只声明一个抽象方法，这个接口的称为函数式接口
*  函数式接口：只包含一个抽象方法。
*  可以使用@@FunctionalInterface检验一个接口是不是函数式接口。
*  6.以前的匿名实现类表示的现在都可以用lambda表达式书写。
```

### 函数式接口

函数式接口就是只包含一个方法的接口，比如java.lang.Runnable和java.utilComparetor就是个典型的函数式接口，因为他们只包含一个接口。java8提供`@Functionalinterface`作为注解，只要接口符合函数式接口的标准，虚拟机会自动判断，但是使用建议添加`@Functionalinterface`进行声明，java中的lambda无法单独出现，他需要一个函数接口盛放他

#### 内置基本类型函数式接口

| 函数式接口                 | 参数类型 | 返回类型 | 用途                                                         |
| -------------------------- | :------: | -------- | ------------------------------------------------------------ |
| `Consummer<T>`消费性       |    T     | Void     | 对类型T的对象应用操作包括方法：void accept(T t)              |
| `Supplier<T>` 供给型接口   |    无    | T        | 返回为T的对象，包含方法：T get()                             |
| `Function<T,R>` 函数型接口 |    T     | R        | 消费型为T的对象应用操作，并返回结果，结果为R类型的对象，包含方法：R apply（T t） |
| `Predicate<T>` 断定型接口  |    T     | boolean  | 确定类型为T的对象是否满足某约束，并返回boolean值，包含 boolean test(T t) |

```java
/**
 * @Author kay三石
 * @date:2020/2/26
 * java内置的4大核心的函数式接口
 *
 * 消费型接口 Comsumer<T>  void accept(T t)
 * 供给型接口 Supplier<T>  T get()
 * 函数型接口 Function<T>  R apply(T t)
 * 断定型接口 Predicate<T> boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test1(){
        happyTime(500, new Consumer <Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.print("dddd"+aDouble);
            }
        });
        ////////////
        happyTime(500,money->System.out.print("lambda:" +money));
    }


    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        List<String> list=new ArrayList <>(Arrays.asList("北京","南京","天井"));
        List <String> list1 = filterString(list, new Predicate <String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        List <String> list2 = filterString(list, s -> s.contains("京"));
        System.out.println(list2);

    }
    // 根据给定的规则，过滤集合中的字符串，此规则由Predicate定义
    public List<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList <String> objects = new ArrayList <>();
        for (String s:list){
            if(predicate.test(s)){
                objects.add(s);
            }
        }
        return objects;
    }
}
```



#### Lambda语法：

1.一个括号内用逗号进行分割的形式的参数，参数是函数式接口里面方法的参数，

2.一个箭头括号：`->`

3.方法体，可以是表达式和代码块，方法体函数式接口里面的方法的实现，如果代码块则必须用`{}`进行包裹起来且需要return返回值，但如果函数式接口里面的方法返回值是void则无需`{}`

```
(parameters) -> expression 或者 (parameters) -> { statements; }
```

```java
public class TestLambda {
    /**
     * lambada直接省略了run，而是直接创建了一个Thread方法，这个个类是无返回值的所以就可以直接调用run。
     * 
     */
    public static void runThreadUseLambda() {
        //Runnable是一个函数接口，只包含了有个无参数的，返回void的run方法；
        //所以lambda表达式左边没有参数，右边也没有return，只是单纯的打印一句话
        new Thread(() ->System.out.println("lambda实现的线程")).start();
    }

    public static void runThreadUseInnerClass() {
        //这种方式就不多讲了，以前旧版本比较常见的做法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类实现的线程");
            }
        }).start();
    }

    public static void main(String[] args) {
        TestLambda.runThreadUseLambda();
        TestLambda.runThreadUseInnerClass();
    }
}

```

#### 方法引用：

其实是lambda表达式的一个简化写法，所引用的方法其实是lambda表达式的方法体实现，语法也很简单，左边是容器（可以是类名，实例名），中间是”::”，右边是相应的方法名。如下所示：

```
ObjectReference::methodName
```

<font color="blue">当要传递给lambda体的操作，已经实现的方法了，可以使用方法引用。</font>

使用方法引用的要求：要求接口中的抽象方法的形参列表和返回值的形参列表和返回值类型相同

<font color="red">方法引用可以看做lambda表达式深层次的表达。换句话说方法引用就是lambda表达式，是一个函数式接口实例。实现接口的抽象方法的参数列表和返回值类型必须和方法引用的类型保持一致}</font>

```java
package com.kaysanshi.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author kay三石
 * @date:2020/5/2
 * 方法引用的使用要求：
 * 要求接口中的抽象方法的形参列表和返回值的与引用的方法形参列表和返回值类型相同
 */
public class MethodRefTest {
    // 可以分为以下三种情况
    //对象:: 非静态方法
    //类::静态方法
    // 类::非静态方法(以前不可以这这样)
    // Consumer中的void accept(T t)
    //PrintSteam中的 void println(T t)
    @Test
    public void test1() {
        Consumer <String> con1 = str -> System.out.println(str);
        con1.accept("北京");
        System.out.println("************************");
        PrintStream ps = System.out;
        Consumer <String> con2 = ps::println;
        con2.accept("AAA");
    }

    /**
     * Supplier 中的 T get();
     * Employee中的 String getName();
     */
    @Test
    public void test2() {
        Employee employee = new Employee();
        employee.setName("TOM");
        Supplier <String> supplier = () -> employee.getName();
        System.out.print(supplier.get());
        System.out.println("----------------");
        Supplier <String> supplier1 = employee::getName;
        System.out.print(supplier1.get());

    }

    /**
     * 情况二： 类::静态方法
     * Comparator 中的int compare(T t1,T t2);
     * Integer int compare();
     */
    @Test
    public void test3() {
        Comparator <Integer> comparator = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator.compare(1, 2));

        Comparator <Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(12, 3));

    }

    /**
     * Function 中的R apply(T t1);
     * Math中的 Long round(Double d);
     */
    @Test
    public void test4() {
        Function <Double, Long> function1 = new Function <Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(12.3);
            }
        };
        Function <Double, Long> function = d -> Math.round(d);
        System.out.println(function.apply(12.2));
        Function <Double, Long> function2 = Math::round;
        System.out.println(function2.apply(12.8));
    }

    /**
     * 情况三： 类::实例方法
     * Comparator 中的int compare(T t1,T t2);
     * String int t1.compareTo(t2);
     */
    @Test
    public void test5() {
        Comparator<String> comparator= (t1,t2)->t1.compareTo(t2);
        System.out.println(comparator.compare("abc","abd"));

        Comparator<String> comparator1=String::compareTo;
        System.out.println(comparator1.compare("abcs","aaa"));

    }
    /**
     *BiPredicate 中的boolean test(T t1,T t2)
     * String boolean t1.equals(t2)
     */
    @Test
    public void test6(){
        BiPredicate<String,String> predicate=(s1,s2)->s1.equals(s2);
        System.out.println(predicate.test("abc","abd"));

        BiPredicate<String,String> predicate2=String::equals;
        System.out.println(predicate2.test("abc","abd"));
    }
    /**
     *Function中的R apply(T t)
     * Employee中的String getName()
     */
    @Test
    public void test7(){
        Employee employee=new Employee();
        employee.setName("Tom");
        Function<Employee,String> comparator= e->e.getName();
        System.out.println(comparator.apply(employee));

        Function<Employee,String> comparator2=Employee::getName;
        System.out.println(comparator2.apply(employee));

    }
}
```

一般方法的引用格式是

1. 如果是静态方法，则是ClassName::methodName。如 Object ::equals
2. 如果是实例方法，则是Instance::methodName。如Object obj=new Object();obj::equals;
3. 构造函数.则是ClassName::new

```java
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        JButton button1 = new JButton("点我!");
        JButton button2 = new JButton("也点我!");

        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        //这里addActionListener方法的参数是ActionListener，是一个函数式接口
        //使用lambda表达式方式
        button1.addActionListener(e -> { System.out.println("这里是Lambda实现方式"); });
        //使用方法引用方式
        button2.addActionListener(TestLambda2::doSomething);

    }
    /**
     * 这里是函数式接口ActionListener的实现方法
     * @param e
     */
    public static void doSomething(ActionEvent e) {

        System.out.println("这里是方法引用实现方式");

    }
	
///方法引用本质就是lambda
// 使用格式： 类::方法名
// 可以分为以下三种情况
	对象:: 非静态方法
	类::静态方法
	类::非静态方法(以前不可以这这样)
// Consumer中的void accept(T t)
//PrintSteam中的 void println(T t)
public void test1(){
    Consumer<String> con1 = str->System.out.println(str)
    con1.accept("北京")
    PrintStream ps=System.out;
    Cousumer con2 =ps::println;   
}
```

```java
package com.kaysanshi.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author kay三石
 * @date:2020/5/2
 *
 *
 * 构造器引用
 *      和方法引用类似，函数式接口的抽象方法形参列表和构造器形参方法一致，
 *      抽象方法返回值即为构造器所属类型。
 * 数组引用
 *
 */
public class ConstructorRefTest {

    //Supplier 中的T get()
    @Test
    public void test1(){
        Supplier<Employee> supplierOld= new Supplier <Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        Supplier<Employee> supplier=()->new Employee();
        supplier.get();
        Supplier<Employee> supplier2=Employee::new;
        System.out.println(":"+supplier2.get());;
    }
    //Function 中的R apply(T t)
    @Test
    public void test2(){
        Function<String,Employee> function =name->new Employee(name);
        Employee employee=function.apply("TOME");
        System.out.print(employee);
        //
        Function<String,Employee> function2 =Employee::new;
        Employee employee1=function2.apply("TOME");
        System.out.print(employee1);
    }
    @Test
    public void test3(){
//        BiFunction<String,String,Employee> function=(id,name)->new Employee(id,name);
    }

    /**
     * 数组引用
     */
    // Function 中的R apply(T t)
    public void test4(){
        Function<Integer,String[]> function =length->new String[length];
        String[] apply = function.apply(5);
        System.out.print(Arrays.toString(apply));
        ///////

        Function<Integer,String[]> function1=String[]::new;

    }
}

```

### 默认方法

简单说，就是接口可以有实现方法，而且不需要实现类去实现其方法。只需在方法名前面加个default关键字即可。加入default声明，这个方法就默认被接口实现了。

为什么要有这个特性？首先，之前的接口是个双刃剑，好处是面向抽象而不是面向具体编程，缺陷是，当需要修改接口时候，需要修改全部实现该接口的类，目前的java 8之前的集合框架没有foreach方法，通常能想到的解决办法是在JDK里给相关的接口添加新的方法及实现。然而，对于已经发布的版本，是没法在给接口添加新方法的同时不影响已有的实现。所以引进的默认方法。他们的目的是为了解决接口的修改与现有的实现不兼容的问题。

```java
public interface A {
    default void foo(){
       System.out.println("Calling A.foo()");
    }
}

public class Clazz implements A {
    public static void main(String[] args){
       Clazz clazz = new Clazz();
       clazz.foo();//调用A.foo()
    }
}
```

这一个功能特性出来后，好像和抽象类有那么点看着一样的，java 8的接口都有实现方法了，跟抽象类还有什么区别？其实还是有的，请看下表对比。。

| 相同点                                      | 不同点                                      |
| ---------------------------------------- | ---------------------------------------- |
| 1.都是抽象类型；                                | 1.抽象类不可以多重继承，接口可以（无论是多重类型继承还是多重行为继承）；    |
| 2.都可以有实现方法（以前接口不行）；                      | 2.抽象类和接口所反映出的设计理念不同。其实抽象类表示的是”is-a”关系，接口表示的是”like-a”关系； |
| 3.都可以不需要实现类或者继承者去实现所有方法，（以前不行，现在接口中默认方法不需要实现者实现） | 3.接口中定义的变量默认是public static final 型，且必须给其初值，所以实现类中不能改变其值；抽象类中的变量默认是 friendly 型，其值可以在子类中重新定义，也可以重新赋值。 |

这样一来如果我有的接口的方法名称都相同，但是实现结果不同，那么对于实现类就有一些问题了，由于同一个方法可以从不同接口引入，自然而然的会有冲突的现象，默认方法判断冲突的规则如下：

1.一个声明在类里面的方法优先于任何默认方法（classes always win）

2.否则，则会优先选取最具体的实现，比如下面的例子 B重写了A的hello方法。

使用形式就变为这样了：

```java
public interface A{
  default void hello (){
    System.out.println("hello A")
  }
}

public interface B extends A{
  default void hello(){
     System.out.println("hello B")
  }
}
public class C implements B,A{
  new C().hello()/// 这里会输出B.因为会选择最具体实现的。
}
//如果想调用A的默认函数，则用到新语法X.super.m(…),下面修改C类，实现A接口，重写一个hello方法
public class C implements A{

    @Override
    public void hello(){
        A.super.hello();
    }

    public static void main(String[] args){
        new C().hello();
    }
}
```

默认方法给予我们修改接口而不破坏原来的实现类的结构提供了便利，目前java 8的集合框架已经大量使用了默认方法来改进了，当我们最终开始使用Java 8的lambdas表达式时，提供给我们一个平滑的过渡体验。也许将来我们会在API设计中看到更多的默认方法的应用。

### 集合中操作

#### 迭代元素

```java
List persons = asList(new Person("Joe"), new Person("Jim"), new Person("John"));
for (Person p :  persons) {
   p.setLastName("Doe");
}
```

```java
persons.forEach(p->p.setLastName("Doe"));
```

原本的外部迭代方式具有线程安全问题，而现在是由jdk 库来控制循环了，我们不需要关心last name是怎么被设置到每一个person对象里面去的，库可以根据运行环境来决定怎么做，并行，乱序或者懒加载方式。这就是内部迭代，客户端将行为p.setLastName当做数据传入api里面。

#### StreamAPI

流（Stream）仅仅代表着数据流，并没有数据结构，所以他遍历完一次之后便再也无法遍历（这点在编程时候需要注意，不像Collection，遍历多少次里面都还有数据），它的来源可以是Collection、array、io等等。

StreamAPI把真正的函数式编程风格引入到java中。这是母亲为止对java类库最好的补充，因为StreamAPI极大的提供java程序员的生产力，让程序员写出高效干净简洁的代码。

Stream和Collection集合的区别：Collection是一种静态的内存数据结构，而Stream是有关计算的，

Stream的操作三个步骤：1.创建Stream,2,中间操作，3.终止操作、



##### 中间与终点方法

流作用是提供了一种操作大数据接口，让数据操作更容易和更快。它具有过滤、映射以及减少遍历数等方法，这些方法分两种：中间方法和终端方法，“流”抽象天生就该是持续的，中间方法永远返回的是Stream，因此如果我们要获取最终结果的话，必须使用终点操作才能收集流产生的最终结果。区分这两个方法是看他的返回值，如果是Stream则是中间方法，否则是终点方法。具体请参照[Stream的api](http://download.java.net/jdk8/docs/api/java/util/stream/Stream.html)。

多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否者中间操作不会执行任何的处理。而在终止操作时一次性全部处理，成为“惰性求值”

简单介绍下几个中间方法（filter、map）以及终点方法（collect、sum）

| 方法                | 描述                                                         |
| ------------------- | ------------------------------------------------------------ |
| filter(Predicate)   | 接收Lambda,从流中排除某些元素                                |
| distinct()          | 筛选，通过流生成元素的hashCode()和equals()去除重复元素       |
| limit(long maxSize) | 截断流，使其不超过给定数量                                   |
| skip(long n)        | 跳过元素，返回一个扔掉前n个元素的流，若流中元素不足，返回一个空流，与limit(n)互补 |



##### **Filter**

在数据流中实现过滤功能是首先我们可以想到的最自然的操作了。Stream接口暴露了一个filter方法，它可以接受表示操作的[Predicate](http://javadocs.techempower.com/jdk18/api/java/util/function/Predicate.html)实现来使用定义了过滤条件的lambda表达式。

```java
List persons = …
Stream personsOver18 = persons.stream().filter(p -> p.getAge() > 18);//过滤18岁以上的人

```

##### **Map**

假使我们现在过滤了一些数据，比如转换对象的时候。Map操作允许我们执行一个[Function](http://javadocs.techempower.com/jdk18/api/java/util/function/Function.html)的实现（Function的泛型T,R分别表示执行输入和执行结果），它接受入参并返回。首先，让我们来看看怎样以匿名内部类的方式来描述它：

```java
Stream adult= persons
              .stream()
              .filter(p -> p.getAge() > 18)
              .map(new Function() {
                  @Override
                  public Adult apply(Person person) {
                     return new Adult(person);//将大于18岁的人转为成年人
                  }
              });

```

现在，把上述例子转换成使用lambda表达式的写法：

```java
Stream map = persons.stream()
                    .filter(p -> p.getAge() > 18)
                    .map(person -> new Adult(person));

```

##### **终止操作：Count**

count方法是一个流的终点方法，可使流的结果最终统计，返回int，比如我们计算一下满足18岁的总人数

```java
int countOfAdult=persons.stream()
                       .filter(p -> p.getAge() > 18)
                       .map(person -> new Adult(person))
                       .count();

```

##### **终止操作：Collect**

collect方法也是一个流的终点方法，可收集最终的结果

```java
List adultList= persons.stream()
                       .filter(p -> p.getAge() > 18)
                       .map(person -> new Adult(person))
                       .collect(Collectors.toList());

```

或者，如果我们想使用特定的实现类来收集结果：

```java
List adultList = persons
                 .stream()
                 .filter(p -> p.getAge() > 18)
                 .map(person -> new Adult(person))
                 .collect(Collectors.toCollection(ArrayList::new));

```

篇幅有限，其他的中间方法和终点方法就不一一介绍了，看了上面几个例子，大家明白这两种方法的区别即可，后面可根据需求来决定使用。

#####  顺序流与并行流

每个Stream都有两种模式：顺序执行和并行执行。

顺序流：

```java
List <Person> people = list.getStream.collect(Collectors.toList());

```

并行流：

```java
List <Person> people = list.getStream.parallel().collect(Collectors.toList());

```

顾名思义，当使用顺序方式去遍历时，每个item读完后再读下一个item。而使用并行去遍历时，数组会被分成多个段，其中每一个都在不同的线程中处理，然后将结果一起输出。

######  并行流原理：

```java
List originalList = someData;
split1 = originalList(0, mid);//将数据分小部分
split2 = originalList(mid,end);
new Runnable(split1.process());//小部分执行操作
new Runnable(split2.process());
List revisedList = split1 + split2;//将结果合并

```

大家对hadoop有稍微了解就知道，里面的 MapReduce 本身就是用于并行处理大数据集的软件框架，其 处理大数据的核心思想就是大而化小，分配到不同机器去运行map，最终通过reduce将所有机器的结果结合起来得到一个最终结果，与MapReduce不同，Stream则是利用多核技术可将大数据通过多核并行处理，而MapReduce则可以分布式的。

#####  顺序与并行性能测试对比

如果是多核机器，理论上并行流则会比顺序流快上一倍，下面是测试代码

```java
long t0 = System.nanoTime();

//初始化一个范围100万整数流,求能被2整除的数字，toArray（）是终点方法

int a[]=IntStream.range(0, 1_000_000).filter(p -> p % 2==0).toArray();

long t1 = System.nanoTime();

//和上面功能一样，这里是用并行流来计算

int b[]=IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2==0).toArray();

long t2 = System.nanoTime();

//我本机的结果是serial: 0.06s, parallel 0.02s，证明并行流确实比顺序流快

System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);

```

#####  关于Folk/Join框架

应用硬件的并行性在java 7就有了，那就是 java.util.concurrent 包的新增功能之一是一个 fork-join 风格的并行分解框架，同样也很强大高效，有兴趣的同学去研究，这里不详谈了，相比Stream.parallel()这种方式，我更倾向于后者。

### 泛型的改进：

在Java SE 7中，这种方式得以改进，现在你可以使用如下语句进行声明并赋值：

```java
Map<String, String> myMap = new HashMap<>(); //注意后面的"<>"
```

在这条语句中，编译器会根据变量声明时的泛型类型自动推断出实例化HashMap时的泛型类型。再次提醒一定要注意new HashMap后面的“<>”，只有加上这个“<>”才表示是自动类型推断，否则就是非泛型类型的HashMap，并且在使用编译器编译源代码时会给出一个警告提示。

java8里面泛型的目标类型推断主要2个：

1.支持通过方法上下文推断泛型目标类型

2.支持在方法调用链路当中，泛型类型推断传递到最后一个方法

让我们看看官网的例子

```java
class List<E> {
   static <Z> List<Z> nil() { ... };
   static <Z> List<Z> cons(Z head, List<Z> tail) { ... };
   E head() { ... }
}

```

根据JEP101的特性，我们在调用上面方法的时候可以这样写

```java
//通过方法赋值的目标参数来自动推断泛型的类型
List<String> l = List.nil();
//而不是显示的指定类型
//List<String> l = List.<String>nil();
//通过前面方法参数类型推断泛型的类型
List.cons(42, List.nil());
//而不是显示的指定类型
//List.cons(42, List.<Integer>nil());
```

### 日期

目前Java8已经实现了JSR310的全部内容。新增了java.time包定义的类表示了日期-时间概念的规则，包括instants, durations, dates, times, time-zones and periods。这些都是基于ISO日历系统，它又是遵循 Gregorian规则的。最重要的一点是值不可变，且线程安全，通过下面一张图，我们快速看下[java.time](http://download.java.net/jdk8/docs/api/index.html?java/time/package-summary.html)包下的一些主要的类的值的格式，方便理解。

![img](https://wizardforcel.gitbooks.io/java8-new-features/img/f717363f035bc844993ada869f5f73fa.jpg)

![img](https://wizardforcel.gitbooks.io/java8-new-features/img/1cf489dbd3ff50bd434f38b7024a66ee.png)

左面是新的api莜面是旧的API

对比旧的日期API

| Java.time | java.util.Calendar以及Date |
| --------- | ------------------------ |
| 流畅的API    | 不流畅的API                  |
| 实例不可变     | 实例可变                     |
| 线程安全      | 非线程安全                    |

日期与时间处理API，在各种语言中，可能都只是个不起眼的API，如果你没有较复杂的时间处理需求，可能只是利用日期与时间处理API取得系统时间，简单做些显示罢了，然而如果认真看待日期与时间，其复杂程度可能会远超过你的想象，天文、地理、历史、政治、文化等因素，都会影响到你对时间的处理。所以在处理时间上，最好选用JSR310（如果你用java8的话就实现310了），或者Joda-Time。

### StampedLock解决同步问题

####  synchronized

在java5之前，实现同步主要是使用synchronized。它是Java语言的关键字，当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。

有四种不同的同步块：

1. 实例方法
2. 静态方法
3. 实例方法中的同步块
4. 静态方法中的同步块

大家对此应该不陌生，所以不多讲了，以下是代码示例

```java
synchronized(this)
// do operation
}

```

小结：在多线程并发编程中Synchronized一直是元老级角色，很多人都会称呼它为重量级锁，但是随着Java SE1.6对Synchronized进行了各种优化之后，性能上也有所提升。

####  Lock

```java
rwlock.writeLock().lock();
try {
// do operation
} finally {
rwlock.writeLock().unlock();
}

```

它是Java 5在java.util.concurrent.locks新增的一个API。

Lock是一个接口，核心方法是lock()，unlock()，tryLock()，实现类有ReentrantLock, ReentrantReadWriteLock.ReadLock, ReentrantReadWriteLock.WriteLock；

ReentrantReadWriteLock, ReentrantLock 和synchronized锁都有相同的内存语义。

与synchronized不同的是，Lock完全用Java写成，在java这个层面是无关JVM实现的。Lock提供更灵活的锁机制，很多synchronized 没有提供的许多特性，比如锁投票，定时锁等候和中断锁等候，但因为lock是通过代码实现的，要保证锁定一定会被释放，就必须将unLock()放到finally{}中

下面是Lock的一个代码示例

```java
class Point {
   private double x, y;
   private final StampedLock sl = new StampedLock();
   void move(double deltaX, double deltaY) { // an exclusively locked method
     long stamp = sl.writeLock();
     try {
       x += deltaX;
       y += deltaY;
     } finally {
       sl.unlockWrite(stamp);
     }
   }
  //下面看看乐观读锁案例
   double distanceFromOrigin() { // A read-only method
     long stamp = sl.tryOptimisticRead(); //获得一个乐观读锁
     double currentX = x, currentY = y; //将两个字段读入本地局部变量
     if (!sl.validate(stamp)) { //检查发出乐观读锁后同时是否有其他写锁发生？
        stamp = sl.readLock(); //如果没有，我们再次获得一个读悲观锁
        try {
          currentX = x; // 将两个字段读入本地局部变量
          currentY = y; // 将两个字段读入本地局部变量
        } finally {
           sl.unlockRead(stamp);
        }
     }
     return Math.sqrt(currentX * currentX + currentY * currentY);
   }
//下面是悲观读锁案例
   void moveIfAtOrigin(double newX, double newY) { // upgrade
     // Could instead start with optimistic, not read mode
     long stamp = sl.readLock();
     try {
       while (x == 0.0 && y == 0.0) { //循环，检查当前状态是否符合
         long ws = sl.tryConvertToWriteLock(stamp); //将读锁转为写锁
         if (ws != 0L) { //这是确认转为写锁是否成功
           stamp = ws; //如果成功 替换票据
           x = newX; //进行状态改变
           y = newY; //进行状态改变
           break;
         }
         else { //如果不能成功转换为写锁
           sl.unlockRead(stamp); //我们显式释放读锁
           stamp = sl.writeLock(); //显式直接进行写锁 然后再通过循环再试
         }
       }
     } finally {
       sl.unlock(stamp); //释放读锁或写锁
     }
   }
 }

```

小结：比synchronized更灵活、更具可伸缩性的锁定机制，但不管怎么说还是synchronized代码要更容易书写些

#### **StampedLock**

它是java8在java.util.concurrent.locks新增的一个API。

ReentrantReadWriteLock 在沒有任何读写锁时，才可以取得写入锁，这可用于实现了悲观读取（Pessimistic Reading），即如果执行中进行读取时，经常可能有另一执行要写入的需求，为了保持同步，ReentrantReadWriteLock 的读取锁定就可派上用场。

然而，如果读取执行情况很多，写入很少的情况下，使用 ReentrantReadWriteLock 可能会使写入线程遭遇饥饿（Starvation）问题，也就是写入线程吃吃无法竞争到锁定而一直处于等待状态。

StampedLock控制锁有三种模式（写，读，乐观读），一个StampedLock状态是由版本和模式两个部分组成，锁获取方法返回一个数字作为票据stamp，它用相应的锁状态表示并控制访问，数字0表示没有写锁被授权访问。在读锁上分为悲观锁和乐观锁。

所谓的乐观读模式，也就是若读的操作很多，写的操作很少的情况下，你可以乐观地认为，写入与读取同时发生几率很少，因此不悲观地使用完全的读取锁定，程序可以查看读取资料之后，是否遭到写入执行的变更，再采取后续的措施（重新读取变更信息，或者抛出异常） ，这一个小小改进，可大幅度提高程序的吞吐量！！

下面是java doc提供的StampedLock一个例子

```java
class Point {
   private double x, y;
   private final StampedLock sl = new StampedLock();
   void move(double deltaX, double deltaY) { // an exclusively locked method
     long stamp = sl.writeLock();
     try {
       x += deltaX;
       y += deltaY;
     } finally {
       sl.unlockWrite(stamp);
     }
   }
  //下面看看乐观读锁案例
   double distanceFromOrigin() { // A read-only method
     long stamp = sl.tryOptimisticRead(); //获得一个乐观读锁
     double currentX = x, currentY = y; //将两个字段读入本地局部变量
     if (!sl.validate(stamp)) { //检查发出乐观读锁后同时是否有其他写锁发生？
        stamp = sl.readLock(); //如果没有，我们再次获得一个读悲观锁
        try {
          currentX = x; // 将两个字段读入本地局部变量
          currentY = y; // 将两个字段读入本地局部变量
        } finally {
           sl.unlockRead(stamp);
        }
     }
     return Math.sqrt(currentX * currentX + currentY * currentY);
   }
//下面是悲观读锁案例
   void moveIfAtOrigin(double newX, double newY) { // upgrade
     // Could instead start with optimistic, not read mode
     long stamp = sl.readLock();
     try {
       while (x == 0.0 && y == 0.0) { //循环，检查当前状态是否符合
         long ws = sl.tryConvertToWriteLock(stamp); //将读锁转为写锁
         if (ws != 0L) { //这是确认转为写锁是否成功
           stamp = ws; //如果成功 替换票据
           x = newX; //进行状态改变
           y = newY; //进行状态改变
           break;
         }
         else { //如果不能成功转换为写锁
           sl.unlockRead(stamp); //我们显式释放读锁
           stamp = sl.writeLock(); //显式直接进行写锁 然后再通过循环再试
         }
       }
     } finally {
       sl.unlock(stamp); //释放读锁或写锁
     }
   }
 }

```

小结：

StampedLock要比ReentrantReadWriteLock更加廉价，也就是消耗比较小。

1. synchronized是在JVM层面上实现的，不但可以通过一些监控工具监控synchronized的锁定，而且在代码执行时出现异常，JVM会自动释放锁定；
2. ReentrantLock、ReentrantReadWriteLock,、StampedLock都是对象层面的锁定，要保证锁定一定会被释放，就必须将unLock()放到finally{}中；
3. StampedLock 对吞吐量有巨大的改进，特别是在读线程越来越多的场景下；
4. StampedLock有一个复杂的API，对于加锁操作，很容易误用其他方法;
5. 当只有少量竞争者的时候，synchronized是一个很好的通用的锁实现;
6. 当线程增长能够预估，ReentrantLock是一个很好的通用的锁实现;

### Optional

可能包含也可能不包含非空值的容器对象。 如果存在值，则isPresent()将返回true并且get()将返回该值。
提供了依赖于包含值的存在与否的其他方法，例如orElse() （如果值不存在则返回默认值）和ifPresent() （如果值存在则执行代码块）。
这是一个基于值的类； 在Optional实例上使用身份敏感操作（包括引用相等性 ( == )、身份哈希码或同步）可能会产生不可预测的结果，应该避免。
**可以结束原来的过多的null的判断**

```java
if(project!=null){
	Address address=project.getAddress();
    if(address!=null){
    	City city=address.getCity();
        if(city!=null){
            // 如果cityName为null就会
        	String cityName=city.getName()
            if(cityName!=null){
            	cityName=cityName.toUpperCase();
            }   
        }
    }
}
```
**使用Optional:**
#### of()&ofNullable()
**of() **和 **ofNullable() **方法创建包含值的 _Optional_。两个方法的不同之处在于如果你把 _null_ 值作为参数传递进去，**of() **方法会抛出 **NullPointerException**

```java
// 对象不为null我们可以使用of
Optional<Project> project=Optional.of(project)
// 对象可能是null也可能是非null我们使用ofNullable()
Optional<Project> project=Optional.ofNUllable(project)
```
#### isParent():
`isParent()` 这个方法用于检查是否有值，还接受一个_Consumer(消费者_) 参数，如果对象不是空的，就对执行传入的 Lambda 表达式：
```java
Optional<Project> opt=Optional.ofNUllable(project)
opt.ifPresent( u -> assertEquals(user.getEmail(), u.getEmail()));
```
#### orElse()&orElseGet()&orElseThrow()
`orElse()` 如果存在则返回值，否则返回other
```java
public T orElse(T other) {
        return value != null ? value : other;
    }
```
`orElseGet()` 如果存在则返回值，否则调用other并返回该调用的结果
```java
public T orElseGet(Supplier<? extends T> other) {
        return value != null ? value : other.get();
    }
```
`orElseThrow()` 返回包含的值（如果存在），否则抛出由提供的供应商创建的异常
```java
public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
```
#### map()&flatMap()
如果存在值，则对其应用提供的映射函数，如果结果非空，则返回描述结果的Optional 。 否则返回一个空的Optional 
例如，以下代码遍历文件名流，选择尚未处理的文件名，然后打开该文件，返回`Optional<FileInputStream>`
在这里， findFirst返回一个Optional<String> ，然后map为所需文件返回一个`Optional<FileInputStream>`（如果存在)
```java
Optional<FileInputStream> fis =
         names.stream().filter(name -> !isProcessedYet(name))
                       .findFirst()
                       .map(name -> new FileInputStream(name))
```
`flatMap()` 如果存在一个值，则将提供的Optional承载映射函数应用于它，返回该结果，否则返回一个空的Optional 。 此方法类似于map(Function) ，但提供的映射器的结果已经是Optional ，并且如果调用， flatMap不会用额外的Optional包装它.

#### filter()
如果存在一个值，并且该值与给定的谓词匹配，则返回一个描述该值的Optional ，否则返回一个空的Optional 
```java
Optional<FileInputStream> fis =
         names.stream().filter(name -> !isProcessedYet(name))
                       .findFirst()
                       .map(name -> new FileInputStream(name))
```
### Future
Future表示异步计算的结果。提供了检查计算是否完成、等待其完成以及检索计算结果的方法。结果只能在计算完成后使用方法get检索，必要时阻塞，直到它准备好。取消是通过cancel方法执行的。提供了额外的方法来确定任务是正常完成还是被取消。一旦计算完成，就不能取消计算。如果您想使用Future来取消可取消性但不提供可用的结果，您可以声明Future<?>形式的类型并返回null作为底层任务的结果。
> 官方实例

```java
interface ArchiveSearcher { String search(String target); }
 class App {
   ExecutorService executor = ...
   ArchiveSearcher searcher = ...
   void showSearch(final String target)
       throws InterruptedException {
    Future<String> future    = executor.submit(new Callable<String>() {
    public String call() {
          return searcher.search(target);
     }});   
   displayOtherThings(); // do other things while searching
try {
   displayText(future.get()); // use future
 } catch (ExecutionException ex) { cleanup(); return; }
}
```
当我们提交一个Callable任务后，我们会同时获得一个Future对象，然后，我们在主线程某个时刻调用Future对象的get()方法，就可以获得异步执行的结果。在调用get()时，如果异步任务已经完成，我们就直接获得结果。如果异步任务还没有完成，那么get()会阻塞，直到任务完成后才返回结果。
```java
ExecutorService executor = Executors.newFixedThreadPool(4); 
// 定义任务:
Callable<String> task = new Task();
// 提交任务并获得Future:
Future<String> future = executor.submit(task);
// 从Future获取异步执行返回的结果:
String result = future.get(); // 可能阻塞
```
#### 方法

- get()：获取结果（可能会等待）
- get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
- cancel(boolean mayInterruptIfRunning)：取消当前任务；
- isDone()：判断任务是否已完成。
### CompletableFuture
> 使用Future获得异步执行结果时，要么调用阻塞方法get()，要么轮询看isDone()是否为true，这两种方法都不是很好，因为主线程也会被迫等待。

> 从Java 8开始引入了CompletableFuture，它针对Future做了改进，可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。 
> CompletionStage：执行某一阶段可以向下执行后序阶段，异步执行没有提供Excetuor，默认线程是ForkJoinPool,commonPool().

可以显式完成（设置其值和状态）的Future ，并且可以用作CompletionStage ，支持在完成时触发的依赖功能和操作。当两个或多个线程尝试complete 、 completeExceptionally异常或cancel CompletableFuture 时，只有其中一个成功。除了这些和直接操作状态和结果的相关方法之外
CompletionStages使用以下策略：

- 为非异步方法的依赖完成提供的操作可以由完成当前 CompletableFuture 的线程执行，或由完成方法的任何其他调用者执行。
- 所有没有显式 Executor 参数的异步方法都使用ForkJoinPool.commonPool() （除非它不支持至少两个并行级别，在这种情况下，会创建一个新线程来运行每个任务）。 为了简化监控、调试和跟踪，所有生成的异步任务都是标记接口CompletableFuture.AsynchronousCompletionTask实例。
- 所有 CompletionStage 方法都是独立于其他公共方法实现的，因此一个方法的行为不受子类中其他方法的覆盖的影响。

CompletableFuture 还使用以下策略实现Future ：

- 由于（与FutureTask不同）这个类不能直接控制导致它完成的计算，取消被视为另一种形式的异常完成。 方法cancel与completeExceptionally(new CancellationException())具有相同的效果。 方法isCompletedExceptionally可用于确定 CompletableFuture 是否以任何异常方式完成。
- 如果出现 CompletionException 异常完成，方法get()和get(long, TimeUnit)抛出一个ExecutionException ，其原因与相应 CompletionException 中的原因相同。 为了在大多数情况下简化使用，此类还定义了join()和getNow ，在这些情况下直接抛出 CompletionException 
#### ComplatebleFuture异步任务创建方式
CompletableFuture中创建一个异步任务的方式总归有三种：

- 与之前的FutureTask一样的使用方式，通过new对象完成创建
- 通过CompletableFuture提供的静态方法完成创建
- 通过CompletableFuture提供的成员方法完成创建
##### 创建CompletableFuture对象的方式创建异步任务
```java
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture completableFuture = new CompletableFuture();
        new Thread(()->{
            System.out.println("异步任务......");
            // 执行完成后可以往CompletableFuture对象里面写出返回值
            completableFuture.complete(Thread.currentThread().getName());
        }).start();
        // 主线程获取异步任务执行结果
        System.out.println("main线程获取执行结果：" + completableFuture.get());
        for (int i = 1; i <= 3; i++){
            System.out.println("main线程 - 输出："+i);
        }
        
    }
   /**
     *  执行结果：
     *     异步任务......
     *     main线程获取执行结果：Thread-0
     *     main线程 - 输出：1
     *     main线程 - 输出：2
     *     main线程 - 输出：3
     */
```

这种方式比较简单，也比较容易理解，创建一条线程执行异步操作，执行完成后往completableFuture对象中写入需要返回的值，而主线程则调用completableFuture.get()方法获取异步线程写回的值。单身显而易见，这种方式与之前的FutureTask没任何区别，在主线程获取到执行结果之前，因为任务还在执行，所以主线程会被迫阻塞，等待任务执行结束后才能继续往下执行
##### 通过CompletableFuture静态方法完成异步任务创建
CompletableFuture类提供了五个静态方法可以完成创建异步任务的操作，如下：我们常用的runAsync()
```java
// 创建不具有返回值的异步任务
public static CompletableFuture runAsync(Runnable runnable);
public static CompletableFuture runAsync(Runnable runnable,Executor executor);

// 创建具有返回值的异步任务
public static  CompletableFuture supplyAsync(Supplier supplier);
public static  CompletableFuture supplyAsync(Supplier supplier,Executor executor);

// 返回一个值
public static  CompletableFuture completedFuture(U value);

```
```java
CompletableFuture.runAsync(() -> 
                       messageFeignClient.sendMsgToPersonWithLog(
                           MessageSendVO.builder()
                            .title("问题处理提醒")
                            .msg("您有一条问题待解决:" + question.getName())
                            .personId()
                            .build()));
```

在这四个方法中，run开头的代表创建一个没有返回值的异步任务，supply开头的方法代表创建一个具备返回值的异步任务。同时这两类方法都支持指定执行线程池，如果不指定执行线程池，CompletableFuture则会默认使用ForkJoinPool.commonPool()线程池内的线程执行创建出的异步任务。

> 创建一个异步任务完成100内的偶数求和，执行完成后返回求和结果，代码如下：

```java
public class TestCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> supply =
            CompletableFuture.supplyAsync(TestCompletableFuture::mock);
        // 执行成功回调
        supply.thenAccept(System.out::println);
         // 执行过程出现异常
        supply.exceptionally((throwable) -> {throwable.printStackTrace(); return "异步任务执行过程出现异常...";});
        // 主线程操作
        for (int i=1;i<=10;i++){
            System.out.println("main线程："+i);
            Thread.sleep(1000);
        }
    }
    // 求和100内的偶数
    private static String mock() {
        int sum = 0;
        System.out.println("模拟异步执行开始！");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) sum += i;
        }
        System.out.println("模拟异步执行完毕！");
        return Thread.currentThread().getName()+"线程 - 100内偶数之和："+sum;
    }
    /**
     * 执行结果：
     *    模拟异步执行开始！
            main线程：1
            模拟异步执行完毕！
            ForkJoinPool.commonPool-worker-9线程-100之内的偶数之和为：2550
            main线程：2
            main线程：3
            main线程：4
            main线程：5
            main线程：6
            main线程：7
            main线程：8
            main线程：9
            main线程：10  
     **/
    
}
```

如上案例，通过了CompletableFuture.supplyAsync创建了一个带返回值的异步任务supply，因为没有指定线程池则使用默认的ForkJoinPool.commonPool()线程池来完成该任务的执行，同时采用supply.thenAccept作为成功的回调方法，采用supply.exceptionally作为执行过程中抛出异常时的回调方法，同时主线程main创建完成异步任务后，写好了成功和失败的回调函数后，继续执行打印1、2、3、4...的逻辑。从上面的执行结果我们可以看出，当main线程创建好异步任务以及相关后续处理后，其实并没有阻塞等待任务的完成，而是继续执行接下来的逻辑，当任务执行结束时则会触发提前定义好的回调函数，返回任务执行结果(执行出现异常则会将捕获的异常信息返回给exceptionally回调函数)。显而易见，CompletableFuture任务对比之前的FutureTask任务，在执行上以及执行结果返回上实现了真正意义上的“异步”。

接下来再看看其他几种创建CompletableFuture异步任务的静态方法使用。如下：

> 创建一个没有返回值的异步任务

public static CompletableFuture runAsync(Runnable runnable,Executor executor);
> 创建有返回值的异步任务

public static  CompletableFuture supplyAsync(Supplier supplier);
public static  CompletableFuture supplyAsync(Supplier supplier,Executor executor);
> 返回已使用给定值完成的新 CompletableFuture。

public static  CompletableFuture completedFuture(U value);
> 创建一个收集所有的CompletableFuture的future
> 此方法的应用之一是在继续程序之前等待一组独立的 CompletableFuture 完成

public static CompletableFuture<Void> allOf(CompletableFuture<?>... cfs) ;

```java
   public class CompletableFutureDemo {
      public static void main(String[] args) throws Exception {
          
       /***************************supplyAsync***************************/
        // 创建有返回值的异步任务
        CompletableFuture supplyCF = CompletableFuture
        .supplyAsync(CompletableFutureDemo::evenNumbersSum);
        // 执行成功的回调
        supplyCF.thenAccept(System.out::println);
        // 执行过程中出现异常的回调
        supplyCF.exceptionally((e)->{
        e.printStackTrace();
        return "异步任务执行过程中出现异常....";
        });
        // 主线程执行打印1234...操作
        // 因为如果不为CompletableFuture指定线程池执行任务的情况下，
        // CompletableFuture默认是使用ForkJoinPool.commonPool()的线程
        // 同时是作为main线程的守护线程进行的，如果main挂了，执行异步任
        // 务的线程也会随之终止结束，并不会继续执行异步任务
        for (int i = 1; i <= 10; i++){
        System.out.println("main线程 - 输出："+i);
        Thread.sleep(50);
		}
          
    /***********************completedFuture****************************/
    
    // 创建一个异步任务，已经给定返回值了
    CompletableFuture c = CompletableFuture.completedFuture("竹子");
    c.thenApply(r -> {
        System.out.println("上个任务结果："+r);
        return r+"...熊猫";
    });
    c.thenAccept(System.out::println);
    
    /***********************runAsync****************************/

    // 创建一个没有返回值的异步任务
    CompletableFuture runCF = CompletableFuture.runAsync(()->{
        System.out.println(Thread.currentThread().getName()+"没有返回值的异步任务");
    });
    
    /*************************supplyAsync具有executor**************************/
    
    // 创建单例的线程池
    ExecutorService executor = Executors.newSingleThreadExecutor();
    // 创建一个有返回值的异步任务并指定执行的线程池
    CompletableFuture<String> supplyCFThreadPool =
            CompletableFuture.supplyAsync(CompletableFutureDemo::oddNumbersSum,executor);
    // // 执行过程中出现异常的回调
    supplyCFThreadPool.thenAccept(System.out::println);
    // 执行过程中出现异常的回调
    supplyCF.exceptionally((e)->{
        e.printStackTrace();
        return "异步任务执行过程中出现异常....";
    });
    
    // 关闭线程池
    executor.shutdown();
  }

    // 求和100内的偶数
    private static String evenNumbersSum() {
        int sum = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) sum += i;
        }
        return Thread.currentThread().getName()+"线程 - 100内偶数之和："+sum;
    }

    // 求和100内的奇数
    private static String oddNumbersSum() {
        int sum = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) sum += i;
        }
        return Thread.currentThread().getName()+"线程 - 100内奇数之和："+sum;
    }
}
```

在上述的案例中，分别创建了四个异步任务，第一个则是前面分析的案例，不再赘述。

1. 第二个则是创建了一个有返回值的异步任务，同时与第一个任务不同的是：我们指定执行的线程池executor，那么该任务在执行的时候则不会使用默认的ForkJoinPool.commonPool()线程池，不过在使用这种方式的时候，一定要记住需要关闭自己创建的线程池。
2. 第三个异步任务则是通过CompletableFuture.runAsync方法创建了一个没有返回值的异步任务，传递的参数是一个Runnable对象，与最开始的new Thread()方式区别不大，但是与之不同的是：该任务的执行因为没有指定线程池，所以也是通过默认的ForkJoinPool.commonPool()线程池执行的，而不会另起线程执行。
3. 第四个任务则是创建了一个已经提前指定了返回值的CompletableFuture任务，很多人可能会感觉这种方式很鸡肋，但是可以配合CompletableFuture成员方法完成链式创建。

##### 通过CompletableFuture成员方法完成异步任务创建

在使用这种方式创建任务的前提是需要建立在已经创建出一个CompletableFuture对象上。总归来说这类成员方法创建异步任务的方式属于串行化的形式创建的，下一个任务依赖于上一个任务的执行结果时，就可以采用这种方式。CompletableFuture中提供很多这类方法：
![1650956141(1).png](https://cdn.nlark.com/yuque/0/2022/png/1500329/1650956126977-38d80089-47d7-4409-995f-6377d9ace041.png#clientId=ufd4a8a70-88c8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=889&id=u3094d6fb&margin=%5Bobject%20Object%5D&name=1650956141%281%29.png&originHeight=1111&originWidth=1104&originalType=binary&ratio=1&rotation=0&showTitle=false&size=139821&status=done&style=none&taskId=u3509f082-3954-4618-aa2b-7ed5e359ec2&title=&width=883.2)

如上列出来了一些常用的方法，方法总体分为四类，这四类方法都可以使得任务串行化执行：

- thenApply类：此类方法可以基于上一个任务再创建一个新的有返回型任务。
- handle类：与thenApply类作用相同，不同点在于thenApply类方法只能在上一个任务执行正常的情况下才能执行，当上一个任务执行抛出异常后则不会执行。而handle类在上个任务出现异常的情况下也可以接着执行。
- thenRun类：此类方法可以基于上一个任务再创建一个新的无返回型任务。
- thenCompose类：与thenApply类大致相同，不同点在于每次向下传递都是新的CompletableFuture对象，而thenApply向下传递的都是同一个CompletableFuture对象对象
- thenAccept类：获取执行异步成功(supplyAsync())的回调

但是不难发现，不管是哪类方法，其实方法名都会有后面跟了Async的和没跟Async的，那么这种跟了Async代表什么意思呢？如果调用方法名不带Async的方法创建出的任务都是由上一个任务的执行线程来执行的，在上一个任务没有执行完成的情况下，当前创建出来的任务会等待上一个任务执行完成后再执行。而如果是通过Async这类方法创建出来的任务则不受到这个限制，通过调用方法名带Async的方法创建出的任务，具体的执行线程会根据实际情况来决定，主要会分为如下三种情况：

- 上一个任务已经执行结束了，那么当前创建出的任务会交给上个任务的执行线程来执行
- 上一个任务还没有执行结束，那么则会另启一条线程来执行
- 如果创建任务时指定了执行线程池，则会使用指定线程池的线程来执行

```java
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture cf =
                CompletableFuture.supplyAsync(CompletableFutureDemo::evenNumbersSum)
                    // 链式编程：基于上个任务的返回继续执行新的任务
                    .thenApply(r -> {
                        System.out.println("获取上个任务的执行结果：" + r);
                        // 通过上个任务的执行结果完成计算：求和100所有数
                        return r + oddNumbersSum();
                    }).thenApplyAsync(r -> {
                        System.out.println("获取上个任务的执行结果：" + r);
                        Integer i = r / 0; // 拋出异常
                        return r;
                    }).handle((param, throwable) -> {
                        if (throwable == null) {
                            return param * 2;
                        }
                        // 获取捕获的异常
                        System.out.println(throwable.getMessage());
                        System.out.println("我可以在上个任务" +
                                "抛出异常时依旧执行....");
                        return -1;
                    }).thenCompose(x -> 
                        CompletableFuture.supplyAsync(() -> x+1
                    )).thenRun(() -> {
                        System.out.println("我是串行无返回任务....");
                });

        // 主线程执行休眠一段时间
        // 因为如果不为CompletableFuture指定线程池执行任务的情况下，
        // CompletableFuture默认是使用ForkJoinPool.commonPool()的线程
        // 同时是作为main线程的守护线程进行的，如果main挂了，执行异步任
        // 务的线程也会随之终止结束，并不会继续执行异步任务
        Thread.sleep(2000);
    }
// 求和100内的偶数
private static int evenNumbersSum() {
    int sum = 0;
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    for (int i = 1; i <= 100; i++) {
        if (i % 2 == 0) sum += i;
    }
    return sum;
}

// 求和100内的奇数
private static int oddNumbersSum() {
    int sum = 0;
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    for (int i = 1; i <= 100; i++) {
        if (i % 2 != 0) sum += i;
    }
    return sum;
}
}
```

在案例中，我们创建了六个异步任务：

1. 求和100内的所有偶数
2. 基于第一个任务的结果再加上100内奇数总值计算100内所有数字的总和
3. 基于第二个任务的结果除0抛出一个异常
4. 使用handle创建一个可以在上个任务抛出异常时依旧执行的任务
5. 使用thenCompose创建一个基于上个任务返回值+1的任务
6. 使用thenRun创建了一个没有返回值的任务
##### 串行执行
**如果只是实现了异步回调机制，我们还看不出CompletableFuture相比Future的优势。CompletableFuture更强大的功能是，多个CompletableFuture可以串行执行，例如，定义两个CompletableFuture，第一个CompletableFuture根据证券名称查询证券代码，第二个CompletableFuture根据证券代码查询证券价格，这两个CompletableFuture实现串行操作如下：**
```java
public class Main {
    public static void main(String[] args) throws Exception {
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
```
##### 并行执行
同时从新浪和网易查询证券代码，只要任意一个返回结果，就进行下一步查询价格，查询价格也同时从新浪和网易查询，只要任意一个返回结果，就完成操作：
```java
public class Main {
    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
```




