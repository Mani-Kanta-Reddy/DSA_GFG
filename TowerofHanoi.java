import java.util.*;
import java.io.*;

public class TowerofHanoi {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		// char source = 'A';
		// char aux = 'B';
		// char dest = 'C';
		char a, b, c;
		a = 'A';
		b = 'B';
		c = 'C';

		printMoves(n, a, b, c);
	}
	//source, auxiliary, destination
	static void printMoves(int n, char a, char b, char c) {
		//base case:
		if(n == 1) {
		System.out.println("Move 1 from "+ a + " to " + c);
		return;	
		} 

		//recursive case:
		printMoves(n-1, a, c, b);
		System.out.println("Move " + n + " from "+ a + " to " + c);
		printMoves(n - 1, b, a, c);
	}
}