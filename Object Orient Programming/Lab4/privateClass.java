package week4;

private class superClass {
	private int x;
	public int y;
	superClass(){
		System.out.println("Inside Super Class Constructor");
		x = 10;
		y = 100;
	}
	public void display() {
		System.out.println("value of x: " + x);
		System.out.println("value of y: " + y);
	}
}
public class privateClass{
	public static void main(String args[]) {
		superClass sc = new superClass()
	}
}