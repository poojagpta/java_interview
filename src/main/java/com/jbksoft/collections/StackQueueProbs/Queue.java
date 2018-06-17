package com.jbksoft.collections.StackQueueProbs;

/**
 * First in first out
 */
public class Queue {

    public static class Node{
        int data;
        Node next;

        public Node(int d){
            this.data=d;
        }

        public void addToTrail(Node n){
            Node current=this;

            while(current.next!=null){
                current=current.next;
            }

            current.next=n;
        }

    }


    public Node first;

    public void enqueue(Node n){
        if(first==null){
            first=n;
        }else{
            first.addToTrail(n);
        }
    }

    public Node dequeue(){
        if(first==null){
            return null;
        }else{
            Node n=first;
            first=first.next;

            return n;
        }
    }

}
