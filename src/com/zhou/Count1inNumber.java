package com.zhou;
/*
 * 
 * 
 * 求出1~13的整数中1出现的次数,
 * 并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 
 * 
 * 
 * 
 * */
public class Count1inNumber {
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(10000));
		System.out.println(MySolution(10000));
	}
	//高级解法
	public static int NumberOf1Between1AndN_Solution(int n) {
		if(n <= 0) return 0;
		String number = String.valueOf(n);
		return numberOf1(number);
	}
	public static int numberOf1(String number) {
		if(number == null || number.length() == 0||Integer.valueOf(number) == 0) {
			return 0;
		}
		//求第一位的个数。
		int first = number.charAt(0)-'0';
		System.out.print("first is "+ first);
		if(number.length() == 1 && first == 0 ) {
			return 0;
		}
		if(number.length() == 1 && first > 0 ) {
			return 1;
		}
		
		
		int firstCount = 0;
		if(first == 1) {
			String Subnumber = number.substring(1, number.length());
			firstCount = Integer.valueOf(Subnumber) + 1;
		}else {
			firstCount = (int)Math.pow(10, number.length()-1);
		}
		System.out.print(" firstCount is "+firstCount);
		
		//求其他位的个数
		int otherCount = (int)Math.pow(10, number.length() - 2) * first * (number.length() - 1);
		System.out.print(" otherCount is "+otherCount);
		//递归求解1-除第一位的部分
		System.out.println();
		int restCount = numberOf1(number.substring(1, number.length()));
		
		System.out.println(" restCount is "+restCount);
		return firstCount + otherCount + restCount;
	}
	//傻逼解法
	  public static int MySolution(int n) {
	    	int sum = 0;
	    	for(int i = 1; i<= n;i++) {
	    		sum += number1(i);
	    	}
	        return sum;
	    }
	    public static int number1(int n) {
	    	int bitNumber = 1;
	    	int count = 0;
	    	while(n / bitNumber !=0) {
	    		bitNumber *= 10;
	    	}
	    	bitNumber /= 10;
	    	while(bitNumber != 0) {
	    		int temp = n / bitNumber;
	    		if(temp == 1 )
	    			count++;
	    		
	    		n = n-temp*bitNumber;
	    		bitNumber /= 10;
	    		
	    	}
	    	return count;
	    }
}
