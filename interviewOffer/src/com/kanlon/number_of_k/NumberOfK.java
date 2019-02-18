package com.kanlon.number_of_k;

/**
 * 面试题38：数字在排序数组中出现的次数
 *
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4.
 *
 * @author zhangcanlong
 * @since 2019/2/17 21:25
 **/
public class NumberOfK {
    public static void main(String[] args) {
        NumberOfK test = new NumberOfK();
        //功能测试1（有多个元素，k出现了多次）
        int[] ints1 = {1,2,3,3,3,3,4,5};
        System.out.println("功能测试1（有多个元素，k出现了多次）,方法一:"+test.getNumberOfK1(ints1,3));
        System.out.println("功能测试1（有多个元素，k出现了多次）,方法二:"+test.getNumberOfK2(ints1,3));
        //功能测试2（有多个元素，k出现了1次）
        int[] ints2 = {1,2,3,3,4,5};
        System.out.println("功能测试2（有多个元素，k出现了1次）,方法一:"+test.getNumberOfK1(ints2,1));
        System.out.println("功能测试2（有多个元素，k出现了1次）,方法二:"+test.getNumberOfK2(ints2,1));
        //功能测试3（有1个元素，k出现了1次）
        int[] ints3 = {2};
        System.out.println("功能测试3（有1个元素，k出现了1次）,方法一:"+test.getNumberOfK1(ints3,2));
        System.out.println("功能测试3（有1个元素，k出现了1次）,方法二:"+test.getNumberOfK2(ints3,2));
        //特殊测试1（有0个元素，k出现了0次）
        int[] ints4 = {0};
        System.out.println("特殊测试1（有0个元素，k出现了0次）,方法一:"+test.getNumberOfK1(ints4,2));
        System.out.println("特殊测试1（有0个元素，k出现了0次）,方法二:"+test.getNumberOfK2(ints4,2));


    }

    /**
     * 解题思路1：先用二分查找k所在数组的位置，再在该位置往前和往后找，不等于该数的。最坏时间复杂度为O(n),和顺序查找统计差不多
     * @param numbers 要查找的数组
     * @param k 要查找的数
     * @return k在数组中出现的次数
     **/
    public int getNumberOfK1(int[] numbers,int k){
        if(numbers==null || numbers.length<=0){
            return 0;
        }
        int kIndex = findK(numbers,k,0,numbers.length-1);
        if(kIndex==-1){
            return 0;
        }
        int numberOfK = 1;
        int beforeIndex=kIndex-1;
        int afterIndex = kIndex+1;
        while(beforeIndex>=0 && numbers[beforeIndex]==k){
            numberOfK++;
            beforeIndex--;
        }
        while(afterIndex<=numbers.length-1  && numbers[afterIndex]==k){
            numberOfK++;
            afterIndex++;
        }
        return numberOfK;
    }

    /**
     * 解题思路2（推荐）：1.利用二分查找找出第一个k元素的位置，具体是，查找到一个k，则判断它之前一个数是否为k，如果是，则在前半段继续二分查找，否则该数位置是第一个k所在位置。
     * 2. 接着二分查找最后一个k元素的位置，具体是，查找到一个k，判断其后面一个数是否为k，如果是，则继续在后半段查找，否则该数位置是最后一个k
     * @param numbers 要查找的数组
     * @param k 要查找的数
     * @return k在数组中出现的次数
     **/
    public int getNumberOfK2(int[] numbers,int k){
        if(numbers==null || numbers.length<=0){
            return 0;
        }
        int firstKIndex = findFirstK(numbers,k,0,numbers.length-1);
        if(firstKIndex==-1){
            return 0;
        }
        int lastKIndex = findLastK(numbers,k,0,numbers.length-1);
        return lastKIndex-firstKIndex+1;
    }

    /**
     * 在数组中用二分查找k的下标
     * @param numbers 要查找的数组
     * @param k 要查找的数
     * @param start 数组开始下标
     * @param end  数组结束的下标
     * @return int 返回k在数组中的下标，没有则返回0
     **/
    private int findK(int[] numbers,int k,int start,int end){
        if(start>=end){
            if(numbers[start]==k){
                return start;
            }else{
                return -1;
            }
        }
        int mid = (start+end)>>1;
        if(numbers[mid]>k){
            return findK(numbers,k,start,mid-1);
        }else if(numbers[mid]<k){
            return findK(numbers,k,mid+1,end);
        }else{
            return mid;
        }
    }
    /**
     * 找第一个k在数组中的下标
     * @param numbers 要查找的数组
     * @param k 要查找的k值
     * @param start 要查找的数组开始的元素
     * @param end 要查找的数组结束的元素
     * @return 第一个k在数组中出现的下标，没有则返回0
     **/
    private int findFirstK(int[] numbers,int k,int start,int end){
        if(start>=end){
            if(numbers[start]==k){
                return start;
            }else{
                return -1;
            }
        }
        int mid = (start+end)>>1;
        if(numbers[mid]>k){
            return findK(numbers,k,start,mid-1);
        }else if(numbers[mid]<k){
            return findK(numbers,k,mid+1,end);
        }else{
            //如果前面一个数不是k，则返回，如果是，则继续在前面查找
            if(mid>start && numbers[mid-1]==k){
                return findK(numbers,k,start,mid-1);
            }else{
                return mid;
            }
        }
    }

    /**
     * 找最后一个k在数组中的下标
     * @param numbers 要查找的数组
     * @param k 要查找的k值
     * @param start 要查找的数组开始的元素
     * @param end 要查找的数组结束的元素
     * @return 最后一个k在数组中出现的下标，没有则返回0
     **/
    private int findLastK(int[] numbers,int k,int start,int end){
        if(start>=end){
            if(numbers[start]==k){
                return start;
            }else{
                return -1;
            }
        }
        int mid = (start+end)>>1;
        if(numbers[mid]>k){
            return findK(numbers,k,start,mid-1);
        }else if(numbers[mid]<k){
            return findK(numbers,k,mid+1,end);
        }else{
            //如果后面一个数不是k或者没有后面的数，则返回，如果是，则继续在前面查找
            if(mid<end && numbers[mid+1]==k){
                return findK(numbers,k,mid+1,end);
            }else{
                return mid;
            }
        }
    }


}
