package Stack;
import java.util.Stack;

public class ValidParenthasis {
    
    public static boolean validParenthasis(String str){

        Stack<Character>st=new Stack<>();
        boolean isvalid=true;


        for(int i=0;i<str.length();i++){
            
            if (str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='[') {       //Opening
                st.push(str.charAt(i));
            }
            else{       // closing

                 if (st.empty()) {  // for this condition ""})}""
                   
                     return false;

                 }
                
                if (str.charAt(i)==')'&& st.peek()=='('||
                str.charAt(i)=='}'&& st.peek()=='{'||
                str.charAt(i)==']'&& st.peek()=='[') {
                
                    st.pop();

                }else{

                    return false;
                }
            }
        }

        if (!st.empty()) {
                
            return false;
        }

        return isvalid;
    }

    public static void main(String[] args) {
        

        System.out.println(validParenthasis("{({{}})}"));
    }
}


