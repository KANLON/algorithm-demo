package com.kanlon.algorithm.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 问题描述
　　《审美的历程》课上有n位学生，帅老师展示了m幅画，其中有些是梵高的作品，另外的都出自五岁小朋友之手。老师请同学们分辨哪些画的作者是梵高，但是老师自己并没有答案，因为这些画看上去都像是小朋友画的……老师只想知道，有多少对同学给出的答案完全相反，这样他就可以用这个数据去揭穿披着皇帝新衣的抽象艺术了（支持帅老师^_^）。
　　答案完全相反是指对每一幅画的判断都相反。
输入格式
　　第一行两个数n和m，表示学生数和图画数；
　　接下来是一个n*m的01矩阵A：
　　如果aij=0，表示学生i觉得第j幅画是小朋友画的；
　　如果aij=1，表示学生i觉得第j幅画是梵高画的。
输出格式
　　输出一个数ans：表示有多少对同学的答案完全相反。
样例输入
3 2
1 0
0 1
1 0
样例输出
2
 * @author Administrator
 *
 */
public class Quest1_审美课 {
	
	public static void main(String[] args) {
		//solution1();
		solution2();
	}
	
	
	/**
	 * 解题思路1(暴力破解，不能成功)：对学生的结果进行组合，然后对应做异或和运算，如果结果等于画数，则表示这两个学生之间的结果是完全相反的
	 */
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		String[] nums = scan.nextLine().split("\\s");
		int studentNum = Integer.parseInt(nums[0]);
		int pictureNum = Integer.parseInt(nums[1]);
		List<int[]> studentResult = new ArrayList<int[]>();
		for(int i=0;i<studentNum;i++){
			//存放单个学生评价结果
			int[] ints = new int[pictureNum];
			String[] results = scan.nextLine().split("\\s");
			for(int j=0;j<results.length;j++){
				ints[j]=Integer.parseInt(results[j]);
			}
			studentResult.add(ints);
		}
		//存储结果的学生对数
		int result = 0;
		//对学生进行组合,并对应异或和
		for(int i=0;i<studentResult.size()-1;i++){
			for(int j=i+1;j<studentResult.size();j++){
				int[] student1 = studentResult.get(i);
				int[] student2 = studentResult.get(j);
				int sum = 0;
				for(int z=0;z<student1.length;z++){
					sum+=(student1[z]^student2[z]);
				}
				if(sum==pictureNum){
					result++;
				}
			}
		}
		System.out.println(result);
	}
	
	/**
	 * （1）将每个学生的答案用数组A[i]以二进制的形式存储。故答案相同的学生数组A[i]存的值是相同的。
                        （2）数组ans[ A[i] ]用于存储每种答案的人数。例如，假设ans[3]=10，即有10个人答案相同且答案都为3 (十进制3对应的二进制为011)。
	           （3）按行遍历，按位取反，与取反后的答案相同的 即为题目要求的完全相反的答案。
	           （4）最后sum/2是因为重复计算了，除以2之后才是“有多少对同学”。
		参考：https://blog.csdn.net/weixin_42324771/article/details/87533713

	 */
	public static void solution2(){
		Scanner scan = new Scanner(System.in);
		int studentNum = scan.nextInt();
		int pictureNum = scan.nextInt();
		//存储判断结果及该结果人数，下标为结果，值为人数
		int[] results = new int[(int)Math.pow(2,pictureNum)];
		//存储结果相反的学生对数
		int sum =0 ;
		for(int i=0;i<studentNum;i++){
			//存储一个学生的结果
			int oneStudnetResult  = 0;
			for(int j=0;j<pictureNum;j++){
				int temp =scan.nextInt();
				oneStudnetResult+=(temp*(int)Math.pow(2,pictureNum-1-j));
			}
			++results[oneStudnetResult];
		}
		
		int max = (int)Math.pow(2,pictureNum)-1;
		//将学生结果按位与反，得到与其相反，学生对数
		for(int i=0;i<results.length;i++){
			if(results[i]==0){
				continue;
			}
			
			int opposite = i^max;
			sum+=Math.max(results[opposite], results[i]);
		}
		System.out.println(sum>>1);
	}
}
