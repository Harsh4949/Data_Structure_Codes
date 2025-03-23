package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    static class Edge{

        int src;
        int dest;
        int wt;

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
        graph[0].add(new Edge(0, 2));
      
        //vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        //vertex 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        //vertex 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

         //vertex 4
        graph[4].add(new Edge(4, 2));         
        graph[4].add(new Edge(4, 3));
        
        //vertex 5 indivisual
        graph[5].add(new Edge(5, 5));         

    }

    public static boolean isBipartiteGraph(ArrayList<Edge>[]graph){

        int color[]= new int[graph.length];
        
        Arrays.fill(color, -1);  // Fill all elements with -1

        //for (int i = 0; i < color.length; i++) color[i]=-1;

        for (int i = 0; i < color.length; i++) {
            
            if (color[i]==-1) {
                if (isBipartiteGraphUtil(graph,i,color)) {
                        return true;
                    }
                }
            }
            
            return false;
    }
                    /*
                     * -1 : not colored
                     *  0 : blue
                     *  1 : yellow
                     */

    public static boolean isBipartiteGraphUtil(ArrayList<Edge>[] graph,int src,int[] color) { 

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src]=0;

        while (!q.isEmpty()) {
            int cur=q.remove();

            for (Edge e : graph[cur]) {

                // case 1 : if not color fill then add queue and do color
                if (color[e.dest]==-1) {
                    color[e.dest]=(color[cur]==0)?1:0;
                    q.add(e.dest);
                }
                // case 2 : if color same of next nad cur then false
                else if (color[cur]==color[e.dest]) {
                    return false;
                }

                // case 3 : if color same diff do nothig
            } 
        }
       
        return true;
    }

    public static void main(String[] args) {

        /*Note  :  if graph does not have cycle then it is bifertile graph by default

         *              0----------2
         *             /          / 
         *            /          /     false
         *           1          4
         *            \        /
         *             \      /
         *              \    /
         *               \  /
         *                 3
         */                 
        
         ArrayList<Edge> graph[]= new ArrayList[6];
         createGraph(graph);
 
         System.out.println(isBipartiteGraph(graph));
    }
}
