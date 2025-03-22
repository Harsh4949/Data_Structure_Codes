package Graphs;

import java.util.ArrayList;

public class Graph_Adjacency_List {

    static class Edge{

        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){

            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    
    public static void main(String[] args) {

        /*                (5)
         *           0---------1
         *                   /  \
         *             (1)  /    \ (3)
         *                 /      \                
         *                2--------3
         *                |   (1)
         *            (2) |
         *                |
         *                4
         */            

         int V =5; // Number of Vertex in graph

         ArrayList<Edge> graph[]= new ArrayList[V];

         //initialize List Arry

         for (int i = 0; i < graph.length; i++) {
            
            graph[i]=new ArrayList<>();
         }

         // add Graph Vertex data

         //Vertex 0
         graph[0].add(new Edge(0, 1, 5));

         //Vertex 1
         graph[1].add(new Edge(1, 0, 5));
         graph[1].add(new Edge(1, 2, 1));
         graph[1].add(new Edge(1, 3, 3));

         //Vertex 2
         graph[2].add(new Edge(2, 1, 1));
         graph[2].add(new Edge(2, 3, 1));
         graph[2].add(new Edge(2, 4, 2));

         //Vertex 3
         graph[3].add(new Edge(3, 1, 3));
         graph[3].add(new Edge(3, 2, 1));

         //Vertex 4
         graph[4].add(new Edge(4, 2, 2));


         // get the adjecency List Of vertex 2

         for (int i = 0; i < graph[2].size(); i++) {

            Edge temp=graph[2].get(i);

            System.out.println(temp.dest);
         }
        
    }
}
