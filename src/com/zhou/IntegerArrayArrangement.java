package com.zhou;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * */
public class IntegerArrayArrangement {
	 class MyCompator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			String temp1 = o1+o2;
			String temp2 = o2+o1;
			return temp1.compareTo(temp2);
		}

	}
	public String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length == 0)
			return null;
		String[] str = new String[numbers.length];
		for(int i=0; i < numbers.length;i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str, new MyCompator());
		String temp="";
		for(int i = 0;i < str.length;i++) {
			temp += str[i];
		}
		return temp;
	}
	public static void main(String[] args) {
//		int[] numbers = {3,32,321};
//		String string = PrintMinNumber(numbers);
//		System.out.println(string);
	}
}
