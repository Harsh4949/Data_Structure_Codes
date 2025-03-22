package Graphs;

import java.util.ArrayList;

public class ConvertionEdgeListToAdjList {

   
    public static ArrayList<Integer>[] convert(int [][]edges){

        ArrayList<Integer>[] adjList= new ArrayList[6];

        for (int i = 0; i < 6; i++) {
            
            adjList[i]= new ArrayList<>();
        }

        for (int []edge : edges) {
            
            int src=edge[0];
            int dest=edge[1];
             adjList[src].add(dest);
             adjList[dest].add(src);
        }

        return adjList;
    }
    
    public static void main(String[] args) {

        int[][] elist= {{0,1},{0,2},{3,5},{5,4},{4,3}};

        ArrayList<Integer>[] adjList=convert(elist);
        
        System.out.println(adjList[0]);
        System.out.println(adjList[1]);
        System.out.println(adjList[2]);
        System.out.println(adjList[3]);
        System.out.println(adjList[4]);
        System.out.println(adjList[5]);
        
    }
}
