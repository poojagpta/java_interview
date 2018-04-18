package com.jbksoft.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortingAlgo {
    public static int NO_OF_TIME=0;

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int[] numberSort=new int[3];
        for(int i=0;i<3;i++){
            numberSort[i]=scanner.nextInt();
        }

       /* bubbleSort1(numberSort,numberSort.length);
        for(int i: numberSort){
            System.out.println(i);

        }*/
        //System.out.println("NO OF TIME"+NO_OF_TIME);

      //  quickSort(numberSort,0,numberSort.length);
        insertionSort1(numberSort);

        for(int i: numberSort){
            System.out.println(i);

        }

    }


    //Merge Sort Algorithm
    public static void mergeSort(int[] numbers, int start, int end){

        if(end-start==1){
            return;
        }
        int middlePoint=end-start/2;
        mergeSort(numbers,start,middlePoint);
        mergeSort(numbers,middlePoint+1,end);
        merge(numbers,start,middlePoint,end);
    }

    public static void merge(int[] number, int l,  int m, int r){
       int n1=m-l-1;
       int n2=r-m;

       int[] templ=new int[n1];
       int[] tempr=new int[n2];

       for(int i=l;i<m;i++){
           templ[i]=number[i];
       }

       for(int i=m;i<r;i++){
            tempr[i]=number[i];
       }

       int i=0,j=0;
       int count=l;

       while(i<n1 && j<n2){
           if(templ[i]<=tempr[j]){
               number[count]=templ[i];
               i++;
           }else{
               number[count]=tempr[j];
               j++;
           }

           count++;
       }

       while(i<n1){
           number[count]=templ[i];
           i++;
           count++;
       }

       while(j<n2){
           number[count]=tempr[j];
           j++;
           count++;
       }
    }



    //6 3 7 1 4
     public static void quickSort(int[] numbers,int start,int end){


        if(end-start==1){
            return;
        }

         int pivotPoint=pivotPoint(numbers,start,end);

        if(pivotPoint-1>0){
            pivotPoint(numbers,start,pivotPoint-1);
        }

        if(pivotPoint+1<end-1){
            pivotPoint(numbers,pivotPoint+1,end);

        }
    }


    private static int pivotPoint(int[] numbers,int start, int end){

        //Find pivot point
        int pivot=numbers[end-1];
        int i=start;
        int j=end-2;


        while(i<j){
            int left,right=left=-1;
            if(numbers[i]<=pivot){
                i++;
            }else{
                left=i;
            }

            if(numbers[j]>pivot){
                j--;
            }else{
                right=j;
            }

            if(left>0 && right>0){
                int temp=0;
                numbers[left]=temp;
                numbers[left]=numbers[right];
                numbers[right]=temp;
            }
        }

        if(numbers[i]>pivot){
            numbers[numbers.length-1]=numbers[i];
            numbers[i]=pivot;
            return i;
        }else if(numbers[j]>pivot){
            numbers[numbers.length-1]=numbers[j];
            numbers[j]=pivot;
            return j;
        }

        return 0;
    }


    //19,24,36,54,21=n,71,90
    //19,24,36,54,55=n,71,18
    public static void insertionSort(int[] numbers,int n){
        int nVal=numbers[n];
        int position=n;
        for(int i=n-1;i>=0;i--){
             if(numbers[i]>nVal){
              numbers[i+1]=numbers[i];
              position=i;
            }
        }
        numbers[position]=nVal;

        while(n<numbers.length){
            insertionSort(numbers,++n);
            ++NO_OF_TIME;
        }
    }

    public static void insertionSort1(int[] arr){

        for(int i=1;i<arr.length;i++){
            int posVal=arr[i];
            int position=i-1;
            while(position>=0){
                if(arr[position]>posVal){
                    arr[position+1]=arr[position];
                    position=position-1;
                }else{
                    break;
                }
            }


            arr[position+1] = posVal;


        }

    }

    public static void selectionSort1(int[] numbers){
        for (int n=0;n<numbers.length-1;n++){
            int min=numbers[n];
            int position=n;
            for(int i=n+1;i<numbers.length;i++){
                if(numbers[i]<min){
                    position=i;
                    min=numbers[i];
                }
            }

            numbers[position]=numbers[n];
            numbers[n]=min;
            ++NO_OF_TIME;
        }
    }

    public static void selectionSort2(int[] numbers, int n){
        int min=numbers[n];
        int position=n;
        for(int i=n+1;i<numbers.length;i++){
            if(numbers[i]<min){
                position=i;
                min=numbers[i];
            }
        }

        numbers[position]=numbers[n];
        numbers[n]=min;

        if(n<numbers.length-1){
            selectionSort2(numbers,++n);
            ++NO_OF_TIME;
        }
    }


    //Ascending order
    public static void bubbleSort1(int[] numbers, int n){
        for(int i=0;i<n-1;i++){
            if(numbers[i]>numbers[i+1]){
               int temp=numbers[i];
               numbers[i]=numbers[i+1];
               numbers[i+1]=temp;
            }

        }

        if(n>1){
            bubbleSort1(numbers,--n);
            ++NO_OF_TIME;
        }
    }


}
