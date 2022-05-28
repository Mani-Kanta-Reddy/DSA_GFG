import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        System.out.println(findWaterStorage(arr)); //O(n ^ 2)
        System.out.println(findWaterStorageEfficient(arr)); // O(n ^ 2) | O(n)
    }
    static int findWaterStorage(int[] arr) {
        int res = 0;
        for(int i = 1; i < arr.length - 1; i++) { //since we can't store any water on top of first & last bar
            //find lmax
            int lmax = arr[i];
            for(int j = 0; j < i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }
            //find rmax
            int rmax = arr[i];
            for(int k = i + 1; k < arr.length; k++) {
                rmax = Math.max(rmax, arr[k]);
            }
            res = res + Math.min(lmax, rmax) - arr[i];
        }
        return res;
    }
    static int findWaterStorageEfficient(int[] arr) {
        /*
        The Idea remains same except we pre-compute the lmax & rmax
        */
        int res = 0;
        int[] lmax = new int[arr.length];
        int[] rmax = new int[arr.length];

        //pre-compute lmax:
        lmax[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            lmax[i] = Math.max(lmax[i - 1], arr[i]);
        }

        //pre-compute rmax:
        rmax[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i]);
        }

        //find res:
        for(int i = 1; i < arr.length - 1; i++) {
            res = res + Math.min(lmax[i], rmax[i]) - arr[i];
        }
        return res;
    }
}
