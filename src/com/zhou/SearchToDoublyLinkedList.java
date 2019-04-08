package com.zhou;

import java.util.Scanner;

/*
 * 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * */
public class SearchToDoublyLinkedList {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root= null;
		root = createBinaryTree(root);
		TreeNode linklist = Convert(root);
		while(linklist!=null) {
			System.out.print(linklist.val+" ");
			linklist = linklist.right;
		}
	}
    public static TreeNode Convert(TreeNode pRootOfTree) {
    	if(pRootOfTree == null)
    		return null;
    	TreeNode root = process(pRootOfTree);
    	while(root.left!=null) {
    		root = root.left;
    	}
    	return root;
    }
    public static TreeNode process(TreeNode root) {
    	if(root == null)
    		return null;
    	TreeNode preNode = null;
    	TreeNode postNode = null;
    	process(root.left);
    	preNode = findRight(root.left);
    	if(preNode!=null) {
    		preNode.right = root;
    		root.left = preNode;
    	//System.out.println(" root is" + root.val + " preNode is " +preNode.val);
    	}
    	postNode = findLeft(root.right);
    	process(root.right);
      	if(postNode != null){
    		postNode.left = root;
    		root.right = postNode;
    		//System.out.println(" root is" + root.val + " postNode is " +postNode.val);
    	}
        return root;
    }
    public static TreeNode findLeft(TreeNode root) {
    	if(root == null) {
    		return null;
    	}

    	while(root.left != null) {
    		root = root.left;
    	}
    	return root;
    }
    public static TreeNode findRight(TreeNode root) {
    	if(root == null) {
    		return null;
    	}

    	while(root.right != null) {
    		root = root.right;
    	}
    	return root;
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
