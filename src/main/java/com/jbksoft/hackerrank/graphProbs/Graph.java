package com.jbksoft.hackerrank.graphProbs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    public HashMap<Integer,Node> nodeLookup=new HashMap<Integer,Node>();

    public static class Node{
        int id;
        LinkedList<Node> adjacent=new LinkedList<Node>();

        @Override
        public int hashCode() {
            return id;
        }
    }

    private Node getNode(int data){
        return (Node)nodeLookup.get(data);
    }

    public boolean hasDFSPath(Node source, Node destination){
     HashSet<Integer> visited=new HashSet<Integer>();

     return hasDFSPath(source,destination,visited);
    }

    public boolean hasDFSPath(Node source, Node destination,HashSet visited){

        if(visited.contains(source.id)){
            return false;
        }

        visited.add(source.id);

        if(source==destination){
            return true;
        }

        for(Node child:source.adjacent){
            if(hasDFSPath(child,destination,visited)){
                return true;
            }
        }

        return false;
    }


    public boolean hasBFSPath(Node source, Node destination){

        LinkedList<Node> nextToVisit=new LinkedList<Node>();
        HashSet<Integer> visited=new HashSet<Integer>();
        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()){

            Node node=nextToVisit.remove();
            if(node == destination){
               return true;
            }

           if(visited.contains(node.id)){
                continue;
           }

           visited.add(node.id);

           for(Node child:node.adjacent){
               nextToVisit.add(child);
           }
        }

        return false;

    }
}
