package recursion;

public class PrintArrayDecreasing {
    static void printFromLastArr(int[] arr, int idx) {
        //base-case:
        if(idx == arr.length)
            return;
        //recursive -case:
        printFromLastArr(arr,  idx + 1);
        System.out.println(arr[idx]);
    }
    public static void main(String[] args) {
        printFromLastArr(new int[] {4, 3, 2, 1}, 1);
    }
}
