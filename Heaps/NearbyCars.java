package Heaps;

import java.util.Collection;
import java.util.Map;
import java.util.PriorityQueue;

public class NearbyCars {

    static class Point implements Comparable<Point> {

        int x;
        int y;
        int dis;
        int idx;

        public Point(int x, int y, int dis, int idx) {

            this.x = x;
            this.y = y;
            this.dis = dis;
            this.idx = idx;

        }

        @Override
        public int compareTo(Point p2) {

            return dis - p2.dis;
        }

    }

    public static void nearbyCars(int cor[][],int k){   // distance = x^2+y^2

        PriorityQueue<Point> distaceq=new PriorityQueue<>();

        for (int i = 0; i < cor.length; i++) {
            //                       x      , y        , x^2                + y^2                 , idx
            distaceq.add(new Point(cor[i][0],cor[i][1],(cor[i][0]*cor[i][0])+(cor[i][1]*cor[i][1]),i));
        }

        for (int i = 1; i <=k; i++) {
            
            System.out.println("C"+distaceq.remove().idx);
            //System.out.println("C"+distaceq.remove().dis);
        }
    }

    public static void main(String[] args) {

        int cordintes[][]={{3,3},{5,-1},{-2,4}};
        int k=2;

        nearbyCars(cordintes, k);

    }
}
