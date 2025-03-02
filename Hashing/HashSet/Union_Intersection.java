import java.util.HashSet;

public class Union_Intersection {
    
    public static void main(String[] args) {
        
        int set1[]= {7,3,9};
        int set2[]={2,3,5,7,10};

        HashSet<Integer> set =new HashSet<>();

        //Union

        for (int integer : set1) {
            set.add(integer);
        }

        for (int integer : set2) {
            set.add(integer);
        }

        System.out.println(set +": Union ");

        //intersection

        set.clear();

        int itersection=0;

        for (int integer : set1) {
            set.add(integer);
        }

        System.out.print("Intersection : ");
        for (int i : set2) {
            
            if (set.contains(i)) {

                itersection++;
                System.out.print(i+" ");
                //set.remove(integer);
            }
        }
    }
}
