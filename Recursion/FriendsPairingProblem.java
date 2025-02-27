package Recursion;

public class FriendsPairingProblem {

    public static int solution(int n) {
      
        if(n==1||n==2)
                return n;
        
        return solution(n-1)+((n-1)*solution(n-2));
    }

    public static void main(String[] args) {

        System.out.println(solution(3));
    }
}

//here we need to find the total number of ways where a single person of pair can be rearenged...
//so first we find the all signle ways ie. solution(n-1) 
//then pairsolution(n-2) but here may smeone are stay alone so it (n-1)*solution(n-2)