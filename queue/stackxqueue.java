import java.util.Stack;

public class stackxqueue {
    public static class Queue{
        public static Stack<Integer> s1 = new Stack<>();
        public static Stack<Integer> s2 = new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s2.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty: ");
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty: ");
                return -1;
            }
            return s1.peek();
        }
    }
    

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(45);
        q.add(26);
        q.add(5);
        q.add(6);
        q.add(43);
        q.add(87);
        while(!q.isEmpty()){
            System.out.print(q.peek()+ " ");
            q.remove();
        }
        
    }
}
