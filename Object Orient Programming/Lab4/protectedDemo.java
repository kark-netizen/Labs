package week4;

class superClass {
	protected int n = 1000;
	private int x = 100;
	public superClass() {
		System.out.println("Inside Super Class");
	}
	public void displayPublic() {
		System.out.println("Value of n: " + n);
		System.out.println("Value of x: " + x);
	}
	protected void displayProtected() {
		System.out.println("Value of n: " + n);
		System.out.println("Value of x: " + x);
	}
}
public class protectedDemo extends superClass {
	public protectedDemo() {
		super();
		System.out.println("Inside Sub Class");
	}
	public static void main(String args[]) {
		protectedDemo pd = new protectedDemo();
		System.out.println(pd.n);
		//System.out.println(pd.x); // error as x is private
		pd.displayPublic();
		pd.displayProtected();
	}
}
