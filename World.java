
import java.util.Random;


public class World {
	
	public Organism[][] grid = new Organism[20][20];  //world
	
	public void starvecount() {

        for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				try {
				if(grid[i][j] == null || grid[i][j].name.equals("o"))
					System.out.print("- ");
				else if(grid[i][j].name.equals("X"))
					System.out.print(grid[i][j].starveTime + " ");	
				}catch(NullPointerException e){
					
				}
			}
			System.out.println();
		}
	}
	
	
	
	public void createGrid() {  // worlde Ant ve Doodlebuglari yerlestiren metot
		 Random rand = new Random(); 
		 int row = 0;
		 int col = 0; 
		 int count = 0;
		 while(count < 100) {
			 row = rand.nextInt(20); 
			 col = rand.nextInt(20); 
			 if(grid[row][col] == null) {
				 grid[row][col] = new Ant();
				 count++;
			 }
		 }
		 count = 0;
		 while(count < 5) {
			 row = rand.nextInt(20); 
			 col = rand.nextInt(20); 
			 if(grid[row][col] == null) {
				 grid[row][col] = new Doodlebug();
				 count++;
			 }
		 }
	}
	
	public void printGrid(){  // worldu print eden metot

        for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if(grid[i][j] == null)
					System.out.print("- " );
				else
					System.out.print(grid[i][j].name+" ");
				
			}
			System.out.println();
		}
	}
	
	public void canAntsMove() { //world uzurindeki karincalari bulup hareket ettiren metot
		for (int i = 0; i < 20; i++) {  
			for (int j = 0; j < 20; j++) {
				try {
					if(grid[i][j].name.equals("o")) {
						int w = grid[i][j].move();
						if(grid[i][j].flag==0)  
							moveTheAnts(i,j,w); 
					}
				}catch(NullPointerException e) {
					
				}	
		
			}
		}
		
	}
	
	public void moveTheAnts(int row, int col, int w) { //hareketin gerceklestigi metot
		try {
			if(w == 0) {
				if(grid[row - 1][col] == null) {
					grid[row - 1][col] = grid[row][col].clone();
					grid[row - 1][col].flag=1;
					grid[row][col] = null;		
				}
				
			}
			if(w == 1) {
				if(grid[row][col + 1] == null) {
					grid[row][col + 1] = grid[row][col].clone();
					grid[row][col + 1].flag=1;
					grid[row][col] = null;
				}
				
			}
			if(w == 2) {
				if(grid[row + 1][col] == null) {
					grid[row + 1][col] = grid[row][col].clone();
					grid[row + 1][col].flag=1;
					grid[row][col] = null;
				}
			}
			if(w == 3) {
				if(grid[row][col - 1] == null) {
					grid[row][col - 1] = grid[row][col].clone();
					grid[row][col - 1].flag=1;
					grid[row][col] = null;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
		
				

		}catch(NullPointerException e) {
			
		}
	}
	
	public void canDoodlebugMove() { //world uzerindeki doodlebuglari bulup hareket ettiren metot
		for (int i = 0; i < 20; i++) {  
			for (int j = 0; j < 20; j++) {
				try {
					if(grid[i][j].name.equals("X")) {
						int w = grid[i][j].move();
						if(grid[i][j].flag==0) 	{
							grid[i][j].starveTime--; // hareket gerceklesecegi icin starveTime bir azaliyor
							moveTheDoodlebugs(i,j,w);
						}
					}
				}catch(NullPointerException e) {
					
				}	
		
			}
		}
		
		
	}
	public boolean control(int row,int col) { // hareket edilen yerde karinca olup olmadigini kontrol eden metot
		try {
			if(grid[row][col] != null && grid[row][col].name.equals("o"))
				return true;
			else
				return false;
		}catch(ArrayIndexOutOfBoundsException e) {
			
			return false;
		}catch(NullPointerException e) {
			return false;
		}
		 
	}
	
	public boolean control2(int row,int col) { //hareket edilen yerin null olup olmadigini kontrol eden metot
		try {
			if(grid[row][col] == null)
				return true;
			else
				return false;
		}catch(ArrayIndexOutOfBoundsException e) {
			
			return false;
			
		}catch(NullPointerException e) {
			
			return false;
		}
		 
	}
	
	
	
	public void moveTheDoodlebugs(int row, int col, int w) {

		
			if( control(row-1, col)) {
				grid[row - 1][col] = grid[row][col].clone();
				grid[row - 1][col].starveTime =3;     // hareket edilen yerde karinca oldugu icin starveTime guncelleniyor
				grid[row - 1][col].flag=1;			// hareket gerceklestigi icin flag 1 oluyor
				grid[row][col] = null;		
			}
			else if(control(row, col + 1)) {
				grid[row][col + 1] = grid[row][col].clone();
				grid[row][col + 1].starveTime = 3;
				grid[row][col + 1].flag=1;
				grid[row][col] = null;
			}
			else if( control(row+1, col)) {
				grid[row + 1][col] = grid[row][col].clone();
				grid[row + 1][col].starveTime =3;
				grid[row + 1][col].flag=1;
				grid[row][col] = null;
			}
			else if( control(row, col-1)) {
				grid[row][col - 1] = grid[row][col].clone();
				grid[row][col - 1].starveTime =3;
				grid[row][col - 1].flag=1;
				grid[row][col] = null;
			}
			
			else if(w == 0) {
				if(control2(row-1, col)) {
					grid[row - 1][col] = grid[row][col].clone();
					grid[row - 1][col].flag=1;
					grid[row][col] = null;		
				}
				
				
			}
			else if(w == 1) {
				if(control2(row, col + 1)) {
					grid[row][col + 1] = grid[row][col].clone();
					grid[row][col + 1].flag=1;
					grid[row][col] = null;
				}
				
			}
			else  if(w == 2) {
				if( control2(row + 1, col)) {
					grid[row + 1][col] = grid[row][col].clone();
					grid[row + 1][col].flag=1;
					grid[row][col] = null;
				}
				
			}
			else if(w == 3) {
				if( control2(row, col-1)) {
					grid[row][col - 1] = grid[row][col].clone();
					grid[row][col - 1].flag=1;
					grid[row][col] = null;
				}
				
			}
		
		
		
		
	}
	
	public void dyingBugs() { //starveTimelari 0 a esit olan doodlebugslari worldden cikaran metot
		for (int i = 0; i < 20; i++) {  
			for (int j = 0; j < 20; j++) {
				try {
					if(grid[i][j].name.equals("X") && grid[i][j].starveTime == 0 ){  
					
						grid[i][j] = null;
					}
				}catch(NullPointerException e) {
					
				}	
		
			}
		}
		
	}
	
	public void reduceBreedCount() {  //her timeda tum canlilarin breedCountlarini bir azaltan metot
		
		 for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++){
				try {
					if(grid[i][j].gaveBirth == 0 && grid[i][j].breedTime==0)
						continue;
					
					grid[i][j].breedTime--;
					
				}catch(NullPointerException e) {
					
				}
			}
				
		}
	}
	
	public void resetFlag() {  // bir sonraki adim icin tum flaglari sifirliyan metot
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if(grid[i][j] != null)
					grid[i][j].flag=0;	
			}		
		}
	}
	
	public void birthAnt() { 
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				try {
				if(grid[i][j] != null && grid[i][j].name.equals("o") && grid[i][j].breedTime  == 0) {
											
					if(control2(i + 1, j)) {
						grid[i][j].gaveBirth = 1;  //dogum gerceklestigi icin 1 oluyor
						grid[i][j].breedTime = 3;	//breedTime guncelleniyor
						grid[i + 1][j] = grid[i][j].breed();
					}
					else if(control2(i, j + 1)) {
						grid[i][j].gaveBirth = 1;
						grid[i][j].breedTime = 3;
						grid[i][j + 1] = grid[i][j].breed();
					}
					else if(control2(i - 1, j)) {
						grid[i][j].gaveBirth = 1;
						grid[i][j].breedTime = 3;
						grid[i - 1][j] = grid[i][j].breed();
					}
					else if(control2(i , j - 1)) {
						grid[i][j].gaveBirth = 1;
						grid[i][j].breedTime = 3;
						grid[i][j - 1] = grid[i][j].breed();
					}
						
				}
				else
					grid[i][j].gaveBirth = 0; 
				}catch(Exception e) {
					
				}
					
			}	
		}
		
		
		
	}
	
	public void birthDoodlebug() {  
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				try {
					if(grid[i][j] != null && grid[i][j].name.equals("X")  && grid[i][j].breedTime == 0) {
					
						if(control2(i + 1, j)) {
							grid[i][j].gaveBirth = 1;
							grid[i + 1][j] = grid[i][j].breed();
							grid[i][j].breedTime=8;
						}
						else if(control2(i, j + 1)) {
							grid[i][j].gaveBirth = 1;
							grid[i][j + 1] = grid[i][j].breed();
							grid[i][j].breedTime=8;
						}
						else if(control2(i - 1, j)) {
							grid[i][j].gaveBirth = 1;
							grid[i - 1][j] = grid[i][j].breed();
							grid[i][j].breedTime=8;
						}
						else if(control2(i , j - 1)) {
							grid[i][j].gaveBirth = 1;
							grid[i][j - 1] = grid[i][j].breed();
							grid[i][j].breedTime=8;
						}	
						
						
					}
					else
						grid[i][j].gaveBirth = 0; 
					}catch(Exception e) {
						
					}
				}	
			}
		
	}
		

	
	public void time() {
		
		canDoodlebugMove();
		canAntsMove();
		resetFlag();
		dyingBugs();
		reduceBreedCount();
		birthDoodlebug();
		birthAnt();
		printGrid();

	}
	
	
	
}
