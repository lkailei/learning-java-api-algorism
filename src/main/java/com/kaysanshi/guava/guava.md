## Guava
Guava是一种基于开源的Java库，其中包含谷歌正在由他们很多项目使用的很多核心库。这个库是为了方便编码，并减少编码错误。这个库提供用于集合，缓存，支持原语，并发性，常见注解，字符串处理，I/O和验证的实用方法。
### 好处
- 函数式编程 -增加JAVA功能和处理能力。
- 实用程序 - 提供了经常需要在应用程序开发的许多实用程序类。
- 验证 -提供标准的故障安全验证机制。


## 检查类

### Optional类
Optional用于包含非空对象的不可变对象。 Optional对象，用于不存在值表示null。这个类有各种实用的方法，以方便代码来处理为可用或不可用，而不是检查null值。```
```java
@GwtCompatible(serializable=true)
public abstract class Optional<T>
   extends Object
      implements Serializable{}
```
#### 方法

- static <T> Optional<T> absent()  返回没有包含的参考Optional的实例
- static <T> Optional<T> of(T reference) 返回包含给定的非空引用Optional实例。
- abstract T get()  返回所包含的实例，它必须存在。
- abstract boolean isPresent() 返回true，如果这支架包含一个(非空)的实例。
- static <T> Optional<T> of(T reference) 返回包含给定的非空引用Optional实例。
- abstract Optional<T> or(Optional<? extends T> secondChoice) 返回此Optional，如果它有一个值存在; 否则返回secondChoice
- abstract T or(Supplier<? extends T> supplier)  返回所包含的实例(如果存在); 否则supplier.get()。

### Precondition类

Preconditions提供静态方法来检查方法或构造函数，被调用是否给定适当的参数。它检查的先决条件。其方法失败抛出IllegalArgumentException。

- `static void checkArgument(boolean expression)`  确保涉及的一个或多个参数来调用方法表达式的真相。否则进行抛出异常
- `static void checkArgument(boolean expression, Object errorMessage)`  确保涉及的一个或多个参数来调用方法表达式的真相。 否则进行抛出自定义异常                                                		
- `static <T> T checkNotNull(T reference, Object errorMessage)` 确保对象引用作为参数传递给调用方法不为空。
- `static int checkElementIndex(int index, int size, String desc)`   确保索引指定一个数组，列表或尺寸大小的字符串有效的元素。
```java
/**
 * Preconditions提供静态方法来检查方法或构造函数，被调用是否给定适当的参数。
 * 它检查的先决条件。其方法失败抛出IllegalArgumentException。
 *
 */
