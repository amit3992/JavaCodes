package oop.inheritance;
import java.util.*;

public class Cylinder extends Circle {
	
	//Static
	double height;
	
	//Constructor
	public Cylinder() {
		super();
		this.height = 1.0;
	}
	public Cylinder(double height) {
		super();
		this.height = height;
	}
	
	public Cylinder(double height, double radius) {
		super(radius);
		this.height = height;
	}
	
	public Cylinder(double height, double radius, String color) {
		super(radius, color);
		this.height = height;
	}
	
	//Methods
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getVolume() {
		return this.height * getArea();
	}
	
	@Override
	public double getArea() {
		return 2 * Math.PI * radius * height + (2 * super.getArea());
	}
	
	public String toString() {
		return "This is a Cylinder";  // to be refined later
	}
}
