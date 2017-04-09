package flipkart.problems.employeesystem;

import java.util.HashMap;
import java.util.Map;

public class CmpEmployee<T> extends Employee {
	private Map<Integer,Employee> subOrdinates;

	public CmpEmployee(String name, int id, int salary, int rating) {
		super(name, id, salary, rating);
		subOrdinates = new HashMap<Integer,Employee>();
	}

	   public void addEmployee(CmpEmployee<? super T> employee) {
		this.subOrdinates.put(employee.getEmployeeDetails().getId(), employee);
	}
	
}
