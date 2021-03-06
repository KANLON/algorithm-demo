### 面试题34：丑数
#### 题目：
我们把只包含因子2、3、5的数称作为丑数（Ugly Number）。求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7.习惯上我们把1当做第一个丑数。

### 解题思路
解题思路1（暴力破解）：对于顺序遍历自然数，如果该数分别是2、3、5的倍数，则除以2、3、5，最后判断其是否等于1，即判断其是否除了2、3、5之外还有没有其他因子。<br/>


解题思路2（空间换时间，推荐）：<br/>
（1）使用一个数组将之前已经求出来的丑数保存起来，然后依次用2,3,4,5乘上数组中已经求出来的丑数，选出其中最小的一个保存到数组中。假设数组中存的最大丑数是Max，那么只要求出2,3，5乘以数组中的某一个数刚好比Max大，然后选出三者间最小的就可以。<br/>

（2）例如：当前数组中的丑数为1，此时2*1,3*1,5*1中最小的是2，将2存到数组中，此时数组中的数为1,2.Max=2。有因为2*1==Max，所以第二次乘的丑数应该为2*2,3*1>2,5*1>2，在新的4,3,5中最小的为3，将3存到数组中，依次循环。<br/>

(3)这种方法只计算丑数，如果是计算1500，时间快过方法一，2万多倍<br/>

参考： https://blog.csdn.net/u013309870/article/details/67012369 <br/>

<hr/>



