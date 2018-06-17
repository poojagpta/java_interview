package com.jbksoft.collections.LinkListTypeProbs;

public class CircularLinkedList {

    public static class Node{
        String data;
        Node next;

        public Node(String data){
            this.data=data;
            this.next=null;
        }

        public void addNodeToTrail(String data){
            Node current=this;

            while(current.next!=null){
                current=current.next;
            }

            current.next=new Node(data);
        }

        public void addNodeToTrail(Node node){
            Node current=this;

            while(current.next!=null){
                current=current.next;
            }

            current.next=node;
        }

    }

    public static void main(String[] args){

        Node n=new Node("A");
        n.addNodeToTrail("B");

        Node node=new Node("C");
        n.addNodeToTrail(node);
        n.addNodeToTrail("D");
        n.addNodeToTrail("E");
        n.addNodeToTrail(node);
        System.out.println(circularListPoint(n).data);
    }

    public static Node circularListPoint(Node head){
        Node n1=head;
        Node n2=head;

      //  Node nn=meetingPoint(n1,n2.next.next);

        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2){ break; }
        }

        n1=head;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }

        // Now n2 points to the start of the loop.
        return n2;

    }


    public static Node meetingPoint(Node n1,Node n2){
        while(n1!=null && n2!=null && n2.next!=null){
            if(n1.data.equals(n2.data)){
                return n1;
            }else{
                n1=n1.next;
                n2=n2.next.next;
            }
        }
        return null;

    }

}
