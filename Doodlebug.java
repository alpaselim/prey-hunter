
import java.util.Random;

public class Doodlebug extends Organism {

	public String name = "X";
	public int timeCount;
	public int flag;
	
	
	
	
	public Doodlebug() {
		super("X");
		
		
		
	}
	
	public Doodlebug breed() {
		
		return new Doodlebug();
	}
	
	public int move() {
		 Random rand = new Random(); 
		 int way = rand.nextInt(4); 
		 return way; 
	}
	 
	public boolean equals(Object obj) {
			
			if(obj == null)
				return false;
			if(obj.getClass() == this.getClass()) {
				Doodlebug a = (Doodlebug)obj;
				return this.name == a.name;
			}
			
			return false;
	}
	
}
