package misc;


import java.util.Scanner;
import java.util.Stack;

public class RemoveDuplicates
{
    //LeetCode - 1209
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(new RemoveDuplicates().removeDuplicatesUsingStack(s, k));
    }
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        if(s.length() == 1) {
            return s;
        } else if(s.length() < k) {
            return s;
        } else {
            //s.length() >= k => "abcdadbcd" => k = 2; 9 - 2
            for(int i = 0; i <= sb.length() - k; i++) {
                //check 'k' chars starting from `i`
                //isAllSame
                boolean isAllSame = true;
                char startChar = sb.charAt(i);
                for(int j = i + 1; j < i + k; j++) {
                    if(sb.charAt(j) != startChar) {
                        isAllSame = false;
                        break;
                    }
                }
                if(isAllSame) {
                    sb.delete(i, i + k);
                    i = -1;
                }
            }
            return sb.toString();
        }
    }
    public String removeDuplicatesUsingStack(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() || stack.peek().first != s.charAt(i)) {
                stack.push(new Pair<>(s.charAt(i), 1));
            } else {
                stack.peek().second++;
                if(stack.peek().second == k) {
                    stack.pop();
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(Pair<Character, Integer> pair : stack) {
            while(pair.second-- > 0) {
                res.append(pair.first);
            }
        }
        return res.toString();
    }
}
class Pair<T, U> {
    T first;
    U second;
    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}