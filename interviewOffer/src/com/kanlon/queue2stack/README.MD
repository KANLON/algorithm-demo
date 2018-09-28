### 面试题7：用两个栈实现队列
#### 题目：
用两个栈实现一个队列。队列的声明如下，，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
```
class CQueue{
	public CQueue(){};
	public void appendTail(T node){}
	public T deleteHead();
	
	private Stack<T> stack1;
	private Stack<T> stack2;
}
```

### 解题思路
用两个栈实现一个队列。实现思路：当添加队列元素的时候，往栈1添加，当删除队列元素的时候，先检查栈2是否为null，如果为null则从栈1出栈元素加入到栈2中，知道剩下一个元素时，则该元素时队列要删除的元素,如果栈1也为空，则删除失败，已经没有元素。
当检查栈2不为null时，则从栈2出栈。

<img src='https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/queue_with_stacks.PNG'>

拓展：

#### 题目：
用两个队列实现一个栈


### 解题思路
用两个队列实现的一个栈，解题思路：入栈时，向队列1添加元素，出栈时，先判断队列1的元素是否为null，如果不为null则将队列1元素出队到队列2中知道队列1中剩下1个时，则将其出栈。
 如果队列1的元素为null，则检查队列2中的元素是否为null，如果不为null则将队列2中的元素出队到队列1中，直到剩下一个时，将其出栈，如果队列2也为null，表示栈没有元素了
 
 <img src='https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/stack_with_queues.PNG'>

 
 