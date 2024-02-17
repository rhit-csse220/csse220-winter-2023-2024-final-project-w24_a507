package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class LevelSerializer3 {
	private final int height=30;
	private final int MISSILE_WIDTH = 75;
	private final int MISSILE_HEIGHT = 50;
	
	public LevelSerializer3() {
		
	}
	
	public void generateFile() {
		Random random = new Random();
		int xForBarrier = 400;
		ArrayList<GameObject> objects = new ArrayList<GameObject>();

		//on screen
		objects.add(new Barrier(200, 0, 300, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(500, 4*height+30, 200, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(250, 300, 150, 2*height, 25,Color.black)); //diagnoal down
		
		
		objects.add(new Barrier(200, 500, 250, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(250, 500-2*height, 100, 2*height, 0,Color.black)); //middle big
		
		objects.add(new Barrier(500, 610, 300, 2*height, 25,Color.black)); //bottom
		
		
		//second top part
		objects.add(new Barrier(750, 0, 500, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(850, 0+2*height, 200, 2*height, 0,Color.black)); //middle big
		objects.add(new Barrier(800, 0+4*height, 100, 2*height, 0,Color.black)); //bottom
	
		
		objects.add(new Barrier(720, 300, 400, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(770, 300+2*height, 100, 2*height, 0,Color.black)); //middle big
		objects.add(new Barrier(850, 610, 300, 2*height, 0,Color.black)); //too bottom?
		
//		
//
		objects.add(new ElectricBarrier(100, 2*height, 150, 2*height, 0, Color.cyan));
		objects.add(new ElectricBarrier(550,  6*height+50, 50, 50, -25, Color.cyan));
		
		objects.add(new ElectricBarrier(1070, 150, 200, 2*height, 0, Color.green));
		objects.add(new ElectricBarrier(1210, 150+2*height, 60, 2*height, 0, Color.green));
		
		objects.add(new Missile(1600, 500, MISSILE_WIDTH, MISSILE_HEIGHT, 25));
		objects.add(new Missile(2400, 300, MISSILE_WIDTH, MISSILE_HEIGHT, 25));
//		
		for(int i=0;i<7;i++) //across
		{
			for(int j=0;j<4;j++) //down
			{
				objects.add(new Coin(270+(30*i), 2*height+20+(30*j)));
			}
		}
//		
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<3;j++)
			{
				objects.add(new Coin(530+(30*i), 420+(30*j)));
			}
		}
//		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<5;j++)
			{
				objects.add(new Coin(890+(30*i), 390+(30*j)));
			}
		}
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<1;j++)
			{
				objects.add(new Coin(720+(50*i), 270+(30*j)));
			}
		}
//		
//		
		
		objects.add(new Missile(300,1250, MISSILE_WIDTH, MISSILE_HEIGHT, 20));
		
		//off screen
		objects.add(new Barrier(1350, 10, 500, 2*height, -25,Color.black)); //long top
		
		
		objects.add(new Barrier(1310, 610, 400, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1410, 610-2*height, 200, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1480, 610-4*height, 100, 2*height, 0,Color.black)); //long top
		
		
		objects.add(new ElectricBarrier(1300, 420, 150, 2*height, 0, Color.pink));
		
		objects.add(new Barrier(1800, 400, 50, 300, 0,Color.black)); //long top
	//	objects.add(new Barrier(850, 500+2*height, 100, 2*height, 0,Color.black)); //long top
		
		
		objects.add(new ElectricBarrier(1600, 0, 200, 2*height, 0, Color.pink));
		objects.add(new ElectricBarrier(1700, 2*height, 200, 2*height, 0, Color.pink));
		
		
		
		objects.add(new Barrier(1950, 0, 50, 250, 0,Color.black)); //long top
		objects.add(new Barrier(1980, 610, 400, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(2100, 100, 300, 2*height, 10,Color.black)); //long top
//		
		objects.add(new ElectricBarrier(2100, 300, 200, 2*height, 0, Color.BLUE));
		objects.add(new ElectricBarrier(2200, 300+2*height, 100, 2*height, 0, Color.BLUE));
//		
//		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<4;j++)
			{
				objects.add(new Coin(1300+(30*i), 200+(30*j)));
			}
		}
//		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<5;j++)
			{
				objects.add(new Coin(1870+(30*i), 400+(30*j)));
			}
		}
//		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<3;j++)
			{
				objects.add(new Coin(2050+(30*i), 200+(30*j)));
			}
		}
//		
//		
//		objects.add(new Barrier(1700, 250, 400, 2*height, 0,Color.black)); //long top
//		objects.add(new Barrier(1850, 250+2*height, 200, 2*height, 0,Color.black)); //long top
//		
//		objects.add(new Barrier(1900, 550, 100, 2*height, 0,Color.black)); //long top
//		objects.add(new Barrier(1950, 550+2*height, 200, 2*height, 0,Color.black)); //long top
//		
//		
//		
//		
//		objects.add(new Barrier(1900, 250, 200, 2*height, 0,Color.black)); //long top
//		objects.add(new Barrier(1950, 250+2*height, 100, 2*height, 0,Color.black)); //long top
//		
//		//objects.add(new Barrier(1900, 400, 100, 2*height, 0,Color.black)); //long top
//	
//		
//
//		objects.add(new ElectricBarrier(1900, 0, 200, 2*height, 0, Color.magenta));
//		objects.add(new ElectricBarrier(2000, 2*height, 150, 2*height, 0, Color.magenta));
//		
//		objects.add(new ElectricBarrier(2100, 450, 200, 2*height, 0, Color.ORANGE));
//		objects.add(new ElectricBarrier(2150, 450+2*height, 200, 2*height, 0, Color.ORANGE));
//		
//		
//		//further off screen
//		
//		objects.add(new Barrier(2200, 200, 250, 2*height, 0,Color.black)); //long top
//		objects.add(new Barrier(2300, 200+2*height, 300, 2*height, 0,Color.black)); //long top
//		
//		objects.add(new Barrier(2200, 580, 200, 2*height, 0,Color.black)); //long top
//		objects.add(new Barrier(2350, 580+2*height, 350, 2*height, 0,Color.black)); //long top
//		
//		
//		objects.add(new Barrier(2450, 320, 150, 2*height, 0,Color.black)); //long top
//	
//		objects.add(new ElectricBarrier(2800, 150, 200, 2*height, 0, Color.magenta));
//		objects.add(new ElectricBarrier(2900, 150+2*height, 100, 2*height, 0, Color.magenta));
//
//		objects.add(new Barrier(2600, 0, 250, 2*height, 0, Color.black));
//		objects.add(new Barrier(2800, 250+2*height, 150, 2*height, 0, Color.black));
//		
//		objects.add(new ElectricBarrier(3000, 450, 300, 2*height, 0, Color.BLUE));
//		objects.add(new ElectricBarrier(3100, 450+2*height, 250, 2*height, 0, Color.BLUE));
//		
//		
//		for(int i=0;i<6;i++)
//		{
//			for(int j=0;j<4;j++)
//			{
//				objects.add(new Coin(3000+(30*i), 20+(30*j)));
//			}
//		}
//		
//		for(int i=0;i<6;i++)
//		{
//			for(int j=0;j<5;j++)
//			{
//				objects.add(new Coin(2800+(30*i), 450+(30*j)));
//			}
//		}
//	
		
	//	objects.add(new Missile(400, 75, 50, 40));
		
		
		
		try {
			FileOutputStream fileOut = new FileOutputStream("level3.ser");
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