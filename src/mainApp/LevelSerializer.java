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
		ArrayList<GameObject> objects = new ArrayList<GameObject>();
		
		objects.add(new Barrier(xForBarrier,random.nextInt(700),50,50,10));
		
		objects.add(new Barrier(xForBarrier,50,75,50,0));
		
		objects.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0));
		
		objects.add(new Barrier(xForBarrier,random.nextInt(700),50,50,30));
		
		objects.add(new ElectricBarrier(xForBarrier,random.nextInt(700),50,50,0,Color.pink));
		
		objects.add(new Coin(500, 500));
		try {
	         FileOutputStream fileOut = new FileOutputStream("level1.ser");
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
