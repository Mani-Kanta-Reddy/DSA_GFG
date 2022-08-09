package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindSubsequenceWithMinCost {
    public static void main(String[] args) {
        int n, m;
        String S, T;
        int[] costArr;
        try(Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            m = sc.nextInt();
            S = sc.next();
            T = sc.next();
            costArr = new int[n];
            for(int i = 0; i < costArr.length; i++) {
                costArr[i] = sc.nextInt();
            }
        }
        List<List<Integer>> possibilites = findPossibilities(n, m, S, T);
        int result = findMinCost(possibilites, costArr);
        System.out.println("============Result=============");
        System.out.println(result);
    }
    static List<List<Integer>> findPossibilities(int n, int m, String S, String T) {
        List<List<Integer>> possibilities = new ArrayList<>(); 
        int loopCounter = (int) Math.pow(2, S.length());
        for(int counter = 0; counter < loopCounter; counter++) {
            StringBuilder currSubsequence = new StringBuilder();
            List<Integer> currIndices = new ArrayList<>();
            for(int i = 0; i < S.length(); i++) {
                if((counter & 1 << i) != 0) {
                    currSubsequence.append(S.charAt(i));
                    currIndices.add(i);
                }
            }
            if(currSubsequence.toString().equals(T)) {
                possibilities.add(currIndices);
            }
        }
        return possibilities;
    }
    static int findMinCost(List<List<Integer>> possibilities, int[] costArr) {
        int minCost = Integer.MAX_VALUE;
        for(List<Integer> option: possibilities) {
            int currCost = 0;
            for(int idx = 0; idx < option.size(); ) {
                int end = isContiguousTill(idx, option);
                if(end != idx) {
                    //find max from idx to end
                    int max = Integer.MIN_VALUE;
                    for(int i = idx; i <= end; i++) {
                        max = Math.max(max, costArr[option.get(i)]);
                    }
                    currCost += max;
                    idx = end + 1;
                } else {
                  currCost += costArr[option.get(idx)];   
                  idx++;
                } 
            }
            // System.out.println(currCost);
            minCost = Math.min(minCost, currCost);
        }
        return minCost;
    }
    static int isContiguousTill(int start, List<Integer> option) {
        int end = start;
        for(int i = start + 1; i < option.size(); i++) {
            if(option.get(i - 1) + 1 != option.get(i)) {
                return end;
            } 
            end++;
        }
        return end;
    }
}
