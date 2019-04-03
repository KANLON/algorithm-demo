package com.kanlon.algorithm.training.algo005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ALGO5 算法训练 最短路  
 * @author zhangcanlong
 * @since 2019-3-30 下午10:40:37
 * @version: V1.0
 */
public class Main {
	/**n个顶点，m条边*/
	private static int n,m;
	/**始点*/
	private static int[] u;
	/**终点*/
	private static int[] v;
	/**u 到 v 有一条长度为l的边*/
	private static int[] l;
	/**d[i]表示始点到 i 的最短路*/
	private static int[] d;
	/**记录前驱*/
	private static int[] first;
	/**赋值为-1，作为循环终止*/
	private static int[] next;
	/** 标记状态*/
	private static boolean[] vis;
	/**队列*/
	private static Queue<Integer> q = new LinkedList<Integer>();
	
	
	public static void main(String[] args) throws IOException {
		int i;
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String str = bfr.readLine();
		String[] s = str.split("//s");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		u = new int[m+1];
		v = new int[m+1];
		l = new int[m+1];
		first = new int[n +1];
		next = new int[m+1];
		d = new int[m+1];
		vis = new boolean[n+1];
		for(i=1;i<=n;i++){
			//前驱全部赋值为-1，表示还没有知道前驱
			first[i]=-1;
		}
		
		for(i=1;i<=m;i++){
			str = bfr.readLine();
			s = str.split("\\s");
			u[i]=Integer.parseInt(s[0]);
			v[i]=Integer.parseInt(s[1]);
			l[i]=Integer.parseInt(s[2]);
			//next[]全部赋值为-1
			next[i] = first[u[i]];
			//存放n个结点
			first[u[i]]=i;
		}
		
		spfa(1);
		
		for(i=2;i<=n;i++){
			System.out.println(d[i]);
		}
	}
	
	public static void spfa(int s){
		
		int i,x;
		for(i=2;i<=n;i++){
			//除始点外，赋值为无限大
			d[i]=Integer.MAX_VALUE;
		}
		//添加队头结点
		q.offer(s);
		//操作直到队空为止
		while(!q.isEmpty()){
			//读取队头结点s，赋值给x，并将s出队
			x=q.poll();
			//清除标记，表示不在队列中
			vis[x]=false;
			for(i=first[x];i!=-1;i=next[i]){
				//对相邻的点做松弛操作
				if(d[v[i]]>d[x]+l[i]){
					d[v[i]]=d[x]+l[x];
					if(!vis[v[i]]){
						//标记，表示在队列中
						vis[v[i]]=true;
						//入队
						q.offer(v[i]);
					}
				}
			}
		}
		
		
	}
}
