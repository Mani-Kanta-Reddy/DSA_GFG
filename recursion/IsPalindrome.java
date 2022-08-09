package recursion;

public class IsPalindrome {
    static boolean isPalindrome(String str, int start , int end) {
        if(start >= end) {
            return true;
        }

        //recursive-case:
        return isPalindrome(str, start + 1, end - 1) && str.charAt(start) == str.charAt(end);
    }
    public static void main(String[] args) {
        isPalindrome("madam", 0, "madam".length() - 1);
    }
}
