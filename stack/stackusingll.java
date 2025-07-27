import java.util.Stack;

public class stackusingll {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null; 
        }
    }  
    public static class stack{
        public static Node head;
        public static boolean isEmpty(){
            return head == null;
        }
        public static void push(int data){
            Node nn = new Node(data);
            if(isEmpty()){
                head = nn;
                return;
            }
            nn.next = head;
            head = nn;
            return;

        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int data = head.data;
            head = head.next;
            return data;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }

        
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(12);
        s.push(2);
        s.push(22);
        s.push(19);
        s.push(11);
        s.push(7);
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        
        
        
        
        


    }
}