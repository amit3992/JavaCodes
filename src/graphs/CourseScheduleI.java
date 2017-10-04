package graphs;
import java.util.*;

public class CourseScheduleI {
	
	private boolean canFinishCourses(int numCourses, int[][] preReqs) {
		
		ArrayList[] graph = new ArrayList[numCourses];
		int [] degree = new int[numCourses];
		Stack<Integer> st = new Stack<Integer>();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = 0;
		
		for(int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < preReqs.length; i++) {
			degree[preReqs[i][1]]++;
			graph[preReqs[i][0]].add(preReqs[i][1]);
		}
		
		for(int i = 0; i < degree.length; i++) {
			if(degree[i] == 0) {
				queue.add(i);
				count++;
			}
		}
		
		while(queue.size() != 0) {
			int course = (int) queue.poll();
			
			for(int i = 0; i < graph[course].size(); i++) {
				int pointer = (int) graph[course].get(i);
				degree[pointer]--;
				
				if(degree[pointer] == 0) {
					queue.add(pointer);
					count++;
				}
			}
			
			st.push(course);
			
			
		}
		
		if(count == numCourses) {
			
			System.out.println("Order: ");
			while(!st.isEmpty()) {
				System.out.println(st.pop());
			}
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		
		CourseScheduleI cs = new CourseScheduleI();
		// int[][] preReqs = {{1,0}, {2,0}, {3,1}, {3,2}};
		int[][] preReqs = {{1,0}};
		
		boolean canFinish = cs.canFinishCourses(2, preReqs);
		
		System.out.println("Can finish: " + canFinish);

	}

}
