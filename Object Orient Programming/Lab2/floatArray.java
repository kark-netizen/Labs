import java.util.Scanner;

public class floatArray {
	public double calculate(float arr[]) {
		double sum = 0.0;
		for(float x : arr)
			sum += x;
		return sum;
	}
	public void input(float arr[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Array");
		for(int i = 0; i < arr.length ; i++) 
				arr[i] = sc.nextFloat();
	}
	public void display(double sum) {
		System.out.println("Sum of Array is: " + sum);
		System.out.println();
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		floatArray sm = new floatArray();
		System.out.println("Input Array Size");
		int n = sc.nextInt();
		float arr[] = new float[n];
		sm.input(arr);
		double sum = sm.calculate(arr);
		sm.display(sum);
	}
}
/*
5	4 6 8 9 0 
6	3 2 66 9 76 1 4
4	-6 6 -3 3 
7	22 -6 43 -19 -40 -2 6
8	a b c 1 4 7
*/

/*
27.0
157.0
0.0
 */