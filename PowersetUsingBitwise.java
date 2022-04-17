import java.util.*;
import java.io.*;
import fastreader.FastReader;

public class PowersetUsingBitwise {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		/*
		input -> set = {a,b}
		output -> {"", a, b, "ab"}
		counter		binaryequi		output
		0				00			  ""
		1				01			  "a"
		2				10	    	  "b"
		3				11			  "ab"
		*/
		String input = sc.next();
		findPowerSet(input);
	}
	static void findPowerSet(String str) {
		//Total numberOf of subsets = 2 ^ str.length()
		//Run a counter from 0 to (2 ^ n) -1 
		//Check setBits for each conter and build set
		int powersetSize = (int)Math.pow(2, str.length());
		for(int counter = 0; counter < powersetSize; counter++) {
			//for each counter find setBits and build set
			for(int i = 0; i < str.length(); i++) {
				if((counter & 1 << i) != 0) System.out.printf("%c",str.charAt(i));
			}
			System.out.println();
		}
	}
}