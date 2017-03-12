package oop.inheritance;

public class Circle {
	
	//Static variables
	double radius;
	String color;
	
	// Constructor
	public Circle() {
		radius = 1.0;
		color = "red";
	}
	
	public Circle(double radius) {
		this.radius = radius;
		color = "red";
	}
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	// Methods
	public double getRadius() {
		return radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setRadius(double r) {
		radius = r;
	}
	
	public void setColor(String c) {
		color = c;
	}
	
	public String toString() {
		 return "Circle[radius=" + radius + ",color=" + color + "]";
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}

}
