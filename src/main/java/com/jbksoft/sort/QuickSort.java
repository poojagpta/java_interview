package com.jbksoft.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[]{0,40,60,10,20,50,30,90};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr,int left, int right){
        if(left==right || left>right){
            return;
        }


        int pivot=getPivot(arr,left,right);

        quickSort(arr,left,pivot-1);
        quickSort(arr,pivot+1,right);
    }

    public static int getPivot(int[] arr, int left, int right){
        int j=right-1;
        int i=left;
        int pVal=arr[right];

        while(i<j){
           while(arr[i]<pVal){
               i++;
           }

           while(arr[j]>pVal){
               j--;
           }

           if(i<j){
               swap(arr,i,j);
           }
        }

        swap(arr, right, i);


        return i;
    }

    public static void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
