package com.jbksoft;

public class LinkedList {
    public class Node{
        private String key;
        private String value;
        private Node next;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(String key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public boolean hasNext(){
            if(next!=null) return true;
            return false;
        }
    }

    private Node head;

    public Node node(){
        return head;
    }



    public Node add(String key,String value){
        Node n;
        if(head==null){
            n=new Node(key,value,null);
            head=n;
        }else{
            n=new Node(key,value,null);
            Node current=head;
            while(current.hasNext()){
                current= current.next();
            }
            current.next=n;

        }
        return n;
    }


    public void add(String key,String value,Node next){
        if(head==null){
            head=new Node(key,value,next);
        }else{
            Node n=new Node(key,value,next);
            Node current=head;
            while(current.hasNext()){
                current= current.next();
            }
            current.next=n;

        }

    }

    public int size(){
        Node current=head;
        int count=0;
        while(current.hasNext()){
            current= current.next();
            count++;
        }
        return count;
    }

    //public
}
