package com.zhou;
/*
 * 
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 
 * 2 4 3 6 8 7 5
 * 
 * */
public class PostSearchBTree {
	public static void main(String[] args) {
		int[] sequence = {1};
		System.out.println(VerifySquenceOfBST(sequence));
	}
    public static  boolean VerifySquenceOfBST(int [] sequence) { 
    	if(sequence.length == 0)
    		return false;
    	boolean flage = process(sequence, 0, sequence.length-1, sequence[sequence.length-1]);
        return flage;
    }
    public static boolean  process(int [] sequence,int start,int end,int root) {
    	if(start >= end)
    		return true;
    	int middle = findIndex(sequence, start, end, root);    	
    	for(int i = start;i <= middle - 1;i++) {
    		if(sequence[i] > root)
    			return false;
    	}
    	for(int i = middle;i <= end - 1 ;i++) {
    		if(sequence[i]<root)
    			return false;
    	}
    	//妈了个巴子的，这个吊玩意儿太坑了，就得加这一句才对，草
    	//这里如果middle是0的话，还是让他保持为0，这样，跳到下一个的时候可以start == end，返回true，不然会报数组
    	//范围溢出，没有array[-1]的用法。
    	middle =middle - 1 >=0 ? middle:1;
    	return process(sequence, start, middle - 1, sequence[middle - 1])
    			&& process(sequence, middle, end-1, sequence[end - 1 ]);
    	
    }
    
    
    public static  int findIndex(int[] sequence,int start,int end,int target) {
    	for(int i=start;i <= end; i++) {
    		if(sequence[i] >= target) {
    			return i; 
    		}
    	}
    	
    	return -1;
    }
}
