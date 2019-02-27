package com.kanlon.reverse_words_in_sentence_and_left_rotate_string;

/**
 * 面试题42：翻转单词顺序 VS 左旋转字符串
 * 题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串“I am a student.”,则输出“student. a am I”.
 * @author zhangcanlong
 * @since 2019/2/27 8:44
 **/
public class ReverseWordsInSentence {

    public static void main(String[] args) {
        ReverseWordsInSentence test= new ReverseWordsInSentence();
        //功能测试1，多个单词，
        String str1 = "I am a student.";
        System.out.println("功能测试1，多个单词，"+test.reverseWords(str1));
        //功能测试2，一个单词
        String str2 = "student.";
        System.out.println("能测试2，一个单词，"+test.reverseWords(str2));
        //特殊测试1，空
        String str3= "";
        System.out.println("特殊测试1，空，"+test.reverseWords(str3));


    }

    /**
     * 解题思路1：直接利用jdk的函数先进行分割，再组合
     *
     * @param str 要翻转的字符串
     * @return java.lang.String
     **/
    public String reverseWords(String str){
        if(str==null || str.length()<=0 ||str.matches("\\s")){
            return null;
        }
        String[] words = str.split("\\s");
        StringBuilder returnBuilder = new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            if(i==0){
                returnBuilder.append(words[i]);
                break;
            }
            returnBuilder.append(words[i]+" ");
        }
        return returnBuilder.toString();
    }

    /**
     * 翻转字符串
     * @param str 要翻转的字符串
     * @return java.lang.String
     **/
    private String reverseString(String str){
        char[] chars = new char[str.length()];
        for(int i=0;i<chars.length;i++){
            chars[i]=str.charAt(i);
        }
        return new String(chars);
    }


}
