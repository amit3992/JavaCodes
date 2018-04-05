package com.intuit;
import java.util.*;

public class Organization {
	
	String name;
	Employee CEO;
	Map<String, Employee> employeeMap;
	
	/* Constructor */
	public Organization(String name, Employee CEO) {
		
		this.name = name;
		this.CEO = CEO;
		this.employeeMap = new HashMap<String, Employee>();
		
		employeeMap.put(CEO.getName(), this.CEO);
	}
	
	/* Methods */
	public void addEmployee(String employeeName, String managerName, Role role) {
		
		if(!employeeMap.isEmpty() && employeeMap.containsKey(managerName)) {
		
			Employee manager = employeeMap.get(managerName);
			Employee emp = new Employee(employeeName, manager, role);
			manager.addEmployee(emp);
			this.employeeMap.put(employeeName, emp);
			
		} else {
			System.out.println("Manager with the name: " + managerName + " does not exist");
		}
	}
	
	public void addEmployee(String employeeName) {
		
		Employee newEmployee = new Employee(employeeName, Role.Employee);
		this.employeeMap.put(employeeName, newEmployee); /* Add to employee pool */
		
	}
	
	/* Search employee */
	public String getEmployeeInfo(String name) {
		
		if(this.employeeMap.containsKey(name)) {
			return this.employeeMap.get(name).toString();
		} else {
			return name + " does not exist in: " + this.name;
		}
	}
	
	/* Updates */
	public void updateManagerFor(String name, String managerName) {
		if(this.employeeMap.containsKey(name) && this.employeeMap.containsKey(managerName)) {
			Employee e = this.employeeMap.get(name);
			Employee newManager = this.employeeMap.get(managerName);
			newManager.addEmployee(e);
			e.setManager(newManager);
		}
	}
	
	
	

}
