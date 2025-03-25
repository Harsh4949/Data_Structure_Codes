package Graphs;

import java.util.ArrayList;

public class CycleDetectionDirectedGraphDFS {

    static class  Edge {
        int src;
        int dest;

        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static boolean isCycle(ArrayList<Edge>[]graph){

        boolean visited[]=new boolean[graph.length];
        boolean stack[] =new boolean[graph.length];

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i]) {
                if (isCycleUtil(graph,i,visited,stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[]graph,int cur,boolean visited[],boolean stack[]){

        visited[cur]=true;          // visite me
        stack[cur]=true;

        //visite my nbr
        for (int i = 0; i < graph[cur].size(); i++) {
            
            Edge e =graph[cur].get(i);

            if (!visited[e.dest]) {
                if (isCycleUtil(graph, e.dest, visited, stack)) {
                    return true;
                }
            }
            else if (stack[e.dest]) {
                return true;
            } 
        }

        stack[cur]=false;
        return false;
    }

    public static ArrayList<Edge>[] createGraph(int V, int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[V];
    
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
    
        // Add edges to graph
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            graph[src].add(new Edge(src, dest));
        }
    
        return graph;
    }
    
    
    public static void main(String[] args) {
        // Sample 1: Graph with a cycle
        int[][] edges1 = {
            {0, 1}, {1, 2}, {2, 3}, {3, 1} // Cycle: 1 -> 2 -> 3 -> 1
        };
        ArrayList<Edge>[] graph1 = createGraph(4, edges1);
        System.out.println("Graph 1 (Cycle Expected): " + isCycle(graph1)); // Expected: true
    
        // Sample 2: Graph without a cycle
        int[][] edges2 = {
            {0, 1}, {1, 2}, {2, 3} // No cycle
        };
        ArrayList<Edge>[] graph2 = createGraph(4, edges2);
        System.out.println("Graph 2 (No Cycle Expected): " + isCycle(graph2)); // Expected: false
    
        // Sample 3: Self-loop (cycle)
        int[][] edges3 = {
            {0, 1}, {1, 2}, {2, 2} // Cycle at node 2 (self-loop)
        };
        ArrayList<Edge>[] graph3 = createGraph(3, edges3);
        System.out.println("Graph 3 (Cycle Expected - Self Loop): " + isCycle(graph3)); // Expected: true
    
        // Sample 4: Disconnected graph with one component having a cycle
        int[][] edges4 = {
            {0, 1}, {1, 2}, {3, 4}, {4, 5}, {5, 3} // Cycle in component 3 -> 4 -> 5 -> 3
        };
        ArrayList<Edge>[] graph4 = createGraph(6, edges4);
        System.out.println("Graph 4 (Cycle Expected in one component): " + isCycle(graph4)); // Expected: true
    }
    
}
