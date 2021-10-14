package es.ucm.tp1.logic.gameobjects;

public class ObstacleList {
	private static final int MAX = 100;
	private Obstacle[] list;
	private int pointer;
	
	public ObstacleList () {
		this.list = new Obstacle [MAX];
		this.pointer = 0;
	}
	
	public boolean obstacleInPosition (int x, int y) {
		boolean found = false;
		int i = 0;
		while(!found && i < this.pointer){
			if(this.list[i].getX()==x && this.list[i].getY()==y)
				found = true;
			else
				i++;
		}
		return found;
	}
	
	public Obstacle obstacleIn(int x, int y) {
		Obstacle output = null;
		boolean found = false;
		int i = 0;
		while(!found && i < this.pointer){
			if (this.list[i].getX()==x && this.list[i].getY()==y) {
				found = true;
				output = this.list[i];
			}
		}
		return output;
	}
	
	public void tryAddObstacle(Obstacle obstacle, double frecuency,double probability) {
		if(probability > frecuency)
			addObstacle(obstacle);
	}
	
	public void addObstacle (Obstacle obstacle) {
		this.list[pointer] = obstacle;
		pointer ++;
			
	}

	public String getPointer() {
		return String.valueOf(this.pointer);
	}
	public void printList() {
		for(int i = 0; i < this.pointer; i++) {
			System.out.println("Element:" + String.valueOf(i));
			System.out.println(this.list[i].getX());
			System.out.println(this.list[i].getY());			
		}
	}
	
	public void moveObjects() {
		for(int i = 0; i < this.pointer; i++) {
			this.list[i].move(-1);
		}
	}
	
	public void removeDeadObstacles() {
		for(int i = 0; i < this.pointer; i++) {
			while(this.list[i].getX()< 0)
				removeObstacle(i);
		}
	}
	
	public void removeObstacle(int index) {
		for(int i = index; i < this.pointer; i++) {
			this.list[i] = this.list[i+1];
		}
		this.pointer--;
	}
}
