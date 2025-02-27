package Heaps;

import java.util.PriorityQueue;

public class WeakestSoldier {

    static class Wsolder implements Comparable<Wsolder> {

        int solders;
        int ridx;

        public Wsolder(int solders,int ridx){

            this.solders=solders;
            this.ridx=ridx;
        }

        @Override
        public int compareTo(Wsolder s2){

            if (solders==s2.solders) {
                
                return this.ridx-s2.ridx; 
            }
                return this.solders-s2.solders;
        }

    }

    public static void weakestSoldierRow(int army[][],int k){

        PriorityQueue<Wsolder> pq= new PriorityQueue<>();


        for(int i=0;i<army.length;i++){

            int soldersCount=0;

            for (int j=0; j<army[0].length;j++) {

                if (army[i][j]==1) {
                    soldersCount++;
                }   

            }

            pq.add(new Wsolder(soldersCount, i));
        }

        for (int i = 0; i <k; i++) {
            System.out.println(" row : "+pq.remove().ridx);
        }
    }

    public static void main(String[] args) {

        int army[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 1, 1 },
                         { 1, 0, 0, 0 },
                         { 1, 0, 0, 0 } };

        int k=2;

        weakestSoldierRow(army, k);

    }
}
