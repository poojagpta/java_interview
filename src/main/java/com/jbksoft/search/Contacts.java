package com.jbksoft.search;

import java.util.HashMap;
import java.util.Scanner;

public class Contacts {

    static TrieNode root= new TrieNode();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            operation(op,contact);
        }



    }


    public static void operation(String op, String contact){
        if(("add").equals(op)){
            insert(contact);
        }else{
            System.out.println(traverse(contact));
        }
    }

    public static void insert(String contact){
        HashMap<Character,TrieNode> children=root.children;
        for(int i=0;i<contact.length();i++){
            char c= contact.charAt(i);
            TrieNode t;
            if(children.containsKey(c)){
                t=children.get(c);
            }else{
                t=new TrieNode();
                t.c=c;
                children.put(c,t);
            }

            t.size++;

            children=t.children;
            if(i==contact.length()-1){
                t.isComplete=true;
            }
        }
    }

    public static int traverse(String contact){
        HashMap<Character,TrieNode> children=root.children;
        TrieNode t=null;
        for(int i=0;i<contact.length();i++){
            char c=contact.charAt(i);

            if(children.containsKey(c)){
                t=children.get(c);
                children=t.children;
            }else{
                return 0;
            }

        }


        return t.size;
    }

    public static int wordCount(HashMap<Character, TrieNode> children){
        int count=0;

        for(Character c: children.keySet()){
            TrieNode node=children.get(c);
            if(node.isComplete){
                count++;
            }

            count+=wordCount(node.children);


        }

        return count;
    }

    public static class TrieNode{
        public char c;
        public HashMap<Character, TrieNode> children=new HashMap<Character, TrieNode>();
        public boolean isComplete;
        public int size;
    }


}
