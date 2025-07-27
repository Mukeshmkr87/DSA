import java.util.*;
public class stackusinglist {
    public static class Stack{
        public static ArrayList<Integer> arr = new ArrayList<>();
        public static boolean isEmpty(){
            return arr.size() == 0;
        }
        public static void push(int data){
            arr.add(data);
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top = arr.get(arr.size()-1);
            return top;
            
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            return top;
        }

    }
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(8);
        while(!s.isEmpty()){
            System.out.print(s.peek() + " ");
            s.pop();
        }

    }
}
