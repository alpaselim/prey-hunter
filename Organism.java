
import java.util.Random;


public  class Organism {
	
	public String name;
	public int timeCount;
	public int flag; // hareket eden canlinin ayni time icinde tekrar hareket etmesini engelliyor
	public int gaveBirth; //dogum gerceklestiyse 0 gerceklesmediyse 1 olan deger
	public int breedTime;
	public int starveTime;
	

	
	public Organism(String name) {
		this.name = name;
		timeCount = 0;
		flag = 0;
		gaveBirth = 0;
		if(name == "o")
			breedTime = 3;
		else {
			breedTime = 8;
			starveTime =3;
		}
		 
	}
	
	public Organism(Organism orig) {
		name = orig.name;
		timeCount = orig.timeCount;
		flag = orig.flag;
		gaveBirth = orig.gaveBirth;
		breedTime = orig.breedTime;
		starveTime = orig.starveTime;
		
		
	}
	
	public int move() {
		 Random rand = new Random(); 
		 int way = rand.nextInt(4); 
		 return way; 
	}

	
	public Organism clone() 
	{
	 return new Organism(this);
	}
	
	public Organism breed() {
		
		return new Organism(this.name);
	}
	
	public String toString() {
		return name;
	}
	
	
}
