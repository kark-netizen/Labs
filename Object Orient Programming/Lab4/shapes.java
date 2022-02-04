import java.util.*;
class areas{
	final double height;
	static double area;
	public areas(double height){
		this.height = height;
		area = 0 ;
	}
}
class triangle extends areas{
	double base;
	public triangle(double height , double base) {
		super(height);
		this.base = base;
	}
	public void calArea() {
		super.area = 0.5 * base * super.height;
	}
}
class rectangle extends areas{
	double width;
	public rectangle(double height , double width) {
		super(height);
		this.width = width;
	}
	public void calArea() {
		super.area = width * super.height;
	}
}
public class shapes {
	public triangle triangleInput() {
		triangle te;
		Scanner sc = new Scanner(System.in);
		double height , base ; 
		System.out.println("Input Height of Triangle");
		height = 0;
		try{
			height = sc.nextDouble();
			if( height <= 0) {
				System.out.println("WARNING!\nParameters must be positive");
				return triangleInput();
			}
		}catch(InputMismatchException E) {
			System.out.println("WARNING!\nParameters must be positive number");
			return triangleInput();
		}
		System.out.println("Input Base of Triangle");
		base = sc.nextDouble();
		if( base <= 0 ) {
			System.out.println("WARNING!\nParameters must be positive");
			return triangleInput();
		}
		te = new triangle(height, base);
		return te;
	}
	public rectangle rectangleInput() {
		Scanner sc = new Scanner(System.in);
		double height , width ; 
		System.out.println("Input Height of Rectangle:");
		height = 0;
		try{
			height = sc.nextDouble();
			if( height <= 0) {
				System.out.println("WARNING!\nParameters must be positive");
				return rectangleInput();
			}
		}catch(InputMismatchException E) {
			System.out.println("WARNING!\nParameters must be positive number");
			return rectangleInput();
		}
		System.out.println("Input Width of Rectangle:");
		width = sc.nextDouble();
		if(  width < 0 ) {
			System.out.println("WARNING!\nParameters must be positive!");
			return rectangleInput();
		}
		rectangle re = new rectangle(height, width);
		return re;
	}
	public static void main(String args[]) {
		triangle te;
		rectangle re;
		shapes se = new shapes();
		te = se.triangleInput();
		te.calArea();
		System.out.println("Area of Triangle is: " + te.area);
		re = se.rectangleInput();
		re.calArea();
		System.out.println("Area of Rectangle is: " + re.area);
	}
}
