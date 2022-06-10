package math;
import utils.FastReader;

public class GCD {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(findGCD(a, b));
        System.out.println(findGCD(new int[] {2, 4, 6, 8}));
        System.out.println(findGCDEuclidean(a, b));
    }
    static int findGCDEuclidean(int a, int b) {
        //base-case:
        if(a == 0) return b;
        return findGCDEuclidean(b % a, a);
    }
    static int findGCD(int[] arr) {
        int big = arr[0];
        int res = 1;
        for(int i = 1; i < arr.length; i++)
            big = Math.max(big, arr[i]);
        for(int i = big; i >= 1; i--) {
            boolean isIIsFactorOfAll = true;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] % i != 0) 
                    isIIsFactorOfAll = false;  
            }
            if(isIIsFactorOfAll) {
                res = i;
                return res;
            }
        }
        return res;
    }
    static int findGCD(int a, int b) {
        int res = 1;
        int big = Math.max(a, b);
        for(int i = big; i >= 1; i--) {
            if(b % i == 0 && a % i == 0) {
                res = i;
                break;
            }
        }
        return res;
    }
}
