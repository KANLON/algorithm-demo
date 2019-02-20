package com.kanlon.tree_depth;

/**
 * 拓展：输入一颗二叉树的根结点，判断该数是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树。例如，下图中的二叉树就是一颗平衡二叉树.
 * @author zhangcanlong
 * @since 2019/2/19 21:07
 **/
public class TreeDepthExt {
    public static void main(String[] args) {
        TreeDepthExt test = new TreeDepthExt();
        //功能测试1（是平衡二叉树，有多个结点）
        BinaryTreeNode tree11 = new BinaryTreeNode(1);
        BinaryTreeNode tree12 = new BinaryTreeNode(2);
        BinaryTreeNode tree13 = new BinaryTreeNode(3);
        BinaryTreeNode tree14 = new BinaryTreeNode(4);
        BinaryTreeNode tree15 = new BinaryTreeNode(5);
        BinaryTreeNode tree16 = new BinaryTreeNode(6);
        BinaryTreeNode tree17 = new BinaryTreeNode(7);
        tree11.pLeft = tree12;
        tree11.pRight = tree13;
        tree12.pLeft = tree14;
        tree12.pRight = tree15;
        tree15.pLeft=tree17;
        tree13.pRight=tree16;
        System.out.println("功能测试1（是平衡二叉树，有多个结点）,方法一："+test.isBalancedBinaryTree1(tree11));
        System.out.println("功能测试1（是平衡二叉树，有多个结点）,方法二："+test.isBalancedBinaryTree2(tree11));
        //功能测试2(（不是平衡二叉树，有多个结点）)
        tree17.pLeft=new BinaryTreeNode(8);
        System.out.println("功能测试1（不是平衡二叉树，有多个结点）,方法一："+test.isBalancedBinaryTree1(tree11));
        System.out.println("功能测试1（不是平衡二叉树，有多个结点）,方法二："+test.isBalancedBinaryTree2(tree11));
        //功能测试3，多个结点，只有右子树
        BinaryTreeNode tree21 = new BinaryTreeNode(1);
        BinaryTreeNode tree22 = new BinaryTreeNode(2);
        BinaryTreeNode tree23 = new BinaryTreeNode(3);
        BinaryTreeNode tree24 = new BinaryTreeNode(4);
        tree21.pRight=tree22;
        tree22.pRight=tree23;
        tree23.pRight=tree24;
        System.out.println("功能测试3，多个结点，只有右子树,不是平衡二叉树，方法一:"+test.isBalancedBinaryTree1(tree21));
        System.out.println("功能测试3，多个结点，只有右子树,不是平衡二叉树，方法二:"+test.isBalancedBinaryTree2(tree21));
        //功能测试4，多个结点，只有左子树
        BinaryTreeNode tree31 = new BinaryTreeNode(1);
        BinaryTreeNode tree32 = new BinaryTreeNode(2);
        tree31.pLeft=tree32;
        System.out.println("功能测试4，多个结点，只有左子树，是平衡二叉树，方法一:"+test.isBalancedBinaryTree1(tree31));
        System.out.println("功能测试4，多个结点，只有左子树，是平衡二叉树，方法二:"+test.isBalancedBinaryTree2(tree31));
        //功能测试5，只有一个结点
        System.out.println("功能测试5，只有一个结点，方法一："+test.isBalancedBinaryTree1(new BinaryTreeNode(1)));
        System.out.println("功能测试5，只有一个结点，方法二："+test.isBalancedBinaryTree2(new BinaryTreeNode(1)));
        //特殊测试1
        System.out.println("特殊测试1，null,方法一："+test.isBalancedBinaryTree1(null));
        System.out.println("特殊测试1，null，方法二："+test.isBalancedBinaryTree2(null));

    }


    /**
     * 解题思路1（暴力）：遍历二叉树的每个结点，每个结点判断一次树的左右子树的深度
     * @param rootNode 二叉树的根结点
     * @return boolean 是否是平衡二叉树
     **/
    public boolean isBalancedBinaryTree1(BinaryTreeNode rootNode){
        if(rootNode==null){
            return true;
        }
        int leftDepth = findTreeDepth(rootNode.pLeft);
        int rightDepth = findTreeDepth(rootNode.pRight);
        int diff = leftDepth-rightDepth;
        if(diff>1 || diff<-1){
            return false;
        }
        return isBalancedBinaryTree1(rootNode.pRight) && isBalancedBinaryTree1(rootNode.pLeft);
    }

    /**
     * 解题思路2(推荐): 用类似后序遍历的方式遍历二叉树的每个结点，在遍历到一个结点之前，我们已经遍历了它的左右子树。只要在遍历每个结点的时候记录它的深度（某一个结点的深度等于它到叶结点的路径长度），可以通过遍历到当前结点时，选择左右子树深度大的那个的深度加1，作为当前结点的深度。
     * 这样就可以一边遍历一边判断每个结点是不是平衡的了。
     * @param rootNode 二叉树的根结点
     * @return boolean 是否是平衡二叉树
     **/
    public boolean isBalancedBinaryTree2(BinaryTreeNode rootNode){
        int[] depth = {0};
        return isBanlanced2(rootNode,depth);
    }

    /**
     * 得到树的深度。
     * @param rootNode 二叉树的根结点
     * @return 树的深度
     **/
    private int findTreeDepth(BinaryTreeNode rootNode) {
        if(rootNode==null){
            return 0;
        }
        int leftDepth = findTreeDepth(rootNode.pLeft);
        int rightDepth = findTreeDepth(rootNode.pRight);

        return leftDepth>rightDepth?(leftDepth+1):(rightDepth+1);
    }

    /**
     * 辅助判断二叉树是否是平衡二叉树，方法二核心
     * @param rootNode 要判断的二叉树的根结点
     * @param depth 二叉树的深度
     * @return boolean
     **/
    private boolean isBanlanced2(BinaryTreeNode rootNode,int[] depth){
        if(rootNode==null){
            depth[0]=0;
            return true;
        }
        int[] leftDepth={0},rightDepth={0};
        //如果左右子树都是平衡二叉树，则该结点下的二叉树是不是平衡二叉树，并得到该结点的深度
        if(isBanlanced2(rootNode.pLeft,leftDepth) && isBanlanced2(rootNode.pRight,rightDepth) ){
            int diff = leftDepth[0]-rightDepth[0];
            if(diff<=1 && diff>=-1){
                depth[0]=1+(leftDepth[0]>rightDepth[0]?leftDepth[0]:rightDepth[0]);
                return true;
            }
        }

        return false;
    }
}
