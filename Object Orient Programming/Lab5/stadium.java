package eval2;
import java.util.*;
interface sports
{
	abstract void getNumberOfGoals();
	public abstract void dispTeam();
}
class hockey implements sports{
	Scanner sc = new Scanner(System.in);
	String player;
	int goals;
	public hockey(String player){
		this.player = player;
		this.goals = 0;
	}
	public void dispTeam() {
		System.out.println("Player: " + player);
		System.out.println("Goals : " + goals);
	}
	public void getNumberOfGoals() {
		System.out.println("Input Goals :");
		goals = sc.nextInt();
	}
}
class football implements sports{
Scanner sc = new Scanner(System.in);
String player;
int goals;
	public football(String player){
		this.player = player;
		this.goals = 0;
	}
	public void dispTeam() {
		System.out.println("Player: " + player);
		System.out.println("Goals : " + goals);
	}
	public void getNumberOfGoals() {
		System.out.println("Input Goals :");
		goals = sc.nextInt();
	}
}
public class stadium {
	public void getFootballPlayers(stadium st) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Playing FOOTBALL!");
		System.out.println("Input Number of Football Players :");
		int n1 = sc.nextInt();
		football fc[] = new football[n1];
		for(int i = 0 ; i < n1 ; i ++) {
			fc[i] = st.inputfootball();
		}
		for(int i = 0 ; i < n1 ; i ++) {
			fc[i].dispTeam();
		}
	}
	public void getHockeyPlayers(stadium st) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Playing HOCKEY!");
		System.out.println("Input Number of Hockey Players :");
		int n2 = sc.nextInt();
		hockey hc[] = new hockey[n2];
		for(int i = 0 ; i < n2 ; i ++) {
			hc[i] = st.inputhockey();
		}
		for(int i = 0 ; i < n2 ; i ++) {
			hc[i].dispTeam();
		}
	}
	public hockey inputhockey() {
		System.out.println("Input Hockey Player :");
		hockey hc = new hockey("");
		Scanner sc = new Scanner(System.in);
		try{
			String player = sc.nextLine();
			hc = new hockey(player);
			hc.getNumberOfGoals();
			if(hc.goals < 0){
				throw new InputMismatchException("Goals can't be Negative");
			}
			
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("Try Again.");
			hc.getNumberOfGoals();
		}
		return hc;
	}
	public football inputfootball() {
		System.out.println("Input Football Player :");
		football fc = new football("");
		Scanner sc = new Scanner(System.in);
		try{
			String player = sc.nextLine();
			fc = new football(player);
			fc.getNumberOfGoals();
			if(fc.goals < 0){
				throw new InputMismatchException("Goals can't be Negative");
			}
			
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("Try Again.");
			fc.getNumberOfGoals();
		}
		return fc;
	}
	public static void main(String args[]) {
		stadium st = new stadium();
		st.getFootballPlayers(st);
		st.getHockeyPlayers(st);
	}
}

