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
<a href='/interviewOffer/src/com/kanlon/singleton'>singleton</a>


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
<a href='/interviewOffer/src/com/kanlon/array'>array</a>

#### 面试题4：替换空格
题目：请实现一个函数，把字符串中每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。
<br/>其实这里应该表述成，把字符数组中的空格替换为%20。这样才能体现出这个题目问题的本质。
<br/><br/>
扩展：有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。请实现一个函数，把A2中的所有数字插入到A1中并且所有数字都是排序的。<br/><br/>
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/blank'>blank</a>

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
<a href='/interviewOffer/src/com/kanlon/listnode'>listnode</a>

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
<a href='/interviewOffer/src/com/kanlon/treenode'>treenode</a>


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
<a href='/interviewOffer/src/com/kanlon/queue2stack'>queue2stack</a>

##### 拓展：用两个队列实现栈

#### 面试题8：旋转数组的最小数字
题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/rotate'>rotate</a>

#### 面试题9：斐波那契数列
题目一：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。斐波那契数列的定义如下：
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/fibonacci.PNG"/><br/>
题目2：一只青蛙一次可以跳上1个台阶，可以跳上2级。求该青蛙跳上一个n级的台阶共有多少种跳法。（等价于题目1）<br/>

##### 拓展题目：<br/>
拓展1：在青蛙跳台阶的问题中，如果把条件改成：一只青蛙一次可以跳上1级台阶，也可以跳上2级。。。。。。它也可以跳上n级，此时该青蛙跳上一个台阶总共有多少种跳法？<br/>
拓展2：我们可以用2X1（下图左边）的小矩形横着或者竖着去覆盖更大的矩形。请问用8个2X1的小矩形无重叠地覆盖一个2X8的大矩形（下图右边），总共有多少种方法？<br/>
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/matrix28.PNG"/><br/>
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/fibonacci'>fibonacci</a><br/>

#### 面试题10：二进制中1的个数
题目：请实现一个函数，输入一个整数，输出该数二进制中1的个数。例如把9表示成二进制是1001，有2位是1。因此，如果输入9，该函数输出2。
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/numof1inbinary'>numof1inbinary</a><br/>

#### 面试题11：数值的整数次方
题目：实现函数double Power(double base,int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。<br/>
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/power'>power</a><br/>

#### 面试题12：打印1到最大的n位数
题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999.<br/>
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/printnumber'>printnumber</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/deletenode'>deletenode</a><br/>
<br/>

#### 面试题14：调整数组顺序使奇数位于偶数前面
题目：输入一个整数数组，实现一个函数来调整该数组中的数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/recorderarray'>recorderarray</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/kth_node_from_end'>KthNodeFromEnd</a><br/>
<br/>

##### 拓展题目：<br/>
拓展1：求链表的中间结点。如果链表中结点总数为奇数，则返回中间结点，如果结点总数是偶数，则返回中间两个结点的任意一个。<br/>
拓展题目2：判断一个单项链表是否形成了环形结构。<br/>
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/kth_node_from_end'>kth_node_from_end</a><br/>

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
<a href='/interviewOffer/src/com/kanlon/reverse_list'>ReverseList</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/merge_sorted_lists'>mergeSortedLists</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/sub_tree'>sub_tree</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/tree_mirror'>tree_mirror</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/matrix_clockwise'>matrix_clockwise</a><br/>
<br/>


### 面试题21：包含min函数的栈
题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)<br/>
答案:<br/>
<a href='/interviewOffer/src/com/kanlon/stack_with_min'>stack_with_min</a><br/>
<br/>

### 面试题22：栈的压入、弹出序列
题目：输入两个整数序列，第一个序列表示栈顶压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、5是某栈的压栈序列。序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但4、3、5、1、2就不可能是该压栈序列的弹出序列。<br/>
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/stack_push_pop_order'>stack_push_pop_order</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/binary_tree_top_to_bottom'>binary_tree_top_to_bottom</a><br/>
<br/>

### 面试题24：二叉搜索树的后序遍历序列
题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。<br/>
例如输入数组{5,7,6,9,11,10,8},则返回true,因为这个整数序列是如下图二叉搜索树的后序搜索结果。如果输入的数组是{7,4,6,5},由于没有哪棵二叉搜索树的后序遍历的结果是这个序列，因此返回false。<br/>
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/squence_of_BST.PNG"/>
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/squence_of_bst'>squence_of_bst</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/path_in_tree'>path_in_tree</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/copy_complex_list'>copy_complex_list</a><br/>
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
<a href='/interviewOffer/src/com/kanlon/convert_binary_search_tree'>convert_binary_search_tree</a><br/>
<br/>



