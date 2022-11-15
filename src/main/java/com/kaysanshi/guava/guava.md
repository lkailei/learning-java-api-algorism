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

### 集合工具
- MultiSet:一个扩展来设置界面，允许重复的元素。
- Multimap:一个扩展来映射接口，以便其键可一次被映射到多个值
- BiMap: 一个扩展来映射接口，支持反向操作
- Table:表代表一个特殊的图，其中两个键可以在组合的方式被指定为单个值。

### Multiset类

Multiset接口扩展设置有重复的元素，并提供了各种实用的方法来处理这样的元素在集合中出现。

- `boolean add(E element)` 添加一个出现的指定元素这个multiset。
- `int add(E element, int occurrences)` 增加大量的元素到这个multiset。
- `boolean contains(Object element)` 确定此多集是否包含指定的元素。
- `boolean containsAll(Collection<?> elements)` 返回true，如果这个多集至少包含一个出现的指定集合中的所有元素。
- `int count(Object element)` 返回出现的元素的在该multiset的数目（元素的数量）。
- `Set<E> elementSet()` 返回集包含在此多集不同的元素。
- `Set<Multiset.Entry<E>> entrySet()` 返回此多集的内容的视图，分组在Multiset.Entry实例中，每一个都提供了多集的一个元素和元素的计数。

                                                                 		
### Multimap类
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
### BiMap类

### Table类

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

                                                      		
                                                      			                                               		
                                                  		
                                                  			                                                        		
                                                       		
                                                       			

                                           		
                                                 			



