package Graphs;

public class DisjointSetUnion {

    static int n= 7;
    static int parent[]= new int[n];
    static int rank[]= new int[n];

    public static void init(){

        for (int i = 0; i <n ; i++) {       
            parent[i]=i;
        }
    }

    public static int find(int x){

        if(x==parent[x]){       // Present itself Prent (i.e Grandprent) then return
            return x;
        }

        return parent[x]=find(parent[x]) ; //path Compression Optimization
        // initialize the Grand Prent to Evry Child at At find to reduce time for Find 
    }

    public static void union(int parA,int parB){       // join then in tree visualize as tree Groping

        if (rank[parA]==rank[parB]) {       // join any grop each other and increase rank
            parent[parB]=parA;
            rank[parA]++;

        }else if (rank[parA]<rank[parB]) {
            
            parent[parA]=parB;   // join less rank to gater rank..
                                // Here Not udated Rank Coz when rank goes equal it automatically add it up  
        }else{
            parent[parB]=parA;
        }
    }

    public static void main(String[] args) {
        
        init();

        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        union(1, 5);
        System.out.println(find(4));


    }
}