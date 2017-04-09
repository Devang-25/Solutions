package flipkart.problems.employeesystem;

import java.util.HashMap;
import java.util.Map;

public class CEO extends Manager {
	private Map<Integer, Manager> subOrdinates;

	public void addEmployee(Manager employee) {
		this.subOrdinates.put(employee.getEmployeeDetails().getId(), employee);
	}

	public CEO(String name, int id, int salary, int rating) {
		super(name, id, salary, rating);
		subOrdinates = new HashMap<Integer, Manager>();
	}

	@Override
	public void print() {
		for (int key : subOrdinates.keySet()) {
			subOrdinates.get(key).print();
		}
	}

}
