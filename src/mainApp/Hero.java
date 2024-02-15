package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

import org.w3c.dom.css.RGBColor;

/**
 * Class: Hero
 * 
 * @author group 507 <br>
 *         Purpose: used to hold methods for player <br>
 *         For example:
 * 
 *         <pre>
 *         Hero hero1 = new Hero(100, 100, 50, 50, 10);
 *         </pre>
 */
public class Hero extends GameObject implements Serializable {
	private boolean up = false;
	private Color heroColor = new Color(97, 75, 164);

	/**
	 * ensures: initializes the x,y,width,height and constSpeed to
	 * x,y,width,height,constSpeed
	 * 
	 * @param x,y           are used to initialize the location of the hero
	 * @param width,        height are used to initialize dimensions of the hero
	 * @param constantSpeed is used to set the speed for which the hero moves up
	 **/
	public Hero(int x, int y, int width, int height, int constSpeed) {
		super(x, y, width, height, Color.BLACK, constSpeed); // calling gameObj
	}// Hero

	/**
	 * ensures: it draws the hero to the screen
	 * 
	 * @param the graphics2d variable
	 */
	@Override
	public void drawOn(Graphics2D g) {

		Rectangle heroBox = new Rectangle(x, y, 50, 50);
		g.setColor(heroColor);
		g.fill(heroBox);
		g.draw(heroBox);

	}// drawOn

	/**
	 * ensures: the hero's position is changed depending on what is happening
	 */
	@Override
	public void update() //
	{
		if (up) {
			y -= super.constantSpeed;

			if (y < 0) {
				y = 0;
			}
		} else {
			y += 10;
			if (y > 620) {
				y = 620;
			}
		}
		this.up = false;

	}// update

	/**
	 * ensures: pretty pointless, but it gets mad if we take it away
	 * 
	 * @param hero the hero it is maybe overlapping with
	 * @return rather or not the hero is overlapping with itself (always)
	 */
	@Override
	protected boolean overlapsWith(Hero hero) {
		return true;
	}// overlapsWith

	/**
	 * ensures: also fairly pointless and mainly for the other classes
	 */
	@Override
	protected void overlapping() {
		return;
	}// overlapping

	/**
	 * ensures: used to make sure hero is moving in the right direction
	 * 
	 * @param up rather or not the up arrow was pressed (meaning the hero needs to
	 *           go up)
	 */
	protected void isUp(boolean up) {
		this.up = up;
	}// isUp

	/**
	 * ensures: used to set the color of hero
	 * 
	 * @param color is the color we want hero to be
	 */
	protected void setColor(Color color) {
		this.heroColor = color;
	}// setColor

}