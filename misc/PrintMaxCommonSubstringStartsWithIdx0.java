package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintMaxCommonSubstringStartsWithIdx0 {
	public static void main(String[] args) {
		/*
		Input:
		Ramsay ramsik ramsor Ramsin
		Output:
		rams (please note r, ra, ram, rams are all common substrings that starts with idx 0 but we want to print max common substring which in this case it's `rams`)
		
		Input:
		Mani Kanta Reddy
		Output:
		(print nothing) (As there is no common substring that starts with idx 0 et all.)

		Note: You've to ignore the String case sensitivity (for eg., R = r)
		*/
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split("\\s");

		//find the smallest length string from the given input:
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < inputs.length; i++) {
			inputs[i] = inputs[i].toLowerCase();
			if(inputs[i].length() < min)
				min = inputs[i].length();
		}
		List<Character> result = new ArrayList<>(min);
		outer: for(int i = 0; i < min; i++) {
			List<Character> chars = new ArrayList<>();
			for(int j = 0; j < inputs.length; j++) {
				chars.add(inputs[j].charAt(i));
			}
			//if all the elements in chars are equal add to result:
			boolean isSame = true;
			for(int k = 1; k < chars.size(); k++) {
				if(chars.get(k) != chars.get(k - 1)) {
					isSame = false;
					break outer;
				}
			}
			if(isSame)	result.add(chars.get(0));
		}
		result.forEach(System.out::print);
	}	
}