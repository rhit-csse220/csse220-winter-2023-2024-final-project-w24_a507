package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

/**
 * Class: Coin
 * 
 * @author Keeley <br>
 *         Purpose: Used to create coins and draw them (int xPosition, int
 *         yPosition) <br>
 *         Restrictions: Only used to create coins <br>
 *         For example:
 * 
 *         <pre>
 *         Coin coin = new Coin(100, 50);
 *         </pre>
 */

public class Coin extends GameObject implements Serializable {

	private static int width = 20;
	private static int height = 20;
	public static boolean isMoving = true;

	public Coin(int x, int y) {
		super(x, y, width, height, Color.YELLOW, 10);
	}

	/**
	 * ensures: The coin is drawn on the screen
	 */
	@Override
	public void drawOn(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double coin1 = new Ellipse2D.Double(super.x, super.y, width, height);
		g2.setColor(super.color);
		g2.fill(coin1);
		g2.draw(coin1);
	}

	/**
	 * ensures: The true is returned if the Hero and coin are overlapping
	 * 
	 * @param Hero used to check if the coin and hero overlap
	 */
	@Override
	protected boolean overlapsWith(Hero hero) {
		int xDiff = super.x - hero.x;
		int yDiff = super.y - hero.y;
		double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		return distance <= 50;

	}

	/**
	 * ensures: Returns True because it is a coin
	 */
	@Override
	protected boolean isCoin() {
		return true;
	}

	/**
	 * ensures: Calls super.update if isMoving is true
	 */
	public void update() {
		if (isMoving) {
			super.update();
		}
	}

	@Override
	protected void overlapping() {
	}

}