package Stack;
import java.util.*;

public class DecodeAString {
    
   public static String decodeString(String str){

        Stack <Integer>numStack= new Stack<>();
        Stack<StringBuilder> sbStack =new Stack<>();
        StringBuilder ans= new StringBuilder();
        int num=0;

        for (char ch : str.toCharArray()) {   // similar to charAt(i) by using for loop
            
            if (ch>='0'&&ch<='9') {
                
                num=num*10+(ch-'0');       //imp WhenEver You Subtract Any (Char)No With '0' then we get that int no.
            }
            else if (ch=='[') {
                
                numStack.push(num);
                num=0;                    // coz now numbes are end when visit [ see example.
                sbStack.push(ans);        // insert empty to start pushing chars inside [] 
                                          //Ex : 0(ans[],(this done by else )(ans[a],ans[ab])) simlier 1(ans [],)
                ans=new StringBuilder();  // to next top of stack Ex : 0(ans[abc])  1(ans [xy])

            }
            else if (ch==']') {
                
                StringBuilder temp=ans;          // **temp = soppose we have ans [xy] letest
                ans=sbStack.pop();              // **0(ans[abc]) previus 


                /*simple logic
                 * 
                 * StringBuilder temp1=ans;  // xy
                 * StringBuilder temp2= sbStack.pop();  // abc
                 * 
                 * for(int i=0;i<count-1;i++) 
                 *              temp1.append(temp1);xyxy
                 * 
                 * ans=new StringBuilder(temp2.toString+temp1.toString()); abcxyxy
                 * 
                */

                int count=numStack.pop();           //ex: 2
                for(int i=0;i<count;i++)         // 0(ans[abcxyxy] append previous to letest
                         ans.append(temp);         


                
            }
            else
                ans.append(ch);
             
        }
        return ans.toString();        
   }

    public static void main(String[] args) {
        

        System.out.println(decodeString("1[abc]2[xy]"));
        System.out.println(decodeString("10[b2[v]]"));  
        System.out.println(decodeString("3[b2[v]]"));
    }
}
