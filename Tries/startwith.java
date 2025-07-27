import java.util.*;
public class startwith {
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
        static void insert(String s){
            Node curr = root;
            for(int i = 0;i<s.length();i++){
                int idx = s.charAt(i)-'a';
                if(curr.child[idx] == null){
                    curr.child[idx] = new Node();
                }
                if(i == s.length()-1){
                    curr.child[idx].eow = true;
                }
                curr = curr.child[idx];
            }
        }
        static boolean search(String str){
            Node curr = root;
            for(int i = 0;i<str.length();i++){
                int idx = str.charAt(i)-'a';
                if(curr.child[idx] == null){
                    return false;
                }
                if(i == str.length()-1 && !curr.child[idx].eow){
                    return false;
                }
                curr = curr.child[idx];
            }
            return true;
        }
        static boolean searchprefix(String str){
            Node curr = root;
            for(int i = 0;i<str.length();i++){
                int idx = str.charAt(i)-'a';
                if(curr.child[idx] == null){
                    return false;
                }
                // if(i == str.length()-1 && !curr.child[idx].eow){
                //     return false;
                // }
                curr = curr.child[idx];
            }
            return true;
        }
        static Node root = new Node();
    
    public static void main(String args[]){
        String words[] = {"apple","app","mango","man","women"};
        for(int i =0 ;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(searchprefix("app"));
        System.out.println(searchprefix("moon"));
    }
}
