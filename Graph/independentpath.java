import java.net.Inet4Address;
import java.util.*;
public class independentpath {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static int V = 5;
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 4));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 3));
    }
    public static void indpath(ArrayList<Edge> graph[],boolean visit[],int curr,int d,String path){
        //Traversal in form of DFS to get the solution
        if(curr == d){
            System.out.println(path);
            return;
        }
        for(int i = 0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[curr]){
                visit[curr] = true;
                indpath(graph, visit, e.dest, d, path+e.dest);
                visit[curr] = false;
            }
        }
        

        


    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        indpath(graph, new boolean[V], 0, 4, "0");


    }
}