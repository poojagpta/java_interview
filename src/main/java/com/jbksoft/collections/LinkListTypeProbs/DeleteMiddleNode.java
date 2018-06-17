package com.jbksoft.collections.LinkListTypeProbs;

public class DeleteMiddleNode {

    public static void main(String[] args){

      Node n1=new Node("A");
      Node n2=new Node("B");
      Node n3=new Node("C");
      Node n4=new Node("D");
      Node n5=new Node("E");

      n1.addNodeToTrail(n2);
      n1.addNodeToTrail(n3);
      n1.addNodeToTrail(n4);
      n1.addNodeToTrail(n5);

      Node m=n1.next.next;
        System.out.println(deleteMiddle(m));

        while(n1!=null){
            System.out.println(n1.data+":");
            n1=n1.next;
        }

    }

    public static class Node{

        String data;
        Node next;

        public Node(String data){
            this.data=data;
        }

        public void addNodeToTrail(Node node){
            Node head=this;
            while(head.next!=null){
                head=head.next;
            }
            head.next=node;
        }
    }

    public static boolean deleteMiddle(Node n){
        if(n==null || n.next==null){
            return false;
        }

       n.data=n.next.data;
       n.next=n.next.next;

       return true;
    }
}
