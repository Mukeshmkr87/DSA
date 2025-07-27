import java.net.Inet4Address;
import java.util.*;
public class demoGraph {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
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
    public static void BFS(ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[graph.length];
        q.add(0);
         
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");
            if(!visit[temp]){
                visit[temp] = true;
                for(int i=0;i<graph[temp].size();i++){
                    Edge e = graph[temp].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void DFS(ArrayList<Edge> graph[]){
        Stack<Integer> q = new Stack<>();
        boolean visit[] = new boolean[graph.length];
        q.add(0);
         
        while(!q.isEmpty()){
            int temp = q.pop();
            System.out.print(temp + " ");
            if(!visit[temp]){
                visit[temp] = true;
                for(int i=graph[temp].size()-1;i>=0;i--){
                    Edge e = graph[temp].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void indpath(ArrayList<Edge> graph[],int curr,int des,boolean visit[],String path){
        if(curr == des){
            System.out.println(path);
            return;
        }
        for(int i = 0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[curr]){
                visit[curr] = true;
                indpath(graph, e.dest, des, visit, path+e.dest);
                visit[curr] = false;
                
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        indpath(graph, 0, 4, new boolean[V], "");


    }
}