import java.util.Arrays;

public class MaxOddEvenSubArray {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        System.out.println(findMaxOddEvenSubArrayLength(arr));
        System.out.println(findMaxOddEvenSubArrayLengthEfficient(arr));
    }
    static int findMaxOddEvenSubArrayLength(int[] arr) {
        int res = 1;
        for(int i = 0; i < arr.length; i++) {
            int curr = 1;
            for(int j = i + 1; j < arr.length; j++) {
                //check alternating ele are not odd or even
                if(
                    (arr[j] % 2 == 0 && arr[j - 1] % 2 != 0) //(even && odd)
                                    ||                       // or
                    (arr[j] % 2 != 0 && arr[j - 1] % 2 == 0) // (odd && even)
                  ) {
                    curr++;
                } else {
                    break;
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }
    static int findMaxOddEvenSubArrayLengthEfficient(int[] arr) {
        /*
        The Idea goes like this start from second element if the i'th element is alternate to i - 1 include else move
        */
        int res = 1, curr = 1;
        for(int i = 1; i < arr.length; i++) {
            if((arr[i - 1] % 2 == 0 && arr[i] % 2 != 0) || (arr[i - 1] % 2 != 0 && arr[i] % 2 == 0)) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }
        return res;
    }
}
