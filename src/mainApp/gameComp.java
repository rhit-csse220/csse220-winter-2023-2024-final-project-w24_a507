package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

public class gameComp extends JComponent{
	Hero hero=new Hero(100, 500, 50, 50, 20);

	ArrayList<Object> objects = new ArrayList<Object>();
	private int xForBarrier = 400;
	Random random = new Random();
	int level = 1;
	final int MAX_LEVEL = 2;

	public gameComp() {
		this.loadFile(1);
	}

	public void loadFile(int level) {
		try {
			FileInputStream fileIn = new FileInputStream("level" + level + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<Object> e = (ArrayList<Object>) in.readObject();
			objects = e;
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
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

		for (Object i : objects) {
			i.drawOn(g2);
		}

		hero.drawOn(g2);
	}

	public void update() {
		for (Object b : this.objects) {
			b.update();
		}

		for (Object b : this.objects) {
			if (b.overlapsWith(hero)) {
				b.overlapping();
			}

		}

		if (objects.size() == 0) {
			level++;
			if (level <= MAX_LEVEL) {
				this.loadFile(level);
				System.out.println("New Level " + level);
			}
		}
	}

	public void removeThings() {

		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).overlapsWith(hero) && objects.get(i).isCoin()) {
				objects.remove(i);
				break;
			}
			if(objects.get(i).isOffScreen()) {
				objects.remove(i);
				break;
			}
		}
	}

	public void moveHeroUp() {
		hero.update();
	}
	
}
