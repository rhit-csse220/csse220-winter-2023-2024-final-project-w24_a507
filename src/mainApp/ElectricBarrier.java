package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class: ElectricBarrier
 * 
 * @author group 507 <br>
 *         Purpose: Used to create electric barriers <br>
 *         For example:
 * 
 *         <pre>
 *         ElectricBarrier barrierE1 = new ElectricBarrier(200, 300, 50, 50, 0, Color.cyan);
 *         </pre>
 */

public class ElectricBarrier extends Barrier {
	private Color color;

	/**
	 * ensures: initializes x,y,width,height,rotation, and color to
	 * x,y,width,height,rotation,and color
	 * 
	 * @param x,y          used to set location of barrier
	 * @param width,height used to set size of barrier
	 * @param rotation     used to rotation of barrier
	 * @param color        used to set color of barrier
	 */
	public ElectricBarrier(int x, int y, int width, int height, int rotation, Color color) {
		super(x, y, width, height, rotation, color);
		this.color = color;
	}// ElectricBarrier

	/**
	 * ensures: it checks to see if electric barrier has been hit by hero
	 * 
	 * @param hero the thing that may or may not be touching it
	 * @return rather or not an electric barrier is in contact with hero
	 */
	@Override
	public boolean overlapsWith(Hero other) {
		int xDiff = super.x - other.x;
		int yDiff = super.y - other.y;
		double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		return super.width / 2 + other.width / 2 >= distance;

	}// overlapsWith

	/**
	 * ensures: just checks to see if it's an electric barrier
	 */
	protected boolean isElectricBarrier() {
		return true;
	}// isElectricBarrier
}
