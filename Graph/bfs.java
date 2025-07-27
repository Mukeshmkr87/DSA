import java.util.*;//Method 1
public class bfs{
    public static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ;i<graph.length;i++){
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
    
    public static void printNeighbour(ArrayList<Edge> graph[]){
        for(int i = 0;i<graph.length;i++){
            System.out.println("Neighbour of Node " + graph[i].get(0).src + " are: ");
            for(int j = 0;j<graph[i].size();j++){
                System.out.print(graph[i].get(j).dest + " ");
            }
            System.out.println();
        }
    }
    public static void bfsprint(ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int ref = q.poll();
            if(!visit[ref]){
                visit[ref] = true;
                System.out.print(ref + " ");

                for(int i = 0;i<graph[ref].size();i++){
                    Edge e = graph[ref].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfsprint(graph);
    }
}