package com.zhou;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * 
 * 
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * */
public class FloorWrapPrintBTree {
	 static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		root = createBinaryTree(root);
		ArrayList<ArrayList<Integer> > arrayList = new ArrayList<>();
		arrayList = Print(root);
		for (ArrayList<Integer> arrayList2 : arrayList) {
			for(int i=0;i<arrayList2.size();i++) {
				System.out.print(arrayList2.get(i)+" ");
			}
			System.out.println();
		}
	}
	static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer> > arrayList = new ArrayList<>();
		if(pRoot!=null) {
			Queue<TreeNode> queue = new LinkedBlockingQueue<>();
			queue.add(pRoot);

			while(!queue.isEmpty()) {
				Queue<TreeNode> linequeue = new LinkedBlockingQueue<>();
				ArrayList<Integer> linearraylist = new ArrayList<>();
				while(!queue.isEmpty()) {
					TreeNode pollnode = queue.poll();
					linequeue.add(pollnode);
					linearraylist.add(pollnode.val);
				}
				while(!linequeue.isEmpty()) {
					TreeNode node = linequeue.poll();
					if(node.left!=null) {
						queue.add(node.left);
					}
					if(node.right!=null) {
						queue.add(node.right);
					}
				}
				arrayList.add(linearraylist);
			}
			
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
