package arrays;

import utils.FastReader;

public class OneOddOccuring {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		String[] arr = sc.nextLine().split("\\s");
		int[] input = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			input[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(naive(input));
		System.out.println(xor(input));
	}

	static int xor(int[] arr) {
		int res = 0;
		for(int i = 0; i < arr.length; i++) {
			res = res ^ arr[i];
		}
		return res;
	}
	static int naive(int[] arr) {
		int res = 0;
		for(int i = 0; i < arr.length; i++) {
			int count = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == arr[i]) {
					count++;
				}
			}
		if(count % 2 != 0) res = arr[i];
		}
		return res;
	}
}