package Stack;
import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path){

        StringBuffer sPath=new StringBuffer();
        String dirNames[]=path.split("/");  //we can Give Mutiple values like  [,\\.\\s] splits the string by

        Stack<String> s=new Stack<>();


        for (String dir : dirNames) {    

            if(dir.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }else
                    continue;
               
            }else if (!dir.equals("") && !dir.equals(".")) { //!(dir.equals("") || dir.equals("."))
                // Push valid directory names onto the stack
                s.push(dir);
            }
        }

        for (String dir : s) {  // otherwise we need to use to loop for 1for getting eleent 2nd for reversing
            
            sPath.append("/").append(dir);
        }

        return sPath.toString();
    }



    public static void main(String[] args) {
        
        System.out.println(simplifyPath("/../user/harsh//../appData//./.../"));

        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home/hoo/.."));

    }
    
}
