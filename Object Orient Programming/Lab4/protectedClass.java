package week4;
class superClass1 {
	public int x;
	public int y;
	superClass1(){
		System.out.println("Inside Super Class Constructor");
		x = 10;
		y = 100;
	}
	public void display() {
		System.out.println("value of x: " + x);
		System.out.println("value of y: " + y);
	}
}
public class protectedClass extends superClass1{
	protectedClass(){
		System.out.println("Inside Sub Class Constructor");
	}
	public static void main(String args[]) {
		superClass1 sc = new superClass1();
		sc.display();
		System.out.println(sc.x + "  " + sc.y);
	}
}