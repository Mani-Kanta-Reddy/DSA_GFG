package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.FastReader;

public class CommonElements {
    public static void main(String[] args) {
        /*
         Given two integer arrays (positive values) of different sizes get the common elements and print them in ascending order 
            Input:
                a1 -> 2 9 5 4 5
                a2 -> 7 4 3 2
            Output: 2 4 

            Input: 
                a1 -> 3 4 2 2 4
                a2 -> 3 2 2 7
            Output: 2 2 3

            Input:
                a1 -> 3 1 9 7 9
                a2 -> 1 9 3 
            Output: 1 3 9

         */
        FastReader sc = new FastReader();
        final int[] a1 = Arrays.stream(sc.nextLine().split("\\s"))
                         .mapToInt(Integer::parseInt)
                         .toArray();
        final int[] a2 = Arrays.stream(sc.nextLine().split("\\s"))
                         .mapToInt(Integer::parseInt)
                         .toArray();
        System.out.println(findCommonElements(a1, a2));    //O(n * m) & O(m) or O(n)
        System.out.println(findCommonElementsHashMap(a1, a2));  //O(n) + O(m)   & O(n) or O(m)
    }
    static List<Integer> findCommonElementsHashMap(int[] a1, int[] a2) {
        List<Integer> res = new ArrayList<>();
        boolean isA1Small = a1.length < a2.length ? true : false;
        
        //scan the array that is small and count the freq b/c in the worst case the no.of common elements == small Array size
        Map<Integer, Integer> freq = new HashMap<>();
        for(int ele : isA1Small ? a1 : a2) {
            if(!freq.containsKey(ele)) {
                freq.put(ele, 1);
            } else {
                freq.put(ele, freq.get(ele) + 1);
            }
        }
        //now scan the other array (largeArray) and if you find that ele as key with freq > 0 add to res and dec the freq by 1
        for(int ele : isA1Small ? a2 : a1) {
            if(freq.containsKey(ele) && freq.get(ele) > 0) {
                res.add(ele);
                freq.put(ele, freq.get(ele) - 1);
            }
        }
        res.sort(Comparator.naturalOrder());
        return res;
    }
    static List<Integer> findCommonElements(int[] a1, int[] a2) {
        boolean[] visited = new boolean[a2.length];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < a1.length; i++) {
            for(int j = 0; j < a2.length; j++) {
                if(!visited[j] && a1[i] == a2[j]) {
                    res.add(a2[j]);
                    visited[j] = true;
                    break;
                }
            }
        }
        res.sort(Comparator.naturalOrder());
        return res;
    }
}
