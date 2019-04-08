package com.zhou;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * 
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 
 * */
public class TwoNumberAppear1InArray {
	public static void main(String[] args) {
		int[] array = {1,2,2,3,3,4};
		int[] num1 = new int[1];
		int[] num2 = new int[2];
		FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0]+" "+num2[0]);
	}
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    	if(array == null || array.length == 0)return;
    	int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<array.length;i++) {
        	if(!hashMap.containsKey(array[i])) {
        		hashMap.put(array[i], 1);
        	}else {
        		int value = hashMap.get(array[i]);
        		value +=1;
        		hashMap.put(array[i], value);
        	}
        }
        @SuppressWarnings("rawtypes")
		Iterator iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
        	@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry)iterator.next(); 
        	int key = (int)entry.getKey();
        	int value = (int)entry.getValue();
        	if(value == 1&&count == 0) {
        		num1[0] = key;
        		count++;
        		continue;
        	}
        	if(value == 1 && count ==1) {
        		num2[0] = key;
        		count++;
        	}
        	
        }
    }
}
