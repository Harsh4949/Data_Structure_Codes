package Heaps;

import java.util.ArrayList;

public class PQImplementationUseingHeap {
    
    static class Heap {      //refer Image while doing this code "D:\Programming\vscodeProgram\Heaps\PQImplementationUseingHeap.java"
    
        ArrayList<Integer> pq=new ArrayList<>();


        public  void add(int data){  //O(log n)       if n nodes in BT then log N level are there

            pq.add(data);   // add it at last 

            // Now correct thier position see the parent is small or not else swap them

            int child=pq.size()-1;   // as insertd last
            int parent=(child-1)/2;  // universal formula to find parent dry run for understanding
            

            while (pq.get(child)<pq.get(parent)) {   // itrate if parent is grater than child which is false in Min Heap
                
                //swap
                int temp=pq.get(child);
                pq.set(child, pq.get(parent));
                pq.set(parent, temp);

                child=parent;        // to check till root or 0th elemnt
                parent=(child-1)/2;
            }
        }

        public int peek(){

            return pq.get(0);
        }
        
        private void heapify(int i){

            int minIdx=i;
            int leftC=2*i+1;
            int rightC=2*i+2;

            // check the minimum value between root and left and root and right
            // also check the leftc and rightc are not leaf node

            if (leftC<=pq.size()-1 && pq.get(leftC)<pq.get(minIdx)) {
                minIdx=leftC;
            }

            if (rightC<=pq.size()-1 && pq.get(rightC)<pq.get(minIdx)) {
                minIdx=rightC;
            }

            // now swap the root element with the samller elemt 
            // do this process til laft node

            if (i!=minIdx) {       // ignore if any minValue not found But found then continue
                
                //swap the root elemt with samllerst one

                int temp=pq.get(i);
                pq.set(i, pq.get(minIdx));
                pq.set(minIdx, temp);

                heapify(minIdx);  // contine till leaf node
            }
        }

        public int remove(){

            int removeddata=pq.get(0);

            //swap the 1st and last element

            int temp=pq.get(0);
            pq.set(0, pq.get(pq.size()-1));
            pq.set(pq.size()-1, temp);

            //remove the last elemnt

            pq.remove(pq.size()-1);  // now the 1st elemt have high priority have removed

            // call heapify 

            heapify(0);  // to adjest the below nodes till leaf node COZ TM= O(logN) n level trversal

            return removeddata;
        }

        public boolean isEmpty(){

            return pq.size()==0;
        }
        
    }


    public static void main(String[] args) {  // refter image of tree and arry is must...
        
        Heap h=new Heap();

        h.add(2);  // 0
        h.add(3);  // 1
        h.add(4);  // 2
        h.add(5);  // 3
        h.add(10); // 4
  

        for (int i : h.pq) {
            System.out.print(i+" ");
        }

        System.out.println("\npeek Value : "+h.peek());
        System.out.println("isEmpty Value : "+h.isEmpty());

        System.out.println(h.remove());
       
        for (int i : h.pq) {
            System.out.print(i+" ");
        }
    }
}

/*
 *  DELETE DEY RUN : 2 3 4 5 10
 * 
 *                1> 10 3 4 5 2   
 *                2> 10 3 4 5    
 * 
 *                3> 3 10 4 5
 *                       3
 *                    10    4             
 *                  5
 * 
 *                4> 3 5 4 10
 * 
 */