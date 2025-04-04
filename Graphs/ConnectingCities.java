package Graphs;

import java.util.PriorityQueue;

public class ConnectingCities {
    
    static class Edge implements Comparable<Edge>{
        
        int dest;
        int wt;

        public Edge(int dest,int wt){
            this.dest=dest;
            this.wt=wt;
        }

        @Override
        public int compareTo(Edge e){
            return this.wt-e.wt;
        }
        
    }

    public static int connectingCities(int cities[][]){   //MST Prims Algo

        int finalCount=0;
        boolean visited[]= new boolean[cities.length];

        PriorityQueue<Edge> pq= new PriorityQueue<>();
        pq.add(new Edge(0, 0));


        while (!pq.isEmpty()) {
           
            Edge curr= pq.poll();

            if (!visited[curr.dest]) {
                
                visited[curr.dest]=true;       // make visited
                finalCount+=curr.wt;

               for(int i=0 ;i<cities[curr.dest].length;i++){           // expore nbrs
                
                    if (cities[curr.dest][i]!=0 ) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
               }
            }
            
        }

        return finalCount;
    }


    public static void main(String args[]) {
        int cities[][] = {
            {0, 5, 0, 0, 7},  // City 0
            {5, 0, 6, 0, 0},  // City 1
            {0, 6, 0, 6, 0},  // City 2
            {0, 0, 6, 0, 0},  // City 3
            {7, 0, 0, 0, 0}   // City 4
        };
    
        System.out.println(connectingCities(cities));
        
    }
    
}