public class PreconditionsTest {
    public static void main(String args[]){
        PreconditionsTest guavaTester = new PreconditionsTest();
        try {
            System.out.println(guavaTester.sqrt(-3.0));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(guavaTester.sum(null,3));
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(guavaTester.getValue(6));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public double sqrt(double input) throws IllegalArgumentException {
        // 确保涉及的一个或多个参数来调用方法表达式的真相。
        Preconditions.checkArgument(input > 0.0,
                "Illegal Argument passed: Negative value %s.", input);
        return Math.sqrt(input);
    }

    public int sum(Integer a, Integer b){
        // 确保对象引用作为参数传递给调用方法不为空。
        a = Preconditions.checkNotNull(a,
                "Illegal Argument passed: First parameter is Null.");
        b = Preconditions.checkNotNull(b,
                "Illegal Argument passed: Second parameter is Null.");
        return a+b;
    }

    public int getValue(int input){
        int[] data = {1,2,3,4,5};
        // 确保索引指定一个数组，列表或尺寸大小的字符串的有效位置。
        Preconditions.checkElementIndex(input,data.length,
                "Illegal Argument passed: Invalid index.");
        return 0;
    }

}
```

### Ordering类

Ordering(排序)可以被看作是一个丰富的比较具有增强功能的链接，多个实用方法，多类型排序功能等。

- `static Ordering<Object> allEqual()`  返回一个排序，它把所有的值相等，说明“没有顺序。”通过这个顺序以任何稳定的排序算法的结果，
- `int binarySearch(List<? extends T> sortedList, T key)`    搜索排序列表使用键的二进制搜索算法
- `<E extends T> List<E> greatestOf(Iterator<E> iterator, int k)`  返回从给定的迭代器按照这个顺序，从最大到最小k个最大的元素。
- `<E extends T> List<E> leastOf(Iterable<E> iterable, int k)`  返回根据这个顺序给出迭代，从而从低到最大的k个最低的元素
- `<S extends T> Ordering<S> reverse()` 返回相反顺序; 顺序相当于Collections.reverseOrder（Comparator）

### Objects类

Objects类提供适用于所有对象，如equals, hashCode等辅助函数

- static boolean equal(Object a, Object b) 确定两个可能是空的对象是否相等。

## 集合工具

- MultiSet:一个扩展来设置界面，允许重复的元素。
- Multimap:一个扩展来映射接口，以便其键可一次被映射到多个值
- BiMap: 一个扩展来映射接口，支持反向操作
- Table:表代表一个特殊的图，其中两个键可以在组合的方式被指定为单个值。
- RangeSet:
- RangeMap:

### Multiset类

Multiset接口扩展设置有重复的元素，并提供了各种实用的方法来处理这样的元素在集合中出现。
Multiset 可以看成ArrayList和Map的结合体。Multiset是没有元素顺序限制的ArrayList。Multiset提供了键为元素，值为计数的Map

- `boolean add(E element)` 添加一个出现的指定元素这个multiset。
- `int add(E element, int occurrences)` 增加大量的元素到这个multiset。
- `boolean contains(Object element)` 确定此多集是否包含指定的元素。
- `boolean containsAll(Collection<?> elements)` 返回true，如果这个多集至少包含一个出现的指定集合中的所有元素。
- `int count(Object element)` 返回出现的元素的在该multiset的数目（元素的数量）。
- `Set<E> elementSet()` 返回集包含在此多集不同的元素。
- `Set<Multiset.Entry<E>> entrySet()` 返回此多集的内容的视图，分组在Multiset.Entry实例中，每一个都提供了多集的一个元素和元素的计数。

```java
public class MultisetTest {
    public static void main(String args[]){
        //create a multiset collection
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("b");
        multiset.add("b");
        //print the occurrence of an element
        // 返回出现的元素的在该multiset的数目（元素的数量）。
        System.out.println("Occurrence of 'b' : "+multiset.count("b"));
        //print the total size of the multiset
        // 大小
        System.out.println("Total Size : "+multiset.size());

        // 是否包含某个元素
        System.out.println(multiset.contains("b"));

        //get the distinct elements of the multiset as set
        // 转成set
        Set<String> set = multiset.elementSet();
        //display the elements of the set
        System.out.println("Set [");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("]");
        //display all the elements of the multiset using iterator
        Iterator<String> iterator  = multiset.iterator();
        System.out.println("MultiSet [");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("]");
        //display the distinct elements of the multiset with their occurrence count
        System.out.println("MultiSet [");
        for (Multiset.Entry<String> entry : multiset.entrySet())
        {
            System.out.println("Element: "+entry.getElement() +", Occurrence(s): " + entry.getCount());
        }
        System.out.println("]");

        //remove extra occurrences
        multiset.remove("b",2);
        //print the occurrence of an element
        System.out.println("Occurence of 'b' : "+multiset.count("b"));
    }


}
```

### SortedMultiSet类

### Multimap类
在jdk中的Map 存储key-value 型数据结构，put进入一个key相同的数据数据会被覆盖。
```java
Map<String,String> map = new HashMap<>();
map.put("key","value1");
map.put("key","value2");
```
上面map中只会存key->value2 的值，会把相同key的值给覆盖。

**Guava为我们提供了Multimap，可以用来做一个Key映射多个值的操作**


- `Map<K,Collection<V>> asMap()` 返回此multimap中的视图，从每个不同的键在键的关联值的非空集合映射。
- `void clear()`将删除所

有multimap中的键值对，留下空。
- `boolean containsEntry(Object key, Object value)`返回true如果此多重映射包含至少一个键 - 值对用键键和值value。
- `boolean containsKey(Object key)`返回true，如果这个multimap中至少包含一个键值对的键key。
- `boolean containsValue(Object value)`返回true，如果这个multimap至少包含一个键值对的值值。
- `Collection<Map.Entry<K,V>> entries()`返回包含在此multimap中，为Map.Entry的情况下，所有的键 - 值对的视图集合。
- `boolean equals(Object obj)`比较指定对象与此多重映射是否相等。
- `Collection<V> get(K key)`返回，如果有的话，在这个multimap中键关联的值的视图集合。
- `int hashCode()`返回此多重映射的哈希码。
- `boolean isEmpty()`返回true，如果这个multimap中未包含键 - 值对。
- `Multiset<K> keys()`返回一个视图集合包含从每个键值对这个multimap中的关键，没有折叠重复。
- `Set<K> keySet()`Returns a view collection of all distinct keys contained in this multimap.
- `boolean put(K key, V value)`存储键 - 值对在这个multimap中。
- `boolean putAll(K key, Iterable<? extends V> values)`存储一个键 - 值对在此multimap中的每个值，都使用相同的键 key。
- `boolean putAll(Multimap<? extends K,? extends V> multimap)`存储了所有键 - 值对多重映射在这个multimap中，通过返回multimap.entries()的顺序.
- `boolean remove(Object key, Object value)`删除一个键 - 值对用键键，并从该多重映射的值的值，如果这样的存在。
- `Collection<V> removeAll(Object key)`删除与键键关联的所有值。
- `Collection<V> replaceValues(K key, Iterable<? extends V> values)` 存储与相同的键值，替换任何现有值的键的集合。
- `int size()` 返回此多重映射键 - 值对的数量。
- `Collection<V> values()` 返回一个视图集合包含从包含在该multimap中的每个键 - 值对的值，而不发生重复 (so values().size() == size()).

```java
/**
 * 多重映射接口扩展映射，使得其键一次可被映射到多个值。
 */
public class MultiMapTest {
    public static void main(String args[]){
        MultiMapTest tester = new MultiMapTest();
        Multimap<String,String> multimap = tester.getMultimap();

        List<String> lowerList = (List<String>)multimap.get("lower");
        System.out.println("Initial lower case list");
        System.out.println(lowerList.toString());
        lowerList.add("f");
        System.out.println("Modified lower case list");
        System.out.println(lowerList.toString());

        List<String> upperList = (List<String>)multimap.get("upper");
        System.out.println("Initial upper case list");
        System.out.println(upperList.toString());
        upperList.remove("D");
        System.out.println("Modified upper case list");
        System.out.println(upperList.toString());

        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println("Multimap as a map");
        for (Map.Entry<String,  Collection<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Collection<String> value =  multimap.get("lower");
            System.out.println(key + ":" + value);
        }

        System.out.println("Keys of Multimap");
        Set<String> keys =  multimap.keySet();
        for(String key:keys){
            System.out.println(key);
        }

        System.out.println("Values of Multimap");
        Collection<String> values = multimap.values();
        System.out.println(values);


        Map<String,String> maps = new HashMap<>();
        maps.put("name","张三");
        maps.put("name",null);
        System.out.println(maps.values());
    }

    private Multimap<String,String> getMultimap(){
        //Map<String, List<String>>
        // lower -> a, b, c, d, e
        // upper -> A, B, C, D

        Multimap<String,String> multimap = ArrayListMultimap.create();

        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");
        multimap.put("lower", "d");
        multimap.put("lower", "e");

        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "C");
        multimap.put("upper", "D");
        return multimap;
    }

}
```
### BiMap类
Guava提供了BiMap，它是一种特殊的Map，可以实现键值的反转

在jdk中我们想维护一个双向Map来实现键值的反转
```java
Map<String,String> map1 = Maps.newHashMap();
Map<String,String> map2 = Maps.newHashMap();
map1.put("key","value");
map2.put("value","key");
```
```java
public class BiMapTest {
    public static void main(String[] args) {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("a","123");
        System.out.println(biMap); // {a=123}
        //对键值对进行反转
        System.out.println(biMap.inverse()); // {123=a}

        //试图将一个key映射到已经存在的值上，会抛异常 value already present: 123
        //biMap.put("b","123");

        //强值将一个key映射到已经存在的值上，会将原来的key覆盖掉
        biMap.forcePut("b","123");
        System.out.println(biMap);// {b=123}
    }
}
```
可以看出，因为BiMap要支持反转，所以它的key和value都必须是唯一的，要不然反转过来就存在一对多的情况

### Table类
在JDK中当需要做key映射到Key-value对时，你需要这样写Map<K,Map<K,V>>,这种写法同样不够友好，同时也不便维护

这实际上就是一个表格的行、列、值的结构，Guava里面提供了表格来解决这种场景

```java
public class TableTest {
    public static void main(String[] args) {
        //创建row,column,value结构的table
        Table<String,String,Integer> table = HashBasedTable.create();
        table.put("a1","c1",23);
        table.put("a1","c2",77);
        table.put("a2","c2",44);
        //通过rowKey获取columnKey->value的映射关系
        System.out.println(table.row("a1")); // {c1=23, c2=77}
        //通过columnKey获取rowKey ->value的映射关系
        System.out.println(table.column("c2")); // {a1=77, a2=44}
    }
}
```


## 不可变集合(Immutable Collections)
对象创建后，所有的状态和属性在整个生命周期内不能被修改.同理，不可变集合就是集合创建后，不能对集合中的对象进行修改

好处：1. 让并发处理变得简单 2. 消除副作用 3. 减少集合出错概率

**为何使用不可变集合**

1. 不可变对象提供给别人使用时是安全的，因为不可变，所有人都无法进行修改，只能读
2. 支持多个线程调用，不存在竞争的问题，天然支持多线程
3. 不可变集合节省内存空间，因为不可变，集合空间在创建时就已经确定好了，不用考虑扩容等问题，内存利用率高
4 .不可变集合可用于常量

**智能的Copyof**

在常量时间内使用底层数据结构是可能的——例如，ImmutableSet.copyOf(ImmutableList)就不能在常量时间内完成
不会造成内存泄露——例如，你有个很大的不可变集合ImmutableList hugeList， ImmutableList.copyOf(hugeList.subList(0, 10))就会显式地拷贝，以免不必要地持有hugeList的引用
不改变语义——所以ImmutableSet.copyOf(myImmutableSortedSet)会显式地拷贝，因为和基于比较器的ImmutableSortedSet相比，ImmutableSet对hashCode()和equals有不同语义

**asList视图**

所有不可变集合都有一个asList()方法提供ImmutableList视图，来帮助你用列表形式方便地读取集合元素。例如，你可以使用sortedSet.asList().get(k)从ImmutableSortedSet中读取第k个最小元素。
asList()返回的ImmutableList通常是——并不总是——开销稳定的视图实现，而不是简单地把元素拷贝进List。也就是说，asList返回的列表视图通常比一般的列表平均性能更好，比如，在底层集合支持的情况下，它总是使用高效的contains方法。

### ImmutableCollection
### ImmutableList
### ImmutableSet
### ImmutableSortSet
### ImmutableMap
### ImmutableMultiset
### ImmutableSortMultiset
### ImmutableMultiMap
### ImmutableListMultiMap
### ImmutableSetMultiMap
### ImmutableBiMap
### ImmutableClassToInstanceMap
### ImmutableTable

## 集合工具类

### Lists

**各种创建list的方法**

- asList()将数据组转成list
- newArrayList()
- newArrayListWithCapacity(10) 指定容量的创建
- newArrayListWithExpectedSize（20） 初始化指定容量
- newCopyOnWriteArrayList()
- newLinkedList()

**其他方法**

- partition(List<T> list, int size) 将list按指定大小分隔成多个list
- cartesianProduct(List<? extends B>... lists) 获取多个list的笛卡尔集
- charactersOf(String str) 将字符串转成字符集合
- reverse(List<T> list) 反转list
- transform(List<F> fromList, Function<? super F, ? extends T> function) 数据转换

```java
public class ListsTest {
    public static void main(String[] args) {
        //将数组转成list,并在开头位置插入元素
        List<String> list = Lists.asList("a",new String[]{"b","c","d"});
        List<String> list1 = Lists.asList("a","b",new String[]{"c","d","e"});

        //直接创建ArrayList
        ArrayList<String> arrayList = Lists.newArrayList();
        //创建ArrayList,并初始化
        ArrayList<String> arrayList1 = Lists.newArrayList("a","b","c");
        //基于现有的arrayList,创建一个arrayList
        ArrayList<String> arrayList2 = Lists.newArrayList(arrayList1);
        //初始化指定容量大小的ArrayList，其中容量指ArrayList底层依赖的数组的length属性值，常用于提前知道ArrayList大小的情况的初始化
        ArrayList<String> arrayList3 = Lists.newArrayListWithCapacity(10);
        //初始化预定容量大小的ArrayList，返回的list的实际容量为5L + estimatedSize + (estimatedSize / 10)，常用于不确定ArrayList大小的情况的初始化
        ArrayList<String> arrayList4 =Lists.newArrayListWithExpectedSize(20);
        //创建CopyOnWriteArrayList
        CopyOnWriteArrayList<String> copyOnWriteArrayList = Lists.newCopyOnWriteArrayList();
        //创建linkedList
        LinkedList<String> linkedList = Lists.newLinkedList();

        ListsTest test = new ListsTest();
        test.partition();
        test.cartesianProduct();
        test.charactersOf();
        test.reverse();
        test.transForm();
    }

