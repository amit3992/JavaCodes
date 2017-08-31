package leetCode.String;
import java.util.*;

/*Link: https://www.hackerrank.com/challenges/attribute-parser */

public class AttributeParser {
	/* Variables */
	String[] strings; // string array 
	
	public void init(int n, Scanner sc) {
		
		strings = new String[n];
		int i = 0;
		
		while(n > 0) {
			String s = sc.nextLine();
			System.out.println(s);
			//strings[i] = sc.nextLine();
			i++;
			n--;
		}
		
		sc.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AttributeParser ap = new AttributeParser();
		
		int n, q;
		n = sc.nextInt();
		q = sc.nextInt();
		
		ap.init(n, sc);
		
	}

}
