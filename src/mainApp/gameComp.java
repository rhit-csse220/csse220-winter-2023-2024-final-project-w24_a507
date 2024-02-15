package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class gameComp extends JComponent {
	Hero hero = new Hero(100, 500, 50, 50, 20);
	JLabel label;

	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private int xForBarrier = 400;
	Random random = new Random();
	int level = 1;
	final int MAX_LEVEL = 3;
	private int counterCoin = 0;
	protected int livesLeft = 3;

	public gameComp() {
		this.loadFile(1);
	}

	public void loadFile(int level) {
		try {
			FileInputStream fileIn = new FileInputStream("level" + level + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<GameObject> e = (ArrayList<GameObject>) in.readObject();
			objects = e;
			in.close();
			fileIn.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found for level " + level);
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Class not found");
		}

	}

	public boolean levelOver() {
		System.out.println(objects.size());
		return objects.size() == 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (GameObject i : objects) {
			i.drawOn(g2);
		}

		hero.drawOn(g2);
	}

	public void update() {
		for (GameObject b : this.objects) {
			if(b.isHomingMissile())
			{
				if(((HomingMissile) b).decreaseTimer() == 0)
				{
					objects.add(new Missile(((HomingMissile) b).yCord(), 75, 50, 40));
					objects.remove(objects.indexOf(b));
				}
				
				if (((HomingMissile) b).updateWarning(hero) > 0) {
					continue;
				}
			}
			
			if(hero.x < 100)
			{
				hero.x += 1;
			}
			else if(hero.x > 100)
			{
				hero.x = 100;
			}
			
			b.update();
		}

		for (GameObject b : this.objects) {
			if (b.overlapsWith(hero)) {				
				
				b.overlapping();
				
				if (b.isMissile()) {
					this.loadFile(level);
					System.out.println("Missle Hit *************************************\nRestart Level");
					
					livesLeft--;
					if(livesLeft==0)
					{
						System.out.println("GAME OVER");
						GameOver over=new GameOver();
						over.main();
					}
					this.updateLabel(counterCoin,livesLeft);
				}
			}
			
			if(b.isBarrier())
			{
				if(((Barrier) b).overlapsWithRight(hero))
				{
					hero.x = b.x - 50;
					System.out.println("Pushing left");
				}
				else if(((Barrier) b).overlapsWith(hero) || ((Barrier) b).overlapsWithTopRight(hero))
				{
					hero.y = ((Barrier) b).getSecondYCoord();
					System.out.println("Top Left/Right");
				}
				else if(((Barrier) b).overlapsWithBottomLeft(hero) || ((Barrier) b).overlapsWithBottomRight(hero))
				{
					hero.y = ((Barrier) b).getSecondYCoord() - 75;
					System.out.println("Bottom Left/Right");
				}
			}

		}

		if (objects.size() == 0) {
			level++;
			if (level <= MAX_LEVEL) {
				this.loadFile(level);
			}
		}
		hero.update();
	}

	public void removeThings() {
		
		ArrayList<GameObject> removeMeObjects = new ArrayList<GameObject>();
		
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).overlapsWith(hero) && objects.get(i).isCoin()) {
				objects.remove(i);
				removeMeObjects.add(objects.get(i));
				this.counterCoin++;
				this.updateLabel(counterCoin,livesLeft);
				objects.remove(i);
				break;
			}
			if (objects.get(i).isOffScreen()) {
				objects.remove(i);
				break;
			}
		}
		
		for(GameObject objs:removeMeObjects)
		{
			objects.remove(objs);
		}
	}

	public void moveHeroUp() {
		hero.isUp(true);
		hero.update();
	}
	
	public void setLabel(JLabel label)
	{
		this.label = label;
	}
	
	public void updateLabel(int coins, int lives) {
		this.label.setText("<html>Coins: " + coins + "<br />Lives: " + lives + "</HTML>");
	}//updateLabel
}
