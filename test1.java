import java.util.*;
public class test1 {
    //Insertion at bottom
    public static void insertbottom(int data , Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        insertbottom(data,s);
        s.push(top);
    }
    public static void main(String[] args) {//predefined function
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(9);
        s.push(16);
        s.push(25);
        System.out.println(s.peek());
        insertbottom(45,s);
        System.out.println(s.peek());
    }
}
