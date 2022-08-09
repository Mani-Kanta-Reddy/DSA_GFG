package recursion;

public class FindFirstOccurance {
    static int findFirstOccurance(int[] arr, int idx, int target) {
        //base -case:
        if(idx == arr.length)
            return -1;

        //recursive-case:
        if(arr[idx] == target) {
            return idx;
        } else {
            return findFirstOccurance(arr, idx + 1, target);
        }
    }
    public static void main(String[] args) {
        System.out.println(findFirstOccurance(new int[] {9, 2, 8, 10, 8, 6}, 0, 8));
    }
}
