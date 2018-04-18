package com.jbksoft.hackerrank.stackqueue;

public class Queue<T> {
    public static class Node<T>{
        public T data;
        public Node next;
        public Node(T data){
            this.data=data;
        }
    }

    public Node head;
    public Node tail;

    public boolean isEmpty(){
        return head==null;
    }

    public void enqueue(T data){
        Node n=new Node(data);

        if(isEmpty()){
            head=tail=n;
        }else {
            tail.next = n;
            tail = n;
        }
    }

    public T peek(){
        if(!isEmpty()){
            return (T)head.data;
        }

        return null;
    }

    public T dequeue(){
        T data=null;

        if(!isEmpty()){
            data=(T)head.data;
            head=head.next;

            if(head==null){
                tail=null;
            }
        }

        return data;
    }
}
