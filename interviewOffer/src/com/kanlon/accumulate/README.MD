### 面试题46：求1+2+...+n

#### 题目：
求1+2+...+n，要求不能使用乘除法，for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）


#### 解题思路：
解题思路1：利用与 或者 或运算，当计算到某个位置时利用与或运算终止递归。（参考： https://blog.csdn.net/wangyang1354/article/details/73350720 ）
<hr/><br/>

解题思路2：解题思路2：利用反射获取方法，再利用boolean集合和n是否等于0来达到选择方法的目的，其本质与方法二相同（参考： https://blog.csdn.net/Sugar_Z_/article/details/51258693 ）
