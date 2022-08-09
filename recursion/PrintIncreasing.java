package recursion;

public class PrintIncreasing {
    static void printIncreasing(int n) {
        if(n == 0) 
            return;
        //recursive -case
        printIncreasing(n - 1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        printIncreasing(8);
    }
}
