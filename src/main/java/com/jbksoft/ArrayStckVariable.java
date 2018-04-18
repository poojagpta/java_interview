package com.jbksoft;

public class ArrayStckVariable {
    public class StackNode{
      private int data;
      private int previous;

        public StackNode(int data, int previous) {
            this.data = data;
            this.previous = previous;
        }

        public int getPrevious() {
            return previous;
        }

        public int getData() {
            return data;
        }
    }

    int stackSize=100;
    StackNode[] buffer=new StackNode[stackSize*3];
    int[] stackPointers=new int[]{-1,-1,-1};
    int indexUsed=0;


    public boolean push(int data, int stackNum){
        if(indexUsed<buffer.length){
            buffer[indexUsed]=new StackNode(data,stackPointers[stackNum]);
            stackPointers[stackNum]=indexUsed;
            indexUsed++;
          return true;
        }

        return false;
    }

    public int pop(int stackNum){
        if(stackPointers[stackNum]<0){
            return -1;
        }else{
            int value=buffer[stackPointers[stackNum]].getData();
            int previous=buffer[stackPointers[stackNum]].getPrevious();
            buffer[stackPointers[stackNum]]=null;
            stackPointers[stackNum]=previous;
            return value;
        }
    }

    public int peek(int stackNum){
        if(stackPointers[stackNum]<0){
            return -1;
        }else{
            int value=buffer[stackPointers[stackNum]].getData();
            return value;
        }
    }

    public boolean isEmpty(int stackNum){
        return stackPointers[stackNum]==-1;
    }
}
