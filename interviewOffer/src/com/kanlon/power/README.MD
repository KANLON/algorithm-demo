### 面试题11：数值的整数次方
#### 题目：
实现函数double Power(double base,int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

#### 解题思路
解题思路1：考虑到指数有可能是负数，当exponent是负数时，base也是0时，则返回0.结果是base的绝对值的倒数。<br/>
注意：<br/>
1.在double值进行比较时，不能直接比较.<br/>
2.(推荐使用)计算base的正整数exponent次方的结果，最好的方法，利用了求a的n次方的公式。时间复杂度为O(logn)<br/>
计算a的n次方的公式
<img src="https://raw.githubusercontent.com/KANLON/algorithmDemo/master/image/a_n_power.PNG"/><br/>



