package misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.FastReader;

public class HowManyTimesPresent {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int count = 1;
        for(int i = x + 1; i <= y; i++) {
            int times = howManyTimesPresent(String.valueOf(i), String.valueOf(x));
            count += times;
        }
        System.out.println(count);
    }
    static int howManyTimesPresent(String ele, String pattern) {
        int count = 0;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(ele);
        while(m.find())
            count++;
        return count;
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
