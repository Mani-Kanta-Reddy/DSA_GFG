package dp;

import java.util.Scanner;

public class Fibonacci
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] qbank = new int[n + 1];   //[0,0,0,.....]
        long before = System.currentTimeMillis();
        int res = fibonacci(n);
        long timeTaken = System.currentTimeMillis() - before;
        long before1 = System.currentTimeMillis();
        int res1 = fibonacciMemoized(n, qbank);
        long timeTaken1 = System.currentTimeMillis() - before1;
        System.out.println(res);
        System.out.println("Time taken by plain recursion is " + timeTaken);
        System.out.println("Time taken by smart recursion is " + timeTaken1);
    }
   public static int fibonacci(int n) {
        //base-case:
       if(n == 0 || n == 1)
           return n;
       //recursive-case:
       return fibonacci(n - 1) + fibonacci(n - 2);
   }

   public static int fibonacciMemoized(int n, int[] qbank) {
        //base-case:
       if(n == 0 || n == 1) {
           qbank[n] = n;
           return qbank[n];
       }
       if(qbank[n] != 0)
           return qbank[n];
       //recursive-case:
       int result = fibonacciMemoized(n - 1, qbank) + fibonacciMemoized(n - 2, qbank);
       qbank[n] = result;
       return qbank[n];
   }

}
