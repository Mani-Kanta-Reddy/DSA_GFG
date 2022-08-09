package recursion;

public class PrintZigZag {
    static void printZigZag(int n) {
        //base-case
        if(n == 0) {
            return;
        }

        //recursive-case:
        System.out.println("Pre -> " + (n));
        printZigZag(n - 1);
        System.out.println("In -> " + (n));
        printZigZag(n - 1);
        System.out.println("Post -> " + (n));
    }
    public static void main(String[] args) {
        printZigZag(3);
    }
}
