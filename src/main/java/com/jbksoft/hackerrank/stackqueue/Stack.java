package com.jbksoft.hackerrank.stackqueue;

import java.util.LinkedList;

public class Stack<T> {
    public static class Node<T>{
        public T data;
        public Node next;
        public Node(T data){
            this.data=data;
        }
    }

    private Node top;


    public void push(T data){
        Node n=new Node(data);
        n.next=top;
        top=n;
    }

    public boolean isEmpty(){
        if(top==null){
            return true;
        }
        return false;
    }
    public T pop(){
       T d=null;

        if(!isEmpty()){
            d= (T)top.data;
            top=top.next;
        }


        return d;
    }

    public T peek(){

        return (T)top.data;
    }
}
