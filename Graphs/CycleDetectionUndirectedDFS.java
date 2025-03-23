package Graphs;
import java.util.ArrayList;

public class CycleDetectionUndirectedDFS {

    static class Edge {
    
        int src;
        int dest;
        
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void createGraph(ArrayList<Edge> []graph){

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        //vertex 0
        graph[0].add(new Edge(0, 1));
      //  graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        //vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        //vertex 2
        graph[2].add(new Edge(2, 1));
       // graph[2].add(new Edge(2, 0));

        //vertex 3
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

         //vertex 4
        graph[4].add(new Edge(4, 3));         

    }

    public static boolean detectCycle(ArrayList<Edge>graph[]){

        boolean visited[] =new boolean[graph.length];

        for (int i = 0; i < visited.length; i++) {
            
            if (!visited[i]) {
                if(detectCycleUtil(graph, i, -1, visited))
                    return true;
            }
        }
        return false;
    }
    
                
    public static boolean detectCycleUtil(ArrayList<Edge>graph[],int src,int par,boolean visited[]) {
        
        // make visit me 
        visited[src]=true;

        // visit neabher if not viaited

        for (Edge eg : graph[src]) {   // we need to handle 3 condition to handle the cycle in undirected graph
            int nbr=eg.dest;

            //Case 1 : if node not visited then vist and return true if any cycle occur 
            if (!visited[nbr]) {
                if(detectCycleUtil(graph, nbr, src, visited))
                        return true;
            }
            //case 2 : when Cycle occur when nbr is visited and src of nbr != parent
            else if (visited[nbr] && nbr != par) {
                return true;

            }

            // Case 3 if parent do nothig that not make
        }

        return false;
    } 

    public static void main(String[] args) {
        
        /*
         *     0----------3
         *   / |          |
         *  /  |          |
         * 1   |          4
         *  \  |
         *   \ |
         *    \|
         *     2
         */   
        
        ArrayList<Edge> graph[]= new ArrayList[5];
        createGraph(graph);

        System.out.println(detectCycle(graph));

    }
}
