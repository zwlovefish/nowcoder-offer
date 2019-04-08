package com.zhou;
/*
 * 
 * 
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * */
public class MatrixCoverage {
    public int RectCover(int target) {
       	if(target <=0)
    		return 0;
    	if(target == 1)
    		return 1;
    	if(target == 2)
    		return 2;
    	int[] help = new int[2];
    	int result=0;
    	help[0]=1;
    	help[1]=2;
    	for(int i=0;i<target-2;i++) {
    		result = help[0]+help[1];
    		help[0]=help[1];
    		help[1]=result;
    	}
    	return result;
    }
}
