package com.jbksoft.collections.LinkListTypeProbs;

import java.util.HashSet;

public class RemoveDuplicateLinkedList {

    public static class Node{
        int data;
        Node next;
        public Node(int d, Node next){
            this.data=d;
            this.next=next;
        }

        public void addToTail(int data){
            Node n=new Node(data,null);
            Node current=this;
            while(current.next!=null){
                current=current.next;
            }

            current.next=n;
        }

        public Node deleteNode(Node head,int data){

            if(head.data==data){
                return head.next;
            }

            Node current=head;

            while(current.next!=null){
                if(current.next.data==data){
                    current.next=current.next.next;
                }else{
                    current=current.next;
                }
            }

            return head;
        }
    }


    public static void main(String[] args){

        Node head=new Node(1,null);
        head.addToTail(1);
        head.addToTail(1);
        head.addToTail(2);
        head.addToTail(2);

       // removeDuplicates(head);

        removeDuplicatesWoDS(head);

        while(head!=null){
            System.out.println(head.data+":");
            head=head.next;
        }
    }

    public static void removeDuplicates(Node head){

      HashSet<Integer> set=new HashSet<Integer>();
      set.add(head.data);

      Node current=head;
      while(current.next!=null){
          if(!set.add(current.next.data)){
              current.next=current.next.next;
          }else{
              current=current.next;
          }
      }

    }

    public static void removeDuplicatesWoDS(Node head){

        Node current=head;
        while(current!=null && current.next!=null){
            int currData=current.data;
            Node n=current.next;

            while(n!=null && n.data==currData){
                current.next=n.next;
                n=current.next;
            }

            while(n!=null && n.next!=null){
                if(n.next.data==currData){
                    n.next=n.next.next;
                }else{
                    n=n.next;
                }
            }

            current=current.next;
        }


    }

    public static void removeDuplicatesWoBackFlow(Node head){

        Node current=head;



    }


}
