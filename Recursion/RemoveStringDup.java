package Recursion;

public class RemoveStringDup {
    
    public static void solution(String str, int idx, String resulString) {
        
        if (idx==str.length()-1){
            System.out.println(resulString);
            return;
        } 
         
        if (resulString.contains(""+str.charAt(idx)))
                    solution(str, idx+1,resulString);
        else
            solution(str, idx+1,resulString+""+str.charAt(idx));
        
    }
    
    public static void main(String[] args) {

        solution("appnnacollege", 0, "");
        
    }
}

// whenever you a-a =0 ,a-b=1 ,a-c=2.....
//another approch is creating a boolean arry[26] that can map the 26 alphabets then
//checkout the perticuer index true or false , make index true whenever you add in StringBilder 