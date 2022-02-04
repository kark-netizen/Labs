import java.io.*;
import java.util.*;
class countMethods{
	public int countCharacters(String line) {
		int n;
		return n = line.length();
	}

	public int countWords(String line) {
		line += " ";
		int n , words = 0;
		n = line.length();
		for(int i = 0 ; i < n; i++) {
			char ch = line.charAt(i);
			if(ch == ' ') {
				words++;
			}
		}
		return words;
	}
	public int countVowels(String line) {
		String vowelString = "AEIOUaeiou";
		int n , vowels = 0 ;
		n = line.length();
		for(int i = 0 ; i < n ; i++) {
			char ch = line.charAt(i);
			if(vowelString.indexOf(ch) != -1) {
				vowels++;
			}
		}
		return vowels;
	}
}

public class filehandling {
	public void getInput() throws IOException  {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input File Path");
		
		String path = sc.next();
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String st;
		
		countMethods cm = new countMethods();
		int characters , vowels , words , lines;
		lines = 0;
		words = 0;
		vowels = 0;
		characters = 0;
		while((st = br.readLine()) != null) {
			lines++;
			words += cm.countWords(st);
			vowels += cm.countVowels(st);
			characters += cm.countCharacters(st);
		}
		System.out.println("Lines\t\t" + lines);
		System.out.println("Words\t\t" + words);
		System.out.println("Vowels\t\t" + vowels);
		System.out.println("Characters\t" + characters);
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		filehandling fh = new filehandling();
		fh.getInput();
		
	}

}
/*
input.txt
*/
