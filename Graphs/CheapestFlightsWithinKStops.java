package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {  // Useses DJIltra Algo here

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

    public static void createGraph(int n, int [][]flights,ArrayList<Edge>graph[]) {
        
        for (int i = 0; i < n; i++) {
            
            graph[i]= new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            
            int src=flights[i][0];
            int nbr=flights[i][1];
            int wt=flights[i][2];

            graph[src].add(new Edge(src, nbr, wt));
        }
    }

    static class Info {
    
        int v;
        int cost;
        int stop;

        public Info(int v,int cost,int stop){
            this.v=v;
            this.cost=cost;
            this.stop=stop;
        }
    }

    public static int cheapestFlights(int n,int flights[][],int src,int dst , int k){

        ArrayList<Edge>graph[]= new ArrayList[n];
        createGraph(n, flights, graph);

        int dist[]= new int[n];

        for (int i = 0; i < n; i++) {
            
            if (i==src) continue; 

            dist[i]=Integer.MAX_VALUE;
        }

        Queue<Info> q =new LinkedList<>();

        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){

            Info curr =q.poll();

            if (curr.stop>k) {     // if Number to Stop grater than k then dont add this vertesx an its nbr Coz Stop are increses
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) { // explore nbr of cur node
                
                Edge e = graph[curr.v].get(i);

                int u= e.src;   // not use here Like Dijiktra See login ON SS 2
                int v= e.dest;
                int wt = e.wt;  

                if (curr.cost+wt<dist[v] && curr.stop<=k) {
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v, dist[v], curr.stop+1));
                }
            }

        }
        
        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst]; 
    }
    
    public static void main(String[] args) {

        int n = 4;
        int flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0, dst = 3, k = 1;

        System.out.println(cheapestFlights(n, flights, src, dst, k));

    }
}
