package com.jbksoft.collections.LinkListTypeProbs;

public class AddLinkedList {

    public static void main(String[] args){

        Node n1=new Node(3,null);
        n1.addToTrail(1);
        n1.addToTrail(5);


        Node n2=new Node(5,null);
        n2.addToTrail(9);
        //n2.addToTrail(2);

        Node head=addLinkedList(n1,n2);
      //  Node head=addLists(n1,n2,0);
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }

    public static class Node{
        int data;
        Node next;

        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }

        public void addToTrail(int data){
            Node head=this;
            Node n=new Node(data,null);

            while(head.next!=null){
                head=head.next;
            }

            head.next=n;
        }

        public void addToTrail(Node n){
            Node head=this;

            while(head.next!=null){
                head=head.next;
            }

            head.next=n;

        }
    }


    public static Node addLinkedList(Node n1,Node n2){

        if(n1==null || n2==null){
            return null;
        }

        int carry=0;
        int sum=0;
        Node head=null;
        while(n1!=null && n2!=null){
            sum=n1.data+n2.data+carry;
            int data=sum%10;
            carry=sum/10;

            if(head==null){
                head=new Node(data,null);
            }else{
                head.addToTrail(data);
            }

            n1=n1.next;
            n2=n2.next;
        }

        while(n1!=null || n2!=null){

            if(n1!=null){
               sum=n1.data+carry;
                n1=n1.next;
            }else{
                sum=n2.data+carry;
                n2=n2.next;
            }

            carry=sum/10;
            head.addToTrail(sum%10);
        }


        return head;
    }


    public static Node addLists(Node n1,Node n2,int carry){

        if(n1==null && n2==null){
          return null;
        }

        int sum=carry;
        if(n1!=null){
            sum+=n1.data;
        }

        if(n2!=null){
            sum+=n2.data;
        }

        carry=sum/10;

        Node n=new Node(sum%10,null);
        Node more=addLists(n1==null?null: n1.next,n2==null?null:n2.next,carry);

        if(more !=null){
            more.addToTrail(n);

        }else{
            more=n;
        }


        return more;

    }
}
