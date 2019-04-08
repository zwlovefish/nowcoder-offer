package com.zhou;

import java.util.Stack;

/*
 * 
 * 输入两个整数序列，
 * 第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 
 * 
 * */
public class StackingSequence {
	public static void main(String[] args) {
		int[] pushA = {1};
		int[] popA = {1};
		System.out.println(IsPopOrder(pushA, popA));
	}
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null)
        	return false;
        int push = 0,pop = 0;
        Stack<Integer> stack = new Stack<>();
        while(pop<popA.length) {
        	if(!stack.isEmpty() && popA[pop] == stack.peek()) {
        		stack.pop();
        		pop++;
        	}else {
        		int index = findIndex(pushA, push, pushA.length-1, popA[pop]);
        		if(index < push)
        			return false;
        		while(push <= index) {
        			stack.push(pushA[push]);
        			push++;
        		}
        	}
        	
        }
        return true;
        
    }
    public static int findIndex(int[] array,int start,int end,int target) {
    	for(int i = start; i <= end; i++ ) {
    		if(array[i] == target)
    			return i;
    	}
    	return -1;
    }
}
