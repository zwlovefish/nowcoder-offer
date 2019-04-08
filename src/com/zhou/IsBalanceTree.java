package com.zhou;
/*
 * 
 * 
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * */
public class IsBalanceTree {
	int k;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		//TreeNode node5 = new TreeNode(6);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		//node3.left = node5;
		System.out.println(isBalanced(root));
	}
	//本屌二笔写法
    public static boolean IsBalanced_Solution(TreeNode root) {//后序遍历每一个节点的左右子树的高度差
    	    if(root == null) 
    	    	return true;
    	    
    	    boolean leftflags = IsBalanced_Solution(root.left);
    	    boolean rightflags = IsBalanced_Solution(root.right);
    	    int left = process(root.left);
    	    int right = process(root.right);
    	    if(Math.abs(left-right)>1)
    	    	return false;
    	    
    	    return leftflags && rightflags;
    }
    public static int process(TreeNode root) {//求树的高度
    	if(root == null) return 0;
    	
    	int left = process(root.left);
    	int right = process(root.right);
    	return left > right ? left+1:right + 1;
    }
    //网上大屌写法
    public static boolean isBalanced(TreeNode root) {
    	return getDepth(root) !=-1;
    }
    public static int getDepth(TreeNode root) {
    	if(root == null)
    		return 0;
    	
    	int left = getDepth(root.left);
    	if(left == -1 ) return -1;
    	int right = getDepth(root.right);
    	if(right == -1 ) return -1;
    	int temp = left>right?left:right;
    	return Math.abs(left-right)>1 ? -1 : temp+1;
    }
}
