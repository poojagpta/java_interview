package com.jbksoft.hackerrank.binary;

public class BinarySearch {

    public static int binarySearchIterative(int[] matrix, int x){

        int left=0;
        int right=matrix.length-1;
        int mid= (right-left)/2;

        while(left<=right){
            if(matrix[mid]==x){
                return mid;
            }else if(matrix[mid]>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
            mid=left+(right-left)/2;
        }

        return -1;
    }


    public static int binarySearchRecursive(int[] matrix,int data){
        return binarySearchRecursive(matrix,data,0, matrix.length);
    }

    public static int binarySearchRecursive(int[] matrix,int data, int start, int end){
        int i=start+(end-start)/2;

        if(start>end){
            return -1;
        }

        if(matrix[i]==data){
            return i;
        }else if(matrix[i]<data){
            return binarySearchRecursive(matrix,data,i+1,end);
        }else if(matrix[i]>data){
            return binarySearchRecursive(matrix,data,start,i-1);
        }

        return -1;
    }
}
