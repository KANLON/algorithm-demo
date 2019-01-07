### 面试题26：复杂链表的复制

#### 题目：
题目：请实现函数ComplexListNode clone(ComplexListNode pHead),复制一个复杂的链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任意结点或者null。<br/>
链表的定义如下：<br/>
```
class ComplexListNode{
	int m_nValue;
	ComplexListNode m_pNext;
	ComplexListNode m_pSibling;
}
```


#### 解题思路：
解题思路1（借助HashMap数组）：<br/>
（1）先将原来链表的结点某个copy到hashmap中，形式为N-N',然后依次复制链表每个结点，并将复制后的结点的指针指向复制前的下一个结点所在的key值对应的value值。<br/>
(2)将任意指针m_pSibling指向原来结点指向的hashmap中key对应的value结点。这样是空间换时间时间复杂度为O（n）<br/>
<hr/>

解题思路2（在原结点下链接新结点）：<br/>
(1)新增结点：在原链表所有结点上都新增加一个结点，使得链表结构由N1->N2->N3变成N1->N1'->N2->N2'->N3->N3'<br/>
(2)重新定位：遍历该链表如果原来结点的任意指针m_pSibling不为null，则将其原结点的下一个结点（即新的对应结点）的任意指针m_pSibling指向原来结点任意指针指向的结点的下一个结点<br/>
(3)拆分连接：将偶数的结点顺序连接起立，将奇数的结点顺序连接起来。返回偶数的结点的头结点<br/>
<hr/>