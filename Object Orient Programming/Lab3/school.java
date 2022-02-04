package dse_200968130;
import java.util.*;
class student {
	String name;
	long ID;
	double marks[];
	double total;
	String status;
	int ascii[]; 
	public student(String name, long ID,double[] marks){
		this.name = name;
		this.ID = ID;
		this.marks = new double[] {0,0,0,0,0};
		for(int i = 0; i < 5; i++) {
			this.marks[i] = marks[i];
		}
		this.total = 0.0;
		this.status = "FAIL";
	}
	public void calculate() {
		for(int i = 0; i < 5; i++) {
			this.total += this.marks[i];
		}
		this.total /= 5.0;
		if(total >= 40.0)
			this.status = "PASS";
	}
	public void display(boolean flag) {
		if(flag) {
			System.out.print(this.name + "\t");
		}
		else {
			System.out.print(this.name.split(" ")[0] + "\t\t");
		}
		System.out.print(this.ID + "\t");
		System.out.print(this.marks[0] + "\t");
		System.out.print(this.marks[1] + "\t");
		System.out.print(this.marks[2] + "\t");
		System.out.print(this.marks[3] + "\t");
		System.out.print(this.marks[4] + "\t");
		System.out.print(this.total + "\t");
		System.out.print(this.status + "\t");
		System.out.println();
	}
	public void displayHeader() {
		System.out.print("Name" + "\t\t");
		System.out.print("Roll" + "\t");
		System.out.print("Sub1" + "\t");
		System.out.print("Sub2" + "\t");
		System.out.print("Sub3" + "\t");
		System.out.print("Sub4" + "\t");
		System.out.print("Sub5" + "\t");
		System.out.print("Total" + "\t");
		System.out.print("Status" + "\t");
		System.out.println();
		System.out.println();
	}
	public void convertASCII() {
		System.out.print(this.name.split(" ")[0] + "\t");
		int n = this.name.split(" ")[0].length();
		ascii = new int[n];
		for(int i = 0; i < n; i++) {
			ascii[i] = (int)name.charAt(i);
			System.out.print(ascii[i]);
		}
		System.out.println();
	}
}
public class school {
	public student input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Name, ID and Marks scored in 5 subjects");
		String name = sc.nextLine();
		long ID = sc.nextLong();
		double marks[] = new double[5];
		try {
			for(int i = 0; i < 5; i++) {
				marks[i] = sc.nextDouble();
				if(marks[i] > 100 || marks[i] < 0)
					System.out.println("Invalid Marks");
			}
		}catch(InputMismatchException E) {
			System.out.println("Not a Number");
		}
		student st = new student(name, ID, marks);
		return st;
	}
	public boolean checknames(student s1, student s2) {
		String l1[] = s1.name.split(" ");
		String l2[] = s2.name.split(" ");
		if(l1[1].equalsIgnoreCase(l2[1]))
			return true;
		return false;
	}
	public static void main(String args[]) {
		school sh = new school();
		student s1;
		student s2;
		s1 = sh.input();
		s2 = sh.input();
		boolean lastname = sh.checknames(s1,s2);
		s1.displayHeader();
		s1.calculate();
		s1.display(lastname);
		s2.calculate();
		s2.display(lastname);
		if(lastname) {
			System.out.println("WARNING: Matching Last Names");
		}
		s1.convertASCII();
		s2.convertASCII();
	}

}
/*
harsh singh
200968
90 87 63 40 13
yash singh
200976
3 40 17 19 61
yash mehta
200911
39 40 71 85 61
*/
