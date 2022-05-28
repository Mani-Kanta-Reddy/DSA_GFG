import java.util.Arrays;

public class LeftRotateArray {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        int n = sc.nextInt();
        // leftRotateArrayOne(arr);
        // leftRotateArray(arr, n); //O(n * d) | O(1)
        // leftRotateArrayExtraSpace(arr, n);
        leftRotateArrayEfficient(arr, n);
        System.out.println(Arrays.toString(arr));
    }
    static void leftRotateArrayOne(int[] arr) {
        /*
        2 3 12 8 9
        copy the first ele to temp so not to loose it when shifting
        */
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }
    static void leftRotateArray(int[] arr, int n) {
        /*
        2 3 9 10 8   | 3
        3 9 10 8 2
        9 10 8 2 3
        10 8 2 3 9
        */
        for(int i = 0; i < n; i++) {
            //Always keep track of the first element
            int temp = arr[0];
            //shift all elements left once
            for(int j = 1; j < arr.length; j++) {
                arr[j - 1] = arr[j];
            }
            arr[arr.length - 1] = temp;
        }
    }
    static void leftRotateArrayExtraSpace(int[] arr, int d) {
        /*
        And the idea goes like this:
        copy the first d digits to a temp array
        shift left the remaining n - d digits starting from idx d. So you'll get all the elem's shifted left
        copy the elements from the temp to source starting from n - d + i pos
        */
        //step 1: copy the first d digits to temp
        int[] temp = new int[d];
        for(int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        //step2: left shift d times starting from idx d:
        for(int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }

        //step3: copy back the eleme's from temp to source starting from n - d + i pos
        for(int i = 0; i < d; i++) {
            arr[arr.length - d + i] = temp[i];
        }
    }
    static void leftRotateArrayEfficient(int[] arr, int d) {
        /*
        1 2 3 4 5 | 2
        step1: reverse first 2 digits
        2 1 3 4 5
        step2: reverse remaining n - 2 digits 
        2 1 5 4 3
        step3: reverse the entire array
        3 4 5 1 2
        */
        reverse(arr,0, d -1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }
    static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
