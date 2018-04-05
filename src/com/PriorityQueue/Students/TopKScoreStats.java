package com.PriorityQueue.Students;
import java.util.*;

public class TopKScoreStats {
	
	HashMap<String, PriorityQueue<Student>> scoreMap;
	int k;
	
	public TopKScoreStats(int k) {
		// TODO Auto-generated constructor stub
		scoreMap = new HashMap<String, PriorityQueue<Student>>();
		this.k = k;
	}
	
	public void addScore(String course, Student student) {
		
		if(!scoreMap.containsKey(course)) {
			
			PriorityQueue<Student> pq = new PriorityQueue<Student>(new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o1.getScore() - o2.getScore();
				}
				
			});
			
			pq.offer(student);
			scoreMap.put(course, pq);
		} else {
			
			PriorityQueue<Student> currQ = scoreMap.get(course);
			
			if(currQ.size() < this.k) {
				currQ.offer(student);
			} else if(currQ.size() == this.k){
				currQ.offer(student);
				currQ.remove();
			}
			
			scoreMap.put(course, currQ);
		}
	}
	
	public void getTopKScoreForCourse(String course) {
		
		if(scoreMap.containsKey(course)) {
			PriorityQueue<Student> q = scoreMap.get(course);
			System.out.println("Size: " + q.size());
			
			while(!q.isEmpty()) {
				Student s = q.peek();
				q.remove();
				
				System.out.println(s.toString());
			}
		} else {
			System.out.println("Invalid course name");
		}
	}

}
