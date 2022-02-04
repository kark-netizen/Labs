package dse_200968130;
import java.util.*;
class book {
	String name;
	int ID;
	String author;
	double price;
	public book(String name,  int ID, double price) {
		this.name = name;
		this.ID = ID;
		//this.author = author;
		this.price = price;
	}
	
	public void display() {
		System.out.print(this.name + "\t");
		System.out.print(this.ID + "\t");
		//System.out.print(this.author + "\t");
		System.out.print(this.price );
		System.out.println();
	}
	public void displayHeader() {
		System.out.print("Name" + "\t\t");
		System.out.print("ID" + "\t");
		//System.out.print("Author" + "\t");
		System.out.print("Price" );
		System.out.println();
	}
}
public class library {
	public book input() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Input Book Name, ID and Price");
		String book = sc.nextLine();
		int ID = 0;
		try {
			ID = sc.nextInt();
		}catch(InputMismatchException E) {
			System.out.println("ID Should be an Integer");
		}
		double price = sc1.nextDouble();
		book bo = new book(book,ID, price);
		return bo;
	}
	public double purchase(book b1, book b2, int ids[]) {
		double total = 0.0;
		for(int i = 0; i < ids.length; i++) {
			if(b1.ID == ids[i])
				total += b1.price;
			else if(b2.ID == ids[i])
				total += b2.price;
		}
		return total;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		library lib = new library();
		book b1 = lib.input();
		book b2 = lib.input();
		b1.displayHeader();
		b2.display();
		b1.display();
		System.out.println("Input ID of Books you want to purchase");
		int ids[] = new int[2];
		for(int i = 0; i < 2; i++)
			ids[i] = sc.nextInt();
		System.out.println("Total Cost is: " + lib.purchase(b1,b2,ids));
	}
}
/*
Harry Potter
12345
20.90
Peter Pan
54321
19.89
try {
			ID = sc.nextInt();
		}catch(InputMismatchException E) {
			System.out.println("ID Should be an Integer");
		}
*/