package com.zhou;
/*
 * 
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 
 * */
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fibonacci(5));
	}
    public static int fibonacci(int n) {
    	//递归解法
//        if(n<0 || n> 39)
//        	return 0;
//        if(n == 0)
//        	return 0;
//        if(n == 1)
//        	return 1;
//        return Fibonacci(n-1)+Fibonacci(n-2);
    	//迭代解法
    	if(n<0||n>39)
    		return 0;
    	if(n==0)
    		return 0;
    	if(n==1)
    		return 1;
    	int result =0,i=0;
    	int first=0,second=1;
    	while(i<=n-2) {
    		result = first + second;
    		first = second;
    		second = result;
    		i++;
    	}
    	return result;
    }
}
