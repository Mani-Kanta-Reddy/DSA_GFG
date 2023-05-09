package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowels
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());
        System.out.println(findMaxVowels(s, k));
        br.close();
    }

    private static int findMaxVowels(String s, int k)
    {
        int start = 0, end = 0, count = 0, size = s.length(), max = Integer.MIN_VALUE;
        int[] vowels = new int[128];
        vowels['a'] = 1; vowels['e'] = 1; vowels['i'] = 1; vowels['o'] = 1; vowels['u'] = 1;

        while(end < size) {
            if (vowels[s.charAt(end)] == 1) count++;
            if(end - start + 1 == k) {
                max = Math.max(max, count);
                //prepare for next window
                if (vowels[s.charAt(start)] == 1) count--;
                start++;
            }
            end++;
        }

        return max;
    }
}
