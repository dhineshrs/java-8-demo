package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TopLowestPaidEmployees {

	// Find highest and lowest paid employees using Streams
	public static void main(String[] args) {
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee("John", "FINANCE", 1000));
		employeesList.add(new Employee("Tim", "ADMIN", 5000));
		employeesList.add(new Employee("Ryan", "ADMIN", 2000));
		employeesList.add(new Employee("Tom", "FINANCE", 20000));

		// Top paid salary employees
		Map<String, Employee> topPaidEmployees = employeesList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(
						Collectors.minBy(Comparator.comparingDouble(e -> e.getSalary())), Optional::get)));

		// Get the all employees dept count
		Map<String, Long> eachDeptCount = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		// Group by dept
		Map<String, List<Employee>> groupByDept = employeesList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment()));

		System.out.println("topPaidEmployees : " +topPaidEmployees);
		System.out.println("eachDeptCount : " +eachDeptCount);
		System.out.println("groupByDept :" +groupByDept);

	}
}

class Employee {

	private String name;
	private String department;
	private double salary;

	public Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "{" + "name='" + name + '\'' + ", department='" + department + '\'' + ", salary=" + salary + '}';
	}
}