package com.zhou;
/*
 * 
 * 
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 * */
public class ReversalWord {
	public static void main(String[] args) {
		String string="student. a am I";
		System.out.println(ReverseSentence(string));
	}
    public static String ReverseSentence(String str) {
    	if(str == null || str.length() == 0)
        return "";
    	str = Reverse(str);
    	System.out.println(str);
    	StringBuilder sb = new StringBuilder();
    	int begin = 0;
    	int end = 0;
    	while(end < str.length() && begin < str.length()) {
    		//System.out.println(str.charAt(end));
    		if(str.charAt(end) == ' ') {
    			String temp = str.substring(begin, end);
    			sb.append(Reverse(temp));
    			sb.append(" ");
    			begin = end+1;
    		}
    		if(end == str.length()-1) {
    			String temp = str.substring(begin,end+1);
    			sb.append(Reverse(temp));
    		}
    		end++;
    	}
    	return sb.toString();
    }
    
    public static String Reverse(String str) {
    	StringBuilder sb = new StringBuilder(str);
    	return sb.reverse().toString();
    }
}
