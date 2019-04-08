package com.zhou;

import java.util.ArrayList;

/*
 * 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 
 *  1  2  3  4 
 *  5  6  7  8 
 *  9 10 11 12 
 * 13 14 15 16 
 * 则依次打印出数字
 *  1  2  3  4 
 *  8 12 16 15
 * 14 13  9  5
 *  6  7 11 10.
 * 
 * 
 * 
 * */
public class ClockwisePrintArray {
	public static void main(String[] args) {
		int[][] matrix= {
				{1}
//				{1,2,3,4},
//				{5,6,7,8},
//				{9,10,11,12},
//				{13,14,15,16}
				
//					{1,2,3,4,5},
//					{6,7,8,9,10},
//					{11,12,13,14,15},
//					{16,17,18,19,20},
//					{21,22,23,24,25}
//				{1},
//				{2},
//				{3},
//				{4},
//				{5}
		};
		ArrayList<Integer> arrayList = printMatrix(matrix);
		//System.out.println(arrayList.size());
		for (Integer integer : arrayList) {
			System.out.print(integer+" ");
		}
	}
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
    	if(matrix == null)
    		return null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int lrow = 0;
        int lcol = 0;
        int rrow = matrix.length-1;
        int rcol = matrix[0].length-1;
        while(lrow<=rrow && lcol<=rcol) {
        	arrayList.addAll(process(matrix, lrow++, lcol++, rrow--, rcol--));
        }
        return arrayList;
    }
    public static ArrayList<Integer> process(int[][] matrix,int lrow,int lcol,int rrow,int rcol) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	if(lcol == rcol) {
    		while(lrow<=rrow) {
    			arrayList.add(matrix[lrow++][rcol]);
    		}
    	}else if(lrow == rrow) {
    		while(lcol<=rcol) {
    			arrayList.add(matrix[rrow][lcol++]);
    		}
    	}else {
			for(int i=lcol;i<=rcol-1;i++) {
				arrayList.add(matrix[lrow][i]);
			}
			for(int i=lrow;i<=rrow-1;i++) {
				arrayList.add(matrix[i][rcol]);
			}
			for(int i=rcol;i>=lcol+1;i--) {
				arrayList.add(matrix[rrow][i]);
			}
			for(int i=rrow;i>=lrow+1;i--) {
				arrayList.add(matrix[i][lcol]);
			}
		}
    	return arrayList;
    }
}
