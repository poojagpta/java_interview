package com.jbksoft.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static long counter=0;
    public static void main(String[] args) {
      /*  Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println( getRecuriveNoDups(n,new int[]{1,2,3}));
        }*/

      int[] arr=new int[]{1,1,1,2,2};
        System.out.println(mergeSort(arr,0,arr.length-1));

    }

    public static long quickSort(int[] arr, int left, int right){
        if(right<=left){
            return counter;
        }

        int pivot = pivotPoint(arr,left,right);
        quickSort(arr,left, pivot-1);
        quickSort(arr,pivot+1, right);

        return counter;
    }

    public static int pivotPoint(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                counter++;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static long mergeSort(int[] arr, int left, int right){

        if(left>=right){
            return counter;
        }

        int mid= (left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        mergeHalf(arr, left, mid, right);

        return counter;
    }

    public static void mergeHalf(int[] arr, int left, int mid, int right){
        int [] temp1=new int[mid-left+1];
        int[] temp2=new int[right-mid];
        int count=left;
        for(int i=0;i<mid-left+1;i++){
            temp1[i]=arr[count];
            count++;
        }

        count=mid+1;
        for(int i=0;i<right-mid;i++){
            temp2[i]=arr[count];
            count++;
        }

        int cleft=0,cright=0;
        count=left;
        while(cleft<temp1.length && cright<temp2.length){
            if(temp1[cleft]>temp2[cright]){
                arr[count]=temp1[cleft];
                cleft++;
                count++;
            }else{
                arr[count]=temp1[cright];
                cright++;
                count++;
            }
        }

        while(cleft<temp1.length){
            arr[count]=temp1[cleft];
            cleft++;
            count++;
        }

        while(cright<temp2.length){
            arr[count]=temp1[cright];
            cright++;
            count++;
        }

    }

    public static int getRecuriveNoDups(int n, int[] arr){
        if(n==0){
            return 1;
        }else if(n< 0 || arr.length<=0){
            return 0;
        }

        // step0 present or Step0 not present
        return getRecuriveNoDups(n-arr[0],arr)+ getRecuriveNoDups(n, Arrays.copyOfRange(arr,1,arr.length));

    }

    public static int getWaysCount1(int n){

        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }

        return getWaysCount1(n-1)+getWaysCount1(n-2)+getWaysCount1(n-3);
    }


    public static int getWaysCount(int n){

     int[] possibleOutcome=new int[n+1];

     possibleOutcome[0]=1;

     for(int i=1;i<=n;i++){

         possibleOutcome[i] = possibleOutcome[i-1];

         if(i-2>=0){
             possibleOutcome[i] += possibleOutcome[i-2];
         }

         if(i-3>=0){
             possibleOutcome[i] += possibleOutcome[i-3];
         }
     }

        return possibleOutcome[n];
    }

}