package com.zhou;
/*
 * 
 * 
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * */
public class NumMoreHalfArray {
	public static void main(String[] args) {
		//int[] array= {1,3,3,3,3,3,4,4,2};
		//int[] array= {1,3,3,3,2,2,4,4,2};
		int[] array= {1};
		System.out.println(MoreThanHalfNum_Solution(array));
	}
    public static int MoreThanHalfNum_Solution(int [] array) {
    	if(array.length == 0) return 0;
    	
    	int result=array[0];
    	int times = 1;
    	for(int i = 1;i<array.length;i++) {
    		if(times == 0) {
    			result = array[i];
    			times = 1;
    		}else if(array[i] == result) {
    			times++;
    		}else {
    			times--;
    		}
    	}
    	if(!checkIsMoreHalf(array, result)) return 0;
    	
    	return result;
    	
    }
    public static boolean checkIsMoreHalf(int[] array,int num) {
    	if(array.length == 0)
    		return false;
    	int times = 0;
    	for(int i =0;i<array.length;i++) {
    		if(array[i] == num)
    			times++;
    	}
    	
    	if(times * 2 <=array.length)
    		return false;
    	
    	return true;
    	
    }
}
