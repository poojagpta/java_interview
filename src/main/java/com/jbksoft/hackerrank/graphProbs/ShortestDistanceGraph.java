package com.jbksoft.hackerrank.graphProbs;
import java.util.*;

public class ShortestDistanceGraph {
    public static class Graph {

        ArrayList<Integer>[] arrayLists;
        private int size;


        public Graph(int size) {
            this.size=size;
            arrayLists=new ArrayList[size];
        }

        public void addEdge(int first, int second) {
            if(arrayLists[first]==null){
                arrayLists[first]=new ArrayList<Integer>();
            }
            if(arrayLists[second]==null){
                arrayLists[second]=new ArrayList<Integer>();
            }
            arrayLists[first].add(second);
            arrayLists[second].add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distance=new int[size];
            Arrays.fill(distance, -1);

            HashSet<Integer> visited=new HashSet();
            LinkedList<Integer> nextToVisit=new LinkedList();
            nextToVisit.add(startId);
            visited.add(startId);
            distance[startId]=0;

            while(!nextToVisit.isEmpty()){

                int current=nextToVisit.poll();

                for(Integer node:arrayLists[current]){

                    if(!visited.contains(node)){
                        nextToVisit.offer(node);
                        distance[node]=distance[current]+6;
                        visited.add(node);
                    }

                }

            }


            return distance;
       }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
