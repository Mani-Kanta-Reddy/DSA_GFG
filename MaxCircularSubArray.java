import java.util.Arrays;

public class MaxCircularSubArray {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        System.out.println(findMaxCircularSubArraySum(arr));
        System.out.println(findMaxCircularSubArraySumEfficient(arr));
    }
    static int findMaxCircularSubArraySum(int[] arr) {
        int res = arr[0];
        for(int i = 0; i < arr.length; i++) {
            int currMax = arr[i];
            int currSum = arr[i];
            for(int j = 1; j < arr.length; j++) {
                int idx = (i + j) % arr.length;
                currSum = currSum + arr[idx];
                currMax = Math.max(currSum, currMax);
            }
            res = Math.max(res, currMax);
        }
        return res;
    }
    static int findMaxCircularSubArraySumEfficient(int[] arr) {
        /*
        The idea goes like this
        1. Find normalMaxSubArraySum using Kadanes algo
        2. From the remaining circular subArray we do slightly differently
        3. To get the circularMaxSubArray we substract the minNormalSubArray from the arraySum (Which is again calculated using using the same maxSubArray but with inverted values)
        4. Calculating minSubArraySum = calculating MaxSubArraySum from elements inverted their signs
        */
        int normalMax = normalMaxSubArray(arr);
        if(normalMax < 0) {
            return normalMax;
        }
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            arr[i] = -arr[i];
        }
        int circularMax = sum + normalMaxSubArray(arr);
        return Math.max(normalMax, circularMax);
    }
    static int normalMaxSubArray(int[] arr) {
        int res = arr[0];
        int curr = arr[0];
        for(int i = 1; i < arr.length; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            res = Math.max(res, curr);
        }
        return res;
    }
}
