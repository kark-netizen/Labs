package eval2;

import java.util.Scanner;
class calculations{
	String str;
	int n;
	int sum;
	calculations(String str){
		this.str = str;
		this.n = str.length();
		sum = 0 ;
	}
	public void calculate() 
	{
		for(int i = 0 ; i < n ; i++)
		{
			char ch = str.charAt(i);
			if((int)ch >= (int)'0' && (int)ch <= '9')
			{
				int x = (int)ch - (int)'0';
				sum += x;
			}
		}
	}
	public void display()
	{
		System.out.println("Sum is: " + sum);
	}
}
public class string_manipulation {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input String");
		String str = sc.next();
		calculations ca = new calculations(str);
		ca.calculate();
		ca.display();
	}
}