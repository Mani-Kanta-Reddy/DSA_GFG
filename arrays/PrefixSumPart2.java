package arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import utils.FastReader;

public class PrefixSumPart2 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        final int[] lArr = Arrays.stream(sc.nextLine().split("\\s"))
                           .map(Integer::parseInt)
                           .mapToInt(Integer::valueOf)
                           .toArray();
        final int[] rArr = Arrays.stream(sc.nextLine().split("\\s"))
                           .map(Integer::parseInt)
                           .mapToInt(Integer::valueOf)
                           .toArray();
        System.out.println(findMostAppearedElement(lArr, rArr));    // O(n * m) | O(n + m)
        System.out.println(findMostAppearedElementUsingPrefixSum(lArr, rArr));  //O(lArr.length + 999) = O(n) | O(1000)
    }
    static int findMostAppearedElementUsingPrefixSum(int[] lArr, int[] rArr) {
        /*
        This idea is more space efficient if the element range is small
        Assuming element range doesn't exceed 1000 i.e., 0 <= lArr[i], rArr[i] < 1000
        Construcct the Array of size(1000), mark the beginning of the array whose all values are 0's in java its by default zeroes with 1 and ending+1 with -1, then do prefixSum on the
        constructed array and find the index of the max value in the array
        The reason why we are marking end range + 1 with -1 is to nullify the cause of prefixSum
        */
        //create array
        int[] marker = new int[1000];
        //mark all start ranges with 1 in the array and end ranges + 1 with -1
        for(int i = 0; i < lArr.length; i++) {
            marker[lArr[i]] = 1;
            marker[rArr[i] + 1] = -1;
        }
        int res = 0, maxElefromMarker = marker[0];
        for(int i = 1; i < marker.length; i++) {
            marker[i] += marker[i - 1];
            if(marker[i] > maxElefromMarker) {
                maxElefromMarker = marker[i];
                res = i;
            }
        }
        return res;
    }
    static int findMostAppearedElement(int[] lArr, int[] rArr) {
        /*
        Input:  lArr -> [1 2 5 15]
                rArr -> [5 8 7 18]
        Output: 5
        Explanation: Ranges Formed are
        [1 -> 5]    => [1 2 3 4 5]
        [2 -> 8]    => [2 3 4 5 6 7 8]
        [5 -> 7]    => [5 6 7]
        [15 -> 18]  => [15 16 17 18]

        Since 5 is the most appeared (3 times) element in 4 ranges hence o/p is 5  
        The Idea is construct the ranges from the given two Arrays
        */
        HashMap<Integer, Integer> freqs = new HashMap<>();
        for(int i = 0; i < lArr.length; i++) {
            int lRange = lArr[i];
            int rRange = rArr[i];
            for(int j = lRange; j <= rRange; j++) {
                if(!freqs.containsKey(j))
                    freqs.put(j, 1);
                else
                    freqs.put(j, freqs.get(j) + 1);
            }
        }
        Entry<Integer, Integer> maxFreqEntry = Map.entry(1, 1);
        for(Entry<Integer, Integer> entry: freqs.entrySet()) {
            if(entry.getValue() > maxFreqEntry.getValue()) {
                maxFreqEntry = entry;
            }
        }
        return maxFreqEntry.getKey();
    }
}
