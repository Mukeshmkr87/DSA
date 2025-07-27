import java.util.*;
public class wordsearch{
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
    public static boolean ss(String sen){
        if(sen.length() == 0){
            return true;
        }
        for(int i = 1;i<=sen.length();i++){
            String str1 = sen.substring(0, i);
            String str2 = sen.substring(i);
            if( search(str1) && ss(str2) ) return true;
        }
        return false;
    }
    static Node root = new Node();
    public static void main(String[] args) {
        String word[] = {"demo","don","mukku","mukesh","muskan"};
        for(int i = 0;i<word.length;i++){
            insert(word[i]);
        }
        String sen = "mukeshdonmuskan";
        System.out.println(ss(sen));
    }
}