## 单列模式

单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

注意：
    1、单例类只能有一个实例。
    2、单例类必须自己创建自己的唯一实例。
    3、单例类必须给所有其他对象提供这一实例。

常见的单列：ServletContext,ServletContextConfig等，ApplicationContext,数据库连接池。

优点：
    1.保证了类的唯一性。
    2.减少内存的开销。
缺点：
    没有接口，不能继承
    
### 饿汉式单例模式
   无论使用与否在类加载和创建实例时都会创建，线程绝对安全。没有加入任何的锁执行效率高。
   
   类加载时初始化和创建实例时初始化实例包含：
   1.虚拟机在首次加载类，初始化静态块，静态成员变量，静态方法，第一次进行初始化
   2.只有在调用的类使用new方法才能够创建类的实例
   3.实例创建过程首先对类初始化，父类的构造方法，再执行初始化子类
   
   缺点：有时浪费内存，
   
   有两种实现方式，一种时静态块中进行初始化，一种是类初始化
   
   ```java
      // 一
      private final static Singleton singleton;
      static{
        singleton = new Singleton();
      } 
      // 二
      private final static Singleton singleton = new Singleton();
   ```
   
### 懒汉式单例模式
   在调用时候进行初始化。
   
    ```java
    /**
     * user:kay三石
     * time: 10:41
     * desc: 懒汉式单例模式，就是什么时候用什么时候进行构造
     * 如果有了就直接返回,有线程安全问题
     **/
    public class LazySingleton {
        // 静态的
        private static  LazySingleton lazySingleton = null;
    
        private LazySingleton(){};
    
        public static  LazySingleton getInstance(){
            if(lazySingleton == null){
                lazySingleton = new LazySingleton();
            }
            return lazySingleton;
        }
    
    }
    ```
    
   优点：第一次调用才初始化，避免内存浪费。
   缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率
   
   ```java
    /**
     * user:kay三石
     * time: 10:58
     * desc: 使用双重的检查锁的单例模式
     * 这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
     * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，它跟第 3 种方式不同的是：
     * 第 3 种方式只要 Singleton 类被装载了，那么 instance 就会被实例化（没有达到 lazy loading 效果），而这种方式是 Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，
     * 另外一方面，又不希望在 Singleton 类加载时就实例化，因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。这个时候，这种方式相比第 3 种方式就显得很合理
     **/
    public class LazySimpleSingletonV1 {
        // 使用volatile关键字
        private volatile  static LazySimpleSingletonV1 lazySimpleSingletonV1;
    
        private LazySimpleSingletonV1(){};
    
        public static LazySimpleSingletonV1 getInstance(){
            if (lazySimpleSingletonV1==null){
                synchronized (LazySimpleSingletonV1.class){
                    lazySimpleSingletonV1 = new LazySimpleSingletonV1();
                }
            }
            return lazySimpleSingletonV1;
        }
    
    }
   ```
### 注册式单例模式
    这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
    这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，它跟第 3 种方式不同的是：第 3 种方式只要 Singleton 类被装载了，那么 instance 就会被实例化（没有达到 lazy loading 效果），而这种方式是 Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。这个时候，这种方式相比第 3 种方式就显得很合理

### 总结：
    无论饿汉式懒汉式单例模式，其特点都是为了保证内存中只有一个实例存在，减少了对内存的开销，避免对资源的多重暂用。
    