import java.util.Stack;

public class stackusingll {
    public static class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static class stack{
        public static Node head;
        public static boolean isempty(){
            return head == null;
        }
        public static void push(int data){
            Node newnode = new Node(data);
            if(isempty()){
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }
        public static int peek(){
            if(isempty()){
                return -1;
            }
            return head.data;
        }
        public static int pop(){
            if(isempty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
    } 
    public static void main(String[] args) {
        stack s = new stack();
        s.push(45);
        s.push(93);
        s.push(35);
        s.push(83);
        s.push(5);
        s.push(83);
        while(!s.isempty()){
            System.out.print(s.pop() + " ");
            
        }
        
    }
}