    /**
     * 分割list
     */
    public void partition(){
        List<String> list = Lists.newArrayList("a","b","c","d","e");
        //将list按大小为2分隔成多个list
        List<List<String>> splitList = Lists.partition(list,2);
        System.out.println(splitList);// [[a, b], [c, d], [e]]
    }

    /**
     * 笛卡尔积
     */
    public void cartesianProduct(){
        List<String> list1 = Lists.newArrayList("a","b","c");
        List<String> list2 = Lists.newArrayList("d","e","f");
        List<String> list3 = Lists.newArrayList("1","2","3");
        //获取多个list的笛卡尔集
        List<List<String>> list = Lists.cartesianProduct(list1,list2,list3);
        System.out.println(list);// [[a, d, 1], [a, d, 2], [a, d, 3], [a, e, 1], [a, e, 2], [a, e, 3], [a, f, 1], [a, f, 2], [a, f, 3], [b, d, 1], [b, d, 2], [b, d, 3], [b, e, 1], [b, e, 2], [b, e, 3], [b, f, 1], [b, f, 2], [b, f, 3], [c, d, 1], [c, d, 2], [c, d, 3], [c, e, 1], [c, e, 2], [c, e, 3], [c, f, 1], [c, f, 2], [c, f, 3]]

    }

    /**
     * 将字符串转成字符集合
     */
    public void charactersOf(){
        //将字符串转成字符集合
        ImmutableList<Character> list = Lists.charactersOf("ababcdfb");
        System.out.println(list);// [a, b, a, b, c, d, f, b]
    }

