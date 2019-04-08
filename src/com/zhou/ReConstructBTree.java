package com.zhou;

/*
 * 
 * '
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8},
 * 中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * 
 * */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class ReConstructBTree {
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode root = reConstructBTree(pre, 0, pre.length-1, in, 0, in.length-1);
		preOrder(root);
		System.out.println();
		inOrder(root);
	}
	
	public static TreeNode reConstructBTree(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd) {
		
		if(inStart > inEnd || preStart > preEnd)
			return null;
		
		TreeNode root = new TreeNode(preOrder[preStart]);
		for(int i = inStart;i<=inEnd;i++) {
			if(preOrder[preStart] == inOrder[i]) {
				root.left = reConstructBTree(preOrder, preStart+1, preStart + i - inStart, inOrder,inStart, i-1);
				root.right=reConstructBTree(preOrder, i - inStart+preStart+1, preEnd, inOrder, i+1, inEnd);
			}
		}
		return root;
	}
	public static int findInOrder(int value,int[] inOrder,int inStart,int inEnd) {
		for(int i =0;i<inEnd;i++) {
			if(value == inOrder[i]) {
				return i;
			}
		}
		return -1;
	}
	public static void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val+" ");
		
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);
	}
}
