package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemoWith2DArray {

	FlatMapDemoWith2DArray() {
		// Here’s the requirement, we want to filter out the a and print out all the
		// characters.

		// 1. withoutFlatMap()
		// withoutFlatMap();

		withFlatMap();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlatMapDemoWith2DArray flatmap = new FlatMapDemoWith2DArray();
	}

	public void withoutFlatMap() {
		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };

		// array to a stream
		Stream<String[]> stream1 = Arrays.stream(array);

		// x is a String[]
		List<String[]> result = stream1.filter(x -> {
			for (String s : x) { // really?
				if (s.equals("a")) {
					return false;
				}
			}
			return true;
		}).collect(Collectors.toList());

		// print array
		result.forEach(x -> System.out.println(Arrays.toString(x)));
	}

	public void withFlatMap() {
		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
//
//		// Java 8
//		String[] result = Stream.of(array) // Stream<String[]>
//				.flatMap(Stream::of) // Stream<String>
//				.toArray(String[]::new); // [a, b, c, d, e, f]
//
//		for (String s : result) {
//			System.out.println(s);
//		}
//		
		List<String> collect = Stream.of(array) // Stream<String[]>
				.flatMap(Stream::of) // Stream<String>
				.filter(x -> !"a".equals(x)) // filter out the a
				.collect(Collectors.toList()); // return a List

		collect.forEach(System.out::println);
	}
}
