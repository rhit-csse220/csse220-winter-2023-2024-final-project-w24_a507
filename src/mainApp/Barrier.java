package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.io.Serializable;

/**
 * Class: Barrier
 * 
 * @author group 507 <br>
 *         Purpose: Used to create barriers <br>
 *         For example:
 * 
 *         <pre>
 *         Barrier barrierE1 = new Barrier(200, 300, 50, 50, 0);
 *         </pre>
 */
public class Barrier extends GameObject implements Serializable {

	protected int rotation;
	Color colorOfBarrier;
	private double firstXCoord;
	private double firstYCoord;
	private double secondXCoord;
	private double secondYCoord;
	public static boolean isMoving = true;

	/**
	 * ensures: initializes x,y,width,height,rotation, and color to
	 * x,y,width,height,rotation,and color
	 * 
	 * @param x,y          used to set location of barrier
	 * @param width,height used to set size of barrier
	 * @param rotation     used to rotation of barrier
	 */
	public Barrier(int x, int y, int width, int height, int rotation) {
		super(x, y, width, height, Color.CYAN, 10);
		this.rotation = -rotation;
		this.colorOfBarrier = Color.CYAN;
	}// Barrier

	/**
	 * ensures: initializes x,y,width,height,rotation, and colorOfBarrier to
	 * x,y,width,height,rotation,and colorOfBarrier
	 * 
	 * @param x,y            used to set location of barrier
	 * @param width,height   used to set size of barrier
	 * @param rotation       used to rotation of barrier
	 * @param colorOfBarrier used to set color of barrier
	 */
	public Barrier(int x, int y, int width, int height, int rotation, Color colorOfBarrier) {
		super(x, y, width, height, colorOfBarrier, 10);
		this.rotation = -rotation;
		this.colorOfBarrier = colorOfBarrier;
	}// Barrier

	/**
	 * ensures: it draws the barrier to the screen
	 * 
	 * @param the graphics2d variable
	 */
	@Override
	public void drawOn(Graphics2D g) {
		g.translate(super.x, super.y);
		g.rotate(Math.toRadians(rotation));
		Rectangle bar = new Rectangle(0, 0, super.width, super.height);
		g.setColor(colorOfBarrier);
		g.fill(bar);
		g.draw(bar);
		g.rotate(Math.toRadians(-rotation));
		g.translate(-super.x, -super.y);
	}// drawOn

	/**
	 * ensures: the barrier's position is changed as they move across the screen
	 */
	public void update() {
		if (isMoving) {
			super.x -= super.constantSpeed;

			if (super.x + super.width * Math.cos(Math.toRadians(rotation)) < 0) {
				offScreen = true;

			}
		}
	}// update

	/**
	 * ensures: it checks to see if barrier has been hit by hero
	 * 
	 * @param hero the thing that may or may not be touching it
	 * @return rather or not a barrier is in contact with hero
	 */
	@Override
	public boolean overlapsWith(Hero hero) {
		return false;
	}// overlapsWith

	/**
	 * ensures: it checks to see if hero is touching top left of the barrier
	 * 
	 * @param other the hero that may or may not be touching it
	 * @return rather or not the barrier is in contact with hero
	 */
	public boolean overlapsWithTopLeft(Hero other) {
		firstXCoord = super.x + Math.sin(Math.toRadians(rotation)) * super.height;
		firstYCoord = super.y + Math.cos(Math.toRadians(rotation)) * super.height;

		secondXCoord = firstXCoord + Math.cos(Math.toRadians(rotation)) * super.width;
		secondYCoord = firstYCoord + Math.tan(Math.toRadians(rotation)) * (other.x - firstXCoord);

		if (other.x >= firstXCoord && other.x <= secondXCoord && other.y <= firstYCoord && other.y >= secondYCoord) {
			return true;
		} else {
			return false;
		}

	}// overlapsWithTopLeft

