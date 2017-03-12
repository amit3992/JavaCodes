package School;
import java.util.*;abstract

public class SchoolTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Student Amit = new Student();
		Student s1 = new Student("Alex", 23, "Male");
		Student s2 = new Student("Sneha","Shinde", 24, "Female");
		
		//Amit.getDetails();
		Amit.setAge(23);
		Amit.getDetails();
		s1.setAge(45);
		s1.getDetails();

	}

}
