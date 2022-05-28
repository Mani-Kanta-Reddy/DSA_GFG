import java.util.*;
import java.io.*;

public class Josepheus {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(josepheusIdxStartsWith0(n, k));
		System.out.println(josepheusIdxStartsWith1(n,k));
	}
	static int josepheusIdxStartsWith0(int n, int k) {
		//base-case:
		if(n == 1) return 0;

		//recusive-case:
		return (josepheusIdxStartsWith0(n - 1, k) + k ) % n;
	}
	static int josepheusIdxStartsWith1(int n, int k) {
		return josepheusIdxStartsWith0(n , k) + 1;
	}
}