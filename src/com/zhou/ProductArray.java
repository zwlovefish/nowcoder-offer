package com.zhou;
/*
 * 
 * 
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * */
public class ProductArray {
	public static void main(String[] args) {
		int[] A= {1,2,3,4,5};
		int[] result = multiply(A);
		for (int i : result) {
			System.out.print(i+" ");
		}
	}
    public static int[] multiply(int[] A) {
    	int[] C = new int[A.length];
    	int[] D = new int[A.length];
    	C[0] = 1;
    	for(int i =1 ;i < A.length;i++) {
    		C[i] = C[i-1]*A[i-1];
    	}
    	
    	D[A.length-1] = 1;
    	for(int i= A.length - 2;i>=0;i--) {
    		D[i] = D[i+1] * A[i+1];
    	}
    	
    	int[] result = new int[A.length];
    	for(int i = 0;i < A.length;i++) {
    		result[i] = C[i] * D[i];
    	}
    	return result;
    }
}
