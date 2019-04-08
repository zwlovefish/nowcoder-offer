package com.zhou;
/*
 * 
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * */
public class RobotMoveRange {
	public static void main(String[] args) {
		System.out.println(movingCount(15, 20,20 ));
	}
    public static int movingCount(int threshold, int rows, int cols)
    {
        int[][] map = new int[rows][cols];
        for(int i = 0;i < rows;i++) {
        	for(int j=0;j < cols;j++) {
        		map[i][j]=0;
        	}
        }
        return process(map, 0, 0, threshold);
    }
    public static int process(int[][] map,int row,int col,int threshold) {
    	if(row <0 || row >=map.length || col <0 || col >=map[0].length || map[row][col] == 1||!numberSum(row,col, threshold))
    		return 0;
    	map[row][col]=1;
    	return 1 +process(map, row-1, col, threshold)+process(map, row+1, col, threshold)+
    			process(map, row, col-1, threshold)+process(map, row, col+1, threshold);
    }
    
    public static boolean numberSum(int row,int col,int k) {
    	int sum = 0;
    	while(row > 0) {
    		sum = sum + row%10;
    		row = row/10;
    	}
    	while(col>0) {
    		sum = sum+col%10;
    		col=col/10;
    	}
    	if(sum > k) {
    		return false;
    	}
    	return true;
    }
}
