import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	
	private static void filterFemaleEmployees(List<Employee> employees) {
		List<Employee> femaleEmployees = employees.stream()
		.filter(emp -> emp.getGender().equals(Gender.MALE))
		.collect(Collectors.toList());
		femaleEmployees.forEach(System.out::println);
	}
	
	private static void sortingEmployee(List<Employee> employees) {
		
		List<Employee> SortedEmployees = employees.stream()
//		sort by name		
		.sorted(Comparator.comparing(Employee::getName))
//		sort by name then salary
//		.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getGender))
		.collect(Collectors.toList());
		
		SortedEmployees.forEach(System.out::println);
	}
	
	private static void highlyPaidEmployee(List<Employee> employees) {
		
//		Optional<Employee> highSalaryEmployee= employees.stream()
//		.max(Comparator.comparing(Employee::getSalary));
//		
		//another way
		
		employees.stream()
		.max(Comparator.comparing(Employee::getSalary))
		.ifPresent(System.out::println);;
		
	}

	private static void minPaidEmployee(List<Employee> employees) {
		
		employees.stream()
		.min(Comparator.comparing(Employee::getSalary))
		.ifPresent(System.out::print);
		
	}
	
	private static void groupByGender(List<Employee> employees) {
		Map<Gender, List<Employee>> groupByGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender));
		
		groupByGender.forEach((gender, emp) -> {
			System.out.println(gender);
			emp.forEach(System.out::println);
			System.out.println();
		});
	}
	
	private static void highlyPaidMaleEmployee(List<Employee> employees) {
		Optional<String> highlyPaidMaleEmployee = employees.stream()
				.filter(emp -> emp.getGender().equals(Gender.MALE))
				.max(Comparator.comparing(Employee::getSalary))
				.map(Employee::getName);
		
		highlyPaidMaleEmployee.ifPresent(System.out::println);
				
	}
	
	public static void main(String[] args) {

		List<Employee> employees = getEmployees();
		
//		Filtering the female employees from the employee list
		System.out.println("Listing the Female Employees");
		filterFemaleEmployees(employees);
		System.out.println("");
		
//		Sorting the list of Employee object
		System.out.println("Sorted Employee list");
		sortingEmployee(employees);

//		Find the Highest paid Employee
		System.out.println("highly paid employee");
		highlyPaidEmployee(employees);
		
//		Find the Lowest paid Employee
		System.out.println("Minimum Paid Employee");
		minPaidEmployee(employees);
		
//		Grouping the Employees by gender
		System.out.println("Grouping the Employees by gender");
		groupByGender(employees);
		
//		Highly Paid Employee
		System.out.println("Highly Paid Employee");
		highlyPaidMaleEmployee(employees);
		
		System.out.println("END");
	}
	
	
	
	private static List<Employee> getEmployees() {
				return Arrays.asList(
					new Employee(100, "Abdul Kather", 10000, Gender.MALE),
					new Employee(101, "Roja", 50000, Gender.FEMALE),
					new Employee(102, "Raja", 40000, Gender.MALE),
					new Employee(103, "Nelson", 700000, Gender.MALE),
					new Employee(104, "Redish", 40000, Gender.MALE),
					new Employee(105, "Kulsoom", 100000, Gender.FEMALE),
					new Employee(106, "Ouva", 300000, Gender.FEMALE),
					new Employee(107, "Syed", 800, Gender.MALE)
		);
	}

}
