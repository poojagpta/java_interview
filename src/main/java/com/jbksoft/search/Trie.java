package com.jbksoft.search;

import java.util.HashMap;
import java.util.HashSet;

public class Trie {

    private TrieNode root;
    static class TrieNode{
        char c;
        public HashMap<Character, TrieNode> children;
        boolean isComplete;

        public TrieNode(){
            children=new HashMap<Character, TrieNode>();
        }

        public TrieNode(Character c){
            this.c=c;
        }

    }

    public Trie(){
        root=new TrieNode();
    }

    public void insert(String word){

        HashMap<Character,TrieNode> children=root.children;

        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            TrieNode t;
            if(children.containsKey(c)){
             t=children.get(c);
            }else{
              t=new TrieNode(c);
              children.put(c,t);
            }

            children=t.children;

            //In case of last word
            if(i==word.length()-1){
                t.isComplete=true;
            }

        }
    }

}
