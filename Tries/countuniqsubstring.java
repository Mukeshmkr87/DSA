import java.util.*;
public class countuniqsubstring{
    static class Node {
        Node child[];
        boolean eow;
        Node(){
            child = new Node[26];
            for(int i =0;i<26;i++){
                child[i] = null;
            }
            eow = false;
        }
    }
    
    static Node root = new Node();
    static void insert(String str){
        Node curr = root;
        for(int i = 0;i<str.length();i++){
            int idx = str.charAt(i)-'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new Node();
                if(i == str.length()-1){
                    curr.child[idx].eow = true;
                }
            }
            curr = curr.child[idx];
        }
    }
    static int findIndependentPath(){
        if(root == null){
            return 0;
        }
        int count = 1;
        // Node curr = root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int ct = 0;
            for(int i = 0;i<26;i++){
                if(curr.child[i]!=null){
                    q.add(curr.child[i]);
                    ct++;
                }
            }
            count += ct;
            
        }
        return count;
    }
    public static void main(String args[]){
        String str = "ababa";
        for(int i =0 ;i<str.length();i++){
            insert(str.substring(i));
        }
        System.out.println(findIndependentPath());

    }
}
