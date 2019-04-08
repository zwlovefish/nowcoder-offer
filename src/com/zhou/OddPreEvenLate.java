package com.zhou;
/*
 * 
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * */
public class OddPreEvenLate {
	public static void main(String[] args) {
		int[] array = {2,4,6,1,3,5,7};
		reOrderArray1(array);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	//本屌二笔解法
    public static void reOrderArray(int [] array) {
    	int count = 0;
    	for(int i =0;i<array.length;i++) {
    		if(array[i] %2 == 0) {
    			count++;
    		}
    	}
    	int[] odd = new int[array.length - count];
    	int[] even = new int[count];
    	
    	int pAdd = 0,pEven=0;
    	for(int i=0;i<array.length;i++ ) {
    		if(array[i]%2 == 0) {
    			even[pEven++]=array[i];
    		}else {
    			odd[pAdd++]=array[i];
    		}
    	}
    	for(int i = 0;i < odd.length;i++) {
    		array[i]=odd[i];
    	}
    	for(int i = odd.length;i<array.length;i++) {
    		array[i]=even[i-odd.length];
    	}
    }
    //网上大屌写法
    //利用插排的思想，是奇数的就往前移动
    public static void reOrderArray1(int [] array) {
    	for(int i=0;i<array.length;i++) {
    		if(array[i]%2!=0) {
    			for(int j=i;j>0 && (array[j-1]%2 ==0) ;j--) {
    				swap(array, j, j-1);
    			}
    		}
    	}
    }
    public static void swap(int[] array,int i,int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}
