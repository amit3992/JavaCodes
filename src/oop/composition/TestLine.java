package oop.composition;

public class TestLine {
	
	   public static void main(String[] args) {
	      // Test constructor and toString()
	      Line l1 = new Line(1, 2, 3, 4);
	      System.out.println(l1);  // Line's toString()
	      Line l2 = new Line(new Point(5,6), new Point(7,8));  // anonymous Point's instances
	      System.out.println(l2);  // Line's toString()

	      // Test Setters and Getters
	      l1.setBegin(new Point(11, 12));
	      l1.setEnd(new Point(13, 14));
	      System.out.println(l1);  // Line's toString()
	      System.out.println("begin is: " + l1.getBegin());  // Point's toString()
	      System.out.println("end is: " + l1.getEnd());  // Point's toString()

	      l1.setBeginX(21);
	      l1.setBeginY(22);
	      l1.setEndX(23);
	      l1.setEndY(24);
	      System.out.println(l1);  // Line's toString()
	      System.out.println("begin's x is: " + l1.getBeginX());
	      System.out.println("begin's y is: " + l1.getBeginY());
	      System.out.println("end's x is: " + l1.getEndX());
	      System.out.println("end's y is: " + l1.getEndY());

	      l1.setBeginXY(31, 32);
	      l1.setEndXY(33, 34);
	      System.out.println(l1);  // Line's toString()
	      System.out.println("begin's x is: " + l1.getBeginXY()[0]);
	      System.out.println("begin's y is: " + l1.getBeginXY()[1]);
	      System.out.println("end's x is: " + l1.getEndXY()[0]);
	      System.out.println("end's y is: " + l1.getEndXY()[1]);

	      // Test getLength()
	      System.out.printf("length is: %.2f%n", l1.getLength());
	   }
	}

