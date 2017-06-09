package hackerrank.algo.implementation;
import java.util.*;

/* Link: https://www.hackerrank.com/challenges/grading */

/* ip: 4 73 67 38 33
 * op: 75 67 40 33
 * */

public class GradingStudents {
	
	static int newGrade = 0;
	
	private static boolean checkMul5(int num) {
		for(int i = num; i < (num + 3); i++) {
			if(i % 5 == 0) {
				newGrade = i;
				return true;
			}
		}
		
		return false;
	}
	
	 static int[] solve(int[] grades){
		 
	        for(int i = 0; i < grades.length; i++) {
	        	
	        	// Grade less than 38
	        	if(grades[i] < 38) {
	        		continue;
	        	} else if (grades[i] >= 38 && grades[i] <= 40) {
	        		grades[i] = 40;
	        		continue;
	        	}
	        	
	        	if(checkMul5(grades[i])) {
	        		grades[i] = newGrade;
	        		continue;
	        	} else {
	        		continue;
	        	}
	        }
	        
	        return grades;
	    }

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");

	}

}
