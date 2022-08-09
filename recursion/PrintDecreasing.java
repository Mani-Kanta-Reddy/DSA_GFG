package recursion;

public class PrintDecreasing {
    static void printDecreasing(int n) {
        //base-case:
        if(n == 0) {
            return;
        }
        //recurisive -case:
        System.out.println(n);
        printDecreasing(n - 1);

    }
    public static void main(String[] args) {
        printDecreasing(9);
    }
}
