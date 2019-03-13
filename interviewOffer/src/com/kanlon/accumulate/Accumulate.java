package com.kanlon.accumulate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 面试题46：求1+2+...+n
 *
 * 题目：求1+2+...+n，要求不能使用乘除法，for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * @author zhangcanlong
 * @since 2019/3/13 18:02
 **/
public class Accumulate {
    /**
     * n的累加和
     **/
    public static  int sum1 =0;


    public static void main(String[] args) {
        Accumulate test = new Accumulate();
        //功能测试1
        System.out.println("方法一，功能测试1："+test.sumSolution1(5));
        System.out.println("方法二，功能测试1："+test.sumSolution2(5));
        //特殊测试1
        System.out.println("方法一，特殊测试1："+test.sumSolution1(0));
        System.out.println("方法二，特殊测试1："+test.sumSolution2(0));

    }

    /**
     * 解题思路1：利用与 或者 或运算，当计算到某个位置时利用与或运算终止递归。（参考：https://blog.csdn.net/wangyang1354/article/details/73350720）
     * @param n 累加的和
     * @return int 累加的结果
     **/
    public int sumSolution1(int n){
        int sum=0;
        //boolean b=(n>0)&&(sum+sumSolution1(n-1))>0;
        boolean b = (n==0 || (sum=n+sumSolution1(n-1))>=0);
        return sum;
    }

    /**
     * 解题思路2：利用反射获取方法，再利用boolean集合和n是否等于0来达到选择方法的目的，其本质与方法二相同
     * @param n 累加的和
     * @return int 累加的结果
     **/
    public int sumSolution2(int n){
        Temp2 temp2 = new Temp2();
        int sum = 0;
        try{
            sum = temp2.sum(n);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sum;
    }

    /**
     * 利用反射求n的和，方法二的辅助类
     **/
    class Temp2{
        public int terminator(int n){
            return 0;
        }

        public int sum(int n) throws InvocationTargetException, IllegalAccessException {
            List<Boolean> methodChoice = new ArrayList<>();
            methodChoice.add(false);
            methodChoice.add(true);
            //第一个为sum方法，第二个为terminator方法
            Method[] methods = this.getClass().getMethods();
            //当n==0时才执行terminator方法，大于时执行sum方法
            int index = methodChoice.indexOf(n==0);
            return n+(int)methods[index].invoke(this,(n-1));
        }

    }

}