    /**
     * 反转list
     */
    public void reverse(){
        List<String> list = Lists.newArrayList("a","b","c","1","2","3");
        //反转list
        List<String> reverseList = Lists.reverse(list);
        System.out.println(reverseList);// [3, 2, 1, c, b, a]
    }

    /**
     * 数据转换
     */
    public void transForm(){
        List<String> list = Lists.newArrayList("a","b","c");
        //把list中的每个元素拼接一个1
        List<String> list1 = Lists.transform(list,str -> str + "1");
        System.out.println(list1); //[a1, b1, c1]
    }


}

```
### Sets

**各种创建set的方法**
- newHashSet()  创建hashSet
- newLinkedHashSet() 创建linKedHashSet
- newTreeSet() 创建TreeSet
- newConcurrentHashSet() 创建不可变HashSet


- cartesianProduct(Set<? extends B>... sets) 笛卡尔集
- combinations(Set<E> set, final int size) 按指定大小进行排列组合
- difference(final Set<E> set1, final Set<?> set2) 两个集合的差集 2与1 的差集
- intersection(final Set<E> set1, final Set<?> set2) 交集
- filter(Set<E> unfiltered, Predicate<? super E> predicate) 过滤
- powerSet(Set<E> set) 获取set可分隔成的所有子集
- union(final Set<? extends E> set1, final Set<? extends E> set2) 并集

```java
public class SetsTest {
    public static void main(String[] args) {
        HashSet<String> set = Sets.newHashSet();
        LinkedHashSet<Object> hashSet = Sets.newLinkedHashSet();
        HashSet<Object> objects = Sets.newHashSetWithExpectedSize(10);
        TreeSet<Comparable> comparables = Sets.newTreeSet();
        Set<Object> objects1 = Sets.newConcurrentHashSet();
        SetsTest setsTest = new SetsTest();
        setsTest.cartesianProduct();
    }

    /**
     *
     */
    public void cartesianProduct(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        Set<String> set2 = Sets.newHashSet("1","2","3");
        Set<String> set3 = Sets.newHashSet("@","2","&");
        //多个Set的笛卡尔集，参数接收多个set集合
        Set<List<String>> sets = Sets.cartesianProduct(set1,set2,set3);
        System.out.println(sets);

        List<Set<String>> list = Lists.newArrayList(set1,set2,set3);
        //也可以把多个Set集合，放到一个list中，再计算笛卡尔集
        Set<List<String>> sets1 = Sets.cartesianProduct(list);
        System.out.println(sets1);
        // 按指定大小进行排列组合
        Set<Set<String>> combinations = Sets.combinations(set1, 2);
        System.out.println(combinations); //Sets.combinations([a, b, c], 2)
        // 两个集合的差集
        System.out.println(Sets.difference(set1,set2));// [a, b, c]
        System.out.println(Sets.difference(set2,set1));// [1, 2, 3]
        // 在后者中没有的前者列出来 差集
        System.out.println(Sets.difference(set2,set3));// [1, 3]
        // 交集
        System.out.println(Sets.intersection(set1,set2));// []
        System.out.println(Sets.intersection(set2,set3));// [2]
        // 并集
        System.out.println(Sets.union(set2,set3));// [1, 2, 3, @, &]
    }
}
```
### Maps

**创建各种Map的方法**

- Maps.newHashMap();
- Maps.newConcurrentMap();
- Maps.newIdentityHashMap();
- Maps.newLinkedHashMap();
- Maps.newTreeMap();

**其他方法**
- asMap(Set<K> set, Function<? super K, V> function) set转map
- difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) 计算map的差值
- filterEntries(Map<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) 通过Entry过滤
- filterKeys(Map<K, V> unfiltered, final Predicate<? super K> keyPredicate) 通过Key过滤
- filterValues(Map<K, V> unfiltered, final Predicate<? super V> valuePredicate) 通过value过滤
- transformEntries(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) 转换Entry
- transformValues(Map<K, V1> fromMap, Function<? super V1, V2> function) 转换value
- uniqueIndex(Iterable<V> values, Function<? super V, K> keyFunction)  根据list中的key生产map
```java
public class MapsTest {
    public static void main(String[] args) {
        MapsTest test = new MapsTest();
        test.setToMap();
        test.difference();
        test.filterEntries();
        test.filterKeys();
        test.filterValues();
        test.transFormEntries();
        test.transformValues();
    }

    public void createDemo() {
        Maps.newHashMap();
        Maps.newHashMapWithExpectedSize(10);
        //Maps.newEnumMap();
        Maps.newConcurrentMap();
        Maps.newIdentityHashMap();

        Maps.newLinkedHashMap();
        Maps.newLinkedHashMapWithExpectedSize(10);

        Maps.newTreeMap();
    }

    /**
     * set TOMap
     */
    public void setToMap() {
        Set<String> set = Sets.newHashSet("a", "b", "c");
        //将set转成Map,key为set元素,value为每个元素的长度
        Map<String, Integer> map = Maps.asMap(set, String::length);
        System.out.println(map);//     {a=1, b=1, c=1}}
    }

    /**
     * 计算map的差值
     */
    public void difference(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> map2 = Maps.newHashMap();
        map2.put("a","1");
        map2.put("e","5");
        map2.put("f","6");
        //mapDifference是将两个map相同的部分剔除
        MapDifference<String,String> mapDifference = Maps.difference(map1,map2);
        //两个Map相同的部分
        System.out.println(mapDifference.entriesInCommon()); //  {a=1}
        //左边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnLeft()); // {b=2, c=3}
        //右边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnRight());// {e=5, f=6}
    }


