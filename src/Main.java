import Entity.Department;
import ExcelEngine.SaveXml;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
    	// Заполняем наш "лист" рандомным кол-вом сотрудников
	    AppData.initDataList();
	    // Вывод имеющиеся данные
	    printListData(AppData.departments);
	    // Сохранение в XML
	    SaveXml.save(AppData.departments);
	    // Пример предикатов
		Predicate<Department> departmentPredicate = d -> d.getName().equals("it");
		AppData.printFiltered(departmentPredicate);
    }

    private static void printListData(List<Department> departments) {
	    System.out.println("\t\t\t--== Имеющиеся данные ==--");
	    departments.forEach(department -> {
		    System.out.println(department);
		    department.getEmployees().forEach(employee -> System.out.println("\t" + employee));
	    });
	    for (int i = 0; i < 55; i++) System.out.print("-");
	    System.out.println();
    }
}
