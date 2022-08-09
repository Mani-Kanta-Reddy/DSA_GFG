package recursion;

public class PrintArray {
    static void printArr(int[] arr, int idx) {
        //base-case:
        if(idx == arr.length) {
            return;
        }
        //recursive -case:
        System.out.println(arr[idx]);
        printArr(arr, idx + 1);
    }
    public static void main(String[] args) {
        printArr(new int[] {1, 2, 3, 4}, 2);
    }
}
