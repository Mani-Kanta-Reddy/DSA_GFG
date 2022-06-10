package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintMaxCommonSubstringStartsWithAnyIdx {
    public static void main(String[] args) {
		/*
		Samples:
		Input:
		Mani kanta Randy
		
		Output:
		an (since `an` is the max common substring that starts with idx 1 for the above input)
		
		Input:
		Trjaswini TeJas Rejas
		
		Output: 
		jas (since `jas` is the max common substring that starts with idx 2 for the above input)
		
		Note: Ignore String case sensitivity 
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
		for(int i = 0; i < min; i++) {
			List<Character> chars = new ArrayList<>();
			for(int j = 0; j < inputs.length; j++) {
				chars.add(inputs[j].charAt(i));
			}
			//if all the elements in chars are equal add to result:
			boolean isSame = true;
			for(int k = 1; k < chars.size(); k++) {
				if(chars.get(k) != chars.get(k - 1)) {
					isSame = false;
					break;
				}
			}
			if(isSame)	result.add(chars.get(0));
		}
		result.forEach(System.out::print);
    }
}
