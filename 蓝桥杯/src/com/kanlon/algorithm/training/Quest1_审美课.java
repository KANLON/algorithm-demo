package com.kanlon.algorithm.training;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
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
4 3
1 0 0
0 1 1
1 0 0
1 0 0
样例输出
3
 * @author Administrator
 *
 */
public class Quest1_审美课 {
	

	private static Reader reader = new InputStreamReader(System.in);
	
	public static void main(String[] args) {
		//超时
//		solution1();
//		solution2();
		solution3();
	}
	
	
	/**
	 * 解题思路1(暴力破解，不能成功)：对学生的结果进行组合，然后对应做异或和运算，如果结果等于画数，则表示这两个学生之间的结果是完全相反的
	 */
	public static void solution1(){
		int studentNum = getInt();
		int pictureNum = getInt();
		List<int[]> studentResult = new ArrayList<int[]>();
		for(int i=0;i<studentNum;i++){
			//存放单个学生评价结果
			int[] ints = new int[pictureNum];
			for(int j=0;j<ints.length;j++){
				ints[j]=getInt();
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
	 * 通过标准输入输入输出，获取字符
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
			sum+=results[opposite]*results[i];
		}
		System.out.println(sum>>1);
	}
	
	/**
	 * 通过自己定义输入输出流获取字符
	 * （1）将每个学生的答案用数组A[i]以二进制的形式存储。故答案相同的学生数组A[i]存的值是相同的。
                        （2）数组ans[ A[i] ]用于存储每种答案的人数。例如，假设ans[3]=10，即有10个人答案相同且答案都为3 (十进制3对应的二进制为011)。
	           （3）按行遍历，按位取反，与取反后的答案相同的 即为题目要求的完全相反的答案。
	           （4）最后sum/2是因为重复计算了，除以2之后才是“有多少对同学”。
		参考：https://blog.csdn.net/weixin_42324771/article/details/87533713

	 */
	public static void solution3(){
		int studentNum = getInt();
		int pictureNum = getInt();
		//存储判断结果及该结果人数，下标为结果，值为人数
		int[] results = new int[(int)Math.pow(2,pictureNum)];
		//存储结果相反的学生对数
		int sum =0 ;
		for(int i=0;i<studentNum;i++){
			//存储一个学生的结果
			int oneStudnetResult  = 0;
			for(int j=0;j<pictureNum;j++){
				int temp =getInt();
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
			sum+=results[opposite]*results[i];
		}
		System.out.println(sum>>1);
	}
	
	
	/**
	 * 解决方法4：
	 * map遍历可以取0~maxn/2即可。。设m个1,1,1.....1（即2^m-1）的数为maxn，mid = maxn/2;  通过枚举你会发现 maxn^x = maxn-x = y (x,y属于[0,maxn]），
	 * (maxn与x逐位取异或 实际就是逐位做减法，因为maxn全为1（1>={0,1}），不存在减法借位),如（111-010 = 101 = 111^010）,则[0,mid]的一个数x与maxn取异的值y一定在(mid,maxn]中。
	 * 如(maxn = 7, 7^0=7 - 0 = 7、7^1=7-1=6、7^2=7-2=5).如果你遍历了map中的[0~mid]那么后面的就不需要再遍历了，因为后面map中能与[0~mid]匹配的值肯定已经被匹配过了。此步骤可要可不要，不会影响实际的通过。
	 */
	public static void solution4(){
		
		int n, m;
		//学生人数
		n = getInt();
		//需要判断的图画数量
		m = getInt();
		//存放某个学生的二进制结果及该结果出现的学生人数
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>(n);
		for (int i = 0; i < n; ++i) {
			int num = 0, x = 0;
			for (int j = 0; j < m; j++) {
				x = getInt();
				num = (num << 1) + x;
			}
			hm.put(num, hm.containsKey(num) ? hm.get(num) + 1 : 1);
		}
		//
		int sum = 0, maxn = (1 << m) - 1;
		for (Entry<Integer, Integer> entry : hm.entrySet()) {
			//只要统计结果小于maxn的1/2就可以了
			if (maxn / 2 < entry.getKey())
				continue;
			int key = entry.getKey() ^ maxn;
			if (hm.containsKey(key))
				//某结果学生数量*相反结果学生数量
				sum += hm.get(key) * entry.getValue();
		}
		System.out.println(sum);
	}
	
	/**
	 * 通过字符串流获取输入数字
	 * @return
	 */
	private static int getInt() {
		int res = 0, read;
		try {
			while ((read = reader.read()) != -1) {
				if (Character.isDigit(read)) {// 因为全是非负数，不需要判断负号‘-’,只要是数字就行
					res = read - '0';
					while ((read = reader.read()) != -1) {// 继续得到能得到的数字
						if (Character.isDigit(read)) {
							res = res * 10 + (read - '0');
						} else {
							break;
						}
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

}
