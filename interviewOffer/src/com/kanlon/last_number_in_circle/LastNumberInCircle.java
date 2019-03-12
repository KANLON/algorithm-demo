package com.kanlon.last_number_in_circle;

import java.util.LinkedList;

/**
 * 面试题目45：圆圈中最后剩下的数字，题目：0,1，...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * @author zhangcanlong
 * @since 2019/3/9 22:52
 **/
public class LastNumberInCircle {
    public static void main(String[] args) {
        LastNumberInCircle test  = new LastNumberInCircle();
        //功能测试1（输入的m小于n）
        System.out.println("功能测试1（输入的m小于n）(方法一):"+test.findLashNumberInCircle1(5,2));
        System.out.println("功能测试1（输入的m小于n）(方法二):"+test.findLashNumberInCircle2(5,2));
        //功能测试2（输入的m大于n）
        System.out.println("功能测试1（输入的m大于n）(方法一):"+test.findLashNumberInCircle1(5,6));
        System.out.println("功能测试1（输入的m大于n）(方法二):"+test.findLashNumberInCircle2(5,6));
        //性能测试1（n为4000，m为997）
        System.out.println("性能测试1（n为4000，m为997）(方法一):"+test.findLashNumberInCircle1(4000,997));
        System.out.println("性能测试1（n为4000，m为997）(方法二):"+test.findLashNumberInCircle2(4000,997));
        //特殊输入测试（圆圈中有0个数字）
        System.out.println("特殊输入测试（圆圈中有0个数字）(方法一):"+test.findLashNumberInCircle1(0,997));
        System.out.println("特殊输入测试（圆圈中有0个数字）(方法二):"+test.findLashNumberInCircle2(0,997));
    }


    /**
     * 解题思路1：利用循环链表存储着这n个数，每次遍历到第m个数时，则删除该数。直到剩下最后一个数时，则是所要求的数
     *
     * @param n 要排成圈数的n个数
     * @param m 从数字0开始每次从这个圈中删除第m个数字
     * @return int 最后返回的数字
     **/
    public int findLashNumberInCircle1(int n,int m){
        if(n<=0){
            return -1;
        }
        //存储这个n个数的链表
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0;i<n;i++){
            linkedList.add(i);
        }
        //循环遍历链表
        //控制链表的循环遍历
        int index =0;
        //标记需要删除第m个数
        int needRemoveIndex=0;
        while(linkedList.size()>1){
            needRemoveIndex++;
            if(m==needRemoveIndex){
                linkedList.remove(index);
                needRemoveIndex=0;
            }else{
                index=(index+1)%(linkedList.size());
            }
        }
        return linkedList.pop();
    }

    /**
     * 解题思路2：类推方法，查找每次删除的数字有那些规律
     * @param n 要排成圈数的n个数
     * @param m 从数字0开始每次从这个圈中删除第m个数字
     * @return int 最后返回的数字
     **/
    public int findLashNumberInCircle2(int n,int m){
        if(n<1 || m<1){
            return -1;
        }
        int last=0;
        for(int i=2;i<=n;i++){
            last= (last+m)%i;
        }
        return last;
    }


}
