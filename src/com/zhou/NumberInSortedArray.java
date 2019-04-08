package com.zhou;
/*
 * 
 * 统计一个数字在排序数组中出现的次数。
 * 
 * */
public class NumberInSortedArray {
    public int GetNumberOfK(int [] array , int k) {
    	int result = 0;
    	for(int i = 0;i < array.length;i++) {
    		if(array[i]==k) {
    			result++;
    		}
    	}
        return result;
    }
}
