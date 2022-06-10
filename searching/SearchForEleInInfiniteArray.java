package searching;

import java.util.Arrays;
import utils.FastReader;

public class SearchForEleInInfiniteArray {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        int target = sc.nextInt();
        System.out.println(search(arr, target));
        System.out.println(searchEfficient(arr, target));
    }
    static int searchEfficient(int[] arr, int target) {
        if(arr[0] == target)  return 0;
        int i = 1;
        while(arr[i] < target)
            i *= 2;
        if(arr[i] == target)
            return i;
        int end = i - 1;    //since we already checked for i
        int start = i / 2 + 1;  //since we already checked for i / 2
        //Apply binary search b/w start and end
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target)
                return mid;
            else if(target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    static int search(int[] arr, int target) {
        int i = 0; 
        while(true) {
            if(arr[i] == target) return i;
            if(arr[i] > target)  return -1;
            i++;
        }
    }
}
