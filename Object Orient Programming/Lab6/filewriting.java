import java.io.*;
import java.util.*;
class fileMethods{
	public void readMethod() throws IOException{
		try {
			File file = new File("input.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			System.out.println("Here is What I Read:\n");
			while((st = br.readLine()) != null) {
				System.out.println(st);
			}
		}catch(IOException E){
			System.out.println("File Not Found");
		}
	}
	public void writeMethod() throws IOException{
		Scanner sc = new Scanner(System.in);
		try {
			FileWriter fw = new FileWriter("output.txt");
			System.out.println("What do you want to write?");
			String write = sc.nextLine();
			fw.write(write);
			fw.close();
			System.out.println("Done Writing");
		}
		catch(IOException E){
			System.out.println("File Not Found");
		}
	}
	public void copyMethod() throws IOException{
		File file = new File("input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		File fileInput = new File("input.txt");
		BufferedReader brInput = new BufferedReader(new FileReader(file));
		
		FileWriter fw = new FileWriter("copyInput.txt");
		
		System.out.println("Starting to Copy from " + "input.txt" );
		String st;
		 while((st = brInput.readLine()) != null) {
			 fw.write(st);
			 fw.write("\n");
		 }
		 System.out.println("Done Copying to " + "copyInput.txt");
		 fw.close();
		 br.close();
	}
}
public class filewriting {
	public fileMethods displayMenu(fileMethods fm) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("R to Read");
		System.out.println("W to Write");
		System.out.println("C to Copy");
		System.out.println("T to Terminate");
		
		char ch;
		ch = sc.next().charAt(0);
		
		while(ch != 'T') {
			switch(ch) {
			case 'R':
				fm.readMethod();
				break;
			case 'W':
				fm.writeMethod();
				break;
			case 'C':
				fm.copyMethod();
				break;
			default:
				System.out.println("Invalid Input");
			}
			ch = sc.next().charAt(0);
		}
		return fm;
	}
	public static void main(String[] args) throws IOException{
		fileMethods fm = new fileMethods();
		filewriting fw = new filewriting();
		fm = fw.displayMenu(fm);
		
	}
}
