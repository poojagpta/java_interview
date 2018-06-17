package com.jbksoft.collections.StackQueueProbs;

/**
 * Last in first out
 */
public class ArrayAs3Stack {

     static int size=10;
    public static int[] buffer=new int[size*3];

    int[] top={-1,-1,-1};



    public  void push(int d, int s){
        if(top[s]<buffer.length/3){
            top[s]=top[s]+1;
            top[s+s*size]=d;
        }
    }

    public int pop(int s){
        if(top[s]>=0){
            int val=buffer[top[s]+s*size];
            top[s]=top[s]-1;
            return val;
        }

        return -1;
    }


}
