package misc;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseWords
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new ReverseWords().reverseWords(s));
    }
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 1; i--) {
            sb.append(arr[i] + " ");
        }
        sb.append(arr[0]);
        return sb.toString();
    }
}
