package misc;

import utils.FastReader;

public class Palindrome {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		String input = sc.next();
		String res = "Yes";
		for(int i = 0, j = input.length() - 1; i < input.length()/2; i++, j--) {
			if(input.charAt(i) != input.charAt(j)) {
				res = "Nope!";
			}
		}
		System.out.println(res);
	}
}