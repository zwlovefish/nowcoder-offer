package com.zhou;
/*
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 
 * */
public class SimpleSum {
	public static void main(String[] args) {
		System.out.println(Sum_Solution(100));
	}
    public static int Sum_Solution(int n) {
        if(n == 0)
        	return 0;
        return n+Sum_Solution(n-1);
    }
}
