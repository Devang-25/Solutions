package flipkart.problems.employeesystem;

public class EmployeeDetails {
	private String name;
	private int id;
	private int salary;
	private int rating;

	public EmployeeDetails(String name, int id, int salary, int rating) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getSalary() {
		return salary;
	}

	public int getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return this.name + "-" + this.id + "-" + this.salary + "-"
				+ this.rating;
	}
}
