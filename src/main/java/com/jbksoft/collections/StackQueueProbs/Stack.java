package com.jbksoft.collections.StackQueueProbs;

/**
 * Last in first out
 */
public class Stack {

    public static class Node{
        int data;
        Node next;

        public Node(int d, Node m){
            this.data=d;
            this.next=m;
        }


        public Node addToHead(Node n){
            Node header=this;
            n.next=header;
            header=n;

            return header;
        }
    }

    Node top;

    public void push(Node n){
        if(top==null){
            top=n;
        }else{
            top=top.addToHead(n);
        }
    }

  public Node pop(){
        if(top==null){
            return null;
        }else{
            Node head=top;
            top=top.next;
            return head;
        }
  }

  public Node seek(){
        if(top==null){
            return null;
        }else{
            return top;
        }
  }

}
