package com.jbksoft.collections.ArrayStringTypeProbs;

public class RotateImage {
    public static void main(String[] args){

        int[][] images=new int[2][2];

        images[0][0]=0;
        images[0][1]=1;
        images[1][0]=2;
        images[1][1]=3;

        rotateImage(images);

        for(int i=0;i<images.length;i++){
            for(int j=0;j<images[0].length;j++){
                System.out.println(images[i][j]);
            }

        }
    }

    public static void rotateImage(int[][] images){

        int row=images.length;
        int column=images[0].length;

        for(int i=0;i<row/2;i++){
            for(int j=0;j<column/2;j++){
                int temp=images[i][j];

                images[i][j]=images[row-1-i][j];
                images[row-1-i][j]=images[row-1-i][column-1-j];
                images[row-1-i][column-1-j]=images[row-1-i][j];
                images[row-1-i][j]=temp;
            }
        }

    }
}
