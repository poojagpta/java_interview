package com.jbksoft;

public class Recursion {

    public static int paths;
    public static void main(String[] args){

        int[][] matrix=new int[2][2];
        int counter=0;
         counter= move(matrix, 0,0, 1,1);
        System.out.println(counter+" ");

    }

    public static int move(int[][] matrix,int currentRow,int currentColumn,int destinationRow, int destinationColumn){

        if(currentRow==destinationRow && currentColumn==destinationColumn) {
             return 1;
        }

        boolean rightMove=canMove(matrix,currentRow, currentColumn, 0);
        boolean downMove=canMove(matrix,currentRow,currentColumn,1);

        if(rightMove){
            return move(matrix,currentRow,currentColumn+1,destinationRow,destinationColumn);
        }

        if(downMove){
            return move(matrix,currentRow+1,currentColumn,destinationRow, destinationColumn);
        }

        return 0;
    }


    public static boolean canMove(int[][] matrix,int currentRow, int currentColumn, int moveType){
        if(moveType==0){
            return currentColumn+1<matrix[0].length;
        }
        if(moveType==1){
            return currentRow+1<matrix.length;
        }

        return false;
    }

}
