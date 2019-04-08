package com.zhou;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * 
 * 
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1
 * */
public class ZigzagPrintTree {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		root = createBinaryTree(root);
		ArrayList<ArrayList<Integer> > arrayList = new ArrayList<>();
		arrayList = Print(root);
		for (ArrayList<Integer> arrayList2 : arrayList) {
			for(int i = 0; i< arrayList2.size();i++) {
				System.out.print(arrayList2.get(i)+" ");
			}
			System.out.println();
		}
	}
	public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer> > arrayList = new ArrayList<>();
		if(pRoot!=null) {
			boolean flag = true;
			Queue<TreeNode> queue = new LinkedBlockingQueue<>();
			Stack<TreeNode> stack = new Stack<>();
			queue.add(pRoot);
			
			while(!queue.isEmpty()) {
				Queue<TreeNode> linequeue = new LinkedBlockingQueue<>();
				ArrayList<Integer> linearraylist = new ArrayList<>();
				while(!queue.isEmpty()) {
					TreeNode pollnode = queue.poll();
					linequeue.add(pollnode);
					linearraylist.add(pollnode.val);
				}
				
				if(flag) {
					while(!linequeue.isEmpty()) {
						stack.push(linequeue.poll());
					}
					while(!stack.isEmpty()) {
						TreeNode node = stack.pop();
						if(node.right!=null) {
							
							queue.add(node.right);
						}
						if(node.left!=null) {
							queue.add(node.left);
						}
					}
					flag = false;
				}else {
					while(!linequeue.isEmpty()) {
						stack.push(linequeue.poll());
					}
					while(!stack.isEmpty()) {
						TreeNode node = stack.pop();
						if(node.left!=null) {
							queue.add(node.left);
						}
						if(node.right != null) {
							queue.add(node.right);
						}
					}
					flag = true;
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
