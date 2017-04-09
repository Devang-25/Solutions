package flipkart.problems.employeesystem;

import java.util.HashMap;
import java.util.Map;

public class Manager extends Employee {
	private Map<Integer, OrgEmployee> subOrdinates;

	public Manager(String name, int id, int salary, int rating) {
		super(name, id, salary, rating);
		subOrdinates = new HashMap<Integer, OrgEmployee>();
	}

	public void addEmployee(Employee employee) {
		this.subOrdinates.put(employee.getEmployeeDetails().getId(), employee);
	}

	@Override
	public void print() {
		super.print();
		for (Integer e : subOrdinates.keySet()) {
			subOrdinates.get(e).print();
		}
	}

	public void distributeBonus(int bonus) {
		int sumRating = 0;
		for (int e : this.subOrdinates.keySet()) {
			sumRating += this.subOrdinates.get(e).getEmployeeDetails()
					.getRating();
		}
		
		for (int e : this.subOrdinates.keySet()) {
			OrgEmployee emp=this.subOrdinates.get(e);
			double eBonus=((emp.getEmployeeDetails().getRating()*bonus)/sumRating);
			((Employee)emp).setBonus(eBonus);
		}
	}

}