    /**
     * 通过Entry过滤
     */
    public void filterEntries(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.filterEntries(map1,item -> !item.getValue().equalsIgnoreCase("2"));
        System.out.println(result);// {a=1, c=3}

    }

    /**
     * 通过key过滤
     */
    public void filterKeys(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.filterKeys(map1, item -> !item.equalsIgnoreCase("b"));
        System.out.println(result);// {a=1, c=3}
    }

    /**
     * 过滤value
     */
    public void filterValues(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result =  Maps.filterValues(map1,item -> !item.equalsIgnoreCase("3"));
        System.out.println(result);// {a=1, b=2}
    }

    /**
     * 转换entry
     */
    public void transFormEntries(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.transformEntries(map1,(k,v) -> k + v);
        System.out.println(result);// {a=a1, b=b2, c=c3}
    }

    /**
     * 转换value
     */
    public void transformValues(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.transformValues(map1, value -> value + 10);
        System.out.println(result); // {a=110, b=210, c=310}
    }
    /**
     * uniqueINdex 根据key生成map要确保key值唯一
     */
    public void uniqueIndex(){
        List<Animal> animals = new ArrayList<>();
        ImmutableMap<Integer, Animal> integerAnimalImmutableMap = Maps.uniqueIndex(animals, Animal::getId);
        System.out.println(integerAnimalImmutableMap.entrySet());// []
    }



}
class Animal{
    private Integer id ;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```

## Graphs

## 字符串工具
- Joiner ：实现加入对象，字符串
- Splitter：用于分割字符串
- CharMatcher：字符串操作
- CaseFormat: 用于改变字符串格式


### Joiner
- `<A extends Appendable> A appendTo(A appendable, Iterator<?> parts) `    每个追加部分的字符串表示，使用每个之间先前配置的分离器，可用来追加。
- `StringBuilder appendTo(StringBuilder builder, Iterable<?> parts)`  每个追加部分的字符串表示，使用每个之间先前配置的分离器，为构建者。                                                             		
- `String join(Iterable<?> parts)` 返回一个包含每个部分的字符串表示，使用每个之间先前配置的分隔符的字符串  
                                                            			                                  

### Splitter

- `static Splitter on(char separator)` 返回使用给定的单字符分离器分离器。
- `static Splitter on(CharMatcher separatorMatcher)` 返回一个分离器的匹配考虑由给定CharMatcher是一个分隔任何单个字符。
- `static Splitter onPattern(String separatorPattern)` 返回分离器的考虑任何序列匹配一个给定模式(正则表达式)是一个分隔符。
- `Iterable<String> split(CharSequence sequence)` 分割成序列串组件并使其可通过迭代器，其可以被懒惰地评估计算。
- `List<String> splitToList(CharSequence sequence)`  拆分序列化为字符串组成部分，并将其返回为不可变列表。
                                                      		
### CharMatcher

- `CharMatcher is(char match)`: 返回匹配指定字符的Matcher
- `CharMatcher isNot(char match)`: 返回不匹配指定字符的Matcher
- `CharMatcher anyOf(CharSequence sequence)`: 返回匹配sequence中任意字符的Matcher
- `CharMatcher noneOf(CharSequence sequence)`: 返回不匹配sequence中任何一个字符的Matcher
- `CharMatcher inRange(char startInclusive, char endIncludesive)`: 返回匹配范围内任意字符的Matcher
- `CharMatcher forPredicate(Predicate<? super Charater> predicate)`: 返回使用predicate的apply()判断匹配的Matcher
- `CharMatcher negate()`: 返回以当前Matcher判断规则相反的Matcher
- `CharMatcher and(CharMatcher other)`: 返回与other匹配条件组合做与来判断的Matcher
- `CharMatcher or(CharMatcher other)`: 返回与other匹配条件组合做或来判断的Matcher
- `boolean matchesAnyOf(CharSequence sequence)`: 只要sequence中有任意字符能匹配Matcher,返回true
- `boolean matchesAllOf(CharSequence sequence)`: sequence中所有字符都能匹配Matcher,返回true
- `boolean matchesNoneOf(CharSequence sequence)`: sequence中所有字符都不能匹配Matcher,返回true
- `int indexIn(CharSequence sequence)`: 返回sequence中匹配到的第一个字符的坐标
- `int indexIn(CharSequence sequence, int start)`: 返回从start开始,在sequence中匹配到的第一个字符的坐标
- `int lastIndexIn(CharSequence sequence)`: 返回sequence中最后一次匹配到的字符的坐标
- `int countIn(CharSequence sequence)`: 返回sequence中匹配到的字符计数
- `String removeFrom(CharSequence sequence)`: 删除sequence中匹配到到的字符并返回
- `String retainFrom(CharSequence sequence)`: 保留sequence中匹配到的字符并返回
- `String replaceFrom(CharSequence sequence, char replacement)`: 替换sequence中匹配到的字符并返回
- `String trimFrom(CharSequence sequence)`: 删除首尾匹配到的字符并返回
- `String trimLeadingFrom(CharSequence sequence)`: 删除首部匹配到的字符
- `String trimTrailingFrom(CharSequence sequence)`: 删除尾部匹配到的字符
- `String collapseFrom(CharSequence sequence, char replacement)`: 将匹配到的组(连续匹配的字符)替换成replacement 
- `String trimAndCollapseFrom(CharSequence sequence, char replacement)`: 先trim在replace

## Guava IO

### ByteStreams

### CharStreams


## Guava 反射

## 缓存 Guava Cache

### 应用场景
- 对性能有非常高的要求
- 不经常变化
- 占用内存不大
- 有访问整个集合的需求
- 数据允许不时时一致
### 优势

- 缓存过期和淘汰机制 ：在GuavaCache中可以设置Key的过期时间，包括访问过期和创建过期
GuavaCache在缓存容量达到指定大小时，采用LRU的方式，将不常使用的键值从Cache中删除

- 并发处理能力：GuavaCache类似CurrentHashMap，是线程安全的。提供了设置并发级别的api，使得缓存支持并发的写入和读取
采用分离锁机制，分离锁能够减小锁力度，提升并发能力分离锁是分拆锁定，把一个集合看分成若干partition, 每个partiton一把锁。ConcurrentHashMap就是分了16个区域，这16个区域之间是可以并发的。GuavaCache采用Segment做分区。

- 更新锁定： 一般情况下，在缓存中查询某个key，如果不存在，则查源数据，并回填缓存。（Cache Aside Pattern）在高并发下会出现，多次查源并重复回填缓存，可能会造成源的宕机（DB），性能下降
GuavaCache可以在CacheLoader的load方法中加以控制，对同一个key，只让一个请求去读源并回填缓存，其他请求阻塞等待。

- 集成数据源：  一般我们在业务中操作缓存，都会操作缓存和数据源两部分GuavaCache的get可以集成数据源，在从缓存中读取不到时可以从数据源中读取数据并回填缓存
- 监控缓存加载/命中情况 统计

### 使用方式：

- cacheLoader 实现
- callable callback 实现

通过这两种方法创建的cache，和通常用map来缓存的做法比，不同在于，这两种方法都实现了一种逻辑——从缓存中取key X的值，如果该值已经缓存过了，则返回缓存中的值，如果没有缓存过，可以通过某个方法来获取这个值。但不同的在于cacheloader的定义比较宽泛，是针对整个cache定义的，可以认为是统一的根据key值load value的方法。而callable的方式较为灵活，允许你在get的时候指定

#### cacheLoader  实现方式

```java
/**
 * cache loader方式实现
 */
public class CacheTest1 {
    public static void main(String[] args) {
        // CacheLoader 初始化
        CacheLoader<String, Object> cacheLoader = new CacheLoader<String, Object>() {
            @Override
            // load方法的作用是在通过get方法从LoadingCache获取不到值时去加载该值并放入缓存。
            public String load(String key) throws Exception {
                // 模拟加载值的过程
                Thread.sleep(1000);
                // 假设某个key是非法访问的
                if ("err".equals(key)) {
                    return null;
                }
                return key + "'s value";
            }
        };

        // 移出监听器配置
        RemovalListener<String, Object> removalListener = new RemovalListener<String, Object>() {
            // 移出时触发的事件
            public void onRemoval(RemovalNotification<String, Object> removal) {
                System.out.println("[" + removal.getKey() + ":" + removal.getValue() + "] is evicted!");
            }
        };

        // 创建LoadingCache 主要缓存对象
        LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
                // 设置容量大小
                .maximumSize(5)
                // 设置超时时间
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .expireAfterAccess(10, TimeUnit.SECONDS)
                // 移出监听器
                .removalListener(removalListener)
                // 加载器配置
                .build(cacheLoader);

        // 由于缓存的容易只设置了5个，存入10个就会由guava基于容量回收掉5个
        for (int i = 0; i < 10; i++) {
            String key = "key" + i;
            String value = "value" + i;
            caches.put(key, value);
            System.out.println("[" + key + ":" + value + "] is put into cache!");
        }

        // 如果存在就获取
        System.out.println(caches.getIfPresent("key6"));

        try {
            caches.get("err");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("不存在key，会报错");
        }
    }
}
```

#### callable callback 实现方式

```java
/**
 * callable callback实现方式
 */
public class CacheTest2 {
    // 构建容量为3的缓存对象
    static Cache<String, String> caches = CacheBuilder.newBuilder()
            .maximumSize(3)
            .build();