	/**
	 * ensures: it checks to see if hero is touching top right of the barrier
	 * 
	 * @param other the hero that may or may not be touching it
	 * @return rather or not the barrier is in contact with hero
	 */
	public boolean overlapsWithTopRight(Hero other) {
		int heroXRight = other.x + other.width;

		firstXCoord = super.x - Math.sin(Math.toRadians(rotation)) * super.height;
		firstYCoord = super.y + Math.cos(Math.toRadians(rotation)) * super.height;

		secondXCoord = firstXCoord + Math.cos(Math.toRadians(rotation)) * super.width;
		secondYCoord = firstYCoord + Math.tan(Math.toRadians(rotation)) * (heroXRight - firstXCoord);

		if (heroXRight >= firstXCoord && heroXRight <= secondXCoord && other.y >= firstYCoord
				&& other.y <= secondYCoord) {
			return true;
		} else {
			return false;
		}
	}// overlapsWithTopRight

	/**
	 * ensures: it checks to see if hero is touching bottom left of the barrier
	 * 
	 * @param other the hero that may or may not be touching it
	 * @return rather or not the barrier is in contact with hero
	 */
	public boolean overlapsWithBottomLeft(Hero other) {
		int heroYBottom = other.y + other.height;

		secondXCoord = super.x + Math.cos(Math.toRadians(rotation)) * super.width;
		secondYCoord = super.y + Math.tan(Math.toRadians(rotation)) * (other.x - super.x);

		if (other.x >= super.x && other.x <= secondXCoord && heroYBottom >= super.y && heroYBottom <= secondYCoord) {
			return true;
		} else {
			return false;
		}
	}// overlapsWithBottomLeft

	/**
	 * ensures: it checks to see if hero is touching bottom right of the barrier
	 * 
	 * @param other the hero that may or may not be touching it
	 * @return rather or not the barrier is in contact with hero
	 */
	public boolean overlapsWithBottomRight(Hero other) {
		int heroXRight = other.x + other.width;
		int heroYBottom = other.y + other.height;

		secondXCoord = super.x + Math.cos(Math.toRadians(rotation)) * super.width;
		secondYCoord = super.y + Math.tan(Math.toRadians(rotation)) * (heroXRight - super.x);

		if (heroXRight >= super.x && heroXRight <= secondXCoord && heroYBottom <= super.y
				&& heroYBottom >= secondYCoord) {
			return true;
		} else {
			return false;
		}
	}// overlapsWithBottomRight

	/**
	 * ensures: it checks to see if hero is touching right of the barrier
	 * 
	 * @param other the hero that may or may not be touching it
	 * @return rather or not the barrier is in contact with hero
	 */
	public boolean overlapsWithRight(Hero other) {
		int heroXRight = other.x + other.width;
		int heroYBottom = other.y + other.height;

		if (heroXRight >= super.x && other.x <= super.x && other.y <= super.y && heroYBottom >= super.y
				|| heroXRight >= firstXCoord && other.x <= super.x && other.y <= firstYCoord
						&& heroYBottom >= firstYCoord) {
			return true;
		} else {
			return false;
		}
	}// overlapsWithRight

	/**
	 * ensures: it checks to see if hero is touching top of the barrier
	 * 
	 * @param other the hero that may or may not be touching it
	 * @return rather or not the barrier is in contact with hero
	 */
	public boolean overlapsWithTop(Hero other) {
		int heroXRight = other.x + other.width;
		int heroYBottom = other.y + other.height;

		if (heroXRight >= super.x && other.x <= super.x + super.width && heroYBottom >= super.y
				&& heroYBottom <= super.y + super.height && rotation == 0) {
			return true;
		} else {
			return false;
		}
	}// overlapsWithTop

	/**
	 * ensures: it checks to see if hero is touching bottom of the barrier
	 * 
	 * @param other the hero that may or may not be touching it
	 * @return rather or not the barrier is in contact with hero
	 */
	public boolean overlapsWithBottom(Hero other) {
		int heroXRight = other.x + other.width;

		if (heroXRight >= super.x && other.x <= super.x + super.width && other.y <= super.y + super.height
				&& other.y >= super.y && rotation == 0) {
			return true;
		} else {
			return false;
		}
	}// overlapsWithBottom

	/**
	 * ensures: here because it has to be
	 **/
	@Override
	protected void overlapping() {

	}// overlapping

	/**
	 * ensures: checks to see if it is in fact a barrier; always true
	 **/
	protected boolean isBarrier() {
		return true;
	}// isBarrier

	/**
	 * ensures: the second y cord is known
	 * 
	 * @returns secondYCord the second y cord
	 **/
	public int getSecondYCoord() {
		return (int) secondYCoord;
	}// getSecondYCoord
}// Barrier
