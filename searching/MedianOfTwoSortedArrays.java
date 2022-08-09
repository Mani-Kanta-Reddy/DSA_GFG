package searching;

import java.util.Arrays;

import utils.FastReader;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        /*
        Given two integer sorted arrays a1, a2 find the median
        Form extra array which is the sorted version of a1 & a2 and 
        if the elements are odd
            then its median is the element at sortedVersion.lenght / 2
        else (the elements are even)
            then its median is 
            avg of element at (sortedVersion.lenght / 2) + (sortedVersion.lenght / 2 - 1) / 2   
        
        Input: a1 = [10, 20, 30, 40, 50]
               a2 = [5, 15, 25, 35, 45]
            
        Output: 27.5

        Explanation:
            a = [5, 10, 15, 20, 25, 30, 35, 40, 45, 50] since there are even number noOf elems
            answer is (25 + 30) / 2 = 27.5
        */
        FastReader sc = new FastReader();
        final int[] a1 = Arrays.stream(sc.nextLine().split("\\s"))
                         .mapToInt(Integer::parseInt)
                         .toArray();
        final int[] a2 = Arrays.stream(sc.nextLine().split("\\s"))
                         .mapToInt(Integer::parseInt)
                         .toArray();
        System.out.println(findMedian(a1, a2));  //O(n + m) | O(n + m)
        System.out.println(findMedianEfficient(a1, a2));    //O(log(n1)) | O(1) where n1 is size of smaller array
    }
    static float findMedianEfficient(int[] a1, int[] a2) {
        //always have a1 is smaller than a2
        int m = a1.length, n = a2.length;
        if(m > n) {
            a1 = a2;
            a2 = a1;
        }
        int start = 0, end = m - 1;
        while(start <= end) {
            //calculate the mid for array a2
            int i1 = (start + end) / 2;
            int i2 = (m + n + 1) / 2 - i1;

            int max1 = i1 == 0 ? Integer.MIN_VALUE : a1[i1 - 1];
            int min1 = i1 == m ? Integer.MAX_VALUE : a1[i1];
            int max2 = i2 == 0 ? Integer.MIN_VALUE : a2[i2 - 1];
            int min2 = i2 == n ? Integer.MAX_VALUE : a2[i2];

            if(max1 < min2 && max2 < min1) {
                //found the stopping point which means all the elements in the left are small & right are large
                if((m + n) % 2 == 0) {  //even length
                    //avg of mid two elements
                    return ((Math.max(max1, max2) + Math.min(min1, min2)) / 2.0f);
                } else {
                    return Math.max(max1, max2);
                }
            } 
            else if(max1 > min2)  end = i1 - 1;
            else start = i1 + 1;
        }
        return -1;
    }
    static float findMedian(int[] a1, int[] a2) {
        //build the sorted array `a` from `a1` & `a2` 
        final int[] a = new int[a1.length + a2.length];
        int i = 0, j = 0, k = 0;
        while(i < a1.length && j < a2.length) {
            if(a1[i] == a2[j]) {
                a[k] = a1[i];
                k++;
                i++;
            } else if(a1[i] < a2[j]) {
                a[k] = a1[i];
                k++;
                i++;
            } else {
                a[k] = a2[j];
                k++;
                j++;
            }
        }
        //line no's 43, 47, 51 can be extracted out from if-else ladder & can be placed outside 
        //as a single statement but leaving them as it is to make program more understandable
        if(i == a1.length && j != a2.length) {
            //push the reamining elements of a2 to a
            for(int x = j; x < a2.length; x++) {
                a[k] = a2[x];
                k++;
            }
        }
        if(j == a2.length && i != a1.length) {
            //push remaining elements of a1 to a
            for(int y = i; y < a1.length; y++) {
                a[k] = a1[y];
                k++;
            }
        }
        //System.out.println(Arrays.toString(a));
        if(a.length % 2 == 0) {
            // System.out.printf("%d, %d \n", a[a.length / 2], a[a.length / 2 - 1]);
            return (a[a.length / 2] + a[a.length / 2 - 1]) / 2.0f;
        }
        return a[a.length / 2];
    }
}
