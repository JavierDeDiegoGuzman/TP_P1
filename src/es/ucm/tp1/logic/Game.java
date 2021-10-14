package es.ucm.tp1.logic;
import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.Obstacle;
import es.ucm.tp1.logic.gameobjects.ObstacleList;
import es.ucm.tp1.logic.gameobjects.Player;

public class Game {
	
	private long seed;
	private Level level;
	private boolean isTestMode;
	private Player player;
	private ObstacleList obstaclelist;
	private Random random;
	
	public Game (long seed, Level level, boolean isTestMode){
		this.seed = seed;
		this.level = level;
		this.isTestMode = isTestMode;
		this.obstaclelist = new ObstacleList();
		this.player = new Player(this.level.getWidth()/2);
		this.random = new Random(this.seed);
		
		generateObjects();
		
	}
	
	private void generateObjects() {
		for(int x = this.level.getVisibility()/2; x < this.level.getLenght(); x++) {
			this.obstaclelist.tryAddObstacle(new Obstacle(x, getRandomLane()), this.level.getObstacleFrecuency(), getRandomDouble());
		}

	}
	public int getVisibility() {
		return level.getVisibility();
	}
	
	public int getRoadWidth() {
		return this.level.getWidth();
	}

	public String positionToString(int x, int y) {
		String output = " ";
		if(this.player.isInPosition(x, y))
			output = this.player.toString();
		else if(this.obstaclelist.obstacleInPosition(x,y))
			output = this.obstaclelist.obstacleIn(x, y).toString();
		return output;
	}
	
	private int getRandomLane(){
		return random.nextInt(this.level.getWidth()) ;
	}

	private double getRandomDouble() {
		return this.random.nextDouble();
	}

	public String getInfo() {
		return
				"\nDistance: "+
				"\nCoins: " +
				"\nCycle: " +
				"\nTotal obstacles: " + this.obstaclelist.getPointer()+
				"\nTotal coins:";
	}
	
	public ObstacleList getObstacleList() {
		return this.obstaclelist;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public boolean gameover() {
		return !this.player.alive();
	}

	public void moveObjects() {
		this.obstaclelist.moveObjects();
	}
	
	public void removeDeadObjects() {
		this.obstaclelist.removeDeadObstacles();
	}
	
	public void killPlayer() {
		this.player.kill();
	}
}
