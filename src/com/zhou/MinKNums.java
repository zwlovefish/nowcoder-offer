package com.zhou;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * 
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * */
public class MinKNums {
	public static void main(String[] args) {
		int[] input = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> arrayList = GetLeastNumbers_Solution(input, 4);
		for (Integer integer : arrayList) {
			System.out.print(integer+" ");
		}
	}
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	if(input.length <k || input==null) return arrayList;
    	PriorityQueue<Integer> deap = new PriorityQueue<>();
    	for(int i = 0;i<input.length;i++) {
    		deap.add(input[i]);
    	}
    	for(int i=0;i<k;i++) {
    		arrayList.add(deap.poll());
    	}
       return arrayList;
    }
}
