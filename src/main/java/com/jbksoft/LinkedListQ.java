package com.jbksoft;

import java.util.HashSet;

public class LinkedListQ {

    public static void main(String[] args){
      /* LinkedList linkList=new LinkedList();
       linkList.add("AA","AA");
       linkList.add("BB","BB");
        linkList.add("AA","AA");
       linkList.add("CC","CC");
       linkList.add("BB","BB");
       linkList.add("AA","AA");
        linkList.add("CC","CC");
        linkList.add("DD","DD");
        linkList.add("AA","AA");
        deleteMiddleNode(linkList);
        LinkedList.Node  n=linkList.node();
       while(n!=null){
           System.out.println(n.getKey());
           n=n.next();
       }*/

    /*   LinkedList l=new LinkedList();
       l.add("3",null);
       l.add("1",null);
       l.add("5",null);


        LinkedList l2=new LinkedList();
        l2.add("5",null);
        l2.add("9",null);
        l2.add("2",null);
        LinkedList l3=addLinkedList(l,l2);
        LinkedList.Node n=l3.node();
        while(n!=null){
            System.out.println(n.getKey());
            n=n.next();
        }*/

       LinkedList l1=new LinkedList();
       l1.add("A","A");
       l1.add("B","B");
        LinkedList.Node c=l1.add("C","C");
       l1.add("D","D");
       l1.add("E","E",c);

        LinkedList.Node n =startCircle(l1);
        System.out.println(n.getKey()+"---->"+n.getValue());
    }

    /*public static LinkedList.Node addLinkedList(LinkedList.Node n1, LinkedList.Node n2, int carry){

        int sum=carry;
        if(n1==null && n2==null){
            return null;
        }

        if(n1!=null){
            sum+=Integer.parseInt(n1.getKey());
        }

        if(n2!=null){
            sum+=Integer.parseInt(n2.getKey());
        }

        sum=sum%10;
       LinkedList.Node result=new LinkedList.Node(sum,null);
       LinkedList.Node more=addLinkedList(n1==null?null:n1.next(),n2==null?null:n2.next(),
               sum>10? 1: 0);

       result.setNext(more);

    }*/


    public static LinkedList.Node startCircle(LinkedList list){

        if(list==null) return null;

        LinkedList.Node n1=list.node();
        LinkedList.Node n2=list.node();

        while(n2.next()!=null){

            n1=n1.next();
            n2=n2.next().next();

            if(n1==n2){
                break;
            }
        }

        System.out.println(n1.getKey()+"-->"+n1.getValue());
       //There is no circular loop
        if(n2.next()==null){
            return null;
        }

        n1=list.node();
        while(n1!=n2){
            n1=n1.next();
            n2=n2.next();
        }
        return n2;
    }


    public static LinkedList addLinkedList(LinkedList list1, LinkedList list2){
        if(list1==null|| list2==null) return null;

        LinkedList.Node n1=list1.node();
        LinkedList.Node n2=list2.node();
        LinkedList n3=new LinkedList();
        int carryForward=0;
        while (n1!=null && n2!=null){
            int sum=carryForward;

            if(n1!=null){
                sum+=Integer.parseInt(n1.getKey());
            }

            if(n2!=null){
                sum+=Integer.parseInt(n2.getKey());
            }

            if(sum/10>0){
                carryForward=sum/10;
                sum=sum%10;
            }else{
                carryForward=0;
            }

            n3.add(String.valueOf(sum),null);

            if(n1!=null){
                n1=n1.next();
            }

         if(n2!=null){
             n2=n2.next();
         }
        }


        return n3;
    }

    public static void deleteMiddleNode(LinkedList linkedListNode){
        if(linkedListNode==null) return;

        //Find size of the linkedList
        LinkedList.Node node=linkedListNode.node();
        int count=0;
        while(node!=null){
          node=node.next();
          count++;
        }

        node=linkedListNode.node();
        LinkedList.Node previous=linkedListNode.node();

        for(int i=0;i<count/2;i++){
            previous=node;
            node=node.next();
        }

        previous.setNext(node.next());
    }

    public static LinkedList.Node nthlengthLast(LinkedList linkedListNode, int n){
        if(linkedListNode==null) return null;

        LinkedList.Node current=linkedListNode.node();

        for(int i=0;i<n;i++){
          if(current!=null){
              current=current.next();
          }else{
              return null;
          }

        }

        //Distance between current and running is n
        LinkedList.Node running=linkedListNode.node();
        while(current.next()!=null){
            current=current.next();
            running=running.next();
        }

        return running;
    }



    public static void removeDuplicatesWithoutDS(LinkedList linkedListNode){
        if(linkedListNode==null) return;
        if(linkedListNode.size()<=1) return;
        LinkedList.Node previous=linkedListNode.node();
        LinkedList.Node n=previous.next();

        while(n!=null){
            String data=n.getKey();
            LinkedList.Node runner=linkedListNode.node();

            while(runner!=n){
                if(runner.getKey().equals(data)){
                    previous.setNext(n.next());
                    break;
                }

                runner=runner.next();
            }
            if(runner==n){
                previous=n;
            }

            n=n.next();
        }

    }
    public static void removeDuplicates(LinkedList linkedListNode){
        if(linkedListNode==null) return;
        if(linkedListNode.size()<=1) return;

        HashSet set=new HashSet();
        LinkedList.Node previous=linkedListNode.node();
        LinkedList.Node n=previous.next();

        while(n!=null){
            if(set.add(n.getKey())){
                previous=n;
                n=n.next();
            }else{
                n=n.next();
                previous.setNext(n);
            }
        }


    }

}
