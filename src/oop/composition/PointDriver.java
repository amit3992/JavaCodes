package oop.composition;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PointDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(3,4);
		Point p2 = new Point(3,11);
		//System.out.println(p.toString());
		
		//System.out.println("Distance of p from 0,0 = " + p.distance());
		System.out.println(p.distanceXY(3, 11));
		System.out.println(p.distanceP(p2));

	}

}
