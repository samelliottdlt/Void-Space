package rbadia.voidspace.model;

import java.awt.Rectangle;
import java.util.Random;

import rbadia.voidspace.main.GameScreen;

public class EnemyShip1 extends Rectangle {
	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_SPEED = 4;
	
	private int esWidth = 35;
	private int esHeight = 35;
	private int speed = DEFAULT_SPEED;

	private Random rand = new Random();
	
	
	public EnemyShip1(GameScreen screen){
		this.setLocation(
        		rand.nextInt(screen.getWidth() - esWidth),
        		40);
		this.setSize(esWidth, esHeight);
	}
	
	public int getESWidth() {
		return esWidth;
	}
	public int getESHeight() {
		return esHeight;
	}

	
	public int getSpeed() {
		return speed;
	}
	
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	public int getDefaultSpeed(){
		return DEFAULT_SPEED;
	}

	
}
