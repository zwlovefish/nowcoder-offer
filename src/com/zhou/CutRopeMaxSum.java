package com.zhou;
/*
 * 
 * 
 * 一根长度为n的绳子，请把绳子剪成m段(m,n都是整数，n>1,且m>1)，每段绳子的长度记为k[0],k[1],...,k[m].k[0]*k[1]*...*k[m]
 * 的最大值是多少？
 * 一个动态规划算法
 * 一个贪心算法
 * */
public class CutRopeMaxSum {
	public static void main(String[] args) {
		System.out.print("动态规划算法：");
		System.out.print(maxSum(0)+" ");
		System.out.print(maxSum(1)+" ");
		System.out.print(maxSum(2)+" ");
		System.out.print(maxSum(3)+" ");
		System.out.print(maxSum(4)+" ");
		System.out.print(maxSum(5)+" ");
		System.out.print(maxSum(6)+" ");
		System.out.println(maxSum(20)+" ");
		System.out.print("贪心算法：");
		System.out.print(GreedyMaxSum(0)+" ");
		System.out.print(GreedyMaxSum(1)+" ");
		System.out.print(GreedyMaxSum(2)+" ");
		System.out.print(GreedyMaxSum(3)+" ");
		System.out.print(GreedyMaxSum(4)+" ");
		System.out.print(GreedyMaxSum(5)+" ");
		System.out.print(GreedyMaxSum(6)+" ");
		System.out.println(GreedyMaxSum(20)+" ");
		System.out.print("绝对正确方法：：");
		System.out.print(maxSumBook(0)+" ");
		System.out.print(maxSumBook(1)+" ");
		System.out.print(maxSumBook(2)+" ");
		System.out.print(maxSumBook(3)+" ");
		System.out.print(maxSumBook(4)+" ");
		System.out.print(maxSumBook(5)+" ");
		System.out.print(maxSumBook(6)+" ");
		System.out.println(maxSumBook(20)+" ");
	}
	
	//动态规划算法
	public static int maxSum(int length) {
		if(length <2)
			return 0;
		if(length == 2)
			return 1;
		if(length == 3)
			return 2;

		int[] help = new int[length + 1];
		help[0]=0;
		help[1]=1;
		help[2]=2;
		help[3]=3;
		int max;
		for(int i = 4;i<=length;i++) {
			max=0;
			for(int j=1;j<=i-j;j++) {
				max = help[j]*help[i-j] > max ? help[j]*help[i-j]:max;
			}
			help[i]=max;
		}
		return help[length];
	}
	
	//贪心算法
	/*
	 * 贪心策略：当length >= 5时，尽可能多剪长度为3的绳子，当剩下的绳子长度为4时，将绳子剪成2段长度为2的绳子
	 * 
	 * */
	public static int GreedyMaxSum(int length) {
		if(length <2)
			return 0;
		if(length == 2)
			return 1;
		if(length == 3)
			return 2;
		int numberOf3 = length/3;
		//如果最后一段为4，则留下4的那一部分
		if((length - numberOf3 * 3) == 1)
			numberOf3 -= 1;
		int number2 = (length - numberOf3 * 3)/2;
		return (int)Math.pow(3, numberOf3)* (int)Math.pow(2,number2);
	}
	//动态规划算法书上的算法
	public static int maxSumBook(int length) {
		if(length <2)
			return 0;
		if(length == 2)
			return 1;
		if(length == 3)
			return 2;

		int[] help = new int[length + 1];
		help[0]=0;
		help[1]=1;
		help[2]=2;
		help[3]=3;
		int max = 0;
		for(int i = 4;i<=length;i++) {
			max=0;
			for(int j=1;j<=i/2;j++) {
				int product = help[j]*help[i-j];
				if(max < product) {
					max = product;
				}
				help[i] = max;
			}
			
		}
		return help[length];
	}
}
