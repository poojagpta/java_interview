package com.jbksoft.collections.StackQueueProbs;

public class MinStack {

    public static class Node{
        int data;
        int min;
        Node next;

        public Node(int data,int min){
            this.data=data;
            this.min=min;
        }

        public Node addToHead(Node n){
          Node current=this;
          current.next=n;

          return n;
        }

    }

    public static Node head;
    public static int min;

    public void push(int data){
        if(data<min){
            min=data;
        }

        Node n=new Node(data,min);
        if(head==null){
            head=n;
        }else{
            head=head.addToHead(n);
        }
    }

    public int pop(){
        int data=head.data;
        head=head.next;
        return data;
    }

    public int minimum(){
        return head.min;
    }

}
