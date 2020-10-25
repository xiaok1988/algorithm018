# 改写Deque
```
 import java.util.Deque;
 import java.util.LinkedList;
 
 public class UseNewAPIForDeque {
     public static void main(String[] args) {
         Deque<String> deque = new LinkedList<String>();
         deque.addFirst("a");
         deque.addFirst("b");
         deque.addFirst("c");
         System.out.println(deque);
         String str =  deque.getFirst();
         System.out.println(str);
         System.out.println(deque);
         while (deque.size() > 0) {
             System.out.println(deque.removeFirst());
         }
         System.out.println(deque);
     }
 }
```

# Queue源码阅读

Queue是一个接口，所以源码文件里只有该接口对外提供的API，而没有具体实现。  
Queue作为队列的接口，它遵循的先进先出原则，即FIFO原则。 
它对外提供的接口分为两种，一种是条件不满足时抛出异常，一种是条件不满足无法做该操作时返回异常值，如null或false  
## A.抛出异常                                 
### a. 插入                                   
add                                      
### b. 删除                                 
remove                                 
### c. 取值                                  
element    

## B.返回异常值  
### a. 插入  
offer  
### b. 删除 
poll 
### c. 取值  
peek                             

因为没有具体实现，只是分析接口中定义的上述六个方法的话相对简单。  
但是需要注意的是，所谓的返回异常值，并不是说这个方法不会抛出异常，只是不会抛出IllegalStateException 。
B中的方法可以抛出  
ClassCastException   
NullPointerException   
IllegalArgumentException   
三种异常  

# PriorityQueue源码阅读

读的是openjdk-8的代码，跟老师提供的网页上的代码不完全一致。

PriorityQueue是一个类，它继承了AbstractQueue.  
它的初始大小是11.即不指定大小的话，新建的优先队列大小为11.    
`private static final int DEFAULT_CAPACITY = 11;`

优先队列的最底层是一个数组`Object[] queue;`，以二叉堆的形式组织内容。即一个元素queue[n] 有两个子节点，
queue[2n+1] 和 queue[2n+2]，子节点大于或等于父节点，是一个最小堆实现。  
下面我们看看一些基础API的实现。  

## 构造函数  
优先队列这个数据结构提供了7个构造函数，分别枚举两个参数，一个初始大小，一个比较器的有无，一共是2*2 = 4个构造函数。还有3个，
是传参为一个其他的有序列表（SortedSet或者另一个优先队列,或者一个泛型的collection）。对于这三种情况，我们需要保持原先序列的
有序性。对于SortedSet， 我们是依次将集合中的元素加到底层`queue`数组里，对于优先队列，我们是直接参数内部的`queue`数组复制到
底层数组里。而对于任意Collection的情况，除了复制数组之外，还有进行heapify操作，即保持最小堆的有序性。

## Queue API 的实现  
### offer
```
public boolean offer(E e) {
   if (e == null)
       throw new NullPointerException();
   modCount++;
   int i = size;
   if (i >= queue.length)
       grow(i + 1);
   size = i + 1;
   if (i == 0)
       queue[0] = e;
   else
       siftUp(i, e);
   return true;
}
```
### poll
```
public E poll() {
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    E result = (E) queue[0];
    E x = (E) queue[s];
    queue[s] = null;
    if (s != 0)
        siftDown(0, x);
    return result;
}

```
### peek
```
public E peek() {
    return (size == 0) ? null : (E) queue[0];
}

```

### add
同offer(直接调用)

从上面offer和poll的代码可以看到，最重要的操作，就是维持堆排序的方法调用，siftUp和siftDown.下面主要分析
这两个方法。

### siftUp
```
private void siftUp(int k, E x) {
    if (comparator != null)
        siftUpUsingComparator(k, x);
    else
        siftUpComparable(k, x);
}
```

### siftDown
```
private void siftDown(int k, E x) {
    if (comparator != null)
        siftDownUsingComparator(k, x);
    else
        siftDownComparable(k, x);
}

```

从上可以看出，siftUp和siftDown都有两个版本，一个使用comparator的实现，一个使用comparable的实现。
我们只看usingComparator的实现就好，另一个同理。

### siftUpUsingComparator
```
private void siftUpUsingComparator(int k, E x) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (comparator.compare(x, (E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}

```

### siftDownUsingComparator
```
private void siftDownUsingComparator(int k, E x) {
    int half = size >>> 1;
    while (k < half) {
        int child = (k << 1) + 1;
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            comparator.compare((E) c, (E) queue[right]) > 0)
            c = queue[child = right];
        if (comparator.compare(x, (E) c) <= 0)
            break;
        queue[k] = c;
        k = child;
    }
    queue[k] = x;
}

```



​                                         
​                                         
​                                         
​                                         






