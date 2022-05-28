import java.util.Arrays;

public class LeadersInArray {
    public static void main(String[] args) {
        /*
        An element is considered to be leader from the given array iff:
        there is no other element which is larger from his/her right pos  
        Input: [10 38 29 57, 20]
        Output: [57, 20]

        Interesting cases:
        1. When the array in sorted in increasing order:
        Input: [10, 20, 30]
        Output: [30] (always last element)

        2. When the array is in sorted in decreasing order:
        Input: [30, 20, 10]
        Output: [30, 20, 10] (all elements)
        */
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        // printAllLeaders(arr); //O(n ^ 2) | O(n)
        printAllLeadersEfficient(arr);
    }
    static void printAllLeaders(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            boolean flag = false; //start with an assumption that there are no elements that are larger than or equal curr
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] >= arr[i]) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                System.out.printf("%d ", arr[i]);
            }
        }
    }
    static void printAllLeadersEfficient(int[] arr) {
        /*
        The idea goes like this:
        But the problem with this approach is it prints the leaders in reverse order
        Since we know that always the last ele is leader. We make curr_ldr = end &
        scan from end - 1 & if i'th ele is greater than curr_ldr change curr_ldr = arr[i] & print
        */
        int curr_ldr = arr[arr.length - 1];
        System.out.printf("%d ", curr_ldr);
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] > curr_ldr) {
                curr_ldr = arr[i];
                System.out.printf("%d ", curr_ldr);
            }
        }
    }
}
