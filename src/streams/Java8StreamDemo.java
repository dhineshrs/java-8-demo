package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Java8StreamDemo {

	public static void main(String[] args) {
		//listExample();
		arraysExample();
//		rangeExample();
//		primesExample();
//		funnyExample();

	}

	// some Java 8 examples using a list of strings
	public static void listExample() {
		List<String> words = new ArrayList<String>();
		words.add("mac");
		words.add("and");
		words.add("cheese");

		// old fashioned way to print the words
		for (int i = 0; i < words.size(); i++) {
			System.out.print(words.get(i) + " ");
		}
		System.out.println();

		// Java 5 introduced the foreach loop and Iterable<T> interface
		for (String s : words) {
			System.out.print(s + " ");
		}
		System.out.println();

		// Java 8 has a forEach method as part of the Iterable<T> interface
		// The expression is known as a "lambda" (an anonymous function)
		words.stream().forEach(n -> System.out.print(n + " "));
		System.out.println();

		// but in Java 8, why use a lambda when you can refer directly to the
		// appropriate function?
		words.stream().forEach(System.out::print);
		System.out.println();

		// this isn't correct, you'll complain, because we want to have spaces
		// attached to the output...no problem, introduce a call on map to
		// transform the data before it is printed
		words.stream().map(n -> n + " ").forEach(System.out::print);
		System.out.println();

		// obviously these chains of calls can get long, so the convention is
		// to split them across lines after the call on "stream":
		words.stream().map(n -> n + " ").forEach(System.out::print);
		System.out.println();
		System.out.println();
	}

	// some examples with an array of int
	public static void arraysExample() {
		int[] numbers = { 3, -4, 8, 73, 507, 8, 14, 9, 3, 15, -7, 9, 3, -7, 15 };

		// want to know the sum of the numbers? It's now built in
		int sum = Arrays.stream(numbers).sum();
		System.out.println("sum = " + sum);

		// how about the sum of the evens?
		int sum2 = Arrays.stream(numbers).filter(i -> i % 2 == 0).sum();
		System.out.println("sum of evens = " + sum2);

		// how about the sum of the absolute value of the evens?
		int sum3 = Arrays.stream(numbers).map(Math::abs).filter(i -> i % 2 == 0).sum();
		System.out.println("sum of absolute value of evens = " + sum3);

		// how about the same thing with no duplicates?
		int sum4 = Arrays.stream(numbers).distinct().map(Math::abs).filter(i -> i % 2 == 0).sum();
		System.out.println("sum of absolute value of distinct evens = " + sum4);

		// a summary of all stats that are built-in
		System.out.println("summary of all stats:");
		System.out.println(Arrays.stream(numbers).summaryStatistics());
		System.out.println();
	}

	// There is a new range type that can be used for lots of interesting
	// things that we have normally done with loops
	public static void rangeExample() {
		// print 1 to 10 (2nd parameter is exclusive, as with substring)
		IntStream.range(1, 11).forEach(System.out::println);
		System.out.println();

		// print factorials of 0 through 10, factorial itself is written using
		// a range
		IntStream.range(0, 11).map(Java8StreamDemo::factorial).forEach(System.out::println);
		System.out.println();
	}

	// factorial function written with range and reduce
	public static int factorial(int n) {
		return IntStream.range(2, n + 1).reduce(1, (a, b) -> a * b);
	}

	// isPrime function that checks to see that the only factors of n are 1 and
	// n (exactly 2 factors)...this isn't very efficient (could check just up
	// to the square root)
	public static boolean isPrime(int n) {
		return IntStream.range(1, n + 1).filter(x -> n % x == 0).count() == 2;
	}

	// example of finding the sum of the primes between 1 and 20,000 with and
	// without parallel processing
	public static void primesExample() {
		// check it 3 times, reporting how long it takes
		for (int i = 0; i < 3; i++) {
			printSum(IntStream.range(1, 20001));
		}
		System.out.println();

		// do it again, but with a parallel stream
		for (int i = 0; i < 3; i++) {
			printSum(IntStream.range(1, 20001).parallel());
		}
		System.out.println();
	}

	// times how long it takes to find the sum of the primes in the stream
	public static void printSum(IntStream s) {
		// run the algorithm and time it
		long start = System.currentTimeMillis();
		int n = s.filter(Java8StreamDemo::isPrime).sum();
		double elapsed = (System.currentTimeMillis() - start) / 1000.0;
		System.out.println("n = " + n + ", time = " + elapsed);
	}

	// it's great to be able to make a stream parallel to make a program run
	// faster, but sometimes that doesn't make sense, as in this example
	public static void funnyExample() {
		System.out.println("Let's print 1 through 20");

		System.out.print("sequentially:");
		IntStream.range(1, 21).forEach(n -> System.out.print(" " + n));
		System.out.println();

		System.out.print("in parallel :");
		IntStream.range(1, 21).parallel().forEach(n -> System.out.print(" " + n));
		System.out.println();
		System.out.println();
	}
}
