学习笔记

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

因为没有具体实现，只是分析接口中实现的上述六个方法的话相对简单。  
但是需要注意的是，所谓的返回异常值，并不是说这个方法不会抛出异常，只是不会抛出IllegalStateException 。
B中的方法可以抛出  
ClassCastException   
NullPointerException   
IllegalArgumentException   
三种异常  

# PriorityQueue源码阅读

PriorityQueue是一个类，它继承了AbstractQueue.  
它的初始大小是11.即不指定大小的话，新建的优先队列大小为11.    
`private static final int DEFAULT_CAPACITY = 11;`

优先队列的最底层是一个数组，以二叉堆的形式组织内容。即一个元素starget[n] 有两个子节点，starget[2n+1] 和 storage[2n+2], 
子节点大于或等于父节点。
                                        
                                         
                                         
                                         
                                         






