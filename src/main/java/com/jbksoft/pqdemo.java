package com.jbksoft;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class pqdemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue(); // minheap as parent is smaller than child
        Random r = new Random();
        int i = r.nextInt(100);
        System.out.print(i+"->");
        pq.offer(i);
        i = r.nextInt(100);
        System.out.print(i+"->");
        pq.offer(i);
        i = r.nextInt(100);
        System.out.print(i+"->");
        pq.offer(i);
        i = r.nextInt(100);
        System.out.print(i+"->");
        pq.offer(i);
        i = r.nextInt(100);
        System.out.print(i+"->");
        pq.offer(i);
        System.out.println(pq);
        System.out.println("Size "+pq.size());
        System.out.println("head: "+pq.peek());
        System.out.println("poll: "+pq.poll()); // poll gives root
        while(pq.size()!=0){
            System.out.print(pq.poll()+"->"); // first root comes out
        }

        // Iterating over PriorityQueue, iterator returned
        // by PriorityQueue doesn't guarantee any order
        Iterator<Integer> itr = pq.iterator();
        System.out.println("Iterating over PriorityQueue");
        while(itr.hasNext()){ System.out.print(itr.next()+"->"); }

    }
}
