package Stack;
import java.util.Stack;
public class StackBasicQue {
   
    public static void pushBottom(Stack<Integer> s,int data){

        if (s.empty()) {
            s.push(data);
            return;
        }

        int top=s.pop();

        pushBottom(s, data);

        s.push(top);
        
    } 

    public static void reverseString(Stack<Character> s,String str) {      //must return the reverse strig; 

        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }

        while (!s.empty()) {
            System.out.print(s.pop());
        }

    }

    public static void reverseStack(Stack<Integer> s){

        if (s.empty()) {
            return;
        }

        int top=s.pop();

        reverseStack(s);

        pushBottom(s, top);
    }

    public static void main(String[] args) {
        
        Stack<Integer> stack=new Stack<>();
        Stack<Character> stackstr=new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

       // pushBottom(stack, 100);

        reverseStack(stack);
        
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        // System.out.println("Reverse String...");
        // reverseString(stackstr, "abc");


    }
}
