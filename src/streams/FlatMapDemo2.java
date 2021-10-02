package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo2 {

	public static void main(String[] args) {
		List<String> list = Stream.of("a", "b").map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("1=========> " + list);

		List<List<String>> dupList = Arrays.asList(Arrays.asList("TOM"), Arrays.asList("JOHN"));
		System.out.println(dupList.stream().flatMap(Collection::stream).collect(Collectors.toList()));

	}

}
