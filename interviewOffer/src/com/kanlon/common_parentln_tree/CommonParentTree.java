package com.kanlon.common_parentln_tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

/**
 * 面试题50：树中两个结点的最低公共祖先
 *
 * @author zhangcanlong
 * @since 2019/3/15 15:01
 **/
public class CommonParentTree {
    public static void main(String[] args) {
        CommonParentTree test = new CommonParentTree();
        DefaultMutableTreeNode nodeA = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode nodeB = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode nodeC = new DefaultMutableTreeNode("C");
        DefaultMutableTreeNode nodeD = new DefaultMutableTreeNode("D");
        DefaultMutableTreeNode nodeE = new DefaultMutableTreeNode("E");
        DefaultMutableTreeNode nodeF = new DefaultMutableTreeNode("F");
        DefaultMutableTreeNode nodeG = new DefaultMutableTreeNode("G");
        DefaultMutableTreeNode nodeH = new DefaultMutableTreeNode("H");
        DefaultMutableTreeNode nodeI = new DefaultMutableTreeNode("I");
        DefaultMutableTreeNode nodeJ = new DefaultMutableTreeNode("J");
        nodeA.add(nodeB);
        nodeA.add(nodeC);
        nodeB.add(nodeD);
        nodeB.add(nodeE);
        nodeD.add(nodeF);
        nodeD.add(nodeG);
        nodeE.add(nodeH);
        nodeE.add(nodeI);
        nodeE.add(nodeJ);
        //测试1，多个树结点，有多个孩子结点,两个结点都在叶子结点
        System.out.println("测试1，多个树结点，有多个孩子结点,两个结点都在叶子结点，方法一："+test.getCommonTreeNode1(nodeA,nodeF,nodeH));
        System.out.println("测试1，多个树结点，有多个孩子结点,两个结点都在叶子结点，方法二："+test.getCommonTreeNode2(nodeA,nodeF,nodeH));
        //测试2，多个树结点，有多个孩子结点,其中一个结点就是公共祖先
        System.out.println("测试2，多个树结点，有多个孩子结点,其中一个结点就是公共祖先，方法一："+test.getCommonTreeNode1(nodeA,nodeF,nodeB));
        System.out.println("测试2，多个树结点，有多个孩子结点,其中一个结点就是公共祖先，方法二："+test.getCommonTreeNode2(nodeA,nodeF,nodeB));
        //特殊测试1，树的跟结点为null
        System.out.println("特殊测试1，树的跟结点为null，方法一："+test.getCommonTreeNode1(null,nodeF,nodeB));
        System.out.println("特殊测试1，树的跟结点为null，方法二："+test.getCommonTreeNode2(null,nodeF,nodeB));
    }


    /**
     * 查找最低的公共祖先。解题思路1（可以得到父结点）：从这两个结点向前遍历分别得到它们到树根结点的链表。从而问题简化为求两个链表的第一个公共结点。
     * @param root 树的根结点
     * @param node1 查找的结点1
     * @param node2 查找的结点2
     * @return javax.swing.tree.TreeNode 最低公共祖先
     **/
    public TreeNode getCommonTreeNode1(TreeNode root,TreeNode node1,TreeNode node2){
        if(root==null || root.isLeaf()){
            return root;
        }
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        //用来遍历结点1的树结点
        TreeNode temp1 = node1;
        while(temp1!=null){
            list1.add(temp1);
            temp1= temp1.getParent();
        }
        //用来遍历结点2的树结点
        TreeNode temp2= node2;
        while(temp2!=null){
            list2.add(temp2);
            temp2=temp2.getParent();
        }
        //查找两个链表第一个公共结点（让链表1的长度最大，然后让链表1先走两个链表长度之差步，再同时走）
        if(list1.size()<list2.size()){
            List<TreeNode> temp = list1;
            list1=list2;
            list2=temp;
        }
        int diff = list1.size()-list2.size();
        //同一位置开始遍历
        for(int i=diff;i<list1.size();i++){
            if(list1.get(i)==list2.get(i-diff)){
                return list1.get(i);
            }
        }
        return null;
    }


    /**
     * 查找最低的公共祖先。解题思路2（不可以得到父结点）：先用深度遍历找出从树的根结点到这两个链表，然后从这两个链表开始遍历，直到最后一个相同的结点则是最低公共祖先
     * @param root 树的根结点
     * @param node1 查找的结点1
     * @param node2 查找的结点2
     * @return javax.swing.tree.TreeNode 最低公共祖先
     **/
    public TreeNode getCommonTreeNode2(TreeNode root,TreeNode node1,TreeNode node2){
        if(root==null || root.isLeaf()){
            return root;
        }
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        depthSearch(root,node1,node2,list1,list2,stack);
        //查找两个链表最后一个公共结点
        TreeNode beforeNode = null;
        for(int i=0;i<Math.min(list1.size(),list2.size());i++){
            if(list1.get(i)!=list2.get(i)){
                return beforeNode;
            }
            beforeNode=list1.get(i);
        }
        return beforeNode;
    }



    /**
     * 深度遍历，从根结点到指定两个结点的路径
     * @param root 要遍历的树的根结点
     * @param node1 指定结点1
     * @param node2 指定结点2
     * @param list1 到指定结点1的路径
     * @param list2 到指定结点2的路径
     * @param stack 辅助存储深度遍历时的栈
     **/
    private  void depthSearch(TreeNode root,TreeNode node1,TreeNode node2,List<TreeNode> list1,List<TreeNode> list2, Stack<TreeNode> stack){
        if(root==null){
            return;
        }
        stack.push(root);
        if(root==node1){
            for(int i=0;i<stack.size();i++){
                list1.add(stack.get(i));
            }
        }
        if(root==node2){
            for(int i=0;i<stack.size();i++){
                list2.add(stack.get(i));
            }
        }
        //如果有子结点，则遍历每个子节点
        Enumeration<TreeNode> childs =  root.children();
        while(childs.hasMoreElements()){
            depthSearch(childs.nextElement(),node1,node2,list1,list2,stack);
        }
        //还原
        stack.pop();
    }

}




