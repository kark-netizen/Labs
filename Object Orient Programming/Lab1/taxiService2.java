import java.util.Scanner;
public class taxiService2 {
	public double calculate(double charge) {
		double km[] = {5,15,29};
		double maxDistance = 49;
		double maxFare = 300;
		double charges[] = {10,8,5};
		double fares[] = {km[0]*charges[0],km[1]*charges[1],maxFare};
		double distance = 0.0;
		if(charge < 0) {
			System.out.println("INVALID INPUT");
			return -1;
		}
		if(checkWarning(charge,maxFare) == true) {
			return maxDistance;
		}
		for(int i=0; i < fares.length ; i++) {
			if(charge>0) {
				distance += Math.min(fares[i],charge)/charges[i];
				charge -= fares[i];
			}
		}
		return distance;
	}
	public boolean checkWarning(double charge,double maxFare){
		if(charge > maxFare) {
			System.out.println("\nWARNING:\nExceeded maximum fare of Rs. " + maxFare);
			return true;
		}
		return false;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); 
		taxiService2 ts = new  taxiService2(); 
		System.out.println("Input Fare: "); 
		double charge = sc.nextDouble(); 
		System.out.println("Distance is: " + ts.calculate(charge));
	}
}
