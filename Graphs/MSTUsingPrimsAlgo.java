package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MSTUsingPrimsAlgo {
    
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static class Pair implements Comparable<Pair>{
    
        int v;
        int cost;

        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void MstUsingPrimsAlgo(ArrayList<Edge>[] graph,int src){

        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int finalCount=0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            
            Pair curr= pq.remove();

            if (!visited[curr.v]) {     // imp...
                
                visited[curr.v]=true;
                finalCount+=curr.cost;

                for (Edge e : graph[curr.v]) {
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println(" Final Couunt  : "+finalCount);
    }


    public static void main(String[] args) {
        
        ArrayList<Edge>[] graph = new ArrayList[4];
        createGraph(graph);

        MstUsingPrimsAlgo(graph, 0);

    }
}
