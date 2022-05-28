import java.util.*;
import java.io.*;

public class PassByValOrRef {
	public static void main(String[] args) {
		//primitive
		int a = 4, b = 5;
		System.out.printf("%d, %d", a, b);
		passPrimitive(a, b);
		System.out.printf("\nPrimitive:\n%d, %d \n", a, b);
		//Box
		Integer p = 3, q = 4;
		System.out.printf("%d, %d", p, q);
		passBox(p, q);
		System.out.printf("\nBox: %d, %d \n", p, q);

		//Objects
		Person mani = new Person(23, "Mani");
		System.out.printf("\nname: %s   age: %d \n", mani.name, mani.age);
		passObject(mani);
		System.out.printf("\n name: %s age: %d \n", mani.name, mani.age);

		//String
		String question = "What is you name?";
		System.out.println(question);
		passString(question);
		System.out.println(question);

		//Collections:
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		System.out.println(intList);
		passCollection(intList);
		System.out.println(intList);
	}

	static void passCollection(List<Integer> intList) {
		intList.remove(1);
	}
	static void passString(String question) {
		question = "What is your age?";
	}

	static void passObject(Person mani) {
		mani.name = "nima";
		mani.age = 32;
	}

	static void passBox(Integer m, Integer n) {
		m = m + 1;
		n = n + 1;
	}
	static void passPrimitive(Integer x, Integer y) {
		x = x + 1;
		y = y + 1;
	}
}

class Person {
	int age;
	String name;

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
}