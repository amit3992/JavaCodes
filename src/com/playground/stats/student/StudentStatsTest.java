package com.playground.stats.student;

public class StudentStatsTest {
	
	public static void main(String[] args) {
		
		Student amit = new Student("Amit", 90);
		Student alex = new Student("Alex", 80);
		Student jen = new Student("Jen", 100);
		Student aaron = new Student("Aaron", 84);
		Student eliza = new Student("Eliza", 67);
		Student angelica = new Student("Angelica", 83);
		
		
		/*
		TopScoreStats ts = new TopScoreStats();
		ts.addScore("Math", amit);
		ts.addScore("Physics", jen);
		ts.addScore("Physics", aaron);
		ts.addScore("Chemistry", alex);
		ts.addScore("Math", jen);
		jen.setScore(98);
		ts.addScore("Chemistry", jen); 
		
		System.out.println(ts.getTopScoreForCourse("Chemistry"));
		*/
		
		TopKScoreStats tks = new TopKScoreStats(3);
		
		tks.addScore("Math", amit);
		tks.addScore("Math", jen);
		tks.addScore("Math", aaron);
		tks.addScore("Chemistry", alex);
		tks.addScore("Math", eliza);
		tks.addScore("Math", angelica);
		
		tks.getTopKScoreForCourse("Math");
		
	}

}
