import java.util.*;
public class test{
    // public static class Node{//Using LinkList
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data = data;
    //         next = null;
    //     }
    // }
    // public static class Stack{
    //     static Node head;
    //     public static boolean isEmpty(){
    //         return head==null;
    //     }
    //     public static int peek(){
    //         return head.data;
    //     }
    //     public static int pop(){
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }
    //     public static void push(int data){
    //         Node newnode = new Node(data);
    //         newnode.next = head;
    //         head = newnode;
    //     }
    // }
    public static class Stack{//Using Dynamic ArrayList
        static ArrayList<Integer>list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek(){
            return list.get(list.size()-1); 
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(12);
        s.push(19);
        s.push(17);
        s.push(15);
        s.push(25);
        s.push(29);
        while(!s.isEmpty()){
            System.out.print(s.pop()+ " ");
        }
    }
}