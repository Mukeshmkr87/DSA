public class queuell {
    static class Node{
        Node next;;
        int data;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class Queue{
        static Node head = null;
        static Node tail = null;
        public static boolean isEmpty(){
            return head == null && tail == null;
        }
        public static void add(int data){
            Node nn = new Node(data);
            if(isEmpty()){
                head = nn;
                tail = nn;
                return;
            }
            tail.next = nn;
            tail = nn; 
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int element = head.data;
            if(head == tail){
                tail = null;
            }
            head = head.next;
            return element;
        }
        public static int peek(){
           if(isEmpty()){
            System.out.println("Queue is empty: ");
            return -1;
           }
            return head.data;
        }

    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(55);
        q.add(77);
        q.add(87);
        q.add(45);
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }

        
    }
}
