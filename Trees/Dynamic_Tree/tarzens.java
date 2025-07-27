import java.util.*;
public class tarzens {
    static class Edge{
        int des;
        Edge(int des){
            this.des = des;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[],int V){
        for(int i = 0;i<V;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(1));
        graph[0].add(new Edge(2));
        graph[0].add(new Edge(3));
        
        graph[1].add(new Edge(0));
        graph[1].add(new Edge(2));

        graph[2].add(new Edge(0));
        graph[2].add(new Edge(1));
        
        graph[3].add(new Edge(0));
        graph[3].add(new Edge(4));
        graph[3].add(new Edge(5));
        
        graph[4].add(new Edge(3));
        graph[4].add(new Edge(5));
        
        graph[5].add(new Edge(3));
        graph[5].add(new Edge(4));
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean []visit,int []disTime,i nt []minTime,int time,int par){
        visit[curr] = true;
        disTime[curr] = minTime[curr] = ++time;
        for(int i = 0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(e.des == par){//par -> Parent
                continue;
            }
            else if(!visit[e.des]){
                dfs(graph, e.des, visit, disTime, minTime, time, curr);
                minTime[curr] = Math.min(minTime[curr],minTime[e.des]);
                if(disTime[curr]<minTime[curr]){
                    System.out.println("Bridge is : " + curr + " ---- " + e.des);
                }
            }else{
                minTime[curr] = Math.min(minTime[curr],disTime[e.des]);
            }


        }
    } 
    public static void getBridge(ArrayList<Edge> graph[],int V){
        int disTime[] = new int[V];//Discovery Time
        int minTime[] = new int[V];//Minimum time
        int time = 0;
        boolean []visit = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!visit[i]){
                dfs(graph,i,visit,disTime,minTime,time,-1);
            }
        }
    }


    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        getBridge(graph, V);

        
        
        
    }
}
    