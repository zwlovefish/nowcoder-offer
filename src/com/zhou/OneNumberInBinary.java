package com.zhou;
/*
 * 
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 一个很重要的技巧就是：把一个整数减去1之后，在与原来的整数做 与 运算，得到的结果相当于把整数的二进制表示中最右边的
 * 1变成0.
 * */
public class OneNumberInBinary {
	public static void main(String[] args) {
		System.out.println(NumberOf1(-9));
	}
    public static int NumberOf1(int n) {
    	int count = 0;
    	while(n != 0) {
    		count ++ ;
    		n=(n-1)&n;
    	}
    	
    	return count;
    }
    
}
