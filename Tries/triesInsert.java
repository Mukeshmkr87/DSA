import java.util.*;
public class triesInsert{
    static class Node{
        Node child[];
        boolean eow;
        Node(){
            child = new Node[26];
            for(int i = 0;i<26;i++){
                child[i] = null;
            }
            eow = false;
        }
    }
    public static void insert(String word){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx] = new Node();
            }
            if(i == word.length()-1){
                curr.child[idx].eow = true;
            }
            curr = curr.child[idx];
        }
    }
    public static boolean search(String word){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx] == null){
                return false;
            }
            if(i == word.length()-1 && !curr.child[idx].eow){
                return false;
            }
            curr = curr.child[idx];
        }
        return true;
    }
    static Node root = new Node();
    public static void main(String[] args) {
        String word[] = {"demo","don","mukku","mukesh","muskan"};
        for(int i = 0;i<word.length;i++){
            insert(word[i]);
        }
        System.out.println(search("demo"));
        System.out.println(search("mukku"));
    }
}