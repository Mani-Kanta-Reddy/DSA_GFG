package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.FastReader;

public class UncommonElements {
    public static void main(String[] args) {
        /*
         Input: 9 7 6 3 4
                8 2 6 4 
         Output: 9 7 3 8 2 (in any permutation)

         Input: 3 3 3 3 3
                8 2 6 4
         Output: 2 3 4 6 8 (in any permutation)

         Input: 2 2 2 
                1 1
        Output: 1 2
         */
        FastReader sc = new FastReader();
        int[] a1 = Arrays.stream(sc.nextLine().split("\\s"))
                         .mapToInt(Integer::parseInt)
                         .toArray();
        int[] a2 = Arrays.stream(sc.nextLine().split("\\s"))
                         .mapToInt(Integer::parseInt)
                         .toArray();
        System.out.println(findUncommonElements(a1, a2));    //2 * O(n * m) | O(1) very bad :( ;
        System.out.println(findUncommonElementsV1(a1, a2)); //O(n * m) | O(n + m) slightly better since space is cheap :)

    }
    static List<Integer> findUncommonElementsV1(int[] a1, int[] a2) {
        boolean[] v1 = new boolean[a1.length];
        boolean[] v2 = new boolean[a2.length];

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < a1.length; i++) {
            for(int j = 0; j < a2.length; j++) {
                if(a1[i] == a2[j]) {
                    v1[i] = true;
                    v2[j] = true;
                    break;
                }
            }
        }

        //scan v1 if v1[i] == false which means a1[i] is Uncommon Element so add to res (don't add blindly if 
        //res already contains a1[i] don't add)
        for(int i = 0; i < v1.length; i++) {
            if(v1[i] == false) {
                if(!res.contains(a1[i]))
                    res.add(a1[i]);
            }
        }

        //scan v2 if v2[i] == false which means a2[i] is Uncommon element so add to res (don't add blindly if
        //res already contains a2[i] don't add)
        for(int i = 0; i < v2.length; i++) {
            if(v2[i] == false) {
                if(!res.contains(a2[i]))
                    res.add(a2[i]);
            }
        }

        return res;
    }
    static List<Integer> findUncommonElements(int[] a1, int[] a2) {
        //Naive approach take a1 as ref and scan a2 if a1[i] is not present add to result Array (don't add blindly if 
        // a1[i] is already present in result Array don't add)
        //Do the same again by taking a2 as ref and scan a1
        List<Integer> res = new ArrayList<>();
        //a1 as ref and scan a2
        for(int i = 0; i < a1.length; i++) {
            boolean isPresent = false;
            for(int j = 0; j < a2.length; j++) {
                if(a1[i] == a2[j]) {
                    isPresent = true;
                    break;
                }
            }
            if(!isPresent) {
                if(!res.contains(a1[i])) 
                    res.add(a1[i]);
            }
        }
        //a2 as ref and scan a1
        for(int i = 0; i < a2.length; i++) {
            boolean isPresent = false;
            for(int j = 0; j < a1.length; j++) {
                if(a2[i] == a1[j]) {
                    isPresent = true;
                    break;
                }
            }
            if(!isPresent) {
                if(!res.contains(a2[i]))
                    res.add(a2[i]);
            }
        }

        return res;
    }
}
