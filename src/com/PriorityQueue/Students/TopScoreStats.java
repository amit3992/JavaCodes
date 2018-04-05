package com.PriorityQueue.Students;

import java.util.HashMap;

public class TopScoreStats {
	
	HashMap<String, Student> studentMap;
	
	public TopScoreStats() {
		// TODO Auto-generated constructor stub
		studentMap = new HashMap<String, Student>();
	}
	
	public void addScore(String course, Student student) {
		
		if(!studentMap.containsKey(course)) {
			studentMap.put(course, student);
		} else {
			
			Student currentTop = studentMap.get(course);
			
			if(currentTop.getScore() <= student.getScore()) {
				studentMap.put(course, student);
			}
		}
	}
	
	public String getTopScoreForCourse(String course) {
		
		if(studentMap.containsKey(course)) {
			Student top = studentMap.get(course);
			
			return top.toString();
		} else {
			return "Invalid course";
		}
	}

}
