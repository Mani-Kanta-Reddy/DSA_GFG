package misc;

import java.util.Scanner;

public class Maximum69Num
{
    //LeetCode
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(new Maximum69Num().maximum69Number(num));
    }
    public int maximum69Number(int num) {
        StringBuilder number = new StringBuilder(String.valueOf(num));
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == '6') {
                number.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(number.toString());
    }
}
