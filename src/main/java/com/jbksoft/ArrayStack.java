package com.jbksoft;

/**
 * Implementation of 3 stack using an array
 */
public class ArrayStack {

  private int stackSize;
    private int[] buffer;
  private int[] stackPointers=new int[]{-1,-1,-1};

  public ArrayStack(int capacity){
      this.stackSize=capacity;
      buffer=new int[stackSize*3];
  }

  public boolean push(int data, int stackNum){
    int index=stackSize*stackNum+stackPointers[stackNum]+1;

      if(buffer.length>index){
          buffer[index]=data;
          stackPointers[stackNum]++;
          return true;
      }

      return false;
  }

  public int pop(int stackNum){
   int index=stackSize*stackNum+stackPointers[stackNum];
   stackPointers[stackNum]--;
   int num=buffer[index];
   buffer[index]=0;
   return num;
  }

  public int peek(int stackNum){
      int index=stackNum*stackSize+stackPointers[stackNum];
      return buffer[index];
  }

  public boolean isEmpty(int stackNum){
      return stackPointers[stackNum]<0?true:false;
  }
}
