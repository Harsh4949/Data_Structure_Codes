package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Graph_Traversal {

    static class Edge{

        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){

            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){

        for (int i = 0; i < graph.length; i++) {
            
            graph[i]=new ArrayList<>();
         
        }

        //Vertex 0
        graph[0].add(new Edge(0, 1, 5));

        //Vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //Vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //Vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //Vertex 4
        graph[4].add(new Edge(4, 2, 2));

    }

    public static void bfs(ArrayList<Edge> graph[]){  //O(V+E)  // vertex , edges

        Queue<Integer> q= new LinkedList<>();
        boolean visited[]=new boolean[graph.length];
        q.add(0);  //src 0 to start

        while (!q.isEmpty()) {
            
            int curr=q.poll();

            if (!visited[curr]) {  // if not visited then print values
                
                System.out.println(curr);
                visited[curr]=true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }  
    }

    

    public static void dfs(ArrayList<Edge> graph[], int curr,boolean visited[]){

        //visit
        System.out.print(curr+" ");
        visited[curr]=true;

        // call for naboers

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if (!visited[e.dest]) {
                
                dfs(graph, e.dest, visited);
            }
            
        }
    }

    public static Boolean hasPath(ArrayList<Edge> graph[], int src,boolean visited[],int dest) {  //O(V+E)
        
        if (src==dest) {        //check wherether src and destination are same or not Base Condition
            return true;
        }

        visited[src]=true;      // make src visited

        // if neighbour not visited then call for it consider as faith it return result true false

        for (int i = 0; i < graph[src].size(); i++) {

            int neighbour = graph[src].get(i).dest;
                                                                    
             if (!visited[neighbour] &&  hasPath(graph, neighbour, visited, dest)) {
                
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        /*                (5)
         *           0---------1
         *                   /  \
         *             (1)  /    \ (3)
         *                 /      \                
         *                2--------3
         *                |   (1)
         *            (2) |
         *                |
         *                4
         */       
        
        ArrayList<Edge> graph[]= new ArrayList[5];
        createGraph(graph);
        //bfs(graph);
        //dfs(graph, 0, new boolean[graph.length]);

        System.out.println(hasPath(graph, 1, new boolean[graph.length], 4));
    }
}
