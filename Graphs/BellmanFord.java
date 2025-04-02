package Graphs;

import java.util.ArrayList;

public class BellmanFord { //used When Edes are -ve But time Complexity is High Than Dijiktra
                          // O(V.E)
                          // Fail in -ve cycle , it keep goes to negatives evry itartion
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

    static void createGraph(ArrayList<Edge>[] graph) {  // Adjecency List
                                                        //[[obj1,obj2],[],[],[],][]]
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    static void createGraph2(ArrayList<Edge> graph) {       // Edge List
                                                     // Ex[obj1,obj2,obj3....]

        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));
    }
 
    public static void bellmanFord(ArrayList<Edge> graph[],int src){   // For

        int dist[] = new int[graph.length];

        for (int i = 0; i < dist.length; i++) { // for initialize INFINY
            if(i!=src)                          //imp
             dist[i]=Integer.MAX_VALUE;
        }

        int V= dist.length;

        for (int i = 0; i < V-1; i++) {     //  no. of itetration/permutation for right answer

            for (int j = 0; j < dist.length; j++) {  // explore vertex
                
                for (Edge nbr : graph[i]) {
                    
                    int u= nbr.src;
                    int v=nbr.dest;
                    int wt= nbr.wt;

                    if (dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]) {
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }

        for (int i : dist) {
            System.out.println(" "+i);
        }

    }


    public static void bellmanFordEdgeList(ArrayList<Edge> graph,int src,int V){   // For

        int dist[] = new int[V];

        for (int i = 0; i < dist.length; i++) { // for initialize INFINY
            if(i!=src)                          //imp
             dist[i]=Integer.MAX_VALUE;
        }

        for (int i = 0; i < V-1; i++) {     //  no. of itetration/permutation for right answer

                for (Edge nbr : graph) {
                    
                    int u= nbr.src;
                    int v=nbr.dest;
                    int wt= nbr.wt;

                    if (dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]) {
                        dist[v]=dist[u]+wt;
                    }
                }
        }

        for (int i : dist) {
            System.out.println(" "+i);
        }

    }

    public static void main(String[] args) {
        
        ArrayList<Edge> graph[]= new ArrayList[5];
        createGraph(graph);
        bellmanFord(graph, 0);
        System.out.println("For Edge List...");
        ArrayList<Edge> graph2 = new ArrayList<>();
        createGraph2(graph2);
        bellmanFordEdgeList(graph2, 0, 5);
        
    }
}