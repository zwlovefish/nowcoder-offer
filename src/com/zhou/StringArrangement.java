package com.zhou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * 
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 * 
 * */
public class StringArrangement {
	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> arrayList = Permutation(str);
		for (String string : arrayList) {
			System.out.println(string);
		}
	}
	//网上大鸟解法。。。

//	public static ArrayList<String> Permutation(String str) {
//		List<String> res = new ArrayList<>();
//		if (str != null && str.length() > 0) {
//			PermutationHelper(str.toCharArray(), 0, res);
//			Collections.sort(res);
//		}
//		return (ArrayList)res;
//	}
//
//	public static void PermutationHelper(char[] cs, int i, List<String> list) {
//		if (i == cs.length - 1) {
//			String val = String.valueOf(cs);
//			if (!list.contains(val))
//				list.add(val);
//		} else {
//			for (int j = i; j < cs.length; j++) {
//				swap(cs, i, j);
//				PermutationHelper(cs, i+1, list);
//				swap(cs, i, j);
//			}
//		}
//	}
	//本屌二笔解法
   public static ArrayList<String> Permutation(String str) {
    	ArrayList<String> arrayList = new ArrayList<>();
    	if(str.length() == 0)
    		return arrayList;
        char[] ch = str.toCharArray();
        Set<String> set = new HashSet<>();
        
        process(ch,0,set);
//        Iterator<String> iterator = set.iterator();
//        while(iterator.hasNext()) {
//        	arrayList.add(iterator.next());
//        }
        arrayList.addAll(set);
        Collections.sort(arrayList);
        return arrayList;
    }

    public static void  process(char[] ch,int i,Set<String> set) {
    	if(ch.length == 0 || i >=ch.length)
    		return ;
    	for(int start = i;start < ch.length; start++) {
    		swap(ch, i, start);	
    		set.add(String.valueOf(ch));
    		process(ch, i+1,set);
    		swap(ch, i, start);	
    	}
    	return ;
    }

    public static void swap(char[] ch,int i,int j) {
    	char temp = ch[i];
    	ch[i] = ch[j];
    	ch[j] = temp;
    }
}
