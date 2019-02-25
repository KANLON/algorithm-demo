package com.kanlon.two_numbers_or_continues_squence_with_sum;

/**
 *  面试题41：和为s的两个数VS和为s的连续正数序列
 *
 * 题目二：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8，所以结果打印出3个连续序列1~5、4~6和7~8。
 *
 * @author zhangcanlong
 * @since 2019/2/25 8:45
 **/
public class ContinuesSquenceWithSum {
    public static void main(String[] args) {
        ContinuesSquenceWithSum test = new ContinuesSquenceWithSum();
        //功能测试1,刚好只有1个序列
        System.out.println("功能测试1,刚好只有1个序列");
        test.findContinuesSquenceWithSum(3);
        //功能测试2，有多个序列
        System.out.println("功能测试2，有多个序列");
        test.findContinuesSquenceWithSum(9);
        //特殊测试1，1
        System.out.println("特殊测试1，1");
        test.findContinuesSquenceWithSum(1);
    }

    /**
     * 解题思路：（1）与题目一类似，用两个数作为序列的首尾，开始时，将1作为序列首元素small，2作为序列尾元素big。
     * （2）如果small+big大于和s，small向前移动一位，直到等于s。如果small+big小于和s，big向前移动，直到等于s。
     * （3）如果等于s，我们就再增加big，重复步骤二。
     * （4）因为这个序列至少要有两个数字，我们一直增加到small到(1+s)/2为止。
     *
     * @param s 两个数的和的值
     * @return 返回和为s的两个数
     **/
    public void findContinuesSquenceWithSum(int s){
        if(s<=2){
            return;
        }
        //序列首元素
        int small = 1;
        //序列尾元素
        int big =2;
        //表示当前的和，可以通过前进和后退知道和变化，不用重复计算
        int curSum = small+big;
        while(small< ((1+s)>>1) ){
            if(curSum<s){
                big++;
                curSum+=big;
            }else if(curSum>s){
                //这个是减去之前的一个数
                curSum-=small;
                small++;
            }else if(curSum==s){
                System.out.println(small+"~"+big+",");
                big++;
                curSum+=big;
            }
        }
    }

}
