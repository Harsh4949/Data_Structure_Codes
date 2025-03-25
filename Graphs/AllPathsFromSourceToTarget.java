package Graphs;

import java.util.ArrayList;

public class AllPathsFromSourceToTarget {

    static class  Edge {
        int src;
        int dest;

        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Corrected edges
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[1].add(new Edge(1, 3)); // Fixed incorrect edge
    }

    public static void printAllPath(ArrayList<Edge> graph[],int src , int dest, String sb){

        if (src==dest) {
            System.out.println(sb+dest);
            return;
        }

        for (Edge e : graph[src]) {
            printAllPath(graph, e.dest, dest, sb+src);
        }

        //sb.deleteCharAt(sb.length()-1);
    }


    public static void main(String[] args) {
        
        ArrayList<Edge> graph[]= new ArrayList[6];

        createGraph(graph);

        printAllPath(graph, 4, 3, " ");
    }
    
}
