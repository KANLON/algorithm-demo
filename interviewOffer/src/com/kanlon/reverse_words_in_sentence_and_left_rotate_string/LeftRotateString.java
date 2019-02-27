package com.kanlon.reverse_words_in_sentence_and_left_rotate_string;

/**
 * 面试题42：翻转单词顺序 VS 左旋转字符串
 * 题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefe"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 *
 * @author zhangcanlong
 * @since 2019/2/27 8:44
 **/
public class LeftRotateString {

    public static void main(String[] args) {
        LeftRotateString test = new LeftRotateString();
        //功能测试1，多个字符，左旋多个
        String str1 = "abcdef";
        System.out.println("功能测试1，多个字符，左旋多个"+test.leftRotateString(str1,2));
        //功能测试2，多个字符，左旋一个
        String str2 = "abcdef";
        System.out.println("功能测试2，多个字符，左旋一个"+test.leftRotateString(str2,1));

        //功能测试3 ,1个字符，左旋1个，
        String  str3 = "a";
        System.out.println("功能测试3 ,1个字符，左旋1个，"+test.leftRotateString(str3,1));

        //功能测试4，1个字符，左旋3个
        String str4 = "a";
        System.out.println("功能测试4，1个字符，左旋3个，"+test.leftRotateString(str4,3));

        //特殊测试1 null
        String str5 = null;
        System.out.println("功能测试5，null，左旋3个，"+test.leftRotateString(str5,3));


    }

    /**
     * 解题思路1：也是先用jdk函数，先将字符分为两个部分，再组合
     * @param str 要旋转的字符
     * @param n  要旋转左边的n个字符
     * @return java.lang.String
     **/
    public String leftRotateString(String str,int n){
        if(str ==null || str.length()<=0){
            return null;
        }
        if(n>=str.length()){
            n=n%str.length();
        }
        if(n==0){
            return str;
        }
        String str1 = str.substring(0,n);
        String str2 = str.substring(n);
        return str2+str1;
    }

}
