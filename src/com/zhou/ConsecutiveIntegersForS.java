package com.zhou;

import java.util.ArrayList;

public class ConsecutiveIntegersForS {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer> > arrayLists = FindContinuousSequence(1);
		for (ArrayList<Integer> arrayList : arrayLists) {
			for(int i= 0;i< arrayList.size();i++) {
				System.out.print(arrayList.get(i)+" ");
			}
			System.out.println();
		}
	}
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer> > arrayLists = new ArrayList<>();
    	for(int i=1; i<= sum/2;i++) {
    		ArrayList<Integer> arrayList = process(sum, i);
    		if(arrayList.size() > 0) {
    			arrayLists.add(arrayList);
    		}
    	}
        return arrayLists;
    }
    public static ArrayList<Integer> process(int sum,int index) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	int result = 0;
    	for(int i = index;i< sum;i++) {
    		result += i;
    		arrayList.add(i);
    		if(result == sum) return arrayList;
    		if(result > sum) {
    			arrayList.clear();
    			return arrayList;
    		}
    	}
    	arrayList.clear();
    	return arrayList;
    }
}
