package com.kanlon.add_two_numbers;

import java.util.Arrays;

/**
 * 拓展题目：不使用新的变量，交换两个变量的值，比如有两个变量a、b，我们希望交换它们的值，有两种不同的办法：
 * @author zhangcanlong
 * @since 2019/3/14 16:41
 **/
public class AddTwoNumbersExt {
    public static void main(String[] args) {
        AddTwoNumbersExt test = new AddTwoNumbersExt();
        //功能测试
        int[] ints={1,2};
        test.swap1(ints);
        System.out.println("方法一结果："+ Arrays.toString(ints));
        test.swap2(ints);
        System.out.println("方法二结果（还原）："+ Arrays.toString(ints));

    }

    /**
     * 解题思路1：利用异或运算，两个相同的数异或等于0，一个数与0异或等于该数本身。
     * 交换两个数，两个数需要在数组中，因为java是值传递
     * @param ints 要交换的数组
     **/
    public void swap1(int[] ints){
        if(ints==null || ints.length!=2){
            throw new IllegalArgumentException("输入的数组不合法");
        }
        ints[0]=ints[0]^ints[1];
        ints[1]=ints[0]^ints[1];
        ints[0]=ints[0]^ints[1];
    }
    /**
     * 解题思路2：数值相加减交换.先将两个数相加，在利用和减去其中一个数，进而也可以得到另一个数。
     * 交换两个数，两个数需要在数组中，因为java是值传递
     * @param ints 要交换的数组
     **/
    public void swap2(int[] ints){
        if(ints==null || ints.length!=2){
            throw new IllegalArgumentException("输入的数组不合法");
        }
        ints[0]=ints[0]+ints[1];
        ints[1]=ints[0]-ints[1];
        ints[0]=ints[0]-ints[1];
    }



}
