package recursion;

import java.util.Scanner;

public class PrintSubsequences {
    public static void main(String[] args) {
        String input;
        try(Scanner sc = new Scanner(System.in)) {
            input = sc.next();
        }
        printSS(input, "");
    }
    static void printSS(String ques, String ans) {
        //base-case:
        if(ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        //recursive-case:
        char ch = ques.charAt(0);
        String rqos = ques.substring(1);
        printSS(rqos, ans + ch);
        printSS(rqos, ans + ""); 
    }
}
