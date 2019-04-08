package com.zhou;

import java.util.Scanner;

/*
 * 
 * 
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * */
public class BTreeDepth {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		root = createBinaryTree(root);
		int depth = TreeDepth(root);
		System.out.println(depth);
	}
    public static int TreeDepth(TreeNode root) {
       if(root == null)
    	   return 0;
       int left = TreeDepth(root.left);
       int right = TreeDepth(root.right);
       return left > right ? left+1 : right+1;
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
