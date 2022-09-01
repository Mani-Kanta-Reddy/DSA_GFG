package misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NothingInCommon
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int aliceCount = sc.nextInt();
            int bertasCount = sc.nextInt();
            Map<Integer, Integer> freq = new HashMap<>();
            for(int i = 0; i < aliceCount; i++) {
                int curr = sc.nextInt();
                if(!freq.containsKey(curr)) {
                    freq.put(curr, 1);
                } else {
                    freq.put(curr, freq.get(curr) + 1);
                }
            }

            for(int i = 0; i < bertasCount; i++) {
                int curr = sc.nextInt();
                if(!freq.containsKey(curr)) {
                    freq.put(curr, 1);
                } else {
                    freq.put(curr, freq.get(curr) + 1);
                }
            }

            int result = 0;

            for(int val : freq.values()) {
                if(val > 1) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