    public static void main(String[] args) {
        caches.put("zhangsan110", "key为名字+编号");

        // 如果存在就获取，不存在返回null
        System.out.println(caches.getIfPresent("zhangsan110"));

        try {
            // 获取key为zhangsan110的缓存数据，如果有就返回，没有就返回call方法的返回值
            System.out.println(caches.get("zhangsan110", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "没有获取到key执行";
                }
            }));

            // 获取key为110的缓存数据，如果有就返回，没有就返回call方法的返回值。
            System.out.println(caches.get("110", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "没有获取到key执行";
                }
            }));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    //key为名字+编号
    //key为名字+编号
    //没有获取到key执行

}
```
### 参数说明
**回收的参数**

1. 大小的设置：CacheBuilder.maximumSize(long)  CacheBuilder.weigher(Weigher)  CacheBuilder.maxumumWeigher(long)
2. 时间：expireAfterAccess(long, TimeUnit) expireAfterWrite(long, TimeUnit)
3. 引用：CacheBuilder.weakKeys() CacheBuilder.weakValues()  CacheBuilder.softValues()
4. 明确的删除：invalidate(key)  invalidateAll(keys)  invalidateAll()
5. 删除监听器：CacheBuilder.removalListener(RemovalListener)

**refresh机制**

1. LoadingCache.refresh(K)  在生成新的value的时候，旧的value依然会被使用。
2. CacheLoader.reload(K, V) 生成新的value过程中允许使用旧的value
3. CacheBuilder.refreshAfterWrite(long, TimeUnit) 自动刷新cache

### 数据移除

GuavaCache的时间移除方式分为：主备移除和被动移除

#### 主动移除方式

- 个别清除： Cache.invalidate(key)
- 批量清除：Cache.invalidateAll(keys)
- 清除所有缓存项：Cache.invalidateAll()

#### 被动移除方式
- 基于数据大小删除
- 基于过期时间删除，隔多久没有被访问过的key删除
- 基于引用删除。可以通过weakKeys和weakValues方法指定Cache只保存对缓存记录key和value的弱引用。这样当没有其他强引用指向key和value时，key和value对象就会被垃圾回收器回收

### guavaCache 核心原理

#### 数据结构
Guava Cache的数据结构跟ConcurrentHashMap类似，但也不完全一样。最基本的区别是ConcurrentMap会一直保存所有添加的元素，直到显式地移除。
相对地，Guava Cache为了限制内存占用，通常都设定为自动回收元素

LocalCache为Guava Cache的核心类，包含一个Segment数组组成 Segeent数组的长度决定了cache的并发数
每一个Segment使用了单独的锁，其实每个Segment继承了ReentrantLock，对Segment的写操作需要先拿到锁

每个Segment由一个table和5个队列组成

**5个队列：**

- ReferenceQueue keyReferenceQueue ： 已经被GC，需要内部清理的键引用队列
- ReferenceQueue valueReferenceQueue ： 已经被GC，需要内部清理的值引用队列
- ConcurrentLinkedQueue<ReferenceEntry<k,v>> recencyQueue : LRU队列，当segment上达到临界值发生写操作时该队列会移除数据
- Queue<ReferenceEntry<K, V>> writeQueue：写队列，按照写入时间进行排序的元素队列，写入一个元素时会把它加入到队列尾部
- Queue<ReferenceEntry<K, V>> accessQueue：访问队列，按照访问时间进行排序的元素队列，访问(包括写入)一个元素时会把它加入到队列尾部

**1个table：**

- AtomicReferenceArray<ReferenceEntry<K, V>> table：AtomicReferenceArray可以用原子方式更新其元素的对象引用数组
- ReferenceEntry<k,v> ReferenceEntry是Guava Cache中对一个键值对节点的抽象，每个ReferenceEntry数组项都是一条ReferenceEntry链。并且一个ReferenceEntry包含key、hash、valueReference、next字段
（单链）Guava Cache使用ReferenceEntry接口来封装一个键值对，而用ValueReference来封装Value值

#### 回收机制
Guava Cache提供了三种基本的缓存回收方式：

- 基于容量回收

在缓存项的数目达到限定值之前，采用LRU的回收方式

- 定时回收

expireAfterAccess：缓存项在给定时间内没有被读/写访问，则回收。回收顺序和基于大小回收一样（LRU）
expireAfterWrite：缓存项在给定时间内没有被写访问（创建或覆盖），则回收

- 基于引用回收

通过使用弱引用的键、或弱引用的值、或软引用的值，Guava Cache可以垃圾回收
除了以上三种还有主动删除，采用命令，上面已写过

GuavaCache构建的缓存不会"自动"执行清理和回收工作，也不会在某个缓存项过期后马上清理，也没有诸如此类的清理机制。

GuavaCache是在每次进行缓存操作的时候，惰性删除 如get()或者put()的时候，判断缓存是否过期


#### Segment定位
先通过key做hash定位到所在的Segment

通过位运算找首地址的偏移量 SegmentCount>=并发数且为2的n次方

```V get(K key, CacheLoader<? super K, V> loader) throws ExecutionException {
	// 注意，key不可为空
	int hash = hash(checkNotNull(key));
	// 通过hash定位到segment数组的某个Segment元素，然后调用其get方法
	return segmentFor(hash).get(key, hash, loader);
}
```
再找到segment中的Entry链数组，通过key的hash定位到某个Entry节点

```
V get(K key, int hash, CacheLoader<? super K, V> loader) throws
ExecutionException {
	checkNotNull(key);
	checkNotNull(loader);
	try {
		if (count != 0) { // read-volatile
		// 内部也是通过找Entry链数组定位到某个Entry节点
		ReferenceEntry<K, V> e = getEntry(key, hash);
		......
    }cache(){
}
}

```

## Guava EventBus
传统上，Java的进程内事件分发都是通过发布者和订阅者之间的显式注册实现的。设计EventBus就是为了取代这种显示注册方式，使组件间有了更好的解耦。EventBus不是通用型的发布-订阅实现，不适用于进程间通信。

```java
// Class is typically registered by the container.
class EventBusChangeRecorder {
    @Subscribe 
    public void recordCustomerChange(ChangeEvent e) {
        recordChange(e.getChange());
    }
}
// somewhere during initialization
eventBus.register(new EventBusChangeRecorder());
// much later
public void changeCustomer() {
    ChangeEvent event = getChangeEvent();
    eventBus.post(event);
}
```

### 事件监听者[Listeners]

- 监听特定事件（如，CustomerChangeEvent）：

传统实现：定义相应的事件监听者类，如CustomerChangeEventListener；

EventBus实现：以CustomerChangeEvent为唯一参数创建方法，并用Subscribe注解标记。

- 把事件监听者注册到事件生产者：

传统实现：调用事件生产者的registerCustomerChangeEventListener方法；这些方法很少定义在公共接口中，因此开发者必须知道所有事件生产者的类型，才能正确地注册监听者；

EventBus实现：在EventBus实例上调用EventBus.register(Object)方法；请保证事件生产者和监听者共享相同的EventBus实例。

- 按事件超类监听（如，EventObject甚至Object）：

传统实现：很困难，需要开发者自己去实现匹配逻辑；

EventBus实现：EventBus自动把事件分发给事件超类的监听者，并且允许监听者声明监听接口类型和泛型的通配符类型（wildcard，如 ? super XXX）。

- 检测没有监听者的事件：

传统实现：在每个事件分发方法中添加逻辑代码（也可能适用AOP）；

EventBus实现：监听DeadEvent；EventBus会把所有发布后没有监听者处理的事件包装为DeadEvent（对调试很便利）。

### 事件生产者[Producers]

- 管理和追踪监听者：

传统实现：用列表管理监听者，还要考虑线程同步；或者使用工具类，如EventListenerList；
EventBus实现：EventBus内部已经实现了监听者管理。

- 向监听者分发事件：

传统实现：开发者自己写代码，包括事件类型匹配、异常处理、异步分发；
EventBus实现：把事件传递给 EventBus.post(Object)方法。异步分发可以直接用EventBus的子类AsyncEventBus。

### EVentBus使用
消息记录
```java
/**
 * 发布接口
 **/
public interface EventService {
    /**
     * 发布事件
     *
     * @param event
     */
    void publishEvent(Object event);
}
@Slf4j
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventBus eventBus;

    @Override
    public void publishEvent(Object event) {
        log.debug("publish event: {}", event);
        eventBus.post(event);
    }
}
```
发布者
```java
/**
 * 可记录操作日志,标记接口
 *
 * @author hanbd
 */
