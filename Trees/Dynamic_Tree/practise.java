import java.util.*;
public class practise {
    static class disjointSet{
        class Node{
            int data;
            Node parent;
            int rank; 
        }
        private Map<Integer,Node> map = new HashMap<>();
        public void create(int data){
            Node node = new Node();
            node.data = data;
            node.parent = node;
            node.rank = 0;
            map.put(data, node);
        }
        public void merge(int data1,int data2){
            Node node1 = map.get(data1);
            Node node2 = map.get(data2);
            Node parent1 = node1.parent;
            Node parent2 = node2.parent;
            if(parent1.data == parent2.data){
                return;
            }
            if(node1.rank>=node2.rank){
                node1.rank = node1.rank==node2.rank ? node1.rank+1 : node1.rank;
                node2.parent = node1;  
            }
            else{
                node1.parent = node2;
            }
        }
        public Node getParent(Node node){
            if(node.data == node.parent.data){
                return node;
            }
            node.parent = getParent(node.parent);
            return node.parent;
        }
        public void print(int data){
            System.out.println(getParent(map.get(data)).data);
        }
    }
    public static void main(String[] args) {
        disjointSet dj = new disjointSet();
        dj.create(1);
        dj.create(2);
        dj.create(3);
        dj.create(4);
        dj.create(5);
        dj.create(6);
        dj.create(7);
        dj.merge(1,2);
        dj.merge(2,3);
        dj.merge(4,5);
        dj.merge(6,7);
        dj.merge(5,6);
        dj.print(3);
        dj.print(7);
        dj.merge(3,7);
        dj.print(3);
        dj.print(7);


    }
}
