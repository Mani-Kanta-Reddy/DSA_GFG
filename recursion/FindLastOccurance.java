package recursion;

public class FindLastOccurance {
    static int findLastOccurance(int[] arr, int idx, int target) {
        //base -case:
        if(idx == arr.length)
            return -1;
        //recursive  -case:
        int fisa = findLastOccurance(arr,  idx + 1, target);
        if(fisa == -1) {
            if(arr[idx] == target) {
                return idx;
            } else {
                return -1;
            }
        } else {
            return fisa;
        }
    }
    public static void main(String[] args) {
        System.out.println(findLastOccurance(new int[] {9, 2, 8, 5, 8}, 0, 8));
    }
}
