import java.util.Scanner;

public class sumArray {
	public void odd(int arr[],int n) {
		int sum = arr[0] + arr[n-1] + arr[n/2];
		System.out.println("Size of array is Odd");
		System.out.println("Sum = " + sum);
	}
	public void even(int arr[],int n) {
		int sum = arr[0] + arr[n-1];
		System.out.println("Size of array is Even");
		System.out.println("Sum = " + sum);
	}
	public boolean input(int arr[], int n) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Array");
		for(int i = 0; i < arr.length ; i++) {
				arr[i] = sc.nextInt();
				if(arr[i] < 0) {
					System.out.println("INVALID INPUT");
					return false;
				}
		}
		return true;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		sumArray sm = new sumArray();
		System.out.println("Input Array Size");
		int n = sc.nextInt();
		int arr[] = new int[n];
		if(sm.input(arr,n) == false)
			return;
		if(n%2 == 0) sm.even(arr, n);
		else sm.odd(arr, n);
	}
}
/*
5	36 23 57 897 27
7	3 2 66 9 76 1 4 
4	-6 6 -3 3 6
 */
