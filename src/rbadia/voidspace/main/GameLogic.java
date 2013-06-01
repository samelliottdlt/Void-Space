package rbadia.voidspace.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import rbadia.voidspace.model.Asteroid;
import rbadia.voidspace.model.Bullet;
import rbadia.voidspace.model.EnemyBullets;
import rbadia.voidspace.model.EnemyShip1;
import rbadia.voidspace.model.Ship;
import rbadia.voidspace.sounds.SoundManager;


/**
 * Handles general game logic and status.
 */
public class GameLogic {
	private GameScreen gameScreen;
	private GameStatus status;
	private SoundManager soundMan;
	
	private Ship ship;
	private List<Asteroid> asteroids;
	//private EnemyShip1 enemyships;
	private List<Bullet> bullets;
	private List<EnemyBullets> enemybullets; 
	private Asteroid asteroid;
	private EnemyShip1 enemyship;
	/**
	 * Craete a new game logic handler
	 * @param gameScreen the game screen
	 */
	public GameLogic(GameScreen gameScreen){
		this.gameScreen = gameScreen;
		
		// initialize game status information
		status = new GameStatus();
		// initialize the sound manager
		soundMan = new SoundManager();
		
		// init some variables
		bullets = new ArrayList<Bullet>();
		asteroids = new ArrayList<Asteroid>();
		asteroid = new Asteroid(gameScreen);
		enemybullets = new ArrayList<EnemyBullets>();
	}

	/**
	 * Returns the game status
	 * @return the game status 
	 */
	public GameStatus getStatus() {
		return status;
	}

	public SoundManager getSoundMan() {
		return soundMan;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	/**
	 * Prepare for a new game.
	 */
	public void newGame(){
		status.setGameStarting(true);
		
		// init game variables
		bullets = new ArrayList<Bullet>();

		status.setShipsLeft(3);
		status.setGameOver(false);
		status.setAsteroidsDestroyed(0);
		status.setNewAsteroid(false);
		status.setNewEnemyShipsDestroyed(0);
		status.setNewEnemyShip1(false);
				
		// init the ship and the asteroid
        newShip(gameScreen);
        newAsteroid(gameScreen);
        newEnemyShip1(gameScreen);
        
        // prepare game screen
        gameScreen.doNewGame();
        
        // delay to display "Get Ready" message for 1.5 seconds
		Timer timer = new Timer(1500, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				status.setGameStarting(false);
				status.setGameStarted(true);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	/**
	 * Check game or level ending conditions.
	 */
	public void checkConditions(){
		// check game over conditions
		if(!status.isGameOver() && status.isGameStarted()){
			if(status.getShipsLeft() == 0){
				gameOver();
			}
		}
	}
	
	/**
	 * Actions to take when the game is over.
	 */
	public void gameOver(){
		status.setGameStarted(false);
		status.setGameOver(true);
		gameScreen.doGameOver();
		
        // delay to display "Game Over" message for 3 seconds
		Timer timer = new Timer(3000, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				status.setGameOver(false);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	/**
	 * Fire a bullet from ship.
	 */
	public void fireBullet(){
		Bullet bullet = new Bullet(ship);
		bullets.add(bullet);
		soundMan.playBulletSound();
	}
	
	public void fireEnemyBullet(){
		EnemyBullets bullet = new EnemyBullets(enemyship);
		enemybullets.add(bullet);
		soundMan.playBulletSound();
	}
	
	/**
	 * Move a bullet once fired.
	 * @param bullet the bullet to move
	 * @return if the bullet should be removed from screen
	 */
	public boolean moveBullet(Bullet bullet){
		if(bullet.getY() - bullet.getSpeed() >= 0){
			bullet.translate(0, -bullet.getSpeed());
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean moveEnemyBullet(EnemyBullets enemybullet){
		if(enemybullet.getY() - enemybullet.getSpeed() >= 0){
			enemybullet.translate(0, +enemybullet.getSpeed());
			return false;
		}
		else{
			return true;
		}
	}
	/**
	 * Create a new ship (and replace current one).
	 */
	public Ship newShip(GameScreen screen){
		this.ship = new Ship(screen);
		return ship;
	}
	
	/**
	 * Create a new asteroid.
	 */
	public void newAsteroid(GameScreen gameScreen){
		asteroids.add(new Asteroid(gameScreen));
	}
	
	public EnemyShip1 newEnemyShip1(GameScreen gameScreen){
		this.enemyship = new EnemyShip1(gameScreen);
		return enemyship;
	}
	
	/**
	 * Returns the ship.
	 * @return the ship
	 */
	public Ship getShip() {
		return ship;
	}
	public EnemyShip1 getEnemyShip1() {
		return enemyship;
	}

	/**
	 * Returns the asteroid.
	 * @return the asteroid
	 */
	public List<Asteroid> getAsteroid() {
		return asteroids;
	}
	
	public Asteroid getIndAsteroid(){
		return asteroid;
	}
	/**
	 * Returns the list of bullets.
	 * @return the list of bullets
	 */
	public List<Bullet> getBullets() {
		return bullets;
	}
	public List<EnemyBullets> getEnemyBullets() {
		return enemybullets;
	}
}
