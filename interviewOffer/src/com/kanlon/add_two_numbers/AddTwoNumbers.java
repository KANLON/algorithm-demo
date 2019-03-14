package com.kanlon.add_two_numbers;

/**
 * 面试题47：不用加减乘除做加法。题目：写一个函数，求两个函数之和，要求在函数体内不得使用+、-、X、÷四则运算符号。
 * @author zhangcanlong
 * @since 2019/3/14 16:16
 **/
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();
        //功能测试1，两正数
        System.out.println("功能测试1，两正数："+test.add(3,3));
        //功能测试2，两个负数
        System.out.println("功能测试2，两个负数："+test.add(-3,-3));
        //功能测试3，一正一负
        System.out.println("功能测试3，一正一负："+test.add(-3,3));
        //功能测试4，一正，一0
        System.out.println("功能测试4，一正，一0："+test.add(3,0));
        //功能测试5，一负，一0
        System.out.println("功能测试5，一负，一0："+test.add(-3,0));
        //功能测试4，两个0
        System.out.println("功能测试4，两个0："+test.add(0,0));
    }

    /**
     * 解题思路：利用二进制位运算来完成。（1）两数相加可以归纳为先将两个数上的各个位上的数对应相加，记为sum1，同时记录下进位的数sum2，则和为sum1+sum2。，如14+8，sum1=12，sum2=10，所以和为22
     * （2）我们可以把两个数看成二进制来运算，各个位上的数相加，是1+0=0+1=1，0+0=1+1=0，即是异或运算。记录进位则是只有当两个数都是1时，才记录并将结果左移一位。
     * （3）在（1）中的sum1+sum2步骤可以重复（2）的步骤，直到不再进位。
     * 不用加减乘除将两个数相加
     * @param a 要相加的数a
     * @param b 要相加的数b
     * @return int 两数之和
     **/
    public int add (int a ,int b){
        int sum1=0;
        int sum2=0;
        do{
            sum1=a^b;
            sum2=(a&b)<<1;
            a=sum1;
            b=sum2;
        }while(sum2!=0);
        return sum1;
    }

}
