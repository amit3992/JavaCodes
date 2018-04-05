package com.intuit;
import java.util.*;

public class Employee {
	
	String name;
	long employee_id;
	Role role;
	Employee manager;
	int level;
	List<Employee> reports;	
	
	/* Constructor */
	
	public Employee(String name, Role role) {
		this.name = name;
		this.employee_id = UUID.randomUUID().getMostSignificantBits();
		this.role = role;
		
		if(role.equals(Role.CEO)) {
			this.manager = null;
			this.level = 1;
		} else if(role.equals(Role.Director)) {
			this.manager = null;
			this.level = 2;
		} else if(role.equals(Role.VP)) {
			this.manager = null;
			this.level = 3;
		} else if(role.equals(Role.Manager)) {
			this.level = 4;
			this.manager = null;
		} else {
			this.level = 5;
			this.manager = null;
		}
		
		reports = new ArrayList<Employee>();
		
	}
	
	public Employee(String name, Employee manager, Role employeeRole) {
		
		this.name = name;
		this.manager = manager;
		this.level = manager.getLevel() + 1;
		this.role = employeeRole;
		this.reports = new ArrayList<Employee>();
	}
	
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getManagerName() {
		
		if(manager != null) {
			return manager.getName();
		} else {
			return "N/A";
		}
	
	}
	
	public Employee getManager() {
		return this.manager;
	}


	public void setManager(Employee manager) {
		this.manager = manager;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public List<Employee> getReports() {
		return reports;
	}


	public void setReports(List<Employee> reports) {
		this.reports = reports;
	}

	
	/* Methods */
	
	public String toString() {
		return "ID: " + employee_id + "| Name: " + name + " | Reporting to: " + this.getManagerName() + " | No.of reports: " + this.reports.size();
	}
	
	public void addEmployee(Employee e) {
		this.reports.add(e);
	}
	
	

}
