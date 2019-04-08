package com.zhou;
/*
 * 
 * 
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * */
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
		/***********本屌写法***************/
		//	    	for(int i=0;i<str.length();i++)
		//	    	{
		//	    		if(str.charAt(i) == ' ') {
		//	    			str.deleteCharAt(i);
		//	    			str.insert(i, "%20");
		//	    		}
		//	    	}
		//	    	return str.toString();
		/*********网上大屌写法**************/
		//	    	return str.toString().replaceAll("\\s", "%20");

		/*************以上轮子写法，以下造轮子**********************/
		String stri = str.toString();
		char ch[] = stri.toCharArray();
		int originLength = ch.length;
		int blankCount = 0 ;
		for(int i=0 ; i < ch.length;i++) {
			if(ch[i] == ' ') {
				blankCount++;
			}
		}
		int newLength = originLength + 2*blankCount;
		char[] newch = new char[newLength];
		newLength--;
		originLength--;
		while(newLength > originLength) {
			if(ch[originLength] !=' ') {
				newch[newLength]=ch[originLength];
				originLength--;
				newLength--;
			}else {
				originLength--;
				newch[newLength--]='0';
				newch[newLength--]='2';
				newch[newLength--]='%';
			}
		}
		for(int i=0;i<=originLength;i++) {
			newch[i]=ch[i];
		}
		return String.valueOf(newch);
	}
}
