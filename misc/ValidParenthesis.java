package misc;

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis
{
    //LeetCode - 20
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            //if open paren then only push
            if(currChar == '(' || currChar == '[' || currChar == '{') {
                stack.push(currChar);
            }
            else {
                //if stack doesn't contain any open parens, this indicates that first we're seeing close version. Hence
                //bail out
                if(stack.isEmpty()) {
                   return false;
                }
                else {
                    char top = stack.peek();
                    //if top matches with currChar open version then pop else bail out
                    if(top == '(' && currChar == ')') {
                        stack.pop();
                    }
                    else if(top == '[' && currChar == ']') {
                        stack.pop();
                    }
                    else if(top == '{' && currChar == '}') {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
