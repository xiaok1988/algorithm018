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
### poll
### peek

### add
### remove
### element
 



​                                         
​                                         
​                                         
​                                         






