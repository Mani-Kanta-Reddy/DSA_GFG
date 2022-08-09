package recursion;

public class BinarySearch {
    static int binSearchRecursive(int[] arr, int start, int end, int target) {
        int mid = (start + end) / 2;
        //base-case:
        if(start >= end)
            return -1;
        //recursive-case:
        if(target < arr[mid])
            return binSearchRecursive(arr, start, mid - 1, target);
        else if(target > arr[mid])
            return binSearchRecursive(arr, mid + 1, end, target);
        else
            return mid;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {2, 9, 31, 36, 99};
        System.out.println(binSearchRecursive(arr, 0, arr.length, 31));
    }
}
