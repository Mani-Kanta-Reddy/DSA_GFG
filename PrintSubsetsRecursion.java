import java.util.*;
import java.io.*;
import fastreader.FastReader;

public class PrintSubsetsRecursion {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		String str = sc.next();
		String curr = "";
		int i = 0;
		printSubsets(str, curr, i); //or printSubsets(str, "", 0); and remove the above un-necessary
	}
	static void printSubsets(String str, String curr, int i) {
		//base-case:
		if(i == str.length()) {
			System.out.println(curr);
			return;
		}
		//recursive-case:
		printSubsets(str, curr, i + 1);
		printSubsets(str, curr + str.charAt(i), i + 1);
	}
}