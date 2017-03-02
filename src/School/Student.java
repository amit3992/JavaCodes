package School;
import java.util.*;

public class Student {
	
	private String fName;
	private String lName;
	private int age;
	private String sex;
	
	// Constructor #1
	public Student() {
		this.fName = "Amit";
		this.lName = "Kulkarni";
		this.age = 24;
		this.sex = "Male";
	}
	
	//Constructor #2
	public Student(String fName, int age, String s) {
		this.fName = fName;
		this.lName = "Kulkarni";
		this.age = age;
		this.sex = s;
	}
	
	//Constructor #3
	public Student(String fName, String lName, int a, String s) {
		this.fName = fName;
		this.lName = lName;
		this.age = a;
		this.sex = s;
	}
	
	// Public methods
	
	public void getDetails() {
		System.out.println("My name is: "+this.fName+" "+this.lName);
		System.out.println("I am "+this.age+" years old");
	}
	
	
	public void setAge(int a) {
		this.age = a;
	}
	
}
