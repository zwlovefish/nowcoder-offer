package com.zhou;
/*
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * */
public class KthNodeTailToHeadInLinkedList {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		//ListNode result = FindKthToTail(node1, 6);
		//System.out.println(result.val);
	}
	public static ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k==0)
			return null;
		ListNode pHead = head;
		for(int i = 0;i < k-1;i++) {
			System.out.println(i);
			if(pHead.next != null) {
				pHead = pHead.next;
			}else {
				return null;
			}
		}
		ListNode kpHead = head;
		while(pHead != null && pHead.next!=null) {
			pHead=pHead.next;
			kpHead = kpHead.next;
		}
		return kpHead;
	}
}
