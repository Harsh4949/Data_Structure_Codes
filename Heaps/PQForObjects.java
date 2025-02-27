package Heaps;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

   
   
class Student implements Comparable<Student> {   // Comparable interface that allows to compare object
    
    String name;
    int rank;

    public Student(String name,int rank){
        this.name=name;
        this.rank=rank;
    }

    @Override
    public int compareTo(Student o){        // method of Comparable Interface implemented.

        return this.rank-o.rank;            //sorting done based on resule -ve value ,0,+ve value.
                                            // -ve : second object have highest rank  ex : 10-15
                                            // 0:  equal ex: 10-10
    }                                       // +ve : 1st object have highest rank     ex: 15-10
}


public class PQForObjects {
    


    public static void main(String[] args) {
        
        PriorityQueue<Student> pq =new PriorityQueue<>();
        PriorityQueue<Student> pq2 =new PriorityQueue<>(Collections.reverseOrder());

        pq.add(new Student("Harsh", 15));
        pq.add(new Student("Raj", 1));
        pq.add(new Student("Nitin", 5));
        pq.add(new Student("Parth", 18));

        pq2.add(new Student("Raj", 1));
        pq2.add(new Student("Nitin", 5));
        pq2.add(new Student("Harsh", 15));
        pq2.add(new Student("Parth", 18));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }

        System.out.println("  Reserse order : ");
        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek().name+"->"+pq2.peek().rank);
            pq2.remove();
        }

    }
}
