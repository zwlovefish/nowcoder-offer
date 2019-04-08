package com.zhou;
/*
 * 
 * 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * */
public class MergeSortLinkList {
	public static void main(String[] args) {
		ListNode list2 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(8);
		ListNode node5 = new ListNode(10);
		list2.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		
		ListNode list1 = new ListNode(1);
		ListNode node6 = new ListNode(3);
		ListNode node7 = new ListNode(5);
		ListNode node8 = new ListNode(7);
		ListNode node9 = new ListNode(9);
		list1.next=node6;
		node6.next=node7;
		node7.next=node8;
		node8.next=node9;
		ListNode head = Merge(list1, list2);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	public static ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 == null && list2 == null) return null;
		if(list1 != null && list2 == null) return list1;
		if(list1 == null && list2 != null) return list2;
		
		ListNode p1 = list1;
		ListNode p2 = list2;

		ListNode root = new ListNode(-1);
		ListNode curNode = root;
		while(p1 != null && p2 != null) {
			   if(p1.val < p2.val) {
				   curNode.next = p1;
				   curNode = p1;
				   p1 = p1.next;
			   }else {
				   curNode.next = p2;
				   curNode = p2;
				   p2 = p2.next;
			   }
		}
		if(p1!= null) {
			curNode.next = p1;
		}
		if(p2 != null) {
			curNode.next = p2;
		}
		return root.next;
		
	}
}
