package com.zhou;
/*
 * 
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * 
 * */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class RepeatNodeInLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		ListNode result = deleteDuplication(head);
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
    public static ListNode deleteDuplication(ListNode pHead)
    {
    	if(pHead == null || pHead.next == null) return pHead;
    	
    	ListNode head = new ListNode(-1);
    	head.next = pHead;
    	ListNode preNode = head;       
    	ListNode curNode = pHead;
    	while(curNode!=null && curNode.next != null) {
	    	if(curNode.next.val == curNode.val) {
	    		int val = curNode.val;
	    		while(curNode!=null && curNode.val == val) {
	    			curNode = curNode.next;
	    		}
	    		preNode.next = curNode;
	    	}else {
	    	preNode = curNode;
	    	curNode = curNode.next;
	    	}
    	}
    	return head.next;
    }
}
