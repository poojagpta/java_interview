package com.jbksoft.sort;

public class MergeSort {


    public static void mergeSort(int[] arr, int left, int right){

        if(right-left<=1){
            return;
        }

        int mid =(right+left)/2;

        mergeSort(arr, left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr, left,mid,right);

    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] temp1=new int[mid-left];
        int[] temp2=new int[right-mid];
        int count=0;
        for(int i=left;i<mid;i++){
            temp1[count]=arr[i];
            count++;
        }

        count=0;
        for(int j=mid;j<right;j++){
            temp2[count]=arr[j];
            count++;
        }


    }


}
