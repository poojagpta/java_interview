package com.jbksoft;

public class Stack<T> {
    public class Node<T>{
        T data;
        Node previous;

    }
   private Node top,bottom;
   private int indexUsed=0;
   private int capacity;

   public Stack(int capacity){
       this.capacity=capacity;
   }

    public int size(){
       return indexUsed;
    }

    public boolean isAtLastCapacity(){
        return indexUsed==capacity;
    }

    public boolean push(T data){
        if(indexUsed>=capacity) return false;

           Node<T> n=new Node();
           n.data=data;
           if(indexUsed==0) bottom=n;
           n.previous=top;
           top=n;

           indexUsed++;

           return true;
       }



   public T pop(){
       T data=(T)top.data;
       top=top.previous;
       indexUsed--;
       return data;
   }

   public boolean isEmpty(){
       return indexUsed==0;
   }
}
