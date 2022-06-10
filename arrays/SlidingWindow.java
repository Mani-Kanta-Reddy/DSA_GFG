package arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.FastReader;

public class SlidingWindow {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        int k = sc.nextInt();
        System.out.println(findMaxSumForGivenWindow(arr, k)); //O((n - k) * k) | O(1) 
        System.out.println(findMaxSumForGivenWindowEfficient(arr,k)); //O(n) + O(n - k) = O(n) | O(1)
        System.out.println(findIfSumCanBeFound(arr, 32)); //Note please consider only subArrays but of any length
        System.out.println(findIfSumCanBeFoundEfficient(arr, 32)); // Please note this only works for non-negative ele's
        new NBonacci().printNBonacciSeries(4, 10);
        new countDistinctInWindow().printDistinctInEachWindow(arr, k);
        new countDistinctInWindow().printDistinctInEachWindowReduceExtraSpace(arr, k);
    }
    static int findMaxSumForGivenWindow(int[] arr, int k) {
        int res = arr[0];
        for(int i = 0; i <= arr.length - k; i++) {
            int currSum = 0;
            for(int j = 0; j < k; j++) {
                currSum += arr[i + j];
            }
            res = Math.max(res, currSum);
        }
        return res;
    }
    static int findMaxSumForGivenWindowEfficient(int[] arr, int k) {
        /*
         The Idea goes like this compute the first window some before in hand
         And for computing the successive window sums we just need to add i'th element and remove first ele from the previous window
         */
        //1. Calculate first Window sum:
        int currWindowSum = 0;
        for(int i = 0; i < k; i++) {
            currWindowSum += arr[i];
        }
        int res = currWindowSum;
        //Start from the successive windows
        for(int j = k; j < arr.length; j++) {
            currWindowSum += arr[j] - arr[j - k];
            res = Math.max(res, currWindowSum);
        }
        return res;
    }
    static boolean findIfSumCanBeFound(int[] arr, int sum) {
        for(int i = 0; i < arr.length; i++) {
            int runningSum = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                runningSum += arr[j];
                if(runningSum == sum)
                    return true;
            }
        }
        return false;
    }
    static boolean findIfSumCanBeFoundEfficient(int[] arr, int sum) {
        /*
        The Idea goes like this start window size with 1 and keep on increment window size by one by adding next ele's
        until running sum is <= sum, if runningSum is exceeded targetSum remove ele's one by one from the start of the
        window & parallely checking if sum becomes targetSum, if not add move window by one pos right
        */
        int currSum = arr[0], start = 0, end = 0;
        for(end = 1; end < arr.length; end++) {
            //clear the prev-window
            while(currSum > sum && start < end - 1) {
                currSum -= arr[start];
                start++;
            }
            //check if found
            if(currSum == sum)
                return true;
            //Prepare for next window
            if(end < arr.length)
                currSum += arr[end];
        }
        return currSum == sum;
    }
}

class NBonacci {
    void printNBonacciSeries(int n, int m) {    //O(n * m) try solving in O(m)
        /*
        The Idea is fibonacci is 2Bonacci, 3Bonacci (currElement = sumOfPrevious 3 three elements)
        Input: n, m | n = nbonacci, m = no.of elements you need to print in that series
        */
        //As we know in fibonacci first n - 1 (1 elements are zeroes) and nth(2 element) element is 1. So for n bonacci (n - 1 elements will be zeroes) and nth element is 1 and there after we computre the series
        //fill n - 1 0s and a 1
        int[] arr = new int[m];
        int i = 0;
        for(i = 0; i < n - 1; i++)
            arr[i] = 0;
        arr[i] = 1;
        i++;
        for(int j = i; j < arr.length; j++) {
            int k = j;
            for(int x = 1; x <= n; x++) {
                arr[j] += arr[k - x];
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

class countDistinctInWindow {
    /*
    Input: n -> no.of elements
           k -> window size
    Output: _, _, _, ..... no.of distinct element in each window of size k
    */
    void printDistinctInEachWindow(int[] arr, int k) {  //O((n - 1) * 2k) => O(n * k)   | O(k) (currWindow) + O(k) (holder)
        for(int i = 0; i <= arr.length - k; i++) {
            //construct the curr window 
            int[] currWindow = new int[k];
            for(int j = 0; j < k; j++) {
                //you can access each element using arr[i + j]
                currWindow[j] = arr[i + j];
            }
            //call count distinct function for the curr window | write that logic here
            countDistinct(currWindow);
        }
    }

    private void countDistinct(int[] currWindow) {
        List<Integer> holder = new ArrayList<>(); //Empty List
        for(int x = 0; x < currWindow.length; x++) {
            if(!holder.contains(currWindow[x])) {
                holder.add(currWindow[x]);
            }
        }
        System.out.printf("%d ", holder.size());
        //holder.clear(); //optional
    }

    void printDistinctInEachWindowReduceExtraSpace(int[] arr, int k) {
        /*
        If we somehow figure out the start and the end idx of all windows possible with size k. We can make use of those indicies
        for computing the distinct elements for each window possible 
        */
        int startIdx = 0, endIdx = k - 1; //intialization
        for(int i = 0; i <= arr.length - k; i++) {
            startIdx = i; endIdx = i + k - 1;
            countDistinct(arr, startIdx, endIdx);
        }
    }

    void countDistinct(int[] arr, int startIdx, int endIdx) {
        List<Integer> holder = new ArrayList<>();
        for(int i = startIdx; i <= endIdx; i++) {
            if(!holder.contains(arr[i]))
                holder.add(arr[i]);
        }
        System.out.printf("%d ", holder.size());
        //holder.clear(); //optional
    }
}

