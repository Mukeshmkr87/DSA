import java.util.*;
public class disjointSet{
public static class union {
    private Map<Integer,Node> map = new HashMap<>();
    class Node{
        int data;
        Node parent;
        int rank;
    }
    public void createSet(int data){
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }
    public void findSet(int data){
        System.out.println(getParent(map.get(data)).data);
    }
    public void merge(int data1,int data2){
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        Node parent1 = getParent(node1);
        Node parent2 = getParent(node2);

        if(parent1.data == parent2.data){
            return;
        }

        if(parent1.rank >= parent2.rank){
            parent1.rank = parent1.rank == parent2.rank ? parent1.rank+1:parent1.rank;
            parent2.parent = parent1;
        }
        else{
            parent1.parent = parent2;   

        }
    }
    Node getParent(Node node) {
    if (node.parent != node) {
        node.parent = getParent(node.parent); // path compression
    }
    return node.parent;
}

}
    public static void main(String[] args) {
        union u = new union();
        u.createSet(1);
        u.createSet(2);
        u.createSet(3);
        u.createSet(4);
        u.createSet(5);
        u.createSet(6);
        u.createSet(7);
        u.merge(1, 2);
        u.merge(2, 3);
        u.merge(4, 5);
        u.merge(6, 7);
        u.merge(5,6);
        u.findSet(3);
        u.merge(1, 2);
        u.merge(3, 7);
        u.findSet(3);


    }
}