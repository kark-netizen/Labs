import java.util.Scanner;

abstract class university_details{
	String university;
	abstract public void display_uni_details();
}
class student_details extends university_details{
	String name;
	String college;
	String university;
	int id;
	student_details(int id, String ...names){
		this.id = id;
		this.name = names[0];
		this.college = names[1];
		this.university = names[2];
	}
	public void display_uni_details(){
		System.out.println("University: " + university);
	}
	public void display_details() {
		System.out.print(name + "\t");
		System.out.print(id + "\t\t");
		System.out.println(college + "\t");
	
	}
	public void display_header() {
		display_uni_details();
		System.out.print("Student\t\t");
		System.out.print("Identity\t");
		System.out.println("College\t");
		System.out.println();
	}
}
public class university {
	public student_details input() {
		System.out.println("Input ID, Name, College");
		student_details sd;
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		sc.nextLine();
		String name = sc.nextLine();
		String college = sc.next();
		sd = new student_details(id , name , college, "MAHE");
		return sd;
	}
	public static void main(String args[]) {
		university uni = new university();
		Scanner sc = new Scanner(System.in);
		student_details sd;
		student_details det[] = new student_details[10];
		System.out.println("Input Number of Students");
		int n = sc.nextInt();
		for(int  i = 0 ; i < n ; i++) {
			sd = uni.input();
			det[i] = sd;
		}
		det[0].display_header();
		for(int  i = 0 ; i < n ; i++) {
			det[i].display_details();
		}
	}
}
/*
29988
Kartik Tiwari
MIT

20199
Piyush Mishra
MIT

29012
Shreeni Nayak
MIT

23232
Yashrj Singh
DOC

89779
Harshi Sinha
KMC
 */
