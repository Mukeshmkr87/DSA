import java.util.*;
public class longestWithAllString {
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
    static Node root = new Node();
    static void insert(String str){
        Node curr = root;
        for(int i = 0;i<str.length();i++){
            int idx = str.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx] = new Node();
            }
            if(i == str.length()-1){
                curr.child[idx].eow = true;
            }
            curr = curr.child[idx];
        }
    }
    static String ans = "";
    static String findPrefix(Node curr,StringBuilder temp){
        if(curr == null){
            return ans;
        }
        for(int i = 0;i<26;i++){
            if(curr.child[i] != null && curr.child[i].eow == true){
                temp.append((char) (i+'a'));
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                findPrefix(curr.child[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        Arrays.sort(words);
        for(int i = 0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(findPrefix(root, new StringBuilder()));

    }
}
