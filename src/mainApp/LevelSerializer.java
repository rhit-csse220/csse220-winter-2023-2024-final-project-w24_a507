package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class LevelSerializer {
	public static void main(String[] args) {
		Random random = new Random();
		int xForBarrier=400;
		ArrayList<Barrier> barriers = new ArrayList<Barrier>();
		ArrayList<DontTouch1> coins=new ArrayList<DontTouch1>();
		
		barriers.add(new Barrier(xForBarrier,random.nextInt(700),50,50,10));
		
		barriers.add(new Barrier(xForBarrier,50,75,50,0));
		
		barriers.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0));
		
		barriers.add(new Barrier(xForBarrier,random.nextInt(700),50,50,30));
		
		barriers.add(new ElectricBarrier(xForBarrier,random.nextInt(700),50,50,0,Color.pink));
		
		
		try {
	         FileOutputStream fileOut = new FileOutputStream("level.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         
	         out.writeObject(barriers);

	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/level.ser");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
}
