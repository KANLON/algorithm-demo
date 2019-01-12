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

##### 拓展：用两个队列实现栈

#### 面试题8：旋转数组的最小数字
题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.

答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/rotate'>rotate</a>

#### 面试题9：斐波那契数列
题目一：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。斐波那契数列的定义如下：
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/fibonacci.PNG"/><br/>
题目2：一只青蛙一次可以跳上1个台阶，可以跳上2级。求该青蛙跳上一个n级的台阶共有多少种跳法。（等价于题目1）<br/>

##### 拓展题目：<br/>
拓展1：在青蛙跳台阶的问题中，如果把条件改成：一只青蛙一次可以跳上1级台阶，也可以跳上2级。。。。。。它也可以跳上n级，此时该青蛙跳上一个台阶总共有多少种跳法？<br/>
拓展2：我们可以用2X1（下图左边）的小矩形横着或者竖着去覆盖更大的矩形。请问用8个2X1的小矩形无重叠地覆盖一个2X8的大矩形（下图右边），总共有多少种方法？<br/>
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/matrix28.PNG"/><br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/fibonacci'>fibonacci</a><br/>

#### 面试题10：二进制中1的个数
题目：请实现一个函数，输入一个整数，输出该数二进制中1的个数。例如把9表示成二进制是1001，有2位是1。因此，如果输入9，该函数输出2。
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/numof1inbinary'>numof1inbinary</a><br/>

#### 面试题11：数值的整数次方
题目：实现函数double Power(double base,int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。<br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/power'>power</a><br/>

#### 面试题12：打印1到最大的n位数
题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999.<br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/printnumber'>printnumber</a><br/>
<br/>
##### 拓展：定义一个函数，在该函数中可以实现任意两个整数的加法。

#### 面试题13：在O(1)时间删除链表结点
题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。链表结点和函数的定义如下：
```
class ListNode{
	int mNValue;
	ListNode mPNext;
}
public void deleteNode(ListNode pListHead,ListNode pToBeDeleted);
	
```
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/deletenode'>deletenode</a><br/>
<br/>

#### 面试题14：调整数组顺序使奇数位于偶数前面
题目：输入一个整数数组，实现一个函数来调整该数组中的数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/recorderarray'>recorderarray</a><br/>
<br/>

#### 面试题15：链表中倒数第k个结点
题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点时倒数第1个结点。例如一个链表有6个结点，从头结点开始它们的值依次是1、2、3、4、5、6这个链表的倒数第3个结点是值为4的结点。
链表结点定义如下：
```
class ListNode{
	int m_nvalue;
	ListNode m_pNext;
}
```


答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/kth_node_from_end'>KthNodeFromEnd</a><br/>
<br/>

##### 拓展题目：<br/>
拓展1：求链表的中间结点。如果链表中结点总数为奇数，则返回中间结点，如果结点总数是偶数，则返回中间两个结点的任意一个。<br/>
拓展题目2：判断一个单项链表是否形成了环形结构。<br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/kth_node_from_end'>kth_node_from_end</a><br/>

#### 面试题16：反转链表
题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。<br/>
链表结点定义如下：
```
class ListNode{
	int m_nvalue;
	ListNode m_pNext;
}
```

答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/reverse_list'>ReverseList</a><br/>
<br/>

#### 面试题17：合并两个排序的链表
题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然按照递增排序的。例如输入如下图中的链表1和链表2，则合并后的升序链表如链表3所示。<br/>
链表结点定义如下：
```
class ListNode{
	int m_nvalue;
	ListNode m_pNext;
}
```
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/combine_list.PNG"/><br/>

答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/merge_sorted_lists'>mergeSortedLists</a><br/>
<br/>


#### 面试题18：树的子结构
题目：输入两颗二叉树A和B，判断B是不是A的子结构。二叉树结点的定义如下：<br/>
二叉树的定义如下：
```
class BinaryTreeNode{
	int mNValue;
	BinaryTreeNode mPLeft;
	BinaryTreeNode mPRight;
}
```
例如：下图中的两颗二叉树，由于A中有一部分子树的结构和B是一样的，因此B是A的子结构。
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/sub_tree.PNG"/><br/>


答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/sub_tree'>sub_tree</a><br/>
<br/>

#### 面试题19：二叉树的镜像
题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。<br/>
二叉树的定义如下：
```
class BinaryTreeNode{
	int mNValue;
	BinaryTreeNode mPLeft;
	BinaryTreeNode mPRight;
}
```
例如下图右边的二叉树就是左边的树的镜像<br/>
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/tree_mirror.PNG"/><br/>
答案:<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/tree_mirror'>tree_mirror</a><br/>
<br/>

####  面试题20：顺时针打印矩阵
题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。例如：如果输入如下矩阵：
```
1  2  3  4
5  6  7  8 
9  10 11 12
13 14 15 16
```
则依次打印出数字1、2、3、4、8、12、16、15、14、13、9、5、6、7、11、10<br/>
答案:<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/matrix_clockwise'>matrix_clockwise</a><br/>
<br/>


### 面试题21：包含min函数的栈
题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)<br/>
答案:<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/stack_with_min'>stack_with_min</a><br/>
<br/>