### 面试题28：字符串的排序
题目：输入一个字符串，打印出该字符串中字符的所有排序。例如输入字符串abc，则打印出由字符a、b、c所能排序出来的所有字符串abc、acb、bac、bca、cab和cba<br/>
答案：<br/>
<a href='/interviewOffer/src/com/kanlon/string_permutation'>string_permutation</a><br/>
<br/>
##### 拓展题目：<br/>

拓展题目1：如果输入n个字符，则这n个字符能构成长度为1的组合、长度为2的组合、。。。、长度为n的组合。求n个字符的所有的组合（所有长度）<br/><br/>
拓展题目2：输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上（如下图所示），使得正方体上三组相对的面上的4个顶点的和都相等。<br/><br/>
<img alt="把8个数字放到正方体的8个顶点上" src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/square_combinate.png"/><br/>
拓展题目3(8皇后问题)：在8X8的国际象棋上摆放8个皇后，使其不能相互攻击，即任意两个皇后不得处在同一行、同一列或者同一对角线上。下图中的每个黑色格子表示一个皇后，这就是一种符合条件的摆放方法。请问总共有多少种符合条件的摆法？<br/><br/>
<img alt="把8个数字放到正方体的8个顶点上" src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/eight_queen.png"/><br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/string_permutation'>string_permutation</a><br/>



### 面试题29：数组中出现次数超过一半的数字

题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字，例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过了数组长度的一半，因此输出2.<br/>

答案：<br/>

<a href='/interviewOffer/src/com/kanlon/more_than_half_number'>more_than_half_number</a><br/>
<br/>


### 面试题30：最小的k个数
题目：输入n个整数，找出其中最小的k个数，例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1、2、3、4<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/k_least_numbers'>k_least_numbers</a><br/>
<br/>


### 面试题31：连续子数组的最大和
题目：输入一个整数数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/greatest_sum_of_sub_arrays'>greatest_sum_of_sub_arrays</a><br/>
<br/>


### 面试题32：从1到n整数中1出现的次数
题目：输入一个整数n，求从1到n这n个整数的十进制中1出现的次数。例如输入12，从1到12这些整数中包含1,10,11,12,1一共出现了5次。<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/number_of_1'>number_of_1</a><br/>
<br/>

### 面试题33：把数组排成最小的数
题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3,32,321},则打印出这三个数字能排成的最小数字321323。<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/sort_array_for_min_number'>sort_array_for_min_number</a><br/>
<br/>


### 面试题34：丑数
题目：我们把只包含因子2、3、5的数称作丑数（Ugly Number）。求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7.习惯上我们把1当做第一个丑数。<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/ugly_number'>ugly_number</a><br/>
<br/>

### 面试题35：第一个只出现一次的字符
题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'.<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/first_not_repeating_char'>first_not_repeating_char</a><br/>
<br/>


### 面试题36：数组中的逆序对
题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/inverse_pairs'>inverse_pairs</a><br/>
<br/>


### 面试题37：两个链表的第一个公共结点

题目：输入两个链表，找出它们的第一个公共结点。链表结点定义如下：<br/>
```
class ListNode{
	int mNKey;
	ListNode mPNext;
}
```
<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/first_common_nodes_in_lists'>first_common_nodes_in_lists</a><br/>
<br/>

### 面试题38：数字在排序数组中出现的次数

题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4.
<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/number_of_k'>number_of_k</a><br/>
<br/>

### 面试题39：二叉树的深度

题目：输入一个二叉树的根结点，求该数的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。<br/>

拓展：输入一颗二叉树的根结点，判断该数是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树。例如，下图中的二叉树就是一颗平衡二叉树.<br/>

<img alt="深度为4的二叉树" src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/tree_depth.PNG"/><br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/tree_depth'>tree_depth</a><br/>
<br/>

### 面试题40：数组中只出现一次的数字

题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写出程序找出这两个只出现一次的数字。要求时间复杂度时O(n),空间复杂度是O(1)。<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/numbers_appear_once'>numbers_appear_once</a><br/>
<br/>


### 面试题41：和为s的两个数VS和为s的连续正数序列

题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。<br/>

题目二：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8，所以结果打印出3个连续序列1\~5、4\~6和7\~8。

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/two_numbers_or_continues_squence_with_sum'>two_numbers_or_continues_squence_with_sum</a><br/>
<br/>


### 面试题42：翻转单词顺序 VS 左旋转字符串

题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串“I am a student.”,则输出“student. a am I”.<br/>

题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefe"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。<br/>

答案：<br/>
<a href='/interviewOffer/src/com/kanlon/reverse_words_in_sentence_and_left_rotate_string'>reverse_words_in_sentence_and_left_rotate_string</a><br/>
<br/>


### 面试题43：n个骰子的点数

题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。<br/>


答案：<br/>
<a href='/interviewOffer/src/com/kanlon/dices_probability'>dices_probability</a><br/>
<br/>


### 面试题44：扑克牌的顺子

题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字<br/>


答案：<br/>
<a href='/interviewOffer/src/com/kanlon/continuous_cards'>continuous_cards</a><br/>
<br/>

### 面试题45：圆圈中最后的剩下的数字

题目：0,1,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。<br/>


答案：<br/>
<a href='/interviewOffer/src/com/kanlon/last_number_in_circle'>last_number_in_circle</a><br/>
<br/>

### 面试题46：求1+2+...+n

题目：求1+2+...+n，要求不能使用乘除法，for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）.<br/>


答案：<br/>
<a href='/interviewOffer/src/com/kanlon/accumulate'>accumulate</a><br/>
<br/>


### 面试题47：不用加减乘除做加法

题目：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、X、÷四则运算符号<br/>


答案：<br/>
<a href='/interviewOffer/src/com/kanlon/add_two_numbers'>add_two_numbers</a><br/>
<br/>


### 面试题48：不能被继承的类

题目：用C++设计一个不能被继承的类。

该题因为Java有final关键字表示一个类型不能被继承，所以该题不能使用Java实现。

### 面试题49：把字符串转换成整数。

题目：把字符串转换成整数<br/>


答案：<br/>
<a href='/interviewOffer/src/com/kanlon/string_to_int'>string_to_int</a><br/>
<br/>

### 面试题50：树中两个结点的最低公共祖先

题目：树中两个结点的最低公共祖先<br/>


答案：<br/>
<a href='/interviewOffer/src/com/kanlon/common_parentln_tree'>common_parentln_tree</a><br/>
<br/>


### 其他题目
1.实现一个排序算法，要求时间效率O(n).对公司所有员工的年龄排序，公司总共有几万名员工。可以用辅助空间，只允许使用常量大小辅助空间，不得超过O(n)。<br/>
答案：
<a href='/other/NSort.java'>nsort</a>

2.比较两个数组是否相等，都含有一样的元素，并且一样的元素的个数相同。<br/>
答案：
[comareEquals](/other/CompareEquals.java)

3.快速排序的实现<br/>
答案：[quick_sort](/other/quick_sort/QuickSort.java)<br/>

4.不用比较，找出两个数的较大值和较小值<br/>
答案：[find_max_and_min](/interviewOffer/src/com/kanlon/find_max_and_min/FindMaxAndMin.java)<br/>


## 算法技巧
1.如果要筛选出某个相同的数，使用HashMap。<br/><br/>

2.如果要筛选出某个不同的数，可以使用异或运算。<br/><br/>

3.如果从前往后复制每个数字（或字符）需要移动数字（或字符）多次，可以考虑从后往前复制。<br/><br/>

4.把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于是把整数的二进制表示中的最右边一个1变成0.<br/><br/>

5.当用一个指针遍历链表不能解决问题的时候，可以使用两个指针遍历链表。可以让其中一个指针遍历的速度快一点，或者让它先在链表上走若干步。<br/><br/>

6.如果面试题是要求处理一棵二叉树的遍历序列，我们可以先找到二叉树的根结点，再基于根结点把整棵树的遍历序列拆分成左子树对应的子序列和右子树对应的子序列，接下来再递归地处理这两个子序列。<br/><br/>

7.如果需要判断多个字符是不是在某个字符串里出现或者统计多个字符在某个字符串中出现的次数，我们可以考虑基于数组创建一个简单的哈希表，这样可以用很小的空间消耗换来时间效率的提升。<br/><br/>

8.计算数列，数组区间和的，可能解法是先求从开始到某个数j的总和sum(j),然后再根据之前得到的从开始到某个数i的总和sum(i)，两者相减得到区间和sum(j-i),这样做会比较简单，减少重复计算。<br/><br/>

## 其他类似的Java题解

1. https://mp.weixin.qq.com/s/BVXIRC6LCLE-3GiMxyNX4Q  【程序员乔戈里】公众号的66道剑指offer题解附答案
