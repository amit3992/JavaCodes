package oop.composition;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;


public class Point {
	
	// Static variables
	private int x;
	private int y;
	
	// Constructor
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Class methods
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		String s = "(" + this.x + "," + this.y + ")";
		return s;
	}
	
	public int[] getXY() {
		int [] xy = new int[2];
		xy[0] = this.x;
		xy[1] = this.y;
		
		return xy;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance() {
		// Returns distance from this instance to 0,0
		
		int x_ = this.x;
		int y_ = this.y;
		return Math.sqrt(Math.pow(x_, 2) + Math.pow(y_, 2));
	}
	
	public double distanceXY(int x2, int y2) {
		
		//System.out.println("Distance between ("+this.x+","+this.y+") and ("+x2+","+y2+") ->");
		int dx = this.x - x2;
		int dy = this.y - y2;
		
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		
	}
	
	
	public double distanceP(Point p) {
		//System.out.println("Distance between ("+this.x+","+this.y+") and ("+p.getX()+","+p.getY()+") ->");
		int dx = this.x - p.getX();
		int dy = this.y - p.getY();
		
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}
	
	
	

}
