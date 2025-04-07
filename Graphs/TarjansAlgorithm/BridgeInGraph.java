package Graphs.TarjansAlgorithm;

import java.util.ArrayList;

public class BridgeInGraph {

    static class Edge {
        int src, dest;
    
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    //dt(discover time) : ex for 0 :1, 1:2 like that when it vistes (timer is used for that)
    //low :  low is lowest discovry time of all nbr's..

    public static void dfs(ArrayList<Edge>[] graph,int cur,int par,int timer,int[]dt,int low[],boolean visited[]){
        
        //visit and expore nbrs;
        visited[cur]=true;
        dt[cur]=low[cur]=++timer;

        for (Edge e : graph[cur]) {
            int nbr=e.dest;

            if (nbr==par) {
                continue;   // do nothind cycle loginc
            }
            else if (!visited[nbr]) {
                
                dfs(graph, nbr, cur, timer, dt, low, visited);
                low[cur]=Math.min(low[cur],low[nbr]);

                if (dt[cur]<low[nbr]) {
                    System.out.println("Bridge : "+cur+" ----- "+nbr);
                }
            } 
            else {  // visited
                
                low[cur]=Math.min(low[cur],dt[nbr]);
            }
        }
    }

    public static void tarjansAlgo(ArrayList<Edge>[] graph,int V){

        int timer =0;
        int[]dt= new int[V];
        int low[]= new int[V];
        boolean visited[]= new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, timer, dt, low, visited);
            }
        }
    }

    public static void main(String[] args) {
         
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        tarjansAlgo(graph, 6);

    }
}
