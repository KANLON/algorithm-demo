### 面试题18：树的子结构

#### 题目：
题目：输入两颗二叉树A和B，判断B是不是A的子结构。<br/>
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



#### 解题思路：
解题思路：利用递归判断，先在判断树1是否还有结点，如果还有结点，则先判断该结点是否与子树2的当前结点值相同，如果相同则继续在另一个方法（专门递归判断所有结点是否相等---判断树1和树2是否一样，树1可以比树2多，但前面的结点必须和树2一样，否则返回false）递归判断左右结点是否相同。如果左右结点相同则继续递归判断。如果当前根结点与树2的当前根结点值不相同，则继续拿树2的根分别与树1的左结点和右结点做递归判断。最后当树1或则树2为null时，则返回结果。
<hr/>
