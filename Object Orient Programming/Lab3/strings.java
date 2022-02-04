import java.util.InputMismatchException;
import java.util.Scanner;

public class strings {
	public void work() {
		try {
			String s1, s2;
			int choice;
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter string one: ");
			s1 = sc.next();
			System.out.print("Enter string two: ");
			s2 = sc.next();
			System.out.print("Enter 1 to compare the two strings: ");
			System.out.print("\nEnter 2 to convert the uppercase character to lower and vice-versa: ");
			System.out.print("\nEnter 3 to display whether an entered string is a substring of the other or not: ");
			System.out.print(
					"\nEnter 4 to check if the entered string is a substring of the other, replace it with Hello: ");
			System.out.print("\nEnter 0 to exit: ");
			for (;;) {
				System.out.print("\nEnter choice: ");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					match(s1, s2);
					break;
				case 2:
					convert(s1, s2);
					break;
				case 3:
					check(s1, s2);
					break;
				case 4:
					change(s1, s2);
					break;
				case 0:
					return;
				default:
					System.out.print("Wrng choice!!");
				}
			}
		} catch (InputMismatchException e) {
			System.err.print("Marks should be float only.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.print("\nArray index has gone.");
		}
	}

	public void match(String str1, String str2) {
		if (str1.compareToIgnoreCase(str2) == 0)
			System.out.print("The two strings are the same.\n");
		else
			System.out.print("The two strings are not the same.\n");
	}

	public void convert(String str1, String str2) {
		int i;
		String c1 = "", c2 = "";
		char c;
		System.out.print("Before converting(string 1): " + str1);
		System.out.println();
		for (i = 0; i < str1.length(); i++) {
			if (Character.isLowerCase(str1.charAt(i))) {
				c1 += Character.toUpperCase(str1.charAt(i));
			} else if (Character.isUpperCase(str1.charAt(i))) {
				c1 += Character.toLowerCase(str1.charAt(i));
			} else {
				c1 += str1.charAt(i);
			}
		}
		System.out.print("After converting(string 1): " + c1);
		System.out.println();
		System.out.print("Before converting(string 1): " + str2);
		System.out.println();
		for (i = 0; i < str2.length(); i++) {
			if (Character.isLowerCase(str2.charAt(i))) {
				c2 += Character.toUpperCase(str2.charAt(i));
			} else if (Character.isUpperCase(str2.charAt(i))) {
				c2 += Character.toLowerCase(str2.charAt(i));
			} else {
				c2 += str2.charAt(i);
			}
		}
		System.out.print("After converting(string 1): " + c2);
		System.out.println();
	}

	public void check(String str1, String str2) {
		int n = str2.length();
		for( int i = 0 ; i <= str1.length() - n ; i++) {
			if(str2.equalsIgnoreCase(str1.substring(i,i+n))) {
				System.out.print("String2 substring of String1.");
				return;
			}
		}
		n = str1.length();
		for( int i = 0 ; i <= str2.length() - n ; i++) {
			if(str1.equalsIgnoreCase(str2.substring(i,i+n))) {
				System.out.print("String1 substring of String2.");
				return;
			}
		}
		System.out.print("They are not a substring of the other.");
		System.out.println();
	}

	public void change(String str1, String str2) {
		if (str1.contains(str2)) {
			str1 = str1.replaceAll(str2, "Hello");
			System.out.println("New string: " + str1);
		} else if (str2.contains(str1)) {
			str2 = str2.replaceAll(str1, "Hello");
			System.out.println("New string: " + str2);
		} else
			System.out.print("They are not a substring of the other.");
		System.out.println();
	}

	public static void main(String args[]) {
		strings ob = new strings();
		ob.work();
	}
}