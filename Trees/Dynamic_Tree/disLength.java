import java.util.*;
public class disLength {
    static class Node{
        int data;
        Node parent;
        int len;
    }
    private Map<Integer,Node> map = new HashMap<>();
    void createSet(int data){
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.len = 1;
        map.put(data,node);

    }
    void merge(int data1,int data2){
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        

    }
    public static void main(String[] args) {
        
    }
}