### 面试题22：栈的压入、弹出序列
题目：输入两个整数序列，第一个序列表示栈顶压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、5是某栈的压栈序列。序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但4、3、5、1、2就不可能是该压栈序列的弹出序列。<br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/stack_push_pop_order'>stack_push_pop_order</a><br/>
<br/>

### 面试题23：从上往下打印二叉树
题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。例如输入如下图中的二叉树，则依次打印出8、6、10、5、7、9、11<br/>
二叉树的定义如下：
```
class BinaryTreeNode{
	int mNValue;
	BinaryTreeNode mPLeft;
	BinaryTreeNode mPRight;
}
```
<br/>
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/binary_tree_top_to_bottom.PNG"/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/binary_tree_top_to_bottom'>binary_tree_top_to_bottom</a><br/>
<br/>

### 面试题24：二叉搜索树的后序遍历序列
题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。<br/>
例如输入数组{5,7,6,9,11,10,8},则返回true,因为这个整数序列是如下图二叉搜索树的后序搜索结果。如果输入的数组是{7,4,6,5},由于没有哪棵二叉搜索树的后序遍历的结果是这个序列，因此返回false。<br/>
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/squence_of_BST.PNG"/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/squence_of_bst'>squence_of_bst</a><br/>
<br/>


### 面试题25：二叉树中和为某一值的路径
题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点形成一条路径。<br/>
二叉树的定义如下：
```
class BinaryTreeNode{
	int mNValue;
	BinaryTreeNode mPLeft;
	BinaryTreeNode mPRight;
}
```
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/path_in_tree'>path_in_tree</a><br/>
<br/>

### 面试题26：复杂链表的复制
题目：请实现函数ComplexListNode clone(ComplexListNode pHead),复制一个复杂的链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任意结点或者null。结点的定义如下：<br/>
```
class ComplexListNode{
	int m_nValue;
	ComplexListNode m_pNext;
	ComplexListNode m_pSibling;
}
```
例如如下图是一个含有5个结点的复杂链表。图中实线箭头表示m_pNext指针，虚线箭头表示m_pSibling指针。为了简单起见，指向null指针没有画出。<br/>
<img alt="一个含有5个结点的复杂链表"     src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/copy_complex_list.PNG"/>


答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/copy_complex_list'>copy_complex_list</a><br/>
<br/>

### 面试题27：二叉搜索树和双向链表
题目：输入一颗二叉搜索树，将二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。比如输入如下图中左边的二叉搜索树，则输出转换之后的排序双向链表。<br/>
二叉树的定义如下：
```
class BinaryTreeNode{
	int mNValue;
	BinaryTreeNode mPLeft;
	BinaryTreeNode mPRight;
}
```
<img alt="一颗二叉搜索树及转换之后的排序双向链表" src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/convert_binary_search_tree.PNG"/><br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/convert_binary_search_tree'>convert_binary_search_tree</a><br/>
<br/>



### 面试题28：字符串的排序
题目：输入一个字符串，打印出该字符串中字符的所有排序。例如输入字符串abc，则打印出由字符a、b、c所能排序出来的所有字符串abc、acb、bac、bca、cab和cba<br/>
答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/string_permutation'>string_permutation</a><br/>
<br/>
##### 拓展题目：<br/>

拓展题目1：如果输入n个字符，则这n个字符能构成长度为1的组合、长度为2的组合、。。。、长度为n的组合。求n个字符的所有的组合（所有长度）<br/>

答案：<br/>
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/string_permutation'>string_permutation</a><br/>






### 其他题目
1.实现一个排序算法，要求时间效率O(n).对公司所有员工的年龄排序，公司总共有几万名员工。可以用辅助空间，只允许使用常量大小辅助空间，不得超过O(n)。<br/>
答案：
<a href='https://github.com/KANLON/algorithmDemo/tree/master/interviewOffer/src/com/kanlon/nsort'>nsort</a>

2.比较两个数组是否相等，都含有一样的元素，并且一样的元素的个数相同。<br/>
答案：
[comareEquals](https://github.com/KANLON/algorithmDemo/tree/master/other/compareEquals.java)

3.对字符数组进行全排序，要求输出全排序的结果。例如：对{a,b,c}全排序输出：abc,acb,bac,bca,cba,cab。<br/>
答案：
[totalsort](https://github.com/KANLON/algorithmDemo/tree/master/other/totalsort)




## 算法技巧
1.如果要筛选出某个相同的数，使用HashMap。<br/><br/>
2.如果要筛选出某个不同的数，可以使用异或运算。<br/><br/>
3.如果从前往后复制每个数字（或字符）需要移动数字（或字符）多次，可以考虑从后往前复制。<br/><br/>
4.把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于是把整数的二进制表示中的最右边一个1变成0.<br/><br/>
5.当用一个指针遍历链表不能解决问题的时候，可以使用两个指针遍历链表。可以让其中一个指针遍历的速度快一点，或者让它先在链表上走若干步。<br/><br/>
6.如果面试题是要求处理一棵二叉树的遍历序列，我们可以先找到二叉树的根结点，再基于根结点把整棵树的遍历序列拆分成左子树对应的子序列和右子树对应的子序列，接下来再递归地处理这两个子序列。<br/><br/>
