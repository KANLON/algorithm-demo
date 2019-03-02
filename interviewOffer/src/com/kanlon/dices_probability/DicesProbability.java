package com.kanlon.dices_probability;


/**
 * 面试题43：n个骰子的点数
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * @author zhangcanlong
 * @since 2019/3/1 9:47
 **/
public class DicesProbability {

    //最大的点数
    private final int MAX_POINTS = 6;

    public static void main(String[] args) {
        DicesProbability test = new DicesProbability();
        //功能测试1，较小的值，1
        System.out.println("功能测试1，较小的值，1");
        test.getDicesProbabilityWithRecursive(1);
        test.getDicesProbabilityWithLoop(1);
        //功能测试2，较小的值，3
        System.out.println("功能测试2，3");
        test.getDicesProbabilityWithRecursive(3);
        test.getDicesProbabilityWithLoop(3);
        //g功能测试3，较大的值，10
        System.out.println("g功能测试3，较大的值，10");
        test.getDicesProbabilityWithRecursive(10);
        test.getDicesProbabilityWithLoop(10);

        //特殊测试1，0
        System.out.println("特殊测试1，0");
        test.getDicesProbabilityWithRecursive(0);
        test.getDicesProbabilityWithLoop(0);

    }

    /**
     * 输入骰子的个数，打印出所有点数之和出现的概率，递归方法
     * 解题思路1（递归，时间复杂度高）：0.根据题目意思，我们可以知道，只要计算出每个点数和出现的次数/总次数（6的n次方），即得所有出现的概率
     * 1.因为n个骰子的最大点数和为6n+1(因为索引从0开始)，所以可以定义大小为6n的数组，存储其对应的点数的出现的次数。
     * 2.然后接下来就是要递归求解n个骰子的所有点数和，可以把问题拆分为1个骰子和n-1个骰子，只需求1个骰子的所有出现的点数加上，n-1个骰子所有出现的点数就可以了。
     * 3. 接着n-1个骰子的点数，可以拆分为1个骰子可能出现的所有点数和n-2个骰子所有可能出现点数。直到骰子剩下一个时。
     * 4. 剑指offer原书内是定义6n+1-n大小的数组的，这里直接就定义6n+1大小的了，减少代码量，也方便理解。
     *
     * @param n 骰子个数
     **/
    public void getDicesProbabilityWithRecursive(int n){
        if(n<=0){
            return;
        }
        //定义6n+1大小的数组,存储所有点数和的次数
        int[] ints = new int[6*n+1];
        //递归遍历n个骰子的和，从第一个骰子开始
        for(int i=1;i<=MAX_POINTS;i++){
            getDicesProbabilityWithRecursive(n,i,ints);
        }
        //打印出各个点数出现的次数
        for(int i=0;i<ints.length;i++){
            if(ints[i]!=0){
                Double probability = new Double(ints[i])/Math.pow(6,n);
                System.out.println("点数和为："+i+"，其概率为："+probability.toString());
            }
        }

    }

    /**
     * 递归的核心方法
     * @param currentN 当前遍历的第几个骰子
     * @param curSum 当前的点数和
     * @param ints 存储所有点数和出现的次数
     **/
    private void getDicesProbabilityWithRecursive(int currentN,int curSum,int[] ints){
        if(currentN==1){
            ints[curSum]++;
        }else{
            for(int i=1;i<=MAX_POINTS;i++){
                getDicesProbabilityWithRecursive(currentN-1,curSum+i,ints);
            }
        }
    }

    /**
     * 解题思路2：(1)我们可以考虑用两个数组来存储骰子点数的每一个总数出现的次数。在一次循环中， 第一个数组中的第 n 个数字表示骰子和为 n 出现的次数。
     * (2)在下一循环中，我们加上一个新的骰子，此时和为 n 的骰子出现的次数应该等于上一次循环中骰子点数和为 n-1 、n-2 、n-3 、n-4, n-5 与 n-6 的次数的总和，
     * (3)所以我们把另一个数组的第 n 个数字设为前一个数组对应的第 n-1 、n-2 、n-3 、n-4、n-5 与 n-6 之和。
     * @param n 骰子个数
     **/
    public  void getDicesProbabilityWithLoop(int n){
        if(n<1){
            return;
        }
        //最大的点数和
        int maxSum = 6*n;
        int[][] ints = new int[2][maxSum+1];
        //标记当前要使用的是第0个数组还是第1个数组
        int flag = 0;
        //抛出第一个骰子时出现的各种情况
        for(int i=1;i<=MAX_POINTS;i++){
            ints[flag][i]=1;
        }
        //抛出其他骰子
        for(int k=2;k<=n;k++){
            //如果抛出了k个骰子，那么和为[0,k-1]的出现次数为0
            for(int i=0;i<k;i++){
                ints[1-flag][i]=0;
            }
            //抛出k个骰子，所有和的可能
            for(int i=k;i<=MAX_POINTS*k;i++){
                ints[1-flag][i]=0;
                //每个骰子的出现的所有可能的点数
                for(int j=1;j<=i&&j<=MAX_POINTS;j++){
                    //统计出和为i的点数出现的次数
                    ints[1-flag][i]+=ints[flag][i-j];
                }
            }
            flag=1-flag;
        }

        for(int i=n;i<=maxSum;i++){
            double ratio = ints[flag][i]/Math.pow(6,n);
            System.out.println("点数和为："+i+"，其对应出现概率为："+ratio);
        }

    }


}
