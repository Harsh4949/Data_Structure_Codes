package Backtracking;

public class SubSetOfString{

    public static void subsetString(String str,int idx,String Sset) {   //O(2^n)
        
        if (idx==str.length()) {
            
            if (Sset.length()==0) 
                System.out.println("null");
            else
                System.out.println(Sset);
                
            return;
        }


        //if yes
        subsetString(str, idx+1, Sset+str.charAt(idx));

        //if no
        subsetString(str, idx+1, Sset);

    }

    public static void main(String[] args) {
        

        subsetString("abc", 0, "");
    }

}

//Each latter Have choice whether it print or not 
// so we need to call functions twice 
//in first where apped value where second not 
// at last we use indesex to evalute 
//see screeenShot for more understading...

/* Whenever er find subset then we get 2^n subsets... */