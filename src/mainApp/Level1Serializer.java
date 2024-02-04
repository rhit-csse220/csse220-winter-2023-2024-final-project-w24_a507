package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Level1Serializer {
	
	public Level1Serializer() {
		
	}
	
	public void generateFile() {
		Random random = new Random();
		int xForBarrier=400;
		ArrayList<Object> objects = new ArrayList<Object>();
		
		objects.add(new Barrier(500,40,50,50,10));
		
		objects.add(new Barrier(600,200,75,50,0));
		
		objects.add(new Barrier(650,500,50,50,30));
		
		objects.add(new Barrier(650,200,50,30,50));
		
		objects.add(new ElectricBarrier(400,50,50,20,0,Color.pink));
		
		objects.add(new DontTouch1(300, 500));
		
		objects.add(new DontTouch1(700, 200));
		
		objects.add(new DontTouch1(900, 300));
		
		objects.add(new DontTouch1(1300, 0));
		
		objects.add(new DontTouch1(1700, 0));
		
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
