package com.jbksoft.sort;

import java.util.Arrays;

public class AllSorting {

    public static void main(String[] str){
        int[] arr={1,3,5,77,22,55,88};
        //bubleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);

        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" : ");
        }

        int[] arr1={99,88,77,66,55,44,33,22,11};

        //bubleSort(arr1);
        //selectionSort(arr1);
        //insertionSort(arr1);
//        mergeSort(arr1,0,arr1.length-1);
        System.out.println(" ");
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" : ");
        }

    }

    public static void bubleSort(int arr[]){

        int count=arr.length-1;

        while(count>0){

            for(int i=0;i<count;i++){

                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }

            }
            count--;

        }
    }

    public static void selectionSort(int arr[]){
        int count=0;
        while(count<arr.length-1){
            int min=arr[count];
            int position=count;
            for(int i=count+1;i<arr.length;i++){
                if(arr[i]<min){
                    min=arr[i];
                    position=i;
                }
            }

            arr[position]=arr[count];
            arr[count]=min;
            count++;
        }
    }

    public static void insertionSort(int arr[]){
        for(int count=1;count<arr.length;count++){
            int position=count;
            int tmp=arr[count];

            for(int i=count-1;i>=0;i--){
                if(arr[i]>tmp){
                    arr[position]=arr[i];
                    position=i;
                }else{
                    break;
                }
            }

            arr[position]=tmp;
        }
    }

    public static void quickSort(int arr[],int l,int r){
        if(r>l){
            int pst=partition(arr,l,r);
            quickSort(arr,l,pst-1);
            quickSort(arr,pst+1,r);
        }
    }



    public static int partition(int[] arr, int l,int r){

        int pivot=arr[l];

        int l1=l+1;
        int r1=r;


        while(r1>l1){

            while(arr[l1]<pivot && l1<r1){
                l1++;
            }

            while(arr[r1]>pivot && r1>l1){
                r1--;
            }

            if(r1>l1){
                int tmp=arr[l1];
                arr[l1]=arr[r1];
                arr[r1]=tmp;
            }

        }

        if(arr[l1]<pivot){
            arr[l]=arr[l1];
            arr[l1]=pivot;
            return l1;
        }

        return l;

    }

    public static void mergeSort(int[] arr, int l,int r){

        if(r>l){
            int mid=(l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);

        }

    }

    public static void merge(int[] arr, int l,int mid,int r){

        if(r-l<=1){
            return;
        }

        int[] tmp1=new int[mid-l];
        int[] tmp2=new int[r-(mid+1)];

        int ctmp1=0;
        for(int i=l;i<mid;i++){
            tmp1[ctmp1]=arr[i];
            ctmp1++;
        }

        int ctmp2=0;
        for(int i=mid+1;i<r;i++){
            tmp2[ctmp2]=arr[i];
            ctmp2++;
        }

        ctmp1=0;
        ctmp2=0;

        int i=l;

        while(ctmp1<tmp1.length && ctmp2<tmp2.length){
            if(tmp1[ctmp1]<tmp2[ctmp2]){
                arr[i]=tmp1[ctmp1];
                ctmp1++;
            }else{
                arr[i]=tmp2[ctmp2];
                ctmp2++;
            }
            i++;
        }

        while(ctmp1<tmp1.length){
            arr[i]=tmp1[ctmp1];
            ctmp1++;
            i++;
        }

        while(ctmp2<tmp2.length){
            arr[i]=tmp2[ctmp2];
            ctmp2++;
            i++;
        }

    }


}
