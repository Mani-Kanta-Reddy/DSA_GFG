package misc;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TinaAndTeddys
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] b = new int[n];
        int[] z = new int[n];
        
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for(int j = 0; j < n; j++) {
            z[j] = sc.nextInt();
        }
        //look for the maximum teddys & minimum no.of chocolate
        boolean[] visited = new boolean[n];
        //find smallest number of teddys
        if(m == 0) {
            //find the smallest 
        }
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(z));
    }
}
