package com.zhou;
/*
 * 
 * 
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 
 * 
 * */
public class RingStartNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(7);
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		//node4.next = node2;
		node4.next=node5;
		node5.next=node6;
		node6.next=node4;
		ListNode node = EntryNodeOfLoop(head);
		if(node != null) {
			System.out.println(node.val);
		}
		if(node == null) {
			System.out.println("null");
		}
	}
    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
    	if(pHead == null || pHead.next == null) return null;
    	
    	ListNode fast = pHead;
    	ListNode slow = pHead;
    	
    	while(fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast == slow)
    			break;
    	}
    	
    	if(fast == null || fast.next == null)
    		return null;
    	
//    	int steps = numberRing(fast, slow.next);
//    	System.out.println("此时的值是："+fast.val+"     环的个数是："+steps);
    	
    	
    	fast = pHead;
    	while(fast!=slow) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	return fast;
    	
    }
    public static int numberRing(ListNode fast,ListNode slow) {
    	int count = 0;
    	while(fast!=slow) {
    		count++;
    		slow = slow.next;
    	}
    	return count+1;
    }

}
