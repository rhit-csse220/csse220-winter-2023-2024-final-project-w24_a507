package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;





public class gameComp extends JComponent{
	Hero hero=new Hero();
	ArrayList<Barrier> barriers = new ArrayList<Barrier>();
	private int xForBarrier=400;
	Random random = new Random();
	
	public gameComp()
	{
		
		try {
	        FileInputStream fileIn = new FileInputStream("level.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        ArrayList<Barrier> e = (ArrayList<Barrier>) in.readObject();
	        barriers = e;
	        in.close();
	        fileIn.close();
	     } catch (IOException i) {
	        i.printStackTrace();
	     } catch (ClassNotFoundException c) {
	        System.out.println("Employee class not found");
	        c.printStackTrace();
	     }
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		
		
		for(int i=0;i<barriers.size();i++)
		{
			barriers.get(i).drawOn(g);
		}
		
		hero.drawOn(g2);
	}
	
	public void update()
	{
		for (Barrier b: this.barriers) {
			b.update();
		}		
		
		
		for (Barrier b: this.barriers) {
			if (b.overlapsWith(hero) ) {
				System.out.println("PLAYER WAS HIT");
			}
	}
	}
	
	

}
