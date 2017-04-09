package flipkart.problems.employeesystem;


public class EmployeeSystem {
	public static void main(String[] args) {
		Employee alex = new Employee("alex", 1, 12000, 3);
		Employee susann = new Employee("susann", 2, 8000, 4);
		Employee sahil = new Employee("sahil", 3, 2000, 2);
		Employee kuldeep = new Employee("kuldeep", 4, 10000, 4);
		Employee manmeet = new Employee("manmeet", 5, 20000, 3);
		Employee negi = new Employee("negi", 6, 15000, 3);
		Manager sudhir = new Manager("sudhir", 7, 30000, 4);
		sudhir.addEmployee(alex);
		sudhir.addEmployee(susann);
		sudhir.addEmployee(sahil);
		Manager honey = new Manager("honey", 8, 35000, 3);
		honey.addEmployee(kuldeep);
		honey.addEmployee(negi);
		honey.addEmployee(manmeet);
		CEO ceo=new CEO("steve",23, 120000, 5);
		ceo.addEmployee(honey);
		ceo.addEmployee(sudhir);
		//ceo.print();
		int bonus=90000;
		sudhir.distributeBonus(bonus);
		sudhir.print();
	}
	
	
}
