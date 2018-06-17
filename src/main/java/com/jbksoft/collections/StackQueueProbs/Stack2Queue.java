package com.jbksoft.collections.StackQueueProbs;

public class Stack2Queue {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
        }

        public Node addToHead(Node n){
            Node current=this;
            n.next=current;
            return n;
        }
    }

    public Node top1;
    public Node top2;

    public void enqueue(int data){
       top1=push(top1,data);
    }

    private int pop(int pos){

        Node current=null;
        Node n=null;

        switch(pos){
            case 1:current=top1;break;
            case 2: current=top2;break;
        }

        if(current!=null){
            n=current;

            switch(pos){
                case 1:top1=current.next;break;
                case 2: top2=current.next;break;
            }

        return n.data;

        }

        return -1;
    }

    private Node push(Node header,int data){
        if(header==null){
            header=new Node(data);
        }else{
            header=header.addToHead(new Node(data));
        }

        return header;
    }

    public int dequeue(){

        if(top2==null){
           while(top1!=null){
               top2=push(top2, pop(1));
           }
        }

       return pop(2);
    }

    public static void main(String[] args){
        Stack2Queue queue=new Stack2Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
