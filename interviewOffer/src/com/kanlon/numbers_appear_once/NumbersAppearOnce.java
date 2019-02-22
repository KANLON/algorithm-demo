package com.kanlon.numbers_appear_once;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题40：数组中只出现一次的数字
 *
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写出程序找出这两个只出现一次的数字。要求时间复杂度时O(n),空间复杂度是O(1)
 *
 * @author zhangcanlong
 * @since 2019/2/22 21:38
 **/
public class NumbersAppearOnce {
    public static void main(String[] args) {
        NumbersAppearOnce test = new NumbersAppearOnce();


    }

    /**
     * 解题思路：有两个不同的数字，证明数组所有元素做异或的结果的二进制里面肯定有存在至少1。那样的话，可以按照该位置是否是1把数组划分两个数组，这样这两个数组里的元素分别做异或，则可以得到这两个元素。
     * @param ints 要查找的数组
     **/
    public int[] findNumbersAppearOnce(int[] ints){
        //存放两个不同的元素
        int[] twoNum = new int[2];
        if(ints==null || ints.length<2){
            return null;
        }
        //保存原数组的二进制形式
        List<String> oldIntsBinaryStrs = new ArrayList<>();
        //将数组做异或
        int firstSum = 0;
        for(int i=0;i<ints.length;i++){
            oldIntsBinaryStrs.add(Integer.toBinaryString(ints[i]));
            firstSum^=ints[i];
        }
        String firstSumBinaryStr = Integer.toBinaryString(firstSum);
        //找出是那个位置上元素是1
        int index = -1;
        for(int i=0;i<firstSumBinaryStr.length();i++){
            if(firstSumBinaryStr.charAt(i)=='1'){
                index=i;
                break;
            }
        }
        //如果都是相同的话，则返回null
        if(index==-1){
            return null;
        }

        //将原数组划分为两个数组
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1= new ArrayList<>();
        for(String str:oldIntsBinaryStrs){
            if(str.length()>index && str.charAt(index)=='1'){
                list1.add(Integer.parseInt(str,2));
            }else{
                list0.add(Integer.parseInt(str,2));
            }
        }

        //最后分别异或这两个数组，得到这两个不同的数
        for(Integer i:list0){
            twoNum[0]^=i;
        }
        for(Integer i:list1){
            twoNum[1]^=i;
        }
        return twoNum;
    }
}
