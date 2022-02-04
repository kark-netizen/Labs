import java.io.*;
import java.util.*;
class pathMethods {
	public int getDirectories(File dir , String directories[]) {
		String contents[];
		contents = dir.list();
		int contentCount = dir.list().length;
		
		if(contentCount == 0) {
			System.out.println("The Direcory is Empty");
		}
		int j = 0;
		for(int i = 0 ; i < contentCount ; i++) {
			String content = contents[i];
			if(content.indexOf('.') == -1) {
				directories[j++] = content;
			}
		}
		return j;
	}
	public int getFiles(File dir , String files[]) {
		String contents[];
		contents = dir.list();
		int contentCount = dir.list().length;
		
		if(contentCount == 0) {
			System.out.println("The Direcory is Empty");
		}
		int j = 0;
		for(int i = 0 ; i < contentCount ; i++) {
			String content = contents[i];
			if(content.indexOf('.') != -1) {
				files[j++] = content;
			}
		}
		return j;
	}
	public void getFilesDirectories(String dirPath) throws IOException{
		String contents[] , files[] , directories[];
		File path = new File(dirPath);
		contents = path.list();
		int contentCount = path.list().length;
		files = new String[contentCount];
		directories = new String[contentCount];
		
		int fileCount = getFiles(path , files);
		int dirCount = getDirectories(path, directories);	
		
		System.out.println("Files are : ");
		printFiles(files, fileCount);
		System.out.println("Directories are : ");
		printFiles(directories, dirCount);
	}
	public void printFiles(String contents[] , int length) {
		for(int i = 0 ; i < length ; i++) {
			System.out.println(contents[i]);
		}
		System.out.println();
	}
	public void displayCanonicalPath(String relPath) {
	
		try{
			File f = new File(relPath);
			String canonical = f.getCanonicalPath();
			System.out.println("Relative file path : " + f.getPath());
			System.out.println("Canonical file path : " + canonical);
		}catch(IOException E) {
			System.out.println("Invalid Path");
		}
	}
}
public class filepaths {
	public void getFileDirectoryInput(pathMethods pm) throws IOException {
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Input Directory Path : ");
			String path = sc.next();
	
			pm.getFilesDirectories(path);
		}catch(IOException E) {
			System.out.println("Invalid Path");
		}catch(InputMismatchException E2) {
			System.out.println("Invalid Input");
		}
	}
	public void getRelativePathInput(pathMethods pm) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input Relative Path");
		String path = sc.next();
		
		pm.displayCanonicalPath(path);
	}
 	public static void main(String args[]) throws IOException{
		filepaths fp = new filepaths();
		pathMethods pm = new pathMethods();
		fp.getFileDirectoryInput(pm);
		fp.getRelativePathInput(pm);
		
	}
}

/*
C:\\Users
*/











































