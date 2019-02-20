package com.kanlon.tree_depth;

import java.util.Stack;

/**
 *  面试题39：二叉树的深度
 *  题目：输入一个二叉树的根结点，求该数的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author zhangcanlong
 * @since 2019/2/19 20:07
 **/
public class TreeDepth {
    public static void main(String[] args) {
        TreeDepth test = new TreeDepth();
        //功能测试1，多个结点，有左右子树
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
        System.out.println("功能测试1，多个结点，有左右子树,方法一:"+test.findTreeDepth1(tree11));
        System.out.println("功能测试1，多个结点，有左右子树,方法二:"+test.findTreeDepth2(tree11));
        //功能测试2，多个结点，只有右子树
        BinaryTreeNode tree21 = new BinaryTreeNode(1);
        BinaryTreeNode tree22 = new BinaryTreeNode(2);
        BinaryTreeNode tree23 = new BinaryTreeNode(3);
        BinaryTreeNode tree24 = new BinaryTreeNode(4);
        tree21.pRight=tree22;
        tree22.pRight=tree23;
        tree23.pRight=tree24;
        System.out.println("功能测试2，多个结点，只有右子树:"+test.findTreeDepth1(tree21));
        System.out.println("功能测试2，多个结点，只有右子树:"+test.findTreeDepth2(tree21));
        //功能测试3，多个结点，只有左子树
        BinaryTreeNode tree31 = new BinaryTreeNode(1);
        BinaryTreeNode tree32 = new BinaryTreeNode(2);
        BinaryTreeNode tree33 = new BinaryTreeNode(3);
        tree31.pLeft=tree32;
        tree32.pLeft=tree33;
        System.out.println("功能测试3，多个结点，只有左子树:"+test.findTreeDepth1(tree31));
        System.out.println("功能测试3，多个结点，只有左子树:"+test.findTreeDepth2(tree31));
        //功能测试4,只有一个结点
        BinaryTreeNode tree41 = new BinaryTreeNode(1);
        System.out.println("功能测试4，1个结点:"+test.findTreeDepth1(tree41));
        System.out.println("功能测试4，1个结点:"+test.findTreeDepth2(tree41));
        //特殊测试，null
        System.out.println("特殊测试，null:"+test.findTreeDepth1(null));
        System.out.println("特殊测试，null:"+test.findTreeDepth2(null));
    }

    /**
     * 得到树的深度。
     * 解题思路1（深度遍历，不推荐,太复杂）：深度遍历优先，（1）用一个栈来存储路径，遍历当前结点，将该结点放入栈，如果当前结点是叶子结点，统计该路径的深度。
     *     （2）如果不是，则继续递归遍历左右子树，遍历后需要还原，将该结点出栈。
     * @param rootNode 二叉树的根结点
     * @return 树的深度
     **/
    public int findTreeDepth1(BinaryTreeNode rootNode) {
        int[] maxDepth = new int[1];
        return depthFirstSearch(rootNode,new Stack<>(),maxDepth );
    }

    /**
     * 得到树的深度。
     * 解题思路2（推荐）：（1）如果一颗树只有一个结点，它的深度为1.如果根结点只有左子树而没有右子树，那么树的深度应该是其左子树的深度加1；
     * （2）如果根结点只有右子树而没有左子树，那么树的深度就是其右子树的深度加1.
     * （3）当树有左右子树时，则树的深度是左右子树深度较大者加1.
     * （4）可以发现，其问题是递归问题，可以轻易求解
     * @param rootNode 二叉树的根结点
     * @return 树的深度
     **/
    public int findTreeDepth2(BinaryTreeNode rootNode) {
        if(rootNode==null){
            return 0;
        }
        int leftDepth = findTreeDepth2(rootNode.pLeft);
        int rightDepth = findTreeDepth2(rootNode.pRight);

        return leftDepth>rightDepth?(leftDepth+1):(rightDepth+1);
    }

    /**
     * 深度遍历优先，（1）用一个栈来存储路径，遍历当前结点，将该结点放入栈，如果当前结点是叶子结点，统计该路径的深度。
     * （2）如果不是，则继续递归遍历左右子树，遍历后需要还原，将该结点出栈。
     * @param rootNode  二叉树的根结点
     * @return  返回树的深度
     **/
    protected int depthFirstSearch(BinaryTreeNode rootNode, Stack<BinaryTreeNode> stack,int[] maxDepth){
        if(rootNode==null){
            return 0;
        }
        stack.push(rootNode);
        //如果是叶子结点，统计深度
        if(rootNode.pLeft==null && rootNode.pRight==null){
            maxDepth[0]=Math.max(stack.size(),maxDepth[0]);
        }else{
            //否则递归遍历左右子树
            if(rootNode.pLeft!=null){
                depthFirstSearch(rootNode.pLeft,stack,maxDepth);
            }
            if(rootNode.pRight!=null){
                depthFirstSearch(rootNode.pRight,stack,maxDepth);
            }
        }
        //还原到上一步
        stack.pop();
        return maxDepth[0];
    }

}

/**
 * 自定义二叉树
 * @author zhangcanlong
 * @since 2019/2/19
 **/
class BinaryTreeNode{
    int value;
    BinaryTreeNode pLeft;
    BinaryTreeNode pRight;
    public BinaryTreeNode(int value){
        this.value=value;
    }
}
