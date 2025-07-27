import java.util.*;

public class dfs {
    static class Edge{
        int src;
        int des;
        public Edge(int src,int des){
            this.src = src;
            this.des = des;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }
    public static void printDfs(ArrayList<Edge> graph[]){
        Stack<Integer> s = new Stack<>();
        boolean visit[] = new boolean[graph.length];
        s.push(0);
        while (!s.isEmpty()){
            int temp = s.pop();
            if(!visit[temp]){
                System.out.print(temp + " ");
                visit[temp] = true;
                for(int i = 0;i<graph[temp].size();i++){
                    Edge e = graph[temp].get(i);
                    s.push(e.des);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creategraph(graph);
        printDfs(graph);
        
    }
}
