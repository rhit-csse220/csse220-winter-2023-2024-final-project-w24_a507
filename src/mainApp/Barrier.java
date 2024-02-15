package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.io.Serializable;

public class Barrier extends GameObject implements Serializable {

	protected int rotation;
	Color colorOfBarrier;

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
	}

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
	@Override
	public void update() {
		super.x -= super.constantSpeed;

		if (super.x + super.width * Math.cos(Math.toRadians(rotation)) < 0) {
			offScreen = true;
			// System.out.println("Object is off screen");
		}
	}// update

	/**
	 * ensures: it checks to see if barrier has been hit by hero
	 * 
	 * @param hero the thing that may or may not be touching it
	 * @return rather or not a barrier is in contact with hero
	 */
	@Override
	public boolean overlapsWith(Hero other) {
		int xDiff = super.x - other.x;
		int yDiff = super.y - other.y;
		double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		return this.width / 2 + other.width / 2 >= distance;

	}// overlapsWith

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
}
