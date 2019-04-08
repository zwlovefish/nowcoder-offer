package com.zhou;

import java.util.Scanner;

/*
 * 
 * 
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * */
public class SerializeAndDeserializeBTree {
	static int i=-1;
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TreeNode root = null;
		root = createBinaryTree(root);
		String string = Serialize(root);
		//System.out.println(string);
		TreeNode head = Deserialize(string);
		preOrderPrint(head);
	}
	public static String Serialize(TreeNode root) {
		if(root == null)
			return null;
		String string = SeriProcess(root);
		string = string.substring(0, string.length()-1);//去除最后一个逗号。。。
		return string;
	}
	public static String SeriProcess(TreeNode root) {
		if(root == null) {
			return "#,";
		}
		String str = "";
		str += root.val+",";
		str += SeriProcess(root.left);
		str += SeriProcess(root.right);
		return str;
	}
	public static TreeNode Deserialize(String str) {
		if(str == null)
			return null;
		System.out.println(str);
		String[] string = str.split(",");
		TreeNode root = DeSerialProcess(string);
		return root;
	}
	public static TreeNode DeSerialProcess(String[] str) {
		i++;
		if( str[i].equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.valueOf(str[i]));
		root.left=DeSerialProcess(str);
		root.right=DeSerialProcess(str);
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
	public static void preOrderPrint(TreeNode head) {
		if(head == null)
			return ;

		System.out.print(head.val+" ");
		preOrderPrint(head.left);
		preOrderPrint(head.right);
	}
}
