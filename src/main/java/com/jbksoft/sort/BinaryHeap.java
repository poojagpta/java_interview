package com.jbksoft.sort;

public class BinaryHeap {

    public static void main(String str[]){
        BinaryHeap heap=new BinaryHeap(10);
        heap.addKey(8);
        heap.addKey(7);
        System.out.println(heap);

        heap.addKey(9);
        heap.addKey(5);
        System.out.println(heap);
        heap.addKey(4);
        System.out.println(heap);

        heap.addKey(3);
        heap.addKey(2);
        System.out.println(heap);
    }

    private int capacity;
    private int unUsedIndex;
    private int arr[];
    public BinaryHeap(int capacity){
        this.capacity=capacity;
        this.unUsedIndex=0;
        this.arr=new int[capacity];
    }

    public void addKey(int key){
        if(unUsedIndex>=arr.length){
            return;
        }

        arr[unUsedIndex]=key;

        for(int i=unUsedIndex-1;i>=0;i--){
          validateBinaryRoot(i,arr);
        }

        unUsedIndex++;

    }

    public void validateBinaryRoot(int root,int[] arr){
        int left=2*root+1;
        int right=2*root+2;
        if(left<arr.length && arr[left]>0 && arr[root]<arr[left]){
            swap(arr, root,left);
            validateBinaryRoot(root,arr);
            validateBinaryRoot(left,arr);
        }

        if(right<arr.length && arr[right]>0 && arr[root]>arr[right]){
            swap(arr, root,right);
            validateBinaryRoot(root,arr);
            validateBinaryRoot(right,arr);
        }

    }



    public void swap(int[] arr,int a1,int a2){
        int tmp=arr[a1];
        arr[a1]=arr[a2];
        arr[a2]=tmp;

    }

    @Override
    public String toString(){
        String val="";
        for(int i=0;i<capacity;i++){

            if(arr[i]>0){
                val+=arr[i]+":";
            }

        }
        return val;
    }
}
