package com.zhou;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 
 * */
class LinkNode {
	int val;
	LinkNode next = null;

	LinkNode(int val) {
		this.val = val;
	}
}
public class PrintTailToFont {
	public ArrayList<Integer> printListFromTailToHead(LinkNode listNode) {
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		while(listNode!=null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()) {
			arrayList.add(stack.pop());
		}
		return arrayList;
	}
}
