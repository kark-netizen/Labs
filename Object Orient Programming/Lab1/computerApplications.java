import java.util.*;
class student{
	int regNumber;
	String studentName,courseName;
	double sub1,sub2,sub3;	
	double subs[] = {0,0,0};
	double dse[] = {0.5,0.25,0.25};
	double mca[] = {0.3,0.3,0.3};
	double score = 0.0;
	student(int regNumber, String studentName,String courseName, 
			double sub1,double sub2,double sub3){
		this.regNumber = regNumber;
		this.studentName = studentName;
		this.courseName = courseName;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		subs[0] = sub1;
		subs[1] = sub2;
		subs[2] = sub3;
	}
	
	public void calculateInternals() {
		if(courseName.equalsIgnoreCase("dse")) {
			for(int i=0; i<dse.length; i++) {
				score += subs[i] * dse[i];
			}
		}
		else if(courseName.equalsIgnoreCase("mca")) {
			for(int i=0; i<dse.length; i++) {
				score += subs[i] * mca[i];
			}
		}
	}
	public void displayHeading() {
		System.out.println("Student Name\tCourse\tSub1\tSub2\tSub3\tFinal");
		System.out.println();
		
	}
	public void display() {
		System.out.print(this.studentName + "\t");
		System.out.print(this.courseName + "\t");
		System.out.print(this.sub1 + "\t");
		System.out.print(this.sub2 + "\t");
		System.out.print(this.sub3 + "\t");
		System.out.print(this.score + "\t");
	}
}
public class computerApplications {
	public static void main(String args[]) {
		//Scanner sc = new Scanner(System.in);
		student st1 = new student(2009105,"Clark Kent","DSE",45,40,48);
		st1.displayHeading();
		st1.calculateInternals();
		st1.display();
		System.out.println();
		student st2 = new student(2009106,"Peter Parker","MCA",46,42,30);
		st2.calculateInternals();
		st2.display();
		System.out.println();
		student st3 = new student(2009107,"Tony Stark","DSE",45,44,43);
		st3.calculateInternals();
		st3.display();
		System.out.println();
		student st4 = new student(2009108,"Diana Spencer","DSE",49,48,44);
		st4.calculateInternals();
		st4.display();
		System.out.println();
		student st5 = new student(2009150,"Bruce Lee","MCA",41,47,48);
		st5.calculateInternals();
		st5.display();
		System.out.println();
		student st6 = new student(2009245,"Anandita","MCA",40,43,47);
		st6.calculateInternals();
		st6.display();
		System.out.println();
	}
}
