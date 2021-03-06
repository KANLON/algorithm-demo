### 面试题43：n个骰子的点数

#### 题目：

把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 
 
#### 解题思路

解题思路1（递归，时间复杂度高）：

0.根据题目意思，我们可以知道，只要计算出每个点数和出现的次数/总次数（6的n次方），即得所有出现的概率

1.因为n个骰子的最大点数和为6n+1(因为索引从0开始)，所以可以定义大小为6n的数组，存储其对应的点数的出现的次数。

2.然后接下来就是要递归求解n个骰子的所有点数和，可以把问题拆分为1个骰子和n-1个骰子，只需求1个骰子的所有出现的点数加上，n-1个骰子所有出现的点数就可以了。

3. 接着n-1个骰子的点数，可以拆分为1个骰子可能出现的所有点数和n-2个骰子所有可能出现点数。直到骰子剩下一个时。

4. 剑指offer原书内是定义6n+1-n大小的数组的，这里直接就定义6n+1大小的了，减少代码量，也方便理解。



解题思路2：(1)我们可以考虑用两个数组来存储骰子点数的每一个总数出现的次数。在一次循环中， 第一个数组中的第 n 个数字表示骰子和为 n 出现的次数。

(2)在下一循环中，我们加上一个新的骰子，此时和为 n 的骰子出现的次数应该等于上一次循环中骰子点数和为 n-1 、n-2 、n-3 、n-4, n-5 与 n-6 的次数的总和.

(3)所以我们把另一个数组的第 n 个数字设为前一个数组对应的第 n-1 、n-2 、n-3 、n-4、n-5 与 n-6 之和。






 
 