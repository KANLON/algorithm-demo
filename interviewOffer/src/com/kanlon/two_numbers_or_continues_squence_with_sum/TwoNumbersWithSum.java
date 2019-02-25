package com.kanlon.two_numbers_or_continues_squence_with_sum;

import java.util.Arrays;

/**
 *  面试题41：和为s的两个数VS和为s的连续正数序列
 *
 * 题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可
 *
 * @author zhangcanlong
 * @since 2019/2/25 8:45
 **/
public class TwoNumbersWithSum {
    public static void main(String[] args) {
        TwoNumbersWithSum test = new TwoNumbersWithSum();
        //功能测试1，多个元素，存在两个数的和等于s
        int[] ints1 = {2,4,5,6,7,8,9};
        System.out.println("功能测试1，多个元素，存在两个数的和等于s:"+ Arrays.toString(test.findTwoNumbersWithSum(ints1,15)));
        //功能测试2，多个元素，不存在两个数的和等于s
        int[] ints2 = {2,4,5,7,9};
        System.out.println("功能测试2，多个元素，不存在两个数的和等于s:"+ Arrays.toString(test.findTwoNumbersWithSum(ints2,15)));

        //功能测试3，2个元素，存在两个数的和等于s
        int[] ints3 = {2,4};
        System.out.println("功能测试3，2个元素，存在两个数的和等于s:"+ Arrays.toString(test.findTwoNumbersWithSum(ints3,6)));

        //功能测试4，2个元素，不存在两个数的和等于s
        int[] ints4 = {2,3};
        System.out.println("功能测试4，2个元素，不存在两个数的和等于s:"+ Arrays.toString(test.findTwoNumbersWithSum(ints4,6)));

        //特殊测试1，空
        int[] ints5=null;
        System.out.println("特殊测试1，空:"+ Arrays.toString(test.findTwoNumbersWithSum(ints5,15)));



    }


    /**
     * 解题思路：定义首尾下标，分别从数组的前后开始扫描，（1）如果前后的值和小于s，则前下标向前移动一位，再求和与s比较。如果前后的值和大于s，则后下标减一移动一位，在求和与s比较，如果等于s，则直接返回这两个数。
     *
     * @param  ints 要查找的数组
     * @param s 两个数的和的值
     * @return 返回和为s的两个数
     **/
    public int[] findTwoNumbersWithSum(int[] ints,int s){
        int[] returnTwoNumbers = new int[2];
        if(ints==null || ints.length<=1){
            return null;
        }

        int firstIndex =0;
        int lastIndex = ints.length-1;
        while(lastIndex>firstIndex){
            int tempSum = ints[firstIndex]+ints[lastIndex];
            if(tempSum==s){
                returnTwoNumbers[0]=ints[firstIndex];
                returnTwoNumbers[1]=ints[lastIndex];
                break;
            }else if(tempSum>s){
                --lastIndex;
            }else{
                ++firstIndex;
            }
        }
        if(returnTwoNumbers[0]==0 && returnTwoNumbers[1]==0){
            return null;
        }
        return returnTwoNumbers;
    }

}
