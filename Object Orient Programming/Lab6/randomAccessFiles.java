import java.io.*;
import java.util.*;
class randomFileMethods {
	public void readMethod(String path, int start , int length) throws IOException{
		RandomAccessFile file = new RandomAccessFile(path , "r");
		file.seek(start);
		byte[] bytes = new byte[length];
		file.read(bytes);
		System.out.println("Here is what I read!\n");
		for(byte ind : bytes ) {
			char ch = (char)ind;
			System.out.print(ch + " ");
		}
	}
	public void writeMethod(String path, int start ) throws IOException{
		RandomAccessFile file = new RandomAccessFile(path, "rw");
		Scanner sc = new Scanner(System.in);
		
		file.seek(start);
		System.out.println("Input Lines");
		String line = sc.next();
		
		while(line.equals("END") == false) {
			file.write(line.getBytes());  
			file.write("\n".getBytes());
			line = sc.next();
		}
		file.close(); 
		System.out.println("Done Writing");
	}
}
public class randomAccessFiles { 
	public void getInput() throws IOException {
		Scanner sc = new Scanner(System.in);
		randomFileMethods rf = new randomFileMethods();
		
		System.out.println("Input Path to Read: ");
		String path = sc.next();
		System.out.println("Input Start Index and Length");
		int start = sc.nextInt() , length = sc.nextInt();
		rf.readMethod(path, start, length);
		System.out.println();
		System.out.println("Input Path to write: ");
		String path2 = sc.next();
		System.out.println("Input Start Index");
		int start2 = sc.nextInt() ;
		rf.writeMethod(path2, start2);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/* randomAccessFiles ra = new randomAccessFiles();
		ra.getInput(); */
		try{
			throw new Exception(10);
		}catch(Exception e){
			System.out.println("a");
		}
	}

}
/*
randomAccessFileData.txt
*/
