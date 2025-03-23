package Graphs;

import java.util.ArrayList;

public class BipartiteGraph {

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

     public static void createGraph(ArrayList<Edge> []graph){

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        //vertex 0
        graph[0].add(new Edge(0, 1));
      //  graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        //vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        //vertex 2
        graph[2].add(new Edge(2, 1));
       // graph[2].add(new Edge(2, 0));

        //vertex 3
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

         //vertex 4
        graph[4].add(new Edge(4, 3));         

    }
    
    public static void main(String[] args) {
        
    }
}
