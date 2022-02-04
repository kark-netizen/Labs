import java.util.*; 

public class conversions { 
	public byte intToByte(int i) {
		byte num = (byte)i;
		return num;
	}
	public int charToInt(char i) {
		int num = (int)i;
		return num;
	}
	public byte doubleToByte(double i) {
		byte num = (byte)i;
		return num;
	}
	public int doubleToInt(double i) {
		int num = (int)i;
		return num;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		conversions co = new conversions();
		System.out.println("Input an Integer: ");
		int i = sc.nextInt();
		
		System.out.println("Input an Double: ");
		double d = sc.nextDouble();
		
		System.out.println("Input an Character: ");
		char c = sc.next().charAt(0);
		
		// int to byte 
		 // i > 255, num1 = 300 -  255 
		
		// char to int  
		
		// double to byte
		
		// double to int 
		
		System.out.println("int    : " + i + "\t\tbyte: " + co.intToByte(i)); 
		System.out.println("char   : " + c + "\t\tint : " + co.charToInt(c)); 
		System.out.println("double : " + d + "\t\tbyte: " + co.doubleToByte(d)); 
		System.out.println("double : " + d + "\t\tint : " + co.doubleToInt(d)); 	
	} 
	
} 
