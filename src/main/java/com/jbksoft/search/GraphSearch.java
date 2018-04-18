package com.jbksoft.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphSearch {
    public static void main(String[] args) {

    }

    static class Node{
        int data;
        Node[] adjacent;

        public Node(int data, Node[] arr){
            this.data=data;
            this.adjacent=arr;
        }
    }

    //Breath first search
    public static boolean hasPathBFS(Node source, int destination, HashSet<Integer> visited){

        if(source == null || visited.contains(source.data)){
            return false;
        }

        if(source !=null && source.data==destination){
            return true;
        }

        LinkedList<Node> nextToVisit=new LinkedList<Node>();
        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()){
           Node node=nextToVisit.remove();

           if(node.data == destination){
               return true;
           }

            if(visited.contains(node.data)){
                continue;
            }

           visited.add(node.data);

           for(Node n:node.adjacent){
               nextToVisit.add(n);
            }
        }

        return false;
    }



    //Depth first Search
    public static boolean hasPathDFS(Node source, int destination,HashSet<Integer> visited){
        if(source==null || visited.contains(source.data)){
            return false;
        }else if(source.data==destination){
            return true;
        }

        visited.add(source.data);

        for(Node n: source.adjacent){
            if(hasPathDFS(n,destination,visited)){
                return true;
            }
        }

        return false;
    }


}
