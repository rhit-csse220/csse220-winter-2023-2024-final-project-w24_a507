package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class LevelSerializer4 {
	private final int height=30;
	private final int MISSILE_WIDTH = 75;
	private final int MISSILE_HEIGHT = 50;
	
	public LevelSerializer4() {
		
	}
	
	public void generateFile() {
		Random random = new Random();
		int xForBarrier = 400;
		ArrayList<GameObject> objects = new ArrayList<GameObject>();

		//on screen
		objects.add(new Barrier(100, 0, 400, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(400, 2*height, 300, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(400, 300, 200, 2*height, 25,Color.black)); //diagnoal down
		
		objects.add(new HomingMissile(MISSILE_WIDTH, MISSILE_HEIGHT, 40, 30));
		
		//second top part
		objects.add(new Barrier(200, 400, 60, 300, 0,Color.black)); //long top
		
		objects.add(new Barrier(700, 500, 60, 200, 0,Color.black)); //middle big
		objects.add(new Barrier(900, 350, 60, 350, 0,Color.black)); //bottom
	
		
		//not used
//		objects.add(new Barrier(720, 300, 400, 2*height, 0,Color.black)); //long top
//		objects.add(new Barrier(770, 300+2*height, 100, 2*height, 0,Color.black)); //middle big
//		objects.add(new Barrier(850, 600-height, 300, 2*height, 0,Color.black)); //too bottom?
//		
//		
//
		objects.add(new ElectricBarrier(1200, 400, 60, 300, 0, Color.cyan));
		objects.add(new ElectricBarrier(1400,  0, 60, 200, 0, Color.cyan));
//		
		objects.add(new ElectricBarrier(400, 620, 200, 2*height, 0, Color.green));
		objects.add(new ElectricBarrier(450,620-2*height, 60, 2*height, 0, Color.green));
		
		objects.add(new ElectricBarrier(800,0, 60, 200, 0, Color.green));
		
		//thing
				objects.add(new Barrier(1000, 100, 300, 2*height, 0,Color.black)); //long top
				objects.add(new Barrier(1050, 100+2*height, 100, 2*height, 0,Color.black)); //middle big
				
				
				
//		
		for(int i=0;i<7;i++) //across
		{
			for(int j=0;j<4;j++) //down
			{
				objects.add(new Coin(380+(30*i), 400+20+(30*j)));
			}
		}
////		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<3;j++)
			{
				objects.add(new Coin(730+(30*i), 250+(30*j)));
			}
		}
////		
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<6;j++)
			{
				objects.add(new Coin(980+(30*i), 400+(30*j)));
			}
		}
//		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<2;j++)
			{
				objects.add(new Coin(1020+(30*i), 40+(30*j)));
			}
		}
////		
////		
//		
//		objects.add(new Missile(300,1250, MISSILE_WIDTH, MISSILE_HEIGHT, 20));

		
		
		//off screen
		objects.add(new Barrier(1400, 300, 400, 2*height, 0,Color.black)); //long top
		
		
		objects.add(new Barrier(1400, 620, 500, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1500, 620-2*height, 200, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(1600, 0, 300, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1700, 0+2*height, 100, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(2000, 0, 60, 200, -45,Color.black)); //long top
//		
//		
//		
		objects.add(new ElectricBarrier(2000, 400, 60, 300, 0, Color.pink));
		
//		
		objects.add(new Barrier(2200, 500, 60, 200, 0,Color.black)); //long top
		objects.add(new Barrier(2200, 0, 500, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(2300, 2*height, 300, 2*height, 0,Color.black)); //long top
//		
//		
		objects.add(new ElectricBarrier(2080, 100, 200, 2*height, -25, Color.pink));

//		
//		
		objects.add(new Barrier(2400, 300, 300, 2*height, 0,Color.black)); //middle thing
		objects.add(new Barrier(2450, 300+2*height, 100, 2*height, 0,Color.black)); //long top
		
	//	objects.add(new Barrier(2100, 100, 300, 2*height, 10,Color.black)); //long top
		
		objects.add(new ElectricBarrier(2450, 620, 200, 2*height, 0, Color.BLUE));
		objects.add(new ElectricBarrier(2800, 0, 60, 200, 0, Color.BLUE));
//		
////		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<2;j++)
			{
				objects.add(new Coin(1450+(30*i), 220+(30*j)));
			}
		}
////		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<5;j++)
			{
				objects.add(new Coin(2300+(30*i), 150+(30*j)));
			}
		}
////		
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<5;j++)
			{
				objects.add(new Coin(1850+(30*i), 200+(30*j)));
			}
		}
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<3;j++)
			{
				objects.add(new Coin(1500+(40*i), 400+(40*j)));
			}
		}
		
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<3;j++)
			{
				objects.add(new Coin(2350+(40*i), 450+(40*j)));
			}
		}
		
		objects.add(new Missile(3500, 460, MISSILE_WIDTH, MISSILE_HEIGHT, 25));
		objects.add(new Missile(5700, 550, MISSILE_WIDTH, MISSILE_HEIGHT, 25));
		objects.add(new Missile(5700, 150, MISSILE_WIDTH, MISSILE_HEIGHT, 25));
//		
		
		try {
			FileOutputStream fileOut = new FileOutputStream("level4.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(objects);

			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/level.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}