
public class Employee {

	private Integer empId;
	private String name;
	private Integer salary;
	private Gender gender;

	public Employee(Integer empId, String name, Integer salary, Gender gender) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
	}

	public Integer getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public Integer getSalary() {
		return salary;
	}
	
	public Gender getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", gender=" + gender + "]";
	}
}
