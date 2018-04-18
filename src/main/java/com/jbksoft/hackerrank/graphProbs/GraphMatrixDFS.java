package com.jbksoft.hackerrank.graphProbs;

import java.util.Scanner;

public class GraphMatrixDFS {


    public static int getBiggestRegion(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        boolean[][] visited =new boolean[row][column];

        int max=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                max=Math.max(max,getMaxCell(matrix,i,j,visited,0));
            }
        }

        return max;
    }


    public static int getMaxCell(int[][] matrix, int i,int j, boolean[][] visited,int count){
        if(visited[i][j]) return count;

        if(isValid(matrix, i, j)&& !visited[i][j]){
            visited[i][j]=true;
            ++count;

            if(isValid(matrix,i-1,j-1)&& !visited[i-1][j-1]){
                 count=getMaxCell(matrix, i-1,j-1,visited,count);
            }

            if(isValid(matrix, i-1,j)&& !visited[i-1][j]){
                count=getMaxCell(matrix, i-1,j,visited,count);
            }

            if(isValid(matrix, i-1,j-1) && !visited[i-1][j-1]){
                count=getMaxCell(matrix, i-1,j,visited,count);
            }

            if(isValid(matrix, i,j-1) && !visited[i][j-1]){
                count=getMaxCell(matrix, i,j-1,visited,count);
            }

            if(isValid(matrix, i,j+1) && !visited[i][j+1]){
                count=getMaxCell(matrix, i,j+1,visited,count);
            }

            if(isValid(matrix, i+1,j+1) && !visited[i+1][j+1]){
                count=getMaxCell(matrix, i+1,j+1,visited,count);
            }

            if(isValid(matrix, i+1,j-1) && !visited[i+1][j-1]){
                count=getMaxCell(matrix, i+1,j-1,visited,count);
            }

            if(isValid(matrix, i+1,j) && !visited[i+1][j]){
                count=getMaxCell(matrix, i+1,j,visited,count);
            }
        }
        return count;
    }

    public static boolean isValid(int[][] matrix, int row, int column){
        if(row>=0 && row<matrix.length && column>=0 && column<matrix[0].length){
            if(matrix[row][column]==1){
                return true;
            }
        }

        return false;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
