package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

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

    public static void createGraph(ArrayList<Edge> graph[]){

        for (int i = 0; i < graph.length; i++) {
            graph[i]= new ArrayList<>();
        }


        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class Pair implements Comparable<Pair>{
        
        int n;
        int path;

        public Pair(int n,int path) {    // path is the cuurent weight(From src to given Node) of the Node

            this.n=n;
            this.path=path;
        } 

        @Override
        public int compareTo(Pair p2){

            return this.path-p2.path;
        }

    }

    public static void dijkstra(ArrayList<Edge> graph[],int src){

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[]= new boolean[graph.length];

        int dist[] = new int[graph.length];  // initailize Infinity to all Distinations(0-5)

        for (int i = 0; i < dist.length; i++) {
            if(!(i==src)){                          // the src dist must be Zero
                dist[i]=Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            
            Pair cur = pq.remove();

            if (!visited[cur.n]) {
                visited[cur.n]=true;

                for(int i=0;i<graph[cur.n].size();i++){

                    Edge e =graph[cur.n].get(i);

                    int u=e.src;
                    int v=e.dest;   // nbr see refernce image
                    int wt=e.wt;   // distace /Edge Wt bwtn U----V

                    if (dist[u]+wt<dist[v]) {   //update V 
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v, dist[v]));
                    }

                }
            }
        }

        for (int i = 0; i < dist.length; i++) {  // Compare Output As Per Referce Image
           
            System.out.println(i+":"+dist[i]+" ");
        }

        System.out.println();

    }

    public static void main(String[] args) {
        
        ArrayList<Edge> graph[] = new ArrayList[6];

        createGraph(graph);

        dijkstra(graph, 0);

    }
}