package com.zhou;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * 
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * */
public class SymmetricBinaryTree {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		root = createBinaryTree(root);
		System.out.println(isSymmetrical(root));
	}
    static boolean  isSymmetrical(TreeNode pRoot)
    {
    	if(pRoot == null)
    		return true;
    	ArrayList<Integer> originTree = new ArrayList<>();
    	ArrayList<Integer> mirrorTree = new ArrayList<>();
    	preOrder(pRoot, originTree);
    	preInverseOrder(pRoot, mirrorTree);
    	for(int i = 0; i < originTree.size();i++) {
    		if(originTree.get(i)!=mirrorTree.get(i))
    			return false;
    	}
        return true;
    }
    static void preOrder(TreeNode root,ArrayList<Integer> arrayList) {
    	if(root == null) {
    		arrayList.add(-1);
    		return;
    	}
    	arrayList.add(root.val);
    	preOrder(root.right, arrayList);
    	preOrder(root.left, arrayList);
    	
    }
    static void preInverseOrder(TreeNode root,ArrayList<Integer> arrayList) {
    	if(root == null) {
    		arrayList.add(-1);
    		return;
    	}
    	arrayList.add(root.val);
    	preInverseOrder(root.left, arrayList);
    	preInverseOrder(root.right, arrayList);
    	
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
