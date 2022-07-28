
import java.util.Random;

public  class Ant extends Organism{
	
	public int timeCount;
	public String name = "o";
	public int flag;

	
	
	public Ant() {
		super("o");
		
	}
	
	public Ant breed() {
		
		return new Ant();
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
			Ant a = (Ant)obj;
			return this.name == a.name;
		}
		
		return false;
	}

}
