
import java.util.LinkedList;
import java.util.ArrayList;


public class HashMapImplimentation {

    static class HashMap<K,V> {   // generic Programing

        private class Node {
        
            K key;
            V value;

            public Node(K key,V value){
                
                this.key=key;
                this.value=value;
            }
        }
    

        private LinkedList<Node> buckets[];    // create a Node LL arry
        private int N;
        private int n;   

        // Constructor to initialize HashMap
        public HashMap(){

            // initialize Buckets

            this.buckets= new LinkedList[4];    // initialize the arry
            this.n=0;
            this.N=buckets.length;
            for (int i=0;i<buckets.length;i++) {  // initialize each linklist In LL arry
               buckets[i]=new LinkedList<>();
            }
        }
        
        private int hashFuction(K key){   // it will retuen the buket inedx

            return Math.abs(key.hashCode()%N);   // it will give the index btwen (0 - N-1)
        }

        private int searchInLL(K key , int bi){     // it will return data index if it found else retuen -1

            LinkedList<Node> ll = buckets[bi];

            int di=0;                 // data index
                
            for (Node node : ll) {
                
                if (node.key==key) {    
                    return di;              // if key is found then return the data index
                }
                di++;
            }
        
            return -1;
        }

        public void put(K key,V value){

            int bi=hashFuction(key);
            int di=searchInLL(key, bi);

            if (di!=-1) {         // that mens key is exits and data need to update
                
                Node node= buckets[bi].get(di);  // Update value
                node.value=value;

                //buckets[bi].get(di).value=value;  this will also considered.
                
            }else{

                buckets[bi].add(new Node(key, value));  // if -1 then add new data;
                n++;
            }
               
            double lamda=n/N; // divide no. of Nodes by Size of Buckes arr

            if(lamda>2.0){   // id any bucket have more than two elements then slw thw Hm

                // Do Double the arr;

                LinkedList<Node> oldBuckets[]=buckets;
                buckets= new LinkedList[N*2];
                N=N*2;

                for (int i = 0; i < N; i++) {
                   
                    buckets[i]=new LinkedList<>();
                }

                for (LinkedList<Node> linkedList : oldBuckets) {
                    for (Node node : linkedList) {
                        
                        put(node.key, node.value);
                    }
                }
            }
            
        }

        public boolean containsKey(K key){

            int bi = hashFuction(key);
            int di= searchInLL(key, bi);

            if (di!=-1) {
                
               return true;
            }else
            return false;
        }

        public V get(K key){

            int bi = hashFuction(key);
            int di= searchInLL(key, bi);

            if (di!=-1) {
                
                return buckets[bi].get(di).value; 
            }
            else
            return null;
        }

        public V remove(K key){
            
            int bi = hashFuction(key);
            int di= searchInLL(key, bi);

            if (di!=-1) {
                n--;
                return buckets[bi].remove(di).value;
              
            }else
            return null;

        }

        public ArrayList keySet(){

            ArrayList<K> keys= new ArrayList<>();


            for (LinkedList<Node> linkedList : buckets) {
                for (Node node : linkedList) {
                    keys.add(node.key);
                }
            }

            return keys;
        }
    }



    public static void main(String[] args) {
        
        HashMap<String,Integer> hm= new HashMap<>();  // O(1) for all functions but Exceptionallu O(n)

        hm.put("Harsh", 4);
        hm.put("Raj", 5);
        hm.put("Raj", 6);

        // System.out.println(hm.remove("Raj"));
        // System.out.println(hm.remove("Raj"));
        // System.out.println(hm.get("Raj"));

        System.out.println(hm.containsKey("Raj"));

        System.out.println(hm.keySet());
    }

}