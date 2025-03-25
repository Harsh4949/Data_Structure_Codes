package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFSKahnsAlgorithm {
    
    static class  Edge {
        int src;
        int dest;

        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void calInDegree(ArrayList<Edge> graph[] ,int inDegree[]){

        for (int i = 0; i < graph.length; i++) {
            for (Edge e: graph[i]) {
                inDegree[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]){

        int inDegree[]= new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        calInDegree(graph, inDegree);

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i]==0) {     // that means it is starting point 
                q.add(i);
            }
        }

        //BSF Logic

        while (!q.isEmpty()) {

            int cur = q.poll();
            System.out.print(" "+cur);

            for (int i = 0; i < graph[cur].size(); i++) {

                Edge e= graph[cur].get(i);

                inDegree[e.dest]--;   // reuce the childern size 

                if (inDegree[e.dest]==0) {   // when degree get 0 then add it into queue..
                    q.add(e.dest);  
                }
            }
        }

    }

    
    public static void main(String[] args) {

        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);
        topSort(graph);
        
    }
}
