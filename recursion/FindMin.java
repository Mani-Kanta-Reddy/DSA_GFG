package recursion;

public class FindMin {
    static int findMin(int[] arr, int idx) {
        //base -case:
        if(idx == arr.length - 1)
            return arr[idx];
        //recursive-case:
        int soFarMin = findMin(arr, idx + 1);
        if(soFarMin < arr[idx])     //guard-clause
            return soFarMin;
        else 
            return arr[idx];
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {9, 22, 6, 8, 1}, 0));
    }
}
