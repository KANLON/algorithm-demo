package com.kanlon.algorithm.training._02_password_suspects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * 这个题不是原题，原题来自<a href="https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=524&page=show_problem&problem=3517">UVALive</a>
 * 方法是使用AC自动机（要理解AC自动机需要先掌握KMP算法和字典树） 以及DP算法
 * 参考实现<a href="https://blog.csdn.net/accelerator_/article/details/38758557">CSDN</a>
 */
public class Main {
	
	public static void main(String[] args) {
		
		int n = 0;
		int m = 0;
		try {
			// 读取数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			// 构建AC自动机
			AC ac = new AC(n, m);
			for(int i = 0; i < m; i ++) {
				ac.insert(br.readLine(), i);
			}
			br.close();
			ac.build();
			long ans = ac.dfs(0, 0, 0);
			System.out.println(ans);
			if(ans <= 42)
				ac.print(0, 0, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

class AC{

	int maxWord = 105; // AC自动机最大记录字母数，最大等于m*字符串最大长度=100，但是还有根节点，不妨设105
	int dicLen  = 26;  // 每一个结点的最大子结点数，即有多少个字母
	int maxLen  = 30;  // 最大密码长度 这里也是个点，不知道为什么写25会出错
	int state   = (1<<10) + 5;      // 1 << M，实际上是一个用二进制表示的状态集，“1”位表示这个词已经出现过了
	long[][][] dp = new long[maxWord][maxLen][state]; // 深度搜索、动态规划的矩阵 设d[u][len][state]表示最后一个是字典树的u结点 已选长度为len，状态为state的剩余种数
	int[] fail  = new int[maxWord]; // 状态转移表
	int[] val   = new int[maxWord]; // 用一个二进制化的整数表示当前已经出现了多少个词 全0表示当前没有出现词 全1表示字典中的词全出现了
    int[] out   = new int[dicLen];  // 输出用
	
	public int[][] trie = new int[maxWord][dicLen]; // 字典树
	private int nodeIndex = 1; // 当前的下标 0表示根结点
	
	int n;
	int m;
	public AC(int n, int m) {
		this.n = n;
		this.m = m;
		for(int i = 0; i < maxWord; i ++) {       // 对数组全部赋-1，-1表示没有搜索过，0表示搜索过但是没有匹配项
			for(int j = 0; j < maxLen; j ++) {
				for(int k = 0; k < state; k ++) {
					dp[i][j][k] = -1;
				}
			}
		}
	}
	
	public void insert(String word, int v) {
		int pre = 0;
		for (int i = 0; i < word.length(); i ++) {
		    int code = toInteger(word.charAt(i));
		    if (trie[pre][code] == 0) { // 如果字典树中不存在这个结点
		    	trie[pre][code] = nodeIndex ++;   // 增加一个结点 记录这个值 
		    }
		    pre = trie[pre][code];
		}
		val[pre] |= (1 << v);  // 标记状态 如果AC自动机经过pre结点，则val[pre]记录的词都出现在了字符串中
	}
	
	/**构建next列表*/
	public void build() {
		ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();    
		// java自带的队列就是LinkedList 但LinkedList是线程不安全的 这里必需用线程安全的 因为有递归调用问题
		
		// 把root的所有的子结点加入到队列中，并将这些结点的fail指向根结点
		fail[0] = 0;
		for (int c = 0; c < dicLen; c ++) {
		    int u = trie[0][c];
		    if (u != 0) {
		    	fail[u] = 0;
		    	queue.add(u);
	    	}
		}
		
		while (!queue.isEmpty()) {
			
			// 弹出一个结点
		    int r = queue.poll();
		    // 遍历下面的每一个结点
		    for (int c = 0; c < dicLen; c ++) {
				int u = trie[r][c];
				if (u == 0) { // 如果字典树中不存在当前遍历的结点
				    trie[r][c] = trie[fail[r]][c]; // 子结点指向父节点失败结点的对应子结点
				    continue;
				}
				queue.add(u);
				int v = fail[r];
				while (v != 0 && trie[v][c] == 0)  // 如果还存着fail结点，并且这个结点的对应子结点却不存在，实际就是访问所有fail链
					v = fail[v];
				fail[u] = trie[v][c];              // 要么存在 要么为0
				val[u] |= val[fail[u]];            // 当前遍历这个结点的状态集等于 当前状态集 并上 失败结点指向的状态集
		    }
		}
	}
	
	public long dfs(int now, int len, int st) {
		if (dp[now][len][st] != -1)  // 如果已经搜索过这个结点，直接返回
			return dp[now][len][st];
		dp[now][len][st] = 0;        // 否则，开始搜索这个结点
		if (len == n) {
		    if (st == (1 << m) - 1)  // 假设输入的m是3，则1 << m后减1得 000...000111，表示3个词都出现了
		    	return dp[now][len][st] = 1;
		    return dp[now][len][st] = 0;
		}
		for (int i = 0; i < dicLen; i++)
			dp[now][len][st] += dfs(trie[now][i], len + 1, st|val[trie[now][i]]);
		return dp[now][len][st];
	}

	public void print(int now, int len, int st) {
		if (len == n) {
		    for (int i = 0; i < len ; i ++)
		    	System.out.print((char)(out[i] + 'a'));
		    System.out.println();
		    return;
		}
		for (int i = 0; i < dicLen; i ++) { // 递归查找结果
		    if (dp[trie[now][i]][len + 1][st|val[trie[now][i]]] > 0) {
				out[len] = i;
				print(trie[now][i], len + 1, st|val[trie[now][i]]);
		    }
		}
    }
	
	public int toInteger(char c) {
		return c - 'a';
	}
	
}
