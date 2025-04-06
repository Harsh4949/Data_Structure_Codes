package Graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class KruskalAlgorithm {
    
    static class Edge implements Comparable<Edge>{
    
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }

        @Override
        public int compareTo(Edge e){
            return this.wt-e.wt;
        }
    }

    static void createGraph(ArrayList<Edge> edges) {

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }
    
    static class PrimsAlgo {
    
        static int V;
        static int []rank;
        static int []parent;

        static public void init(int Vertexs){

            V =Vertexs;
            rank= new int[V];
            parent= new int[V];

            for (int i = 0; i < V ;i++) {
              parent[i]=i;
            }
        }
        
        public static int find(int x){

            if (x== parent[x]) {
                return x;
            }
            return parent[x]= find(parent[x]);
        }

        public static void union(Edge e){

            int parA=e.src;
            int parB=e.dest;

            if (rank[parA]==rank[parB]) {
                parent[parB]=parA;
                rank[parA]++;

            }else if (rank[parA]<rank[parB]){

                parent[parA]=parB;

            }else{
                parent[parB]=parA;
            }
        }
    }

    public static int kruskalAlgorithm(ArrayList<Edge> edges,int V){

        Collections.sort(edges);        // sort aacoring to weights
        int finalCount=0;
        PrimsAlgo.init(V);        // initialize

        for (int i = 0; i < V-1; i++) { // if 5 Vertext then $ egaes are reqire for MST TO NOT make a loop
            
            Edge e= edges.get(i);

            if (PrimsAlgo.find(e.src)!= PrimsAlgo.find(e.dest)) {       // if both not in same Set then add them in mst
                PrimsAlgo.union(e);
                finalCount+=e.wt;
            }
        }

        return finalCount;
    }
    

    public static void main(String[] args) {
        
         ArrayList<Edge>graph = new ArrayList<>();
        createGraph(graph);;
        System.out.println(kruskalAlgorithm(graph, 4));
    }
}
