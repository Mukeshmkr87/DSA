import java.util.*;
public class queue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(45);
        q.add(8);
        q.add(5);
        q.add(87);
        q.add(59);
        q.add(87);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        
    }
    
}
