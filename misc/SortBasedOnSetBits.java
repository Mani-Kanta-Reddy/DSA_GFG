package misc;

import java.util.*;

public class SortBasedOnSetBits
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {
            //custom logic to sort:
            int n1 = 0, n2 = 0;
            String s1 = Integer.toBinaryString(o1);
            String s2 = Integer.toBinaryString(o2);
            for(char ch : s1.toCharArray()) {
                if(ch == '1')
                    n1++;
            }
            for(char ch : s2.toCharArray()) {
                if(ch == '1')
                    n2++;
            }
            return n1 < n2 ? -1 : n1 == n2 ? 0 : 1;
        });
        System.out.println(Arrays.toString(arr));
    }
}
