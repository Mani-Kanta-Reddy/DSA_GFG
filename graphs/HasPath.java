package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HasPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < vertices; i++) {
            String[] arr = sc.nextLine().split("\\s");
            List<Integer> list = new ArrayList<>();
            for(String s : arr) {
                list.add(Integer.parseInt(s));
            }
            graph.add(i, list);
        }
        // System.out.println(graph);
        int source = sc.nextInt();
        int dest = sc.nextInt();
        boolean[] visited = new boolean[vertices];
        System.out.println(hasPath(graph, source, dest, visited));
    }

    public static boolean hasPath(List<List<Integer>> graph, int source, int dest, boolean[] visited) {
        //base-case
        if(source == dest) {
            return true;
        }
        //recursive-case
        List<Integer> nbrs = graph.get(source);
        visited[source] = true;
        for(int nb : nbrs) {
            //if nbr is un-visited
            if(!visited[nb]) {
                boolean res = hasPath(graph, nb, dest, visited);
                if(res) {
                    return true;
                }
            }
        }
        return false;
    }
}
