### 面试题19：二叉树的镜像

#### 题目：
请完成一个函数，输入一个二叉树，该函数输出它的镜像。<br/>
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


#### 解题思路（核心是遍历二叉树和认识到镜像就是交换树的左右结点）：
解题思路1（递归解法）：仔细观察和自己手动将一个二叉树转变成镜像二叉树时，我们会发现只要如果二叉树某结点下有左右结点，将其左右结点将交换就可以了。然后在其左右结点递归该方法就完成镜像转换了
<br/>
解题思路2（循环解法）：可以直接利用层次遍历中的方法，层次遍历方法有挺多，这个就不一一介绍了或者直接使用一种遍历二叉树的方法就可以了。具体看代码，在层次遍历中得到每个结点后，将他们的左右结点交换就可以了。
<hr/>
