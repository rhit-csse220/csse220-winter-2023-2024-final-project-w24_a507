package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 * Abstract Class: GameObject
 * 
 * @author 507 group <br>
 *         Purpose: Used as a "base case" for most of the other objects (shapes
 *         on the screen)
 */
public abstract class GameObject implements Serializable {
	protected int x, y, constantSpeed, width, height;
	protected Color color;
	protected boolean offScreen;

	/**
	 * ensures: initializes the account name to accountName and balance to
	 * initialBalance
	 * 
	 * @param x,            y used to make the x and y of the object
	 * @param width,        height used to make the size of the object
	 * @param color         the color for the object
	 * @param constantSpeed the speed of the object
	 */
	public GameObject(int x, int y, int width, int height, Color color, int constantSpeed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.constantSpeed = constantSpeed;
		this.offScreen = false;
	}//GameObject

	/**
	 * ensures: it draws the object to the screen
	 * 
	 * @param the graphics2d variable
	 */
	abstract public void drawOn(Graphics2D g);

	/**
	 * ensures: checks if the object if off screen and therefore should be removed
	 */
	public void update() {
		x -= constantSpeed;

		if (x < 0) {
			offScreen = true;

		}
	}//update

	/**
	 * ensures: objects off screen are removed
	 * 
	 * @return rather or not the object is off the screen
	 */
	protected boolean isOffScreen() {
		return offScreen;
	}//isOffScreen

	/**
	 * ensures: it checks to see if the object has been hit by hero
	 * 
	 * @param hero the thing that may or may not be touching the other object
	 * @return rather or not the object is in contact with hero
	 */
	protected abstract boolean overlapsWith(Hero hero);

	/**
	 * ensures: doesn't do much here; is called if two things are overlapping
	 **/
	protected abstract void overlapping();

	/**
	 * ensures: just checks to see if the obj is a coin
	 */
	protected boolean isCoin() {
		return false;
	}//isCoin

	/**
	 * ensures: checks to see if the obj is in fact a barrier
	 **/
	protected boolean isBarrier() {
		return false;
	}//isBarrier

	/**
	 * ensures: just checks to see if it's an electric barrier
	 */
	protected boolean isElectricBarrier() {
		return false;
	}//isElectricBarrier

	/**
	 * ensures: just checks to see if it's a missile
	 */
	protected boolean isMissile() {
		return false;
	}//isMissile

	/**
	 * ensures: just checks to see if it's a homing missile
	 */
	protected boolean isHomingMissile() {
		return false;
	}//isHomingMissile
}
