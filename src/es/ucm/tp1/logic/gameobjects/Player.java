package es.ucm.tp1.logic.gameobjects;

public class Player {
	
	private int x;
	private int y;
	private boolean alive;
	
	public Player (int y) {
		this.alive = true;
		this.y = y;
	}
	
	public boolean isInPosition(int x, int y) {
		return (this.x == x && this.y ==y);
	}
	
	public String toString() {
		if(this.alive)
			return ">";
		else
			return "@";
	}

	public boolean alive() {
		return this.alive;
	}

	public int getY() {
		return this.y;
	}
	
	public void kill() {
		this.alive = false;
	}
}
