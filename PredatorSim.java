
import java.util.Scanner;

public class PredatorSim {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		World w1 = new World();
		
		 Scanner keyboard = new Scanner(System.in);
		 String enterkey = "";
		 System.out.println("press enter");
		 System.out.println("START");
		 w1.createGrid();
		 w1.printGrid();
		 int count = 1;
		 do {
		  	enterkey = keyboard.nextLine(); 
		  	System.out.println("\t\t--  " + count + "  --  ");
		  	
		  	w1.time();  	
		  	count++;
		 }while(enterkey.equals(""));   
		
		
	
		 
	}
	
}
