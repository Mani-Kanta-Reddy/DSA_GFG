package graphs;

import java.util.*;

public class Hamiltonian
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        sc.nextLine();
        List<Integer>[] graph = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++) {
            String[] arr = sc.nextLine().split("\\s");
            List<Integer> list = new ArrayList<>();
            for(String s : arr) {
                list.add(Integer.parseInt(s));
            }
            graph[i] = list;
        }
        HashSet<Integer> visited = new HashSet<>();
        hamiltonian(graph, 0, visited, "0" + "", 0);
    }
    public static void hamiltonian(List<Integer>[] graph, int src, Set<Integer> visited, String psf, int osrc) {
        //base-case
        if(visited.size() == graph.length - 1) {
            boolean isCyclic = false;
            for(int nb : graph[src]) {
               if(nb == osrc) {
                   isCyclic = true;
               }
            }
            System.out.println(isCyclic ? psf + "*" : psf + ".");
            return;
        }

        //recursive case
        visited.add(src);
        for(int nb : graph[src]) {
            if(!visited.contains(nb)) {
                hamiltonian(graph, nb, visited, psf + nb, osrc);
            }
        }
        visited.remove(src);
    }
}
