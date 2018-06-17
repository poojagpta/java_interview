package com.jbksoft.sort;

public class MaxMinHeap {
    int[] arr;

    public MaxMinHeap(int[] arr){
        this.arr=arr;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{0,40,60,10,20,50,30};
        int mid=(arr.length-1)/2;

        for(int i=mid;i>0;i--){
            createMaxHeap(arr,i);
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    public static void createMaxHeap(int[] arr,int i){
            int left=2*i;
            int right=2*i+1;
            int largest =i;
            if(left<arr.length && arr[left]>arr[i]){
                largest=left;
            }
            if(right<arr.length && arr[right]>arr[largest] && arr[right]>arr[i]){
                largest=right;
            }

            if(i!=largest){
                swap(arr,i,largest);
                createMaxHeap(arr,largest);
            }


        }

    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
