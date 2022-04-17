import java.util.*;
import java.io.*;
import fastreader.FastReader;

public class IsPowerOf2 {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		System.out.println(naive(n));
		System.out.println(brianKerningham(n));
	}

	static boolean naive(int n) {
		//keep on dividing the number by 2 if you get odd quotient then return false but for the last instant you'll get 1
		if(n == 0) return false;
		
		while(n != 1) {
			if(n % 2 != 0) return false;
			n = n / 2;
		}
		return true;
	}

	static boolean brianKerningham(int n) {
		//count set bits idea the speciality of a number if its a power of 2 is that it will have only one set bit
		return (n != 0) && (n & (n - 1)) == 0;
	}
}