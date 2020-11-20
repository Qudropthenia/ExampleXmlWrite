package Builder;

import Entity.Department;
import Entity.Employee;

import java.util.ArrayList;
import java.util.List;

// Класс для построения департаментов
public class DepartmentBuilder {
	public static Department getDep(String depName, Integer emplValue) {
		List<Employee> employees = new ArrayList<>();

		for (int i = 0; i < emplValue; i++) employees.add(EmployeeBuilder.getNewEmpl());

		return new Department(depName, employees);
	}
}
