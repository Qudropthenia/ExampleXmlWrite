package Entity;

import java.util.List;

// Структура департамента
public class Department {
	private String name;
	private List<Employee> employees;

	public Department() {
	}

	public Department(String name, List<Employee> employees) {
		this.name = name;
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	private int getEmplSize() {
		return (employees != null) ? employees.size() : 0;
	}

	@Override
	public String toString() {
		return "Department{ name = '" + name + "', employees count = " + getEmplSize() + "}";
	}
}
