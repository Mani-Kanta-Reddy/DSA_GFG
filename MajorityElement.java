import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        /*
        Majority Element is the one which appears more then n/2 times where n is the size of given array.
        Please note the idx returned can be anything but majority element should be correct
        */
        FastReader sc = new FastReader();
        final int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        System.out.println(findIdxOfMajorityElement(arr)); //O(n^2) | O(1)
        System.out.println(findIdxOfMajorityElementEfficient(arr)); //O(n) | O(1)
    }
    static int findIdxOfMajorityElement(int[] arr) {
        /*
        The Idea goes like this
        Compute each ele freq if > n/2 print it's idx break out
        */
        for(int i = 0; i < arr.length; i++) {
            int count = 0;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] == arr[i]) {
                    count++;
                    if(count > arr.length / 2) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    static int findIdxOfMajorityElementEfficient(int[] arr) {
        /*
        The Idea is to apply Moores Election Algorithm:
        First half find the idx of majority Element
        Second half is to handle if there is no majority Element at all, because Moores Election algo assumes there exists a majority element
        */
        //First Half:
        int currMajorityElementIdx = 0, count = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[currMajorityElementIdx])
                count++;
            else
                count--;
            if(count == 0) {
                currMajorityElementIdx = i;
                count = 1;
            }
        }
        //Now we have the idx of MajorityElement
        //second half
        count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[currMajorityElementIdx]) {
                count++;
            }
        }
        if(count < arr.length / 2) {
            currMajorityElementIdx = -1;
        }
        return currMajorityElementIdx;
    }
}
