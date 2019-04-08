package com.zhou;
/*
 * 
 * 
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 
 * 
 * */

import java.util.Scanner;

public class KthNodeInSearchBTree {
	static int i = 0;
	static TreeNode node=null;
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		root = createBinaryTree(root);
		TreeNode node = KthNode(root, 3);
		System.out.println(node.val);
	}
    static TreeNode KthNode(TreeNode pRoot, int k)
    {   
    	process(pRoot, k);
    	return node;
    }
    static void process(TreeNode root,int k) {
    	if(root == null) return;
    	process(root.left, k);
    	i++;
    	if(i == k)
    		node = root;
    	process(root.right, k);
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
