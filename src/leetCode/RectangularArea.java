package leetCode;

class Rectangle {
	int a, b, c, d;
	
	Rectangle(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
}
public class RectangularArea {
	
	public double getArea(Rectangle r) {
		double length = (r.c - r.a);
		double breadth = (r.d - r.b);
		
		return length * breadth;
	}
	
	public double getCommonArea(Rectangle r1, Rectangle r2) {
		
		double areaA = getArea(r1);
		double areaB = getArea(r2);
		
		int left = Math.max(r1.a, r2.a);
		int top = Math.max(r1.c, r2.c);
		int bottom = Math.max(r1.b, r2.b);
		int right = Math.max(r1.d, r2.d);
		
		double optimal = 0;
		
		if(right > left && top > bottom) {
			optimal = 0;
		}
		
		return optimal;
	}

	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(-3, 0, 3, 4);
		Rectangle r2 = new Rectangle(0, -1, 9, 2);
		
		RectangularArea ra = new RectangularArea();
		System.out.println("Common area -> " + ra.getCommonArea(r1, r2));
	}

}
