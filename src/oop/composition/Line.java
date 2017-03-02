package oop.composition;
import java.util.*;
import java.io.*;

public class Line {
	
	//Variables of two points
	Point begin;
	Point end;
	
	//Constructors
	public Line(int x1, int y1, int x2, int y2) {
		begin = new Point(x1, y1);
		end = new Point(x2, y2);
	}
	
	public Line(Point p1, Point p2) {
		begin = p1;
		end = p2;
	}
	
	//Line methods
	public Point getBegin() {
		return begin;
	}
	
	public void setBegin(Point begin) {
		this.begin = begin;
	}
	
	public Point getEnd() {
		return end;
	}
	
	public void setEnd(Point end) {
		this.end = end;
	}
	 
	public int getBeginX() {
		return begin.getX();
	}
	
	public int getEndX() {
		return end.getX();
	}
	
	public int getBeginY() {
		return begin.getY();
	}
	
	public int getEndY() {
		return end.getY();
	}
	
	public void setBeginX(int x) {
		begin.setX(x);
	}
	
	public void setEndX(int x) {
		end.setX(x);
	}
	
	public void setBeginY(int y) {
		begin.setY(y);
	}
	
	public void setEndY(int y) {
		end.setY(y);
	}
	
	public void setBeginXY(int x, int y) {
		begin.setXY(x, y);
	}
	
	public void setEndXY(int x, int y) {
		end.setXY(x, y);
	}
	
	public String toString() {
		String s  = "Line[begin = " + begin.toString() + ", end = " + end.toString() + "]";
		
		return s;
	}
	
	public double getLength() {
		return begin.distanceP(end);
	}

	public int[] getBeginXY() {
		// TODO Auto-generated method stub
		return begin.getXY();
	}
	
	public int[] getEndXY() {
		// TODO Auto-generated method stub
		return end.getXY();
	}
	
	
}
