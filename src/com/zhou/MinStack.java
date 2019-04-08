package com.zhou;

import java.util.Stack;

/*
 * 
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 
 * */
public class MinStack {
	
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
    public void push(int node) {
    	stack.push(node);
    	if(minStack.isEmpty()) {
    		minStack.push(node);
    	}else {
    		int temp = node < minStack.peek()?node:minStack.peek();
    		minStack.push(temp);
    	}
    }
    
    public void pop() {
        
    }
    
    public int top() {
        return 0;
    }
    
    public int min() {
        return 0;
    }
}
