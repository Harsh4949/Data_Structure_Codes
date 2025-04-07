package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponents {
 
    static class Edge {
        int src, dest;
    
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topoSort(ArrayList<Edge> graph[],int cur,Stack<Integer> st,boolean visited[]){
    
        //make visited 
        visited[cur]=true;

        //expore nbr
        for (Edge e : graph[cur]) {
            
            if (!visited[e.dest]) {
                topoSort(graph, e.dest, st, visited);
            }
        }

        st.push(cur); // backtrack topo sort

    }

    public static void bfs(ArrayList<Edge> graph[],int cur,boolean visited[]){
    
        //make visited 
        visited[cur]=true;
        System.out.print(" "+cur);

        //expore nbr
        for (Edge e : graph[cur]) {
            
            if (!visited[e.dest]) {
                bfs(graph, e.dest, visited);
            }
        }

    }

    public static void kasarajuAlgo(ArrayList<Edge> graph[],int V){  //O(V+E)  refer image for undertnading

        //1.topological sort

        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(graph,i, st,visited);
            }
        }
        
        //2.Transpose of Graph 
        ArrayList<Edge> transpose[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {  //initalize
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {  // nbr
                Edge e= graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));  // transe by revering edges as per gieven image
            }
        }

        //3.DFS on trspose as per Stack element in Topo sort.
        visited= new boolean[V];
       while (!st.isEmpty()) {
        
            int cur = st.pop();
            if (!visited[cur]) {
                System.out.print("SCC : ");
                bfs(transpose, cur, visited);
           }
           System.out.println();
        }
    }

    
    public static void main(String[] args) {
        
        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraph(graph);
        kasarajuAlgo(graph, 5);
    }
}
