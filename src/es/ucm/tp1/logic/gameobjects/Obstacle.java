package es.ucm.tp1.logic.gameobjects;

public class Obstacle {
	
	private int x;
	private int y;
	
	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public String toString() {
		return "░";
	}
	
	public void move(int i) {
		this.x += i;
	}
}
