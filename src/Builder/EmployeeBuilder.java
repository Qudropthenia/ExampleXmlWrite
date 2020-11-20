package Builder;

import Entity.Employee;

import java.util.Random;

// Класс для построения сотрудников
public class EmployeeBuilder {
	private static Integer id = 0;

	public EmployeeBuilder() {
	}

	public static Employee getNewEmpl() {
		return new Employee(getId(), getName(), getSalary());
	}

	private static String getName() {
		final int CHARS_VALUE = 5;
		char[] array = new char[CHARS_VALUE];
		Random random = new Random();

		for (int i = 0; i < CHARS_VALUE; i++) {
			array[i] = (char) ('a' + random.nextInt(26));
		}

		return new String(array);
	}

	private static Integer getId() {
		id++;
		return id;
	}

	private static Integer getSalary() {
		return new Random().nextInt(1000) + 300;
	}
}
