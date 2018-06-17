package com.jbksoft.collections.ArrayStringTypeProbs;

public class FindSetZeroRowColumn {

    public static void main(String[] args){

        int[][] matrix=new int[2][3];
        //matrix[0][0]= 3;

        findReplaceZero(matrix);

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.println(matrix[i][j]);
            }

        }

    }

    public static void findReplaceZero(int[][] matrix){
       int row=matrix.length;
       int column=matrix[0].length;
       boolean[] m=new boolean[row];
        boolean[] n=new boolean[column];

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==0){
                    m[i]=true;
                    n[j]=true;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(m[i] || n[j]){
                    matrix[i][j]=0;
                }
            }
        }

    }
}
