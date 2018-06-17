package com.jbksoft.collections.LinkListTypeProbs;

public class NthLast {

    public static class Node{
        int data;
        Node next;

        public Node(int d, Node n){
            this.data=d;
            this.next=n;
        }

        public void addNodeToTail(int data){
            Node n=new Node(data,null);
            Node head=this;

            while(head.next!=null){
                head=head.next;
            }

            head.next=n;
        }

    }


    public static void main(String[] args){
        Node n=new Node(1,null);
        n.addNodeToTail(2);
        n.addNodeToTail(3);
        System.out.println(NthToLast(n,1));
    }

    public static int NthToLast(Node head, int position){
        if(head==null || position<0){
            return -1;
        }

        Node runner=head;
        int count=position;

        while(runner!=null && count>0){
            runner=runner.next;
            count--;
        }

        if(runner==null){
            return -1;
        }

        while(runner!=null && runner.next!=null){
            head=head.next;
            runner=runner.next;
        }

        return head.data;
    }

}
