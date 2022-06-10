package searching;

import utils.FastReader;

public class FloorOfSqrt {
    public static void main(String[] args) {
        /*
        Note: In-general binary search will be beneficial if you've a monotonically increasing function (such as sqrt) for which
        you've find `x` for `f(x)` in this find `sqrt(x)` for `x`
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        System.out.println(calcSqrt(n));
    }
    static int calcSqrt(int n) {
        int start = 1;
        int end = n;
        int res = -1;

        while(start <= end) {
            //calculate mid-square
            int mid = (start + end) / 2;
            int midSquare = mid * mid;
            if(midSquare == n)
                return mid;
            else if(midSquare > n)
                end = mid - 1;
            else {
                //MidSquare < n There will be many midSquares that are less than `n` but we've to find the highest which is < `n` like find the lastOccurance in binarySearch
                start = mid + 1;
                res = mid;
            }
        }
        return res;
    }
}
