## 概述
该项目存放一些自己做过的算法的题目，主要以《剑指offer》中的算法为主。
<br/>
### 题目
#### 面试题1：赋值运算符函数（由于该题为C++题目，暂时不做解答）
题目：如下为类型CMyString的声明，请为该类型添加赋值运算符函数。
class  CMyString{
	public CMyString();
}

#### 面试题2：实现Singleton模式
题目：设计一个类，我们只能生成该类的一个实例。<br/><br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/singleton'>singleton</a>


#### 面试题3：二维数组中的查找
题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
<br/>
例如下面的二维数组就是每行、每列都递增排序。如果在这个数组中查找数字7，则返回true；如果查找数字5，由于数组不含有该数字，则返回false。
<br/>
```
1      2      8     9
2      4      9     12
4      7      10    13
6      8      11    15
```
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/array'>array</a>

#### 面试题4：替换空格
题目：请实现一个函数，把字符串中每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。
<br/>其实这里应该表述成，把字符数组中的空格替换为%20。这样才能体现出这个题目问题的本质。
<br/><br/>
扩展：有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。请实现一个函数，把A2中的所有数字插入到A1中并且所有数字都是排序的。<br/><br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/blank'>blank</a>

#### 面试题5：从尾到头打印链表
题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。<br/>
链表的结点定义如下：
```
class ListNode
{
	int mNKey;
	ListNode mPNext;
}
```
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/listnode'>listnode</a>

#### 面试题6：重建二叉树
题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出该图6所示的二叉树并输出它的头结点。二叉树结点的定义如下：
```
class BinaryTreeNode{
int mNValue;
BinaryTreeNode mPLeft;
BinaryTreeNode mPRight;
}
```
图6
<img src='https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/binary_example.PNG'/>

答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/treenode'>treenode</a>


#### 面试题7：用两个栈实现队列
题目：用两个栈实现一个队列。队列的声明如下，，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
```
class CQueue{
	public CQueue(){};
	public void appendTail(T node){}
	public T deleteHead();
	
	private Stack<T> stack1;
	private Stack<T> stack2;
}
```

答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/queue2stack'>queue2stack</a>

拓展：用两个队列实现栈

#### 面试题8：旋转数组的最小数字
题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.

答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/rotate'>rotate</a>

#### 面试题9：斐波那契数列
题目一：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。斐波那契数列的定义如下：
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/fibonacci.PNG"/><br/>
题目2：一只青蛙一次可以跳上1个台阶，可以跳上2级。求该青蛙跳上一个n级的台阶共有多少种跳法。（等价于题目1）<br/>

拓展题目：<br/>
拓展1：在青蛙跳台阶的问题中，如果把条件改成：一只青蛙一次可以跳上1级台阶，也可以跳上2级。。。。。。它也可以跳上n级，此时该青蛙跳上一个台阶总共有多少种跳法？<br/>
拓展2：我们可以用2X1（下图左边）的小矩形横着或者竖着去覆盖更大的矩形。请问用8个2X1的小矩形无重叠地覆盖一个2X8的大矩形（下图右边），总共有多少种方法？<br/>
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/matrix28.PNG"/><br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/fibonacci'>fibonacci</a>














### 其他题目
1.实现一个排序算法，要求时间效率O(n).对公司所有员工的年龄排序，公司总共有几万名员工。可以用辅助空间，只允许使用常量大小辅助空间，不得超过O(n)。
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/nsort'>nsort</a>

2.比较两个数组是否相等，都含有一样的元素，并且一样的元素的个数相同。
答案：<br/>
[comareEquals](https://github.com/KANLON/algorithmDemo/tree/master/other/compareEquals.java)

## 算法技巧
1.如果要筛选出某个相同的数，使用HashMap。<br/>
2.如果要筛选出某个不同的数，可以使用异或运算。<br/>
3.如果从前往后复制每个数字（或字符）需要移动数字（或字符）多次，可以考虑从后往前复制。

