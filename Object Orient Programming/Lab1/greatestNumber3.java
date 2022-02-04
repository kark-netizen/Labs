import java.util.Scanner; 
public class greatestNumber3 { 

	public void displayGreatest(int ... num) { 
		int max = num[0];
		if(checkEquality(num) == true) {
			System.out.println("Maximum: " + num[0]);
			System.out.println("All Equal ");
			return;
		}
		for(int i : num) 
		{
			if(max < i)
				max = i;
		}
		System.out.println("Maximum: " + max); 
	} 
	public boolean checkEquality(int num[]) {
		for(int i = 0;i<num.length-1;i++) {
			if(num[i]!=num[i+1])
				return false;
		}
		return true;
	}
	public static void main(String args[]) { 
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Input 3 Numbers");
		//object creation
		greatestNumber3 gn = new greatestNumber3();
		
		//creating array of numbers
		int num[], n=3; 
		num = new int[n];
		
		//input
		for(int i=0; i<n; i++) 
		{
			num[i] = sc.nextInt(); 
		}
		gn.displayGreatest(num);
	}
}  