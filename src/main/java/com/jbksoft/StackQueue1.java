package com.jbksoft;

import java.util.ArrayList;

public class StackQueue1 {
    private int capacity;
    private ArrayList<Stack<Integer>> stackList=new ArrayList<Stack<Integer>>();

    public StackQueue1(int capacity){
        this.capacity=capacity;
    }
    public boolean push(int data){
      Stack last= getLastStack();
      if(last!=null && !last.isAtLastCapacity()){
         return last.push(data);
      }else{
          Stack s=new Stack(100);
          s.push(data);
          stackList.add(s);
          return true;
      }

    }

    public int pop(){
        Stack last=getLastStack();
        Integer data=(Integer)last.pop();

        if(last.size()==0){
            stackList.remove(stackList.size()-1);
        }

        return data;
    }


   public Stack getLastStack(){
        if(stackList==null) return null;

        return stackList.get(stackList.size()-1);
   }

   /*public int pop(int index){

   }

   public int leftShift(int index, boolean removetop){
       Stack stack=stackList.get(index);
       if(!stack.isEmpty()){
           stack.pop();
       }
   }*/
}
