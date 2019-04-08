package com.zhou;
/*
 * 
 * 
 * 输入一个链表，反转链表后，输出新链表的表头
 * 
 * */
public class ReversalLinkList {
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
		ListNode head = ReverseList(node1);
		while(head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
    public static ListNode ReverseList(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
		ListNode preNode = head;  
		ListNode curNode = head.next;
		ListNode postNode = head.next.next;
		head.next = null;
		while(curNode != null) {
			curNode.next = preNode; 
			preNode = curNode;  
			if(postNode == null) {
				return curNode;
			}
			curNode = postNode;
			postNode=curNode.next;
		}
    	return null;
    }
}
