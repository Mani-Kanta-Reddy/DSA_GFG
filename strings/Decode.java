package strings;
import java.util.Scanner;

public class Decode {
    /*chars -> [abcdefghijklmnop]
     * Input : 4
     *         0010 (binary String)
     * Output: c
     * Explanation: consider 4 chars at a time which means (0 - 15) you've to decode that bin String
     * How to decode: start from most signficant bit till last bit
     *              do:
     *              if `0` go to left half of chars
     *              else (`1`) go to right half of chars
     *              reduce the range till you find only one element
     *        e.g., 0001 -> 0 (left half) -> [abcdefgh]
     *                   -> 0 (left half) -> [abcd]
     *                   -> 1 (right half) -> [cd]
     *                   -> 0 (left half)  -> [c]
     *              Hence output is `c`
     * 
     * Input : 8
     *         00011111
     * Output: bp (following same steps as described above for the first 4 -> `b` and for the rest 4 -> `p`)
     * 
     */

    static final char[] chars = "abcdefghijklmnop".toCharArray();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        sc.close();
        System.out.println(decode(n, str));
        //if you carefully observe the answer is actually the character at the decimal equivalent of each 4 digits
        System.out.println(decode2(n, str));
    }
    static String decode(int n, String str) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i+=4) {
            int left = 0, right = chars.length - 1;
            for(char currChar : str.substring(i, i + 4).toCharArray()) {
                if(left <= right) {
                    if(currChar == '0') {
                        right = right / 2;
                    } else {
                        left = (left + right) / 2 + 1;
                    }
                }
            }
            res.append(chars[left]);
        }
        return res.toString();
    }

    static String decode2(int n, String str) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i+=4) {
            res.append(chars[Integer.parseInt(str.substring(i, i + 4), 2)]);
        }
        return res.toString();
    }
}
