package Queue;

import java.util.*;

public class StackUsing2Queue {
    
    static class Stack {
    
        Queue<Integer> q1=new ArrayDeque<>();
        Queue<Integer> q2=new ArrayDeque<>();


        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public void add(int data){

            if (!q1.isEmpty()) {            //check which queue is not Empty... and add element there
                q1.add(data);
            }else
                q2.add(data);
            
        }

        public int remove(){

            if (isEmpty()) {
                System.out.println("Stack is Empty...");
                return -1;
            }
            
            int top =-1;

            if (!q1.isEmpty()) {                //copy the elements of not empty queue to empty queue..
                
                while (!q1.isEmpty()) {
                    
                    top=q1.remove();         //  delete  elemnts

                    if (q1.isEmpty()) {      //but not insert last element coz it need to delete
                        break;
                    }

                    q2.add(top);        //add all ements except last coz loop is break
                }
    
                return top;    

            }else{                       //same for other queue if iit not empty

                while (!q2.isEmpty()) {
                    
                   top=q2.remove();

                    if (q2.isEmpty()) {
                        break;
                    }
                    
                    q1.add(top);
                    
                }

                return top;
            }
            
          
        }

        public int peek(){

            if (isEmpty()) {
                System.out.println("Stack is Empty...");
                return -1;
            }
         
            int top =-1;

            if (!q1.isEmpty()) {                //copy the elements of not empty queue to empty queue..
                
                while (!q1.isEmpty()) {
                    
                    top=q1.remove();         //  delete  elemnts

                    q2.add(top);        //add all elements and last element store in top
                }       
    
                return top;    

            }else{                       //same for other queue if iit not empty

                while (!q2.isEmpty()) {
                    
                   top=remove();

                    q1.add(top);
                    
                }

                top=q2.remove();

                return top;
            }
        }
    }

    public static void main(String[] args) {
        
        Stack q =new Stack();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        
    }

}
