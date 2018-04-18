package com.jbksoft.hackerrank.stackqueue;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.Stack;
import java.util.regex.*;

/**
 * 10
 1 42
 2
 1 14
 3
 1 28
 3
 1 60
 1 78
 2
 2
 */
public class Queuewith2Stack {
    public static class MyQueue<T> {
        java.util.Stack<T> stackNewestOnTop = new java.util.Stack<T>();
        java.util.Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack

            while(!stackOldestOnTop.empty()){
                stackNewestOnTop.push(stackOldestOnTop.pop());
            }

            stackNewestOnTop.push(value);
        }

        public T peek() {
            if(stackOldestOnTop.empty()){
                while(!stackNewestOnTop.empty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }

            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if(stackOldestOnTop.empty()){
                while(!stackNewestOnTop.empty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }

            return stackOldestOnTop.pop();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
