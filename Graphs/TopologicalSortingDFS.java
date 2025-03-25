package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {

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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge>[] graph){

        boolean visited[]= new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < visited.length; i++) {
            
            if (!visited[i]) {
                topSortUtil(graph,i,visited,st);
            }
        }
        System.out.print("Topo Sort Order: ");
        while(!st.empty()){
            System.out.print(" "+st.pop());
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph,int cur,boolean[]visited,Stack<Integer>st){

        visited[cur]=true;

        for (int i = 0; i <graph[cur].size(); i++) {
            Edge e =graph[cur].get(i);

            if (!visited[e.dest]) {
                topSortUtil(graph, e.dest, visited, st);
            }
        }

        st.push(cur);
    }

    public static void main(String[] args) {
        
        ArrayList<Edge> graph[]= new ArrayList[6];

        createGraph(graph);
        topSort(graph);
    }
}
