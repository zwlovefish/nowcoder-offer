package com.zhou;
/*
 * 
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * */
public class TreeSubstructure {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(9);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(4);
		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		preOrder(root1);
		System.out.println();
		TreeNode root2 = new TreeNode(8);
		TreeNode node7 = new TreeNode(9);
		TreeNode node8 = new TreeNode(2);
		root2.left = node7;
		root2.right = node8;
		preOrder(root2);
		System.out.println();
		System.out.println(HasSubtree(root1, root2));
	}
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag= false;
        if(root1 == null || root2 == null) return false;
        if(root1.val == root2.val) {
        	flag = isReallyEqual(root1,root2);
        }
        if(!flag) {
        	flag = HasSubtree(root1.left, root2);
        }
        if(!flag) {
        	flag = HasSubtree(root1.right, root2);
        }
        return flag;
    }
    public static boolean isReallyEqual(TreeNode root1,TreeNode root2) {
    	if(root2 == null)
    		return true;
    	if(root1 == null)
    		return false;
    	if(root1.val != root2.val)
    		return false;
    	return isReallyEqual(root1.left, root2.left) && isReallyEqual(root1.right, root2.right);
    }
    
    public static void preOrder(TreeNode root) {
    	if(root == null)
    		return;
    	
    	System.out.print(root.val+" ");
    	preOrder(root.left);
    	preOrder(root.right);
    	
    }
    
}
