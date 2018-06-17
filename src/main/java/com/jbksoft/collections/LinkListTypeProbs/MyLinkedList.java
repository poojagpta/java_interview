package com.jbksoft.collections.LinkListTypeProbs;

public class MyLinkedList {
    public class Node{
        public int data;
        public Node next;

      public Node(int data,Node next){
          this.data=data;
          this.next=next;
      }

        public void appendToTail(int data){

            Node end=new Node(data,null);
            Node n=this;
            while(n.next!=null){
               n=n.next;
            }
            n.next=end;
        }

        public Node deleteNode(Node head,int data){

          if(head.data==data){
              return head.next;
          }

          Node prev=head;
          Node current=head.next;
          while(current.next!=null){

              if(current.data==data){
                  prev.next=current.next;
                  return head;
              }

              current=current.next;
              prev=prev.next;
          }

          return head;
        }


    }

    public Node root;





}
