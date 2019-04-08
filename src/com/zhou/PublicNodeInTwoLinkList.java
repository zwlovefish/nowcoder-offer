package com.zhou;
/*
 * 
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * 
 * */
public class PublicNodeInTwoLinkList {
    @SuppressWarnings("unused")
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	if(pHead1 == null || pHead2 == null)
    	 return null;
    	int size1 = 0,size2=0;
    	ListNode p1,p2;
    	p1 = pHead1;
    	p2 = pHead2;
    	while(p1!=null) {
    		size1++;
    		p1 = p1.next;
    	}
    	while(p2!=null) {
    		size2++;
    		p2 = p2.next;
    	}
    	if(p1 != p2)
    		return null;
    	
    	p1 = pHead1;
    	p2 = pHead2;
    	if(size1 >= size2) {
    		int temp = size1 - size2;
    		for(int i=0;i<temp;i++) {
    			p1 = p1.next;
    		}
    	}else {
    		int temp = size2 - size1;
    		for(int i=0;i<temp;i++) {
    			p2 = p2.next;
    		}
    	}
    	while(p1 != p2) {
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	
    	return p1;
    }
}
