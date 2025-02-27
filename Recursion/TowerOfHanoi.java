package Recursion;

public class TowerOfHanoi {
                                            // b              a              c
                                            // a              c              b
                                            // a              b              c
    public static void towerOfHanoi(int n, String src, String helper, String dest) { 

       if (n==1) {
            System.out.println("Transfer Disk : "+n+" From "+src+" To "+dest);
            return ;
       }

       towerOfHanoi(n-1, src,dest, helper);

       System.out.println("transfer Disk : "+n+" From "+src+" To "+dest);

       towerOfHanoi(n-1, helper, src, dest);
    } 


    public static void main(String[] args) {
       
        int n = 3; 
        towerOfHanoi(n, "A", "B", "C"); 

    }
}

/*
 * Logic:
 * 
        Base Case:
            If there's only one disk (n == 1), you simply move it from src to dest and stop:

                ==>  Sop("transfer disk " + n + " from " + src + " to " + dest);

        Example: If n = 1, move the single disk directly.

        Recursive Steps:

            Step 1: Move the top n-1 disks from src to the helper rod, using dest as a temporary helper.

                   ==> towerOfHanoi(n-1, src, dest, helper);

                        //->This breaks the problem into a smaller subproblem.

            Step 2: Move the largest disk (the nth disk) directly from src to dest.


                ==>  Sop("transfer disk " + n + " from " + src + " to " + dest);

            Step 3: Move the n-1 disks from the helper rod to the dest rod, using src as a temporary helper.


                ==>   towerOfHanoi(n-1, helper, src, dest);

 */