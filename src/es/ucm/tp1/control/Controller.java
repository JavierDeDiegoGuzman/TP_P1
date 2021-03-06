package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobjet info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */

	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(this.game);
	}

	public void printGame() {
		System.out.println(printer);
	}
	
	public void takeCommand() {
		String command;
		System.out.print(PROMPT);
		command = this.scanner.nextLine();
		System.out.println(command);
		
		
	}
	
	public void update() {
		this.game.moveObjects();
		if(this.game.getObstacleList().obstacleInPosition(0, this.game.getPlayer().getY())) {
			this.game.killPlayer();
		}
		this.game.removeDeadObjects();
	}
	

	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}

	public void run() {
		do {
			printGame();
			takeCommand();
			update();
			System.out.println(!this.game.gameover());
		}while(!this.game.gameover());
	}

}
