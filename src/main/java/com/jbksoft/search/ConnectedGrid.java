package com.jbksoft.search;



import sun.awt.image.ImageWatched;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class ConnectedGrid {
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
        System.out.println(getConnectedCell(grid));
    }

    public static int getConnectedCell(int[][] matrix){
        int row= matrix.length;
        int column=matrix[0].length;

        int max=Integer.MIN_VALUE;
        HashSet<String> isVisited=new HashSet<String>();

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
              if(matrix[i][j]==0){
                  continue;
              }else{

                  if(!isVisited.contains(row+""+column+"")){
                      max=Math.max(max,getNeighborCount(matrix, i, j, isVisited));
                  }
              }

            }
        }

        return max;
    }

    public static int getNeighborCount(int[][] matrix, int row, int column, HashSet<String> isVisited){

        int count=0;


        if(matrix[row][column]==1 && !isVisited.contains(row+""+column+"")){

            isVisited.add(row+""+column+"");
            count+=1;

            if(isValid(matrix,row-1,column-1,isVisited)){
                count+=getNeighborCount(matrix, row-1,column-1, isVisited);
            }

            if(isValid(matrix, row-1,column,isVisited)){
                count+=getNeighborCount(matrix, row-1,column,isVisited);
            }

            if(isValid(matrix,row-1,column+1,isVisited)){
                count+=getNeighborCount(matrix, row-1,column+1,isVisited);
            }
            if(isValid(matrix,row,column-1,isVisited)){
                count+=getNeighborCount(matrix, row,column-1,isVisited);
            }

            if(isValid(matrix,row,column+1,isVisited)){
                count+=getNeighborCount(matrix, row,column+1,isVisited);
            }

            if(isValid(matrix,row+1,column-1,isVisited)){
                count+=getNeighborCount(matrix, row+1,column-1,isVisited);
            }

            if(isValid(matrix,row+1,column,isVisited)){
                count+=getNeighborCount(matrix, row+1,column,isVisited);
            }

            if(isValid(matrix,row+1,column+1,isVisited)){
                count+=getNeighborCount(matrix, row+1,column+1,isVisited);
            }
        }


        return count;
    }

    public static boolean isValid(int[][] matrix, int row,int column,HashSet isVisited){
        if(!isVisited.contains(row+""+column+"")&& row>=0 && row<matrix.length && column>=0 &&
                column<matrix[0].length && matrix[row][column]==1){
            return true;
        }else{
            return false;
        }
    }
}
