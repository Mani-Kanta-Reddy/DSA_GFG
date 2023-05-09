package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountAnagrams
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        System.out.println(findTotalOccurrence(text, pattern));
        br.close();
    }

    private static int findTotalOccurrence(String text, String pattern)
    {
        int start = 0, end = 0, size = text.length(), windowSize = pattern.length(), result = 0;
        //build the map for the pattern
        int[] needed = new int[128];
        for(int i = 0; i < pattern.length(); i++)
        {
            char curr = pattern.charAt(i);
            needed[curr]++;
        }

        int[] window = new int[128];
        while(end < size)
        {
            char currChar = text.charAt(end);
            //build the map for the current window
            window[currChar]++;

            if(end - start + 1 == windowSize)
            {
                //match window against needed
                boolean allMatch = true;
                for(int i = 0; i < needed.length; i++)
                {
                    int freq = needed[i];
                    if(freq > 0)
                    {
                        if(freq != window[i]) allMatch = false;
                    }
                }
                result = allMatch ? result + 1 : result;
                //prepare for next window
                char currWindowStart = text.charAt(start);
                window[currWindowStart]--;
                start++;
            }
            end++;
        }
        return result;
    }
}
