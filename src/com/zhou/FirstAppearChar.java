package com.zhou;

import java.util.HashMap;

/*
 * 
 * 
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 * 
 * */
public class FirstAppearChar {
	public static void main(String[] args) {
		String string ="abcacb";
		System.out.println(FirstNotRepeatingChar(string));
	}
    public static int FirstNotRepeatingChar(String str) {
    	HashMap<Character,Integer > hashMap = new HashMap<>();
    	char[] strArray = str.toCharArray();
    	for(int i=0;i<strArray.length;i++) {
    		if(hashMap.containsKey(strArray[i])) {
    			int value = hashMap.get(strArray[i]);
    			value++;
    			hashMap.put(strArray[i], value);
    		}else {
    			hashMap.put(strArray[i], 1);
    		}
    	}
    	for(int i=0;i<strArray.length;i++) {
    		int value = hashMap.get(strArray[i]);
    		if(value == 1) return i;
    	}
        return -1;
    }
}