public interface ILoggable {
    /**
     * 获取操作日志
     *
     * @return
     */
    OperationLog getLog();
}

/**
 * 基础事件
 *
 * @author hanbd
 */
@Data
@SuperBuilder
public abstract class BaseEvent {
    /**
     * 触发人{@link User#getId() userId}
     */
    protected Integer userId;
    /**
     * 触发时间
     */
    protected LocalDateTime triggerTime;
    /**
     * 事件类型
     */
    protected EventTypeEnum eventType;
    /**
     * 企业id
     */
    @NotNull
    protected Integer entId;
    /**
     * 项目Id
     */
    @Nullable
    protected Integer projectId;
    /**
     * 标段id
     */
    @Nullable
    protected Integer sectionId;
    /**
     * 单位工程Id
     */
    @Nullable
    protected Integer unitId;
    protected ProjectLevelInfo levelInfo;

    protected BaseEvent(Integer userId, EventTypeEnum eventType, ProjectLevelInfo levelInfo) {
        if (!isAllowedEventType(eventType)) {
            throw new IllegalArgumentException("illegal eventType");
        }
        this.entId = TenantUtils.DEFAULT_TENANT;
        this.userId = Preconditions.checkNotNull(userId);
        this.eventType = Preconditions.checkNotNull(eventType);
        this.triggerTime = LocalDateTime.now();
        this.levelInfo = levelInfo;
        if (Objects.nonNull(levelInfo)) {
            this.projectId = levelInfo.getProjectId();
            this.sectionId = levelInfo.getSectionId();
            this.unitId = levelInfo.getUnitId();
        }
    }

