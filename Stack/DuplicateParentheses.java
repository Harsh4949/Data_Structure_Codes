package Stack;

import java.util.Stack;

public class DuplicateParentheses {
    
    
    public static boolean duplicateParentheses(String str){

        Stack<Character>st=new Stack<>();
        boolean isvalid=false;
        
        for(int i=0;i<str.length();i++){
            
            if (str.charAt(i)==')') {
            
                int count=0;
                
                while (st.peek()!='('){
                    count++;
                    st.pop();
                }

                if (count==0) {   // i.e 0
                    return true;
                }

                st.pop(); // remove )

            }else{
                st.push(str.charAt(i));
            }
        }        

        return isvalid;
    }

    public static void main(String[] args) {
        

        System.out.println(duplicateParentheses("(A+b)"));
    }
}
