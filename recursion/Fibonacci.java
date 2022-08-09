package recursion;

public class Fibonacci {
    static int fibonacci(int n) {
        //base-case
        if(n <= 1) {
            return n;
        }
        //recursive-case
        //pre-order
        int fibn1 = fibonacci(n - 1);   //leftcall
        //in-order
        int fibn2 = fibonacci(n - 2);   //rightcall
        //post-order
        return fibn1 + fibn2;
    }
    public static void main(String[] args) {
        fibonacci(5);
    }
}
