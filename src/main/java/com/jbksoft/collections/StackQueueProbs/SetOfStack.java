package com.jbksoft.collections.StackQueueProbs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Like
 */
public class SetOfStack {
   public static class Node{
       public int data;
       public Node next;

       public Node(int d){
           this.data=d;
       }

       public Node addToHead(Node n){
           Node current=this;
           n.next=current;
           return n;
       }
   }



   ArrayList<Node> stackOfNode=new ArrayList<Node>();
   public static int capacity=3;
   public static int currentCount=0;

   public void push(int d){
       Node n=new Node(d);
       if(currentCount<capacity && stackOfNode.size()>0 && stackOfNode.get
           (stackOfNode.size()-1)!=null){
               Node header=stackOfNode.get(stackOfNode.size()-1);
               header=header.addToHead(n);
               stackOfNode.set(stackOfNode.size()-1,header);
               currentCount++;
       }else if (currentCount==capacity) {
           currentCount=0;
           stackOfNode.add(stackOfNode.size(),n);
       }else{
           currentCount++;
           stackOfNode.add(stackOfNode.size(),n);
       }
   }

   public int pop(){
       if(stackOfNode.size()>0){
           Node head=stackOfNode.get(stackOfNode.size()-1);
           int data=head.data;
           head=head.next;

           if(head==null){
               stackOfNode.remove(stackOfNode.size()-1);
           }

           return data;
       }

       return -1;
   }


   public int pop(int sPos){

       return leftShift(sPos,true);
   }

   public int leftShift(int index, boolean removeTop){
       int itemData=-1;
       if(stackOfNode.size()>index){
           Node head=stackOfNode.get(index);

           if(removeTop){
               itemData=head.data;
               head=head.next;
           }else{
               int count=2;
               while(count<capacity){
                   head=head.next;
                   count=count+1;
               }
               itemData=head.next.data;
               head.next=null;
           }

           if(head==null){
               stackOfNode.remove(index);
           }else if(stackOfNode.size()>index+1){
              int v= leftShift(index,false);
              head.addToHead(new Node(v));
           }

       }
     return itemData;
   }


   public static void main(String[] args){
       SetOfStack s=new SetOfStack();
       s.push(10);
       s.push(20);
       s.push(30);
       s.push(40);
       s.push(50);
       s.push(60);
       s.push(70);
       s.push(80);
       s.push(90);
       s.push(100);
       s.push(110);

       System.out.println(s.pop(1));

   }

}
