package com.zhou;

import java.util.ArrayList;

/*
 * 
 * 
 * 
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 * 
 * */
public class SumIsSInIncreasingArray {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> arrayList = FindNumbersWithSum(array, 9);
		for (Integer integer : arrayList) {
			System.out.println(integer);
		}
	}
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    	ArrayList<Integer> arrayList= new ArrayList<>();
        if(array == null || array.length==0)
        	return arrayList;
        int p1 = 0;
        int p2 = array.length - 1;
        while(p1 < p2) {
        	if(array[p1] + array[p2] > sum) {
        		p2--;
        	}else if(array[p1] + array[p2] < sum) {
        		p1++;
        	}else {
        		arrayList.add(array[p1]);
        		arrayList.add(array[p2]);
        		return arrayList;
        	}
        }
        return arrayList;
    }
}
