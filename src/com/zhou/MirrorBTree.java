package com.zhou;
/*
 * 
 * 
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 
 * */
public class MirrorBTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(11);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		preOrder(root);
		Mirror(root);
		System.out.println();
		preOrder(root);
	}
    public static void Mirror(TreeNode root) {
        if(root == null)
        	return;
        Mirror(root.left);
        Mirror(root.right);
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
    }
    
    public static void preOrder(TreeNode root) {
    	if(root == null)
    		return;
    	
    	System.out.print(root.val+" ");
    	preOrder(root.left);
    	preOrder(root.right);
    	
    }
}
