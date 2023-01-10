package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetConnectedComponents
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        sc.nextLine();
        List<Integer>[] graph = new ArrayList[vertices];
        for(int v = 0; v < vertices; v++) {
            List<Integer> list = new ArrayList<>();
            String[] arr = sc.nextLine().split("\\s");
            for(String vt : arr) {
                list.add(Integer.parseInt(vt));
            }
            graph[v] = list;
        }
        List<List<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        for(int v = 0; v < vertices; v++) {
            if(!visited[v]) {
                List<Integer> component = new ArrayList<>();
                drawTree(graph, v, component, visited);
                components.add(component);
            }
        }
        System.out.println(components);
        System.out.println(isGraphConnected(graph, components));
    }
    public static void drawTree(List<Integer>[] graph, int src, List<Integer> component, boolean[] visited) {
        visited[src] = true;
        component.add(src);
        for(int nbr : graph[src]) {
            if(!visited[nbr]) {
                drawTree(graph, nbr, component, visited);
            }
        }
    }
    public static boolean isGraphConnected(List<Integer>[] graph, List<List<Integer>> components) {
        return components.size() == 1;
    }
}
