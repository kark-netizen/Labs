package week4;
import java.util.*;

public class vehicle {
	String model_name;
	String company_name;
	String license_number;
	double odometer_read;
	double mileage;
	long vin_number;
	
	public vehicle(long vin_number,double odometer_read, double mileage , String ...names) {
		this.model_name = names[0];
		this.company_name = names[1];
		this.license_number = names[2];
		this.odometer_read = odometer_read;
		this.mileage = mileage;
		this.vin_number = vin_number;
	}
	
	public void displayHeader() {
		System.out.print("Model\t");
		System.out.print("Company\t");
		System.out.print("License\t\t");
		System.out.print("Odometer\t");
		System.out.print("Mileage\t");
		System.out.println("VIN\t");
		System.out.println();
	}
	public void display() {
		System.out.print(model_name + "\t");
		System.out.print(company_name + "\t");
		System.out.print(license_number + "\t");
		System.out.print(odometer_read + "\t\t");
		System.out.print(mileage + "\t");
		System.out.println(vin_number + "\t");
	}
}

public class car extends vehicle {
	String model_name;
	String company_name;
	String license_number;
	double odometer_read;
	double mileage;
	long vin_number;
	public car(long vin_number,double odometer_read, double mileage , String ...names) {
		super(vin_number,odometer_read, mileage , names);
		this.model_name = names[0];
		this.company_name = names[1];
		this.license_number = names[2];
		this.odometer_read = odometer_read;
		this.mileage = mileage;
		this.vin_number = vin_number;
	}
}

public class dealership {
	public car input() {
		triangle te;
		Scanner sc = new Scanner(System.in);
		String model_name , company_name , license_number;
		double odometer_read , mileage;
		long vin_number;
		try {
			model_name = sc.nextLine();
			company_name = sc.next();
			license_number = sc.next();
			odometer_read = sc.nextDouble();
			mileage = sc.nextDouble();
			vin_number = sc.nextLong();
		}
		catch (InputMismatchException E) {
			System.out.println("WARNING!\nInvalid Input");
			return input();
		}
		car ca = new car(vin_number,odometer_read, mileage , model_name , company_name , license_number );
		return ca;
	}
	public void checkNames(car c1, car c2, car c3 , car c4) {
		String names[] = {c1.model_name, c2.model_name , c3.model_name ,c4.model_name};
		for(int i = 0 ; i < 3; i++) {
			for(int j = i+1; j < 4; j++) {
				if(names[i].equalsIgnoreCase(names[j]))
					System.out.println("WARNING!\nSa Model Name: " + names[i]);
			}
		}
	}
	public static void main(String args[]) {
		dealership de = new dealership();
		car car1 , car2 , car3, car4;
		System.out.println("Input Format:\nModel Name\nCompany Name\nLicense\nOdometerReading\nMileage\nVIN");
		System.out.println("Input Car 1 Details");
		car1 = de.input();
		System.out.println("Input Car 2 Details");
		car2 = de.input();
		System.out.println("Input Car 3 Details");
		car3 = de.input();
		System.out.println("Input Car 4 Details");
		car4 = de.input();
		car1.displayHeader();
		car1.display();
		car2.display();
		car3.display();
		car4.display();
		de.checkNames(car1, car2, car3, car4);
	}
}
/*

Innova
Toyota
KA32JS1234
5000
13
99877

Figo
Ford
KA12AB0101
8000
20
98221

City
Honda
KA12IO1292
900
10
23233

City
Hyundai
KA90NM1223
700
10
34355
 */