package misc;

import utils.FastReader;

public class FindHowManyOccurances {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int count = 1;
        for(int i = x + 1; i <= y; i++) {
            int times = howManyTimes(String.valueOf(i), String.valueOf(x));
            count += times;
        }
        System.out.println(count);
    }
    static int howManyTimes(String ele, String pattern) {
        int count = 0;
        int i = 0;
        while(i <= ele.length() - pattern.length()) {
            if(ele.substring(i, i + pattern.length()).equals(pattern)) {
                i += pattern.length();
                count++;
            } else  i++;
        }
        return count;
    }
}
