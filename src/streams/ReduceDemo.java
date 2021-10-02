package streams;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2, 4, 6, 8);
		// java.util.stream.Stream.reduce(Integer identity, BinaryOperator<Integer> accumulator)
		int result = numbers.stream().reduce(1, (total, element) -> total + element);
		System.out.println(result);

		List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");
		//java.util.stream.Stream.reduce(Integer identity, BinaryOperator<Integer> accumulator)
		String output = letters.stream().reduce("", (String::concat));
		String outputConcatenate = letters.stream().reduce("",
				(string, element) -> string.toUpperCase() + element.toLowerCase());
		System.out.println("output : " +output);
		System.out.println("outputConcatenate : " +outputConcatenate);

		List<User> users = Arrays.asList(new User("hameed", 20), new User("hameed", 20));
		int computedAges = users.stream().reduce(0, (ageResult, user) -> ageResult + user.getAge(), Integer::sum);
		System.out.println(computedAges);

	}

}

class User {
	private String name;
	private int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getEmployees() {
		return getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}
