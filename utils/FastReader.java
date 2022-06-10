package utils;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class FastReader {
		BufferedReader br;
		PrintStream ps;
		StringTokenizer st;
		
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("input.txt"));
				ps = new PrintStream(new FileOutputStream("output.txt"));
				System.setOut(ps);
			} catch(Exception e) {}
		}
		public String next() {
			try {
				while(st == null || !st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}
			} catch(Exception e) {}
			
			return st.nextToken();
		}
		
		public String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {}
			return str;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public float nextFloat() {
			return Float.parseFloat(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public char nextChar() {
			return next().charAt(0);
		}
	} 