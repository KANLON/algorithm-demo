### 面试题23：从上往下打印二叉树

#### 题目：
题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。例如输入如下图中的二叉树，则依次打印出8、6、10、5、7、9、11<br/>
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/binary_tree_top_to_bottom.PNG"/>
二叉树的定义如下：
```
class BinaryTreeNode{
	int mNValue;
	BinaryTreeNode mPLeft;
	BinaryTreeNode mPRight;
}
```


#### 解题思路：
解题思路：用队列存储二叉树的结点，并打印出结点值，直到该队列为null，当结点有左右子结点的时候将其放入到队列中。<br/>
<hr/>
