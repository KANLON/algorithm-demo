package com.kanlon.string_to_int;

/**
 * 面试题49：把字符串转换成整数。
 *
 * @author zhangcanlong
 * @since 2019/3/15 9:54
 **/
public class StringToInt {

    public static void main(String[] args) {
        StringToInt test = new StringToInt();
        //功能测试1，输入的字符串为整数
        System.out.println("功能测试1，输入的字符串为整数:"+test.stringToInt("1234567"));
        //功能测试2，输入的字符串为负数
        System.out.println("功能测试2，输入的字符串为负数:"+test.stringToInt("-1234567"));
        //功能测试3，输入的字符串为0
        System.out.println("功能测试3，输入的字符串为0:"+test.stringToInt("0"));
        //边界值测试1，最大的整数
        System.out.println("边界值测试1，最大的整数:"+test.stringToInt(String.valueOf(Integer.MAX_VALUE)));
        //边界值测试1，最大的负整数
        System.out.println("边界值测试1，最大的负整数:"+test.stringToInt(String.valueOf(Integer.MIN_VALUE)));
        //特殊测试1，null
        System.out.println("特殊测试1，null:"+test.stringToInt(null));
        //特殊测试2，""
        System.out.println("特殊测试2，\"\":"+test.stringToInt(""));
        //输入的字符串中有非数字字符
        System.out.println("输入的字符串中有非数字字符:"+test.stringToInt("1z234567"));
        //输入的字符串中只有"+"或"-"
        System.out.println("输入的字符串中只有\"+\"或\"-\":"+test.stringToInt("-"));
    }


    /**
     * 将字符串转化为整数，主要是要考虑多种情况，（1）字符串为null或""时（2）字符串只有“-”号时（3）字符串有负号时（4）考虑溢出情况（5）字符串有非“0-9”和“-”号时
     * @param str 要转换的字符串
     * @return int 转换后的整数
     **/
    public Integer stringToInt(String str){
        if(str==null || str.length()==0){
            throw new IllegalArgumentException("字符串不能为null");
        }
        //结果与该数相乘，如果时负数，则该数等于-1
        int minus = 1;
        //开始计算整数的位置
        int begin = 0;
        if('-' == str.charAt(0) ){
            minus=-1;
            begin=1;
            if(str.length()==1){
                throw new IllegalArgumentException("要转化的字符全是非数字字符，是非法的！");
            }
        }

        long result = 0;
        for(int i=begin;i<str.length();i++){
            if(str.charAt(i)<='9' && str.charAt(i)>='0'){
                //从后面累加起来
                if(result>Integer.MAX_VALUE){
                    throw new IllegalArgumentException("要转化的字符串大于最大的整数，不能转换！");
                }
                if(begin==0){
                    result+=(str.charAt(str.length()-i-1)-'0')*Math.pow(10,i);
                }else if(begin ==1){
                    result+=(str.charAt(str.length()-i)-'0')*Math.pow(10,i-1);
                }
            }else{
                throw new IllegalArgumentException("要转化的字符含有非数字字符，是非法的！");
            }
        }
        return Integer.parseInt(String.valueOf(minus*result));
    }
}
