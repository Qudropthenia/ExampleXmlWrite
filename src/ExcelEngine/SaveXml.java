package ExcelEngine;

import Entity.Department;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Entity.Employee;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public class SaveXml {
	private final static String FILE_PATH = "file.xml";

	public static void save(List<Department> list) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Создаём корневой элемент
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Company");
			doc.appendChild(rootElement);

			// Проходимся по нашему списку Отдел/сотрудники, формируя ноды
			for (Department department : list) {
				Element departmentNode = getDepartmentNode(doc, department);
				rootElement.appendChild(departmentNode);
			}

			// Запись в файл
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(FILE_PATH));

			transformer.transform(source, result);
			System.out.println("File saved!");
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}

	private static Element getDepartmentNode(Document doc, Department department) {
		final String TEG_NAME = "Department";
		Element depNode = doc.createElement(TEG_NAME);
		// Добавляю название отдела
		Element depNameNode = doc.createElement("Name");
		depNameNode.appendChild(doc.createTextNode(department.getName()));
		depNode.appendChild(depNameNode);
		// Добавление ноды "Employees", которая будет родительской при добавлении сотрудников
		Element emplsNode = doc.createElement("Employees");
		depNameNode.appendChild(emplsNode);
		// Перебор всех сотрудников текущего отдела
		List<Employee> employees = department.getEmployees();
		employees.forEach(employee -> {
			Element emplNode = getEmployeeNode(doc, employee);
			emplsNode.appendChild(emplNode);
		});
		// Запись в ноду департамента
		depNode.appendChild(emplsNode);

		return depNode;
	}

	private static Element getEmployeeNode(Document doc, Employee employee) {
		final String TEG_NAME = "Employee";
		Element emplNode = doc.createElement(TEG_NAME);

		Attr attr = doc.createAttribute("id");
		attr.setValue(employee.getId().toString());
		emplNode.setAttributeNode(attr);

		Element nameNode = doc.createElement("Name");
		nameNode.appendChild(doc.createTextNode(employee.getName()));
		emplNode.appendChild(nameNode);

		Element salaryNode = doc.createElement("Salary");
		salaryNode.appendChild(doc.createTextNode(employee.getSalary().toString()));
		emplNode.appendChild(salaryNode);

		return emplNode;
	}
}
