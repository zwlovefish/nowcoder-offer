package com.zhou;
/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 
 * */
public class PathInMatrix {
	public static void main(String[] args) {
		//char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
		
		//char[] matrix= {'a','b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
		char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
		char[] str = "SLHECCEIDEJFGGFIE".toCharArray();
		//char[] str = {'b','c','c','e','d'};
		//char[] str = {'a','b','c','d'};
		//char[] str = {'a','b','c','b'};
		System.out.println(hasPath(matrix, 5, 8, str));
	}
    public static  boolean hasPath(char[] matrix, int rows, int cols, char[] str){
    	//首先将一维矩阵转为二维矩阵
    	char[][] map = new char[rows][];
    	int[][] help = new int[rows][];
    	for(int i=0;i<rows;i++)
    		{map[i]=new char[cols];
    		help[i]=new int[cols];}
    	int k=0;
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			map[i][j]=matrix[k++];
    			help[i][j]=0;
    		}
    	}
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			System.out.print(map[i][j]+" ");
    		}
    		System.out.println();
    	}
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			if(process(map, i, j, str, 0,help)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    public static boolean process(char[][] matrix,int row,int col,char[] str,int k,int[][] help) {
   
    	if(row <0||row >=matrix.length||col<0||col>=matrix[0].length ||matrix[row][col]!=str[k] || help[row][col]==1)
    		return false;
    	if(k==str.length-1)
    		return true;
    	help[row][col]=1;
    	if(process(matrix, row, col+1, str, k+1, help) || process(matrix, row+1, col, str, k+1, help)||process(matrix, row, col-1, str, k+1, help)||process(matrix, row-1, col, str, k+1, help))
    		return true;
    	help[row][col]=0;
    	return false;
    }
}
