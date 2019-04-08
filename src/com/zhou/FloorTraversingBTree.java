package com.zhou;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;


/*
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * */
public class FloorTraversingBTree {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		root = createBinaryTree(root);
		ArrayList<Integer> arrayList = PrintFromTopToBottom(root);
		for (Integer integer : arrayList) {
			System.out.println(integer);
		}
		
	}
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	if(root == null)
    		return arrayList;
    	
    	Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		arrayList.add(node.val);
    		if(node.left != null)
    			queue.add(node.left);
    		if(node.right!=null)
    			queue.add(node.right);
    	}
        return arrayList;
    }
	public static TreeNode createBinaryTree(TreeNode head) {
		int value = scanner.nextInt();
		if(value == -1) {
			return null;
		}
		else
		{
			head = new TreeNode(value);
		}
		head.left = createBinaryTree(head.left);
		head.right = createBinaryTree(head.right);
		return head;
	}
}
