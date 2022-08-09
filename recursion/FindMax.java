package recursion;

public class FindMax {
    static int findMax(int[] arr, int idx) {
        //base-case:
        if(idx == arr.length - 1) {
            return arr[idx];
        }
        //recursive -case:
        int soFarMax = findMax(arr, idx + 1);
        if(soFarMax > arr[idx]) {
            return soFarMax;
        } else {
            return arr[idx];
        }
    }
    public static void main(String[] args) {
        System.out.println(findMax(new int[] {9, 3, 99, 66, 32}, 0));
    }
}
