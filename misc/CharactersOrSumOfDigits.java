package misc;

import java.util.Scanner;

public class CharactersOrSumOfDigits {
    /*
    Input:
        i1 <- String
        i2 <- int (either 1 or 0)
    Output:
    if String is null or blank return null
    if i2 == 0 then sum all the digits in i1 and return it as string
    if i2 == 1 then extract all alphabets from i1 and return it as String
    if there are no digits in i1 when i2 is 0 return 0
    if there are no alphabets in i1 when i2 is 1 return 0
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        int input2 = sc.nextInt();
        System.out.println(findCharsOrDigitSum(input1, input2));
    }
    static String findCharsOrDigitSum(String input1, int input2) {
        StringBuilder res = new StringBuilder();
        int sum = 0;
        if(input1.isEmpty() || input1 == null) {
            return null;
        } else {
            int noOfAlphas = 0;
            //no-need to have extra noOfDigits variable b/c if there are no digits in i1
            //sum will remain `0` which is the final solution
            if(input2 == 0) {
                for(int i = 0; i < input1.length(); i++) {
                    if(Character.isDigit(input1.charAt(i)))
                        sum += Character.getNumericValue(input1.charAt(i));
                } 
            } else {
                for(int j = 0; j < input1.length(); j++) {
                    if(Character.isAlphabetic(input1.charAt(j))) {
                        noOfAlphas++;
                        res.append(input1.charAt(j));
                    }
                }
                if(noOfAlphas == 0) {
                    res = res.append("0");
                }
            }
        }
        
        return input2 == 0 ? String.valueOf(sum) : res.toString();
    }
}
