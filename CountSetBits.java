import java.util.*;
import java.io.*;
import fastreader.FastReader;

public class CountSetBits {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		System.out.println(naive1(n));
		System.out.println(naive2(n));
		System.out.println(brianKerningham(n));
	}
	static int naive1(int n) {
		int res = 0;
		while(n > 0) {
			//check last bit
			if(n % 2 != 0) res++;
			n /= 2;
		}
		return res;
	}

	static int naive2(int n) {
		int res = 0;
		while(n > 0) {
			//check last bit
			if((n & 1) == 1) res++;
			//res = res + (n & 1)
			n = n >> 1;
		}
		return res;
	}

	static int brianKerningham(int n) {
		int res = 0;
		while(n > 0) {
			n = n & (n - 1);
			res++;
		}
		return res;
	}
}
