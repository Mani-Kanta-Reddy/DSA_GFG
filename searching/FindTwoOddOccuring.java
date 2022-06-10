package searching;
import java.util.*;

import utils.FastReader;

public class FindTwoOddOccuring {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		//Parse the input:
		String[] input = sc.nextLine().split("\\s");
		int[] arr = new int[input.length];
		for(int i = 0; i < input.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		//Naive solution
		naive(arr);
		xorApproach(arr);
	}
	static void naive(int[] arr) {
		List<Integer> res = new ArrayList<>(2);
		for(int i = 0; i < arr.length; i++) {
			int count = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == arr[i]) count++;
			}
			if(count % 2 != 0) {
				if(!res.contains(arr[i])) res.add(arr[i]);
			}
		}
		System.out.println(res);
	}
	static void xorApproach(int[] arr) {
		int xor = 0, res1 = 0, res2 = 0;
		//compute xor of arr to get res1 ^ res2
		for(int i = 0; i < arr.length; i++) xor = xor ^ arr[i];
		//Now we get res of res1 ^ res2 need to figure out those two numbers can be achieved by the speaciality of xor if both bits are different then only the output is high
		//compute the value that is rightmost bit alone set from xor
		int value = xor & ~(xor - 1);
		//make two different groups from the input with the condition that if the ele from the array has the value set bit then group 1 else group 2
		for(int i = 0; i < arr.length; i++) {
			if((arr[i] & value) != 0) res1 = res1 ^ arr[i];
			else res2 = res2 ^ arr[i];
		}
		System.out.printf("[%d, %d]", res1, res2);
	}
}