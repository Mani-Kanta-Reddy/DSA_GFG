import java.util.*;
import java.io.*;

public class PrintAllPermutations {
	public static void main(String[] args) {
		//If n is the length of string then n! is the total no.of permutations
		FastReader sc = new FastReader();
		char[] str = sc.next().toCharArray();
		int i = 0;
		printAllPermutations(str, i);
	}
	static void printAllPermutations(char[] str, int i) {
		//base-case:
		if(i == str.length - 1) {
			System.out.println(str);
			return;
		}
		//recursive-case:
		for(int j = i; j < str.length; j++) {
			swap(str, i, j);
			printAllPermutations(str, i + 1);
			swap(str, i, j);
		}
	}
	static void swap(char[] str, int a, int b) {
		char c = str[a];
		str[a] = str[b];
		str[b] = c;
	}
}