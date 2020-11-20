import Builder.DepartmentBuilder;
import Entity.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Хранение и инициализация списка данных приложения
public class AppData {
	public static List<Department> departments = new ArrayList<>();

	public static void initDataList() {
		departments = new ArrayList<>();
		String[] depNames = {"it", "hr", "other"};

		for (String depName : depNames) {
			Integer valueEmpl = new Random().nextInt(5) + 3;
			departments.add(DepartmentBuilder.getDep(depName, valueEmpl));
		}
	}
}
