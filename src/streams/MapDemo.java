package streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Employee;

// Java 8, stream().map() lets you convert an object to something else.

public class MapDemo {

	MapDemo() {
	//	demo1();
	//	demo2();
	//	demo3();
		hashMapDemo();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapDemo mapDemo = new MapDemo();
	}

	// Convert lower case to upper case
	public void demo1() {
		List<String> alpha = Arrays.asList("a", "b", "c", "d");

		// Before Java8
		List<String> alphaUpper = new ArrayList<>();
		for (String s : alpha) {
			alphaUpper.add(s.toUpperCase());
		}

		System.out.println(alpha); // [a, b, c, d]
		System.out.println(alphaUpper); // [A, B, C, D]

		// Java 8
		List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(collect); // [A, B, C, D]

		// Extra, streams apply to any data type.
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
		System.out.println(collect1); // [2, 4, 6, 8, 10]

	}

	// 2.1 Get all the name values from a list of the staff objects.
	public void demo2() {
		List<Staff> staff = Arrays.asList(new Staff("mkyong", 30, new BigDecimal(10000)),
				new Staff("jack", 27, new BigDecimal(20000)), new Staff("lawrence", 33, new BigDecimal(30000)));

		// Before Java 8
		List<String> result = new ArrayList<>();
		for (Staff x : staff) {
			result.add(x.getName());
		}
		System.out.println(result); // [mkyong, jack, lawrence]

		// Java 8
		List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
		System.out.println(collect); // [mkyong, jack, lawrence]

	}

	// 3.1 This example shows you how to convert a list of staff objects into a list
	// of StaffPublic objects.
	
	
	public void demo3() {
		List<Staff> staff = Arrays.asList(new Staff("mkyong", 30, new BigDecimal(10000)),
				new Staff("jack", 27, new BigDecimal(20000)), new Staff("lawrence", 33, new BigDecimal(30000)));

		//Before Java 8.
		//List<StaffPublic> result = convertToStaffPublic(staff);
	//	System.out.println(result);
		
		// convert inside the map() method directly.
		List<StaffPublic> result = staff.stream().map(temp -> {
			StaffPublic obj = new StaffPublic();
			obj.setName(temp.getName());
			obj.setAge(temp.getAge());
			if ("mkyong".equals(temp.getName())) {
				obj.setExtra("this field is for mkyong only!");
			}
			return obj;
		}).collect(Collectors.toList());

		System.out.println(result);

	}

	private static List<StaffPublic> convertToStaffPublic(List<Staff> staff) {

		List<StaffPublic> result = new ArrayList<>();

		for (Staff temp : staff) {

			StaffPublic obj = new StaffPublic();
			obj.setName(temp.getName());
			obj.setAge(temp.getAge());
			if ("mkyong".equals(temp.getName())) {
				obj.setExtra("this field is for mkyong only!");
			}

			result.add(obj);
		}

		return result;

	}
	
	
	
	void hashMapDemo() {
		Map<Integer, Employee> hashMap = new HashMap<>();
		Employee emp1 = new Employee(124, "sachin", "kumar", 8900.00);
		Employee emp2 = new Employee(125, "Rahul", "Dravid", 6800.00);
		Employee emp3 = new Employee(126, "Virat", "kholi", 10000.00);
		hashMap.put(emp1.getEmpId(), emp1);
		hashMap.put(emp2.getEmpId(), emp2);
		hashMap.put(emp3.getEmpId(), emp3);
		
		hashMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()));
		
	}
	
	
	
	
	
	
	
}

class Staff {

	private String name;
	private int age;
	private BigDecimal salary;

	public Staff(String name, int age, BigDecimal salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}

class StaffPublic {

	private String name;
	private int age;
	private String extra;

	public StaffPublic() {

	}

	public StaffPublic(String name, int age, String extra) {
		super();
		this.name = name;
		this.age = age;
		this.extra = extra;
	}

	public String getName() {
		return name;
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

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "StaffPublic [name=" + name + ", age=" + age + ", extra=" + extra + "]";
	}
	

}
