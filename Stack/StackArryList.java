package Stack;

import java.util.ArrayList;

public class StackArryList {

    public class Stack {
    
       private ArrayList<Integer> stack=new ArrayList<>();

        public boolean isEmpty(){

            return stack.size()==0;
        }

        public void push(int data){

            stack.add(data);
        }

        public int pop(){

            int data=stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return data;
        }

        public int peek(){
            return stack.size()-1;
        }

        public void display(){

            System.out.println(stack);
        }
    }

    public static void main(String[] args) {
        
        Stack s= new StackArryList().new Stack();
        
        s.push(40);
        s.push(30);
        s.push(20);
        s.push(10);
        s.push(5);

        s.display();
        
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        s.display();
    }
}