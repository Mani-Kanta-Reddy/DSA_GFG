package graphs;

import java.util.*;

public class Dijikstra
{
    public static class Edge {
        int vt;
        int nb;
        int wt;
        Edge(int vt, int nb, int wt) {
            this.vt = vt;
            this.nb = nb;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int src;
        String psf;
        int wsf;
        Pair(int src, String psf, int wsf) {
            this.src = src;
            this.psf = psf;
            this.wsf = wsf;
        }
        @Override
        public int compareTo(Pair o2) {
            return this.wsf - o2.wsf;
        }
    }

    public static void main(String[] args)
    {
        //Single Source Shortest Path
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        List<Edge>[] graph = new ArrayList[vertices];
        sc.nextLine();
        for(int v = 0; v < vertices; v++) {
            graph[v] = new ArrayList<>();
        }
        for(int e = 0; e < edges; e++) {
            // vt, nb, wt
            String[] arr = sc.nextLine().split("\\s");
            int vt = Integer.parseInt(arr[0]);
            int nb = Integer.parseInt(arr[1]);
            int wt = Integer.parseInt(arr[2]);
            graph[vt].add(new Edge(vt, nb, wt));
            graph[nb].add(new Edge(nb, vt, wt));
        }
        boolean[] visited = new boolean[vertices];
        dijikstra(graph, 0, visited);
    }
    public static void dijikstra(List<Edge>[] graph, int src, boolean[] visited) {
        Queue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src+"", 0));
        // r m* w a*
        while(!pq.isEmpty()) {
            Pair removed = pq.remove();
            if(visited[removed.src]) {
                continue;
            }
            visited[removed.src] = true;
            System.out.println(removed.src + " via " + removed.psf + " @ " + removed.wsf);
            for(Edge e : graph[removed.src]) {
                if(!visited[e.nb]) {
                    pq.add(new Pair(e.nb, removed.psf + e.nb, removed.wsf + e.wt));
                }
            }
        }
    }
}
