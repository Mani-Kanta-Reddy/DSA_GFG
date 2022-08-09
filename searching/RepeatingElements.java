package searching;

import java.util.Arrays;

import utils.FastReader;

public class RepeatingElements {
    public static void main(String[] args) {
        /*
         Input: 0 3 2 4 5 1 5
         Output: 5

         Input: 0 0
         Output: 0
         Rules: 
         0. Array will contains exactly one repeating element
         1. Input always contains all elements from 0 to max(arr) there is no element left in between

         Try to solve it in O(n) | O(1)
         i.e., 0 <= max(arr) <= n - 2
         */
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        System.out.println(findRepeatingElement(arr));  //O(n ^ 2) | O(1)
        System.out.println(findRepeatingElementSort(arr));  //O(n * log(N)) | O(1)
        System.out.println(findRepeatingElementSpace(arr)); //O(n) | O(n)
        System.out.println(findRepeatingElementCycleDetection(arr));
    }
    static int findRepeatingElementCycleDetection(int[] arr) {
        //find where `slow` & `fast` meets inside the cycle
        int slow = arr[0] + 1, fast = arr[0] + 1;
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1];
        } while(slow != fast);

        //find the beginning element of the cycle which is the answer
        slow = arr[0] + 1;
        while(slow != fast) {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }
        return slow - 1;
    }
    static int findRepeatingElementSpace(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(visited[arr[i]]) {
                return arr[i];
            }
            visited[arr[i]] = true;
        }
        return -1; //Unreachable code for the given inputs but have to deal with :(
    }
    static int findRepeatingElementSort(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;  //Un-reachable code for the given inputs but have to deal with :(
    }
    static int findRepeatingElement(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j])
                    return arr[i];
            }
        }
        return -1;  //Un-reachable code for the given inputs but have to deal with :(
    }
}
