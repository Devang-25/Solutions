package flipkart.problems.employeesystem;

public class Employee implements OrgEmployee{
	
	public EmployeeDetails details;
	public Employee(String name, int id, int salary, int rating) {
		super();
		details=new EmployeeDetails(name, id, salary, rating);	
	}


	public EmployeeDetails getEmployeeDetails() {
		return this.details;
	}


	@Override
	public void print() {
		System.out.println(this.details+": Bonus"+this.bonus);
	}
	private double bonus;

	public void setBonus(double eBonus) {
		this.bonus=eBonus;
		
	}

}
