import java.util.ArrayList;

public class stackusingarraylist {
    static class  Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
        public static pob(int data){
            
        }

    }
    public static void main(String[] args) {
        Stack st = new Stack();
        System.out.println(st.peek());
        st.push(4500);
        st.push(9300);
        st.push(8700);
        while (!st.isEmpty()) {
            System.out.println(st.peek() + " removed " + st.pop() );
            
        }

    }
}
