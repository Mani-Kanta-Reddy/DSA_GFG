package bits;

import utils.FastReader;

public class CheckNthBitSet {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int k = sc.nextInt();
		String res = "Nope!";
		//Left-Shift Solution
		if((n & (1 << k-1)) != 0) {
			res = "Yes!";
		}	
		System.out.println(res);

		//right-Shift solution:
		if((n >> k-1 & 1) != 0) {
			res = "Yes";
		}
		System.out.println(res);
	}
}