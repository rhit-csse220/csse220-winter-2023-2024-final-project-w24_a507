package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
		
		
		barriers.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0,Color.BLUE));
		
		barriers.add(new Barrier(xForBarrier,100,50,50,0,Color.BLUE));
		
		barriers.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0,Color.BLUE));
		
		barriers.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0,Color.BLUE));
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
