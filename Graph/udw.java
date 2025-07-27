import java.util.*;
public class udw{
    public static class Edge{
        int src;
        int dest;
        int weight;
        Edge(int src,int dest,int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2,2));
        graph[2].add(new Edge(2, 0,2));
        graph[2].add(new Edge(2, 3,-1));
        graph[2].add(new Edge(2, 1,10));
        graph[3].add(new Edge(3, 2,-1));
        graph[3].add(new Edge(3, 1,10));
        graph[1].add(new Edge(1, 3,0));
        graph[1].add(new Edge(1, 2,10));
    }
    public static void printNeighbour(ArrayList<Edge> graph[]){
        for(int i = 0;i<graph.length;i++){
            System.out.println("Neighbour of Node along with it weight of " + graph[i].get(0).src + " are: ");
            for(int j = 0;j<graph[i].size();j++){
                System.out.print("Destination "+graph[i].get(j).dest + " and weight is " + graph[i].get(j).weight + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        printNeighbour(graph);
    }
}

