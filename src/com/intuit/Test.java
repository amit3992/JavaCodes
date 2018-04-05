package com.intuit;

public class Test {
	
	public static void main(String [] args) {
		
		Employee CEO = new Employee("Karen", Role.CEO);
		Organization myOrg = new Organization("Intuition Inc", CEO);
		
		/* Add an employee to the org */
		myOrg.addEmployee("Nikhil", "Karen", Role.Director);
		myOrg.addEmployee("Alex", "Nikhil", Role.VP);
		
		myOrg.addEmployee("Amit");
		myOrg.updateManagerFor("Amit", "Karen");
		
		
		/* Search employee */
		System.out.println(myOrg.getEmployeeInfo("Karen"));
		System.out.println(myOrg.getEmployeeInfo("Nikhil"));
		System.out.println(myOrg.getEmployeeInfo("Amit"));
		System.out.println(myOrg.getEmployeeInfo("Alex"));
		
	}

}
