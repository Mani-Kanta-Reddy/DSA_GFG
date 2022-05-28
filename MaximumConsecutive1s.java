import java.util.Arrays;

public class MaximumConsecutive1s {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        System.out.println(findMaxConsecutive1s(arr));
    }
    static int findMaxConsecutive1s(int[] arr) {
        int res = 0, curr = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                curr = 0;
            } else {
               curr++;
               res = Math.max(res, curr); 
            }
        }
        return res;
    }
}
