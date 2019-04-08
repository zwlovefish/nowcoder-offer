package com.zhou;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class CloneComplexLinkList {
    public RandomListNode Clone(RandomListNode pHead)
    {
    	if(pHead == null)
    		return null;
    	Map<RandomListNode, RandomListNode> map = new HashMap<>();
    	RandomListNode root = new RandomListNode(-1);
    	RandomListNode head = pHead;
    	RandomListNode proot = root;
    	while(head!=null) {
    		RandomListNode temp = new RandomListNode(head.label);
    		map.put(head, temp);//这里键值对是：head  -  head‘ 
    		proot.next = temp;
    		head = head.next;
    		proot = proot.next;
    		
    	}
    	head = pHead;
    	proot = root.next;
    	while(head!=null) {
    		RandomListNode copyRandowNode = map.get(head.random);
    		proot.random = copyRandowNode;
    		head = head.next;
    		proot = proot.next;
    		
    	}
        return root.next;
    }
}
