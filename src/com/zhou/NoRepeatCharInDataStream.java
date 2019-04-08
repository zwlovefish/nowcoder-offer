package com.zhou;
/*
 * 
 * 
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * */
public class NoRepeatCharInDataStream {
	int[] charArray = new int[128];
	String string ="";
	//Insert one char from stringstream
	public void Insert(char ch)
	{
		charArray[ch]++;
		string += String.valueOf(ch); 
	}
	//return the first appearence once char in current stringstream
	public char FirstAppearingOnce()
	{
		char[] str= string.toCharArray();
		for(int i = 0; i < str.length;i++) {
			if(charArray[str[i]] == 1) {
				return str[i];
			}
		}
		return '#';
	}
	public static void main(String[] args) {
		NoRepeatCharInDataStream noRepeatCharInDataStream = new NoRepeatCharInDataStream();
		noRepeatCharInDataStream.Insert('h');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		noRepeatCharInDataStream.Insert('e');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		noRepeatCharInDataStream.Insert('l');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		noRepeatCharInDataStream.Insert('l');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		noRepeatCharInDataStream.Insert('o');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		noRepeatCharInDataStream.Insert('w');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		noRepeatCharInDataStream.Insert('o');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		noRepeatCharInDataStream.Insert('r');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		noRepeatCharInDataStream.Insert('l');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		noRepeatCharInDataStream.Insert('d');
		System.out.println(noRepeatCharInDataStream.string+" "+noRepeatCharInDataStream.FirstAppearingOnce());
		
	}
}
