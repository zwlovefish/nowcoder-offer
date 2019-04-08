package com.zhou;
/*
 * 
 * 
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * */
public class UglyNumber {
	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(1));
	}
    public static int GetUglyNumber_Solution(int index) {
    	if(index <= 0) return 0;
    	int[] ugly = new int[index+1];
    	ugly[0]=1;
    	for(int i = 1;i<ugly.length;i++) {
    		int max = ugly[i-1];
    		int min2 = Integer.MAX_VALUE,min3 = Integer.MAX_VALUE,min5=Integer.MAX_VALUE;
    		for(int j=0;j<i;j++) {
    			if(ugly[j] * 2 > max) {
    				if(ugly[j] * 2 < min2 ) {
    					min2 = ugly[j]*2;
    				}
    			}
    			System.out.print(" min2 is "+min2);
    			if(ugly[j] * 3 > max) {
    				if(ugly[j] * 3 < min3 ) {
    					min3 = ugly[j]*3;
    				}
    			}
    			System.out.print(" min3 is "+min3);
    			if(ugly[j] * 5 > max) {
    				if(ugly[j] * 5 < min5 ) {
    					min5 = ugly[j]*5;
    				}
    			}
    			System.out.print(" min5 is "+min5);
    		}
    		min2 = min2 < min3 ? min2:min3;
    		ugly[i] = min2 < min5 ? min2:min5;
    		System.out.println(" 第 "+ i +" 个 "+ugly[i]);
    	}
        return ugly[index-1];
    }
}
