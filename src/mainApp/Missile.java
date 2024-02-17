package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;

/**
 * Class: Missile
 * 
 * @author Bennett <br>
 *         Purpose: Used to create Missile objects and draw them <br>
 *         Restrictions: Cannot be used for anything other than missiles <br>
 *         For example:
 * 
 *         <pre>
 *         Missile missile = new Missile(2000, 500, 50, 25, 40);
 *         </pre>
 */

public class Missile extends GameObject {

	public Missile(int x, int y, int width, int height, int constantSpeed) {
		super(x, y, width, height, Color.ORANGE, constantSpeed);
	}

	public Missile(int width, int height, Color color, int constantSpeed) {
		super(1125, 0, width, height, color, constantSpeed);
	}

	/**
	 * ensures: The Missile is drawn on the screen
	 */
	@Override
	public void drawOn(Graphics2D g) {
		Rectangle body = new Rectangle(super.x + super.width / 5, super.y, (super.width * 3) / 5, height);
		Arc2D.Double tip = new Arc2D.Double((double) super.x, (double) super.y, (super.width * 2) / 5, super.height,
				90.0, 180.0, Arc2D.OPEN);
		g.setColor(super.color);
		g.fill(body);
		g.fill(tip);
		g.draw(body);
		g.draw(tip);
	}

	/**
	 * ensures: The true is returned if the Hero and missile are overlapping
	 * 
	 * @param Hero used to check if the coin and hero overlap
	 */
	@Override
	protected boolean overlapsWith(Hero hero) {
		int xDiff = super.x - hero.x;
		int yDiff = super.y - hero.y;
		double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		return this.width / 2 + hero.width / 2 >= distance;
	}

	/**
	 * ensures: Returns True because it is Missile
	 */
	@Override
	protected boolean isMissile() {
		return true;
	}

	@Override
	protected void overlapping() {
		System.out.println("PLAYER WAS HIT");
	}

}
