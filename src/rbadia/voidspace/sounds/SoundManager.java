package rbadia.voidspace.sounds;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.sound.sampled.AudioInputStream;

import rbadia.voidspace.main.GameScreen;

/**
 * Manages and plays the game's sounds.
 */
public class SoundManager {
	private static final boolean SOUND_ON = true;

	private AudioClip shipExplosionSound = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/shipExplosion.wav"));
	private AudioClip bulletSound = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/laser.wav"));
	private AudioClip bgm = Applet.newAudioClip(GameScreen.class.getResource(
			"/rbadia/voidspace/sounds/Spacewalk.wav"));

	/**
	 * Plays sound for bullets fired by the ship.
	 */
	public void playBulletSound(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					bulletSound.play();
				}
			}).start();
		}
	}

	/**
	 * Plays sound for ship explosions.
	 */
	public void playShipExplosionSound(){
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					shipExplosionSound.play();
				}
			}).start();
		}
	}

	/**
	 * Plays sound for asteroid explosions.
	 */
	public void playAsteroidExplosionSound(){
		// play sound for asteroid explosions
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					shipExplosionSound.play();
				}
			}).start();
		}
	}
	public void playEnemyShipExplosionSound(){
		// play sound for asteroid explosions
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					shipExplosionSound.play();
				}
			}).start();
		}
	}
	public void music() {
		if(SOUND_ON){
			new Thread(new Runnable(){
				public void run() {
					bgm.loop();
				}
			}).start();
		}

	}
}
