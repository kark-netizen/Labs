import java.util.*;
public class arrayMultiply {
	public void input(int arr[][]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a 2D Matrix");
		for(int i = 0; i < arr.length ; i++) 
			for(int j = 0; j < arr.length ; j++)
				arr[i][j] = sc.nextInt();
	}
	public void display(int arr[][]) {
		System.out.println("Displaying Matrix");
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0; j < arr.length ; j++)
				System.out.print(arr[i][j]+"  ");
			System.out.println();
		}
		System.out.println();
	}
	public void multiply(int arr[][], int arr2[][],int mat[][]) {
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				int x = 0;
				for(int k = 0; k < arr.length; k++) {
					x += arr[i][k] * arr2[k][j];
				}
				mat[i][j] = x;
			}
		}
	}
	public static void main(String args[]) {
		arrayMultiply am = new arrayMultiply();
		int n1 = 3, m1 = 3, n2 = 3, m2 = 3;
		int arr[][] = new int[n1][m1];
		int arr2[][] = new int[n2][m2];
		int mat[][] = new int[n1][m2];
		am.input(arr);
		am.input(arr2);
		am.display(arr);
		am.display(arr2);
		am.multiply(arr, arr2, mat);
		System.out.println("Matrix Multiplication");
		am.display(mat);
	}
}
/*
INPUTS

23 22 45
2 12 33
43 53 63 

0 1 1 
2 0 2
3 3 0 

-2 22 45
-23 12 33
43 -53 68

32 54 -1
-42 0 26 
73 33 -44
*/
/*
OUTPUTS
179  158  67  
123  101  26  
295  232  149  

2297  1377  -1406  
1169  -153  -1117  
8566  4566  -4413  
*/