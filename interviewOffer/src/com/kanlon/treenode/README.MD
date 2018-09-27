### 面试题6：重建二叉树
#### 题目：
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出该图6所示的二叉树并输出它的头结点。二叉树结点的定义如下：
```
class BinaryTreeNode{
int mNValue;
BinaryTreeNode mPLeft;
BinaryTreeNode mPRight;
}
```
图6
<img src='https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/binary_example.PNG'/>

### 解题思路
解题思路：在函数ConstructCore中，我们先根据前序遍历的第一个数字创建跟节点，接下来在中序遍历序列中找到根节点的位置，这样就能确定左、右子树结点的数量。在前序遍历和中序遍历的序列中划分了左、右子数结点的值之后，我们就可以递归地调用函数ConstructCore去分别构建他它的左右子树