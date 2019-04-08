package com.zhou;
/*
 * 
 *将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 *但是string不符合数字要求时返回0)，
 *要求不能使用字符串转换整数的库函数。 
 *数值为0或者字符串不是一个合法的数值则返回0。
 * 
 * */
public class Str2Int {
	public static void main(String[] args) {
		System.out.println(StrToInt("-123"));
	}
    public static int StrToInt(String str) {
    	if(str.equals(""))
    		return 0;
    	char[] numbers = str.toCharArray();
    	int symbol = numbers[0] == '-' ? 1 : 0; 
    	int sum = 0;
    	if(numbers[0]>='0'&&numbers[0]<='9') {
			sum = numbers[0]-'0';
		}
    	for(int i = 1;i<numbers.length;i++) {
    		if(numbers[i]<'0' || numbers[i]>'9')
    			return 0;
    		//sum = sum*10+(numbers[i]-'0');
    		sum = (sum<<1) + (sum << 3) + (numbers[i]&0xf);
    	}
    	if(symbol == 1)
    		sum = sum * -1;
		return sum;
    }
}
