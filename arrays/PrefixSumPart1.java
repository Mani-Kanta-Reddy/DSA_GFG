package arrays;
import java.util.Arrays;

import utils.FastReader;

public class PrefixSumPart1 {
    public static void main(String[] args) {
        /*
        Input: [2, 8, 9, 3, 6]
              Queries:                          Output
                    q(2, 3) => 9 + 3            12
                    q(0, 3) => 2 + 8 + 9 + 3    22
                    ......
        */
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        int noOfQueries = sc.nextInt();
        // If we observe the normal sol for each query we're traversing the arr from l to r
        /*
        Prefix sum advantage we can pre-compute the sum and find the res for all queries in O(1)
        So lets build the prefix sum array first
        */
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        for(int i = 0; i < noOfQueries; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            solveQueries(arr, l, r);    //O(n)
            //Computed using pre-fix sum as reference
            solveUsingPrefixSum(prefixSum, l, r);   //O(1)
        }
        Equilibrium.findEquilibriumPoints(arr);     //O(n ^ 2)
        Equilibrium.findEquilibriumPointsEfficient(arr);
    }
    static void solveUsingPrefixSum(int[] prefixSum, int l, int r) {
        if(l != 0)
            System.out.println(prefixSum[r] - prefixSum[l - 1]);
        else
            System.out.println(prefixSum[r]);
    }
    static void solveQueries(int[] arr, int l, int r) {
        int res = 0;
        for(int i = l; i <= r; i++) {
            res += arr[i];
        }
        System.out.println(res);
    }
}

class Equilibrium {
    static void findEquilibriumPoints(int[] arr) {
        /*
        Input: 
            arr => [3, 2, 1, 6, 8, -2]
        Output: (All the element positions that are in equilibrium)
            if sum of all the elements before pos & after pos are equal then ele at pos is in equilibrium
            for above example ele at pos 4 is 6. So sum of ele's before pos 4 is (3 + 2 + 1) = Sum of elements after pos 4 (8 - 2) 
            Hence element at pos i.e., 6 is in equilibrium
        */
        System.out.println("Equilibrium Checks");
        for(int i = 0; i < arr.length; i++) {
            int lsum = 0;
            for(int j = 0; j < i; j++) {
                lsum += arr[j];
            }
            int rsum = 0;
            for(int k = i + 1; k < arr.length; k++) {
                rsum += arr[k];
            }
            if(lsum == rsum)
                System.out.println(i);
        }
    }
    static void findEquilibriumPointsEfficient(int[] arr) {
        System.out.println("Equilibrium Check using prefixSum Array as reference");
        //first calculate total sum:
        int total = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int lsum = 0;
        for(int i = 0; i < arr.length; i++) {
            int rsum = total - arr[i];
            if(lsum == rsum)
                System.out.println(i);
            lsum += arr[i];
            total -= arr[i];
        }
    }
}
