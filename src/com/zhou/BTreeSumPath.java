package com.zhou;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * 
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * */
class ThisTreeNode {
    int val = 0;
    ThisTreeNode left = null;
    ThisTreeNode right = null;

    public ThisTreeNode(int val) {
        this.val = val;

    }

}
public class BTreeSumPath {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
	ThisTreeNode root = null;
	root = createBinaryTree(root);
	ArrayList<ArrayList<Integer>> allPath = FindPath(root, 6);
	for(int i =0;i<allPath.size();i++) {
		ArrayList<Integer> path = allPath.get(i);
		for(int j=0;j<path.size();j++) {
			System.out.print(path.get(j)+" ");
		}
		System.out.println();
	}
	}
	public static ArrayList<ArrayList<Integer>> FindPath(ThisTreeNode root,int target){
		
		ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		process(target, root, allPath,path);
		return allPath;
	}
	
	@SuppressWarnings("unchecked")
	public static void process(int target,ThisTreeNode root,ArrayList<ArrayList<Integer>> allPath,ArrayList<Integer> path) {
		if(root == null)
			return;	
		path.add(root.val);
		if(root.left == null && root.right == null) {
			if(isTarget(target, path)) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp = (ArrayList<Integer>)path.clone();
				allPath.add(temp);
				
			}
		}
		process(target, root.left, allPath,path);
		process(target, root.right, allPath,path);
		path.remove(path.size()-1);
		
	}
	public static boolean isTarget(int target,ArrayList<Integer> path) {
		int sum =0;
		for(int i =0;i<path.size();i++) {
			sum +=path.get(i);
		}
		if(sum == target)
			return true;
		return false;
	}
	//===============
	public static ThisTreeNode createBinaryTree(ThisTreeNode head) {
		int value = scanner.nextInt();
		if(value == -1) {
			return null;
		}
		else
		{
			head = new ThisTreeNode(value);
		}
		head.left = createBinaryTree(head.left);
		head.right = createBinaryTree(head.right);
		return head;
	}
	public static void preOrderPrint(ThisTreeNode head) {
		if(head == null)
			return ;

		System.out.print(head.val+" ");
		preOrderPrint(head.left);
		preOrderPrint(head.right);
	}
}
