package dataStructures.disjointSets;
import java.util.*;

public class Solution {
	
	static class Student {
        
        int id;
        int rank;
        int total;
        Student parent;
        
    }

    private static HashMap<Integer, Student> map = new HashMap<Integer, Student>();

    private static void makeStudent(int id) {
        
        Student st = new Student();
        st.id = id;
        st.rank = 0;
        st.total = 1;
        st.parent = st;
       
        map.put(id, st);
    }

    private static boolean friendStudents(int first, int second) {
        
        Student st1 = map.get(first);
        Student st2 = map.get(second);
        
        Student parent1 = findParent(st1);
        Student parent2 = findParent(st2);
        
        /* Do nothing if they're a part of the same set*/
        if(parent1.id == parent2.id) {
            return false;
        }
        
        /* Else parent whose rank is higher becomes parent */
        if(parent1.rank >= parent2.rank) {
            
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1: parent1.rank;
            parent2.parent = parent1;
            
            /* Update parent's total */
            parent1.total = parent1.total + 1;
        }
        else {
            parent1.parent = parent2;
            parent2.total = parent2.total + 1;
        }
        
        return true;
    }

    private static Student findParent(Student st) {
        
        Student parent = st.parent;
        
        if(parent == st) {
            return parent;
        }
        
        st.parent = findParent(st.parent);
        return st.parent;
 
    }

    private static int getTOTALQuery(String[] queryType) {
        
        int count = 0;
        for(String st: queryType) {
            if(st.equals("Total")) {
                count++;
            }
        }
        
        return count;
    }

    private static int getTotalStudents(int first, int second) {
        
        Student s1 = findParent(map.get(first));
        Student s2 = findParent(map.get(second));

        int sum = s1.total + s2.total;
        
        return sum;
    }

    static int[] getTheGroups(int n, String[] queryType, int[] students1, int[] students2) {
        
        if(n <= 1) {
            
            int [] result = new int[1];
            result[0] = 1;
            
            return result;
        }
        
        int totalCounts = 0;
        
        if(queryType != null || queryType.length > 2) {
            totalCounts = getTOTALQuery(queryType);
        }
        
        int [] result = new int[totalCounts];
        
        /* Build students */
        for(int i = 1; i <= n; i++) {
            makeStudent(i);
        }
        
        int len = 0;
        
        if(queryType.length != students1.length || queryType.length != students2.length) {
            System.out.println("Invalid input");
            return null;
        }
        
        int length = students1.length;
        int count = 0;
        
        for(int i = 0; i < length; i++) {
            
            if(queryType[i].equals("Friend")) {
                
                /* call makeFriends; */
                int first = students1[i];
                int second = students2[i];
                
                if(!friendStudents(first, second)) {
                    continue;
                }
            }
            else if(queryType[i].equals("Total")) {
                
                /* Call total method */
                int first = students1[i];
                int second = students2[i];
                
                result[count] = getTotalStudents(first, second);
                count++;
                
            }
            else {
                System.out.println("Invalid input");
            }
        }
        
        return result;


    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
