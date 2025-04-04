package Graphs;

public class CheapestFlightsWithinKStops {  // Useses DJIltra Algo here

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
    
    public static void main(String[] args) {

        int n = 4;
        int flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0, dst = 3, k = 1;

    }
}
