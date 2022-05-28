import java.util.*;
import java.io.*;

public class HelloWorld {
	public static void main(String[] args) throws IOException {
		FastReader sc = new FastReader();
		int x1 = sc.nextInt();
		char c1 = sc.nextChar();
		long x2 = sc.nextLong();
		String res = sc.next();
		String res1 = sc.next();
		System.out.printf("%d, %c, %s %s", x1, c1, res, res1);
		System.out.println(x2);
	}
}