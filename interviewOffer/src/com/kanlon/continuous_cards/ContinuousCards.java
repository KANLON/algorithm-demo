package com.kanlon.continuous_cards;

import java.util.Arrays;

/**
 * 面试题44：扑克牌的顺子
 *
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字
 *
 * @author zhangcanlong
 * @since 2019/3/4 8:53
 **/
public class ContinuousCards {
    public static void main(String[] args) {
        ContinuousCards test = new ContinuousCards();
        //功能测试1，1个0，是连续
        int[] ints1 = {3,0,4,5,7};
        System.out.println("功能测试1，1个0，是连续 "+test.isContinuous(ints1));

        //功能测试2，2个0，是连续
        int[] ints2 = {4,0,5,8,0};
        System.out.println("功能测试2，2个0，是连续 "+test.isContinuous(ints2));


        //功能测试3，1个0，不是连续
        int[] ints3 = {3,4,5,8,0};
        System.out.println("功能测试3，1个0，不是连续 "+test.isContinuous(ints3));

        //功能测试4，没有0，是连续
        int[] ints4 = {4,3,5,6,7};
        System.out.println("功能测试4，没有0，是连续 "+test.isContinuous(ints4));

        //功能测试5，没有0，不是连续
        int[] ints5 = {4,3,1,6,7};
        System.out.println("功能测试5，没有0，不是连续 "+test.isContinuous(ints5));

        //功能测试6，没有0，有重复值的，不是连续
        int[] ints6 = {4,6,5,6,7};
        System.out.println("功能测试6，没有0，有重复值的，不是连续 "+test.isContinuous(ints6));

        //特殊测试，空值
        System.out.println("特殊测试空，"+test.isContinuous(null));

    }

    /**
     * 判断某个数组是否是连续的。
     * 解题思路：（1）因为大小王是任意数字，因此先将大小王当做0，这样方便后面操作。
     * （2）将大小为5的数组排序，然后统计非0元素之间的空缺总数，如果空缺总数小于等于0的个数，则数组是连续的，否则是不连续的。
     * （3）另外需要注意的是如果非0数字出现两次，则也表示不是连续的。
     * （4）这里排序直接调用本身提供的函数进行排序，因为n不是太大，O(nlogn)和O(n)的时间复杂度并没有太大区别
     * @param numbers 要判断的数组
     * @return boolean 是连续的则返回true，否则返回false
     **/
    public boolean isContinuous(int[] numbers){
        if(numbers==null || numbers.length!=5){
            throw new IllegalArgumentException("数组大小不是5");
        }
        Arrays.sort(numbers);
        //0的个数
        int zeroNumber = 0;
        //空缺总数
        int vacancyNumber =0;
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]==0){
                ++zeroNumber;
                continue;
            }
            //判断是否是重复值
            if(numbers[i]==numbers[i+1]){
                return false;
            }
            //统计空缺间隔数
            vacancyNumber+=numbers[i+1]-numbers[i]-1;
        }

        if(vacancyNumber<=zeroNumber){
            return true;
        }
        return false;
    }



}