    /**
     * 是否是允许的事件类型
     *
     * @param eventType
     * @return
     */
    public final boolean isAllowedEventType(EventTypeEnum eventType) {
        return allowedEventTypeSet().contains(eventType);
    }

    /**
     * 允许的事件类型集合
     *
     * @return
     */
    protected abstract EnumSet<EventTypeEnum> allowedEventTypeSet();
}

/**
 * 增删改查事件。增删改查全部记录日志
 *
 * @author hanbd
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public abstract class AbstractLoggableEvent extends BaseEvent implements ILoggable {
    protected AbstractLoggableEvent(Integer userId, EventTypeEnum eventType, ProjectLevelInfo levelInfo) {
        super(userId, eventType, levelInfo);
    }

    @Override
    public OperationLog getLog() {
        LogBizInfo bizInfo = bizInformation();
        return OperationLog.builder()
                .userId(userId)
                .operationTime(triggerTime)
                .eventType(eventType)
                .entId(TenantUtils.DEFAULT_TENANT)
                .projectId(projectId)
                .sectionId(sectionId)
                .unitId(unitId)
                .subjectId(bizInfo.getSubjectId())
                .secondSubjectId(bizInfo.getSecondSubjectId())
                .thirdSubjectId(bizInfo.getThirdSubjectId())
                .memo(MoreObjects.firstNonNull(bizInfo.getMemo(), "无"))
                .build();
    }

    /**
     * 日志业务信息
     *
     * @return
     */
    protected abstract LogBizInfo bizInformation();
}

public class IssueEvent extends AbstractLoggableEvent {

    private final Issue issue;
    private final User user;
    private final EventTypeEnum eventType;

    public IssueEvent(User user, EventTypeEnum eventType, Issue issue) {
        super(user.getId(), eventType, issue.getLevelInfo());
        this.user = user;
        this.issue = issue;
        this.eventType = eventType;
    }

    @Override
    protected LogBizInfo bizInformation() {
        String action;
        switch (eventType) {
            case CREATE_ISSUE:
                action = "新增问题";
                break;
            case DELETE_ISSUE:
                action = "删除问题";
                break;
            default:
                throw new IllegalArgumentException("非问题事件类型");
        }
        String memo = String.format("%s%s #%d-%s",
                user.getUsername(), action, issue.getId(), issue.getDescription());
        return LogBizInfo.builder()
                .memo(memo)
                .subjectId(issue.getId())
                .build();
    }

    @Override
    protected EnumSet<EventTypeEnum> allowedEventTypeSet() {
        return EnumSet.of(EventTypeEnum.CREATE_ISSUE, EventTypeEnum.DELETE_ISSUE,
                EventTypeEnum.SOLVE_ISSUE, EventTypeEnum.CHECK_REJECT_ISSUE,
                EventTypeEnum.CHECK_PASS_ISSUE, EventTypeEnum.REVIEW_REJECT_ISSUE,
                EventTypeEnum.REVIEW_PASS_ISSUE);
    }
}
```

业务中使用

```java
// 业务中使用
IssueEvent issueEvent = new IssueEvent(getUser(), EventTypeEnum.CREATE_ISSUE, issue);
eventService.publishEvent(issueEvent);
```
订阅者

```java
   @Subscribe
    @SuppressWarnings("UnstableApiUsage")
    public void receiveIssueEvent(IssueEvent event) {
        EventTypeEnum eventType = event.getEventType();
        switch (eventType) {
            case CREATE_ISSUE:
            case SOLVE_ISSUE:
            case CHECK_PASS_ISSUE:
            case CHECK_REJECT_ISSUE:
            case REVIEW_REJECT_ISSUE:
                break;
            default:
                return;
        }
        Issue issue = event.getIssue();
        IssueDetailVO issueDetail = issueService.getIssueDetail(issue.getId());
        IssueVO issueSolve = issueDetail.getSubmitHistory();
        List<IssueHistoryVO> issueHistories = issueDetail.getHistory();
        String questionType = IssueType.of(issue.getType()).getName();
        List<KvPair> kvList = Lists.newArrayList();
        String title;
        String body;
        MsgJumpType msgJumpType;
        MsgModuleType msgModuleType;
        IssueHistoryVO history;
        PrjPerson creator = personService.getPerson(issue.getSubmitterId())
                .orElseThrow(() -> new CommonException("人员不存在"));
        List<User> receivers;
        String bizStr;
        switch (event.getEventType()) {
            case CREATE_ISSUE:
                String creatorName = creator.getName();
                title = String.format("有一条%s问题待处理", questionType);
                body = String.format("%s上报了问题<span>%s</span>，请及时查看并处理", creatorName, issue.getDescription());
                kvList.add(new KvPair("问题类型", questionType));
                kvList.add(new KvPair("上报人", creatorName));
                kvList.add(new KvPair("上报时间", formatTime(issue.getSubmitTime())));
                // 接收人
                receivers = personToUser(issueSolve.getSolvers());
                msgModuleType = issue.getType().equals(1) ? MsgModuleType.QUALITY_QUESTION_EXECUTE : MsgModuleType.SAFE_QUESTION_EXECUTE;
                msgJumpType = MsgJumpType.QUESTION_EXECUTE;
                bizStr = "待处理";
                break;
           
            default:
                return;
        }
        // 发送个推消息
    }
```
## 并发


### Guava Monitor

### ListenableFuture

### FutureCallback

### SetableFuture

### AsuncFallback

### Futures

### RateLimiter                                       			



