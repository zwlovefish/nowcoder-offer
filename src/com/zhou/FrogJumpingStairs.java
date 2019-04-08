package com.zhou;

public class FrogJumpingStairs {
	public static void main(String[] args) {
		System.out.println(JumpFloorII(4));
	}
	/*
	 * 
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
	 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
	 * 
	 * */
    public static int JumpFloor(int target) {
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
    /*
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 
     * 解：经数学归纳法证明，总共有2的n-1次方种方法
     * */
    public static int JumpFloorII(int target) {
    	if(target <= 0 )
    		return 0;
    	return (int)Math.pow(2, target-1);
                  
    }
}
