package application.Grid;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import GUI.Main;
import application.Settings.Rules;
import common.Panel2;

public class Grid {
	private static Grid instance;
	public static HashMap<Point, Integer> map ;
	public static HashMap<Point, Integer> map1 = new HashMap<Point, Integer>();
	public static HashMap<Point, Integer> map2 = new HashMap<Point, Integer>();
	public static int step = 4;
	public static Grid instance(){
		if(instance == null)
			instance = new Grid();
		return instance;
	
	}
	private Grid(){
		map = new HashMap();
		Grid.instance = this;
	}
	
	public static void initGrid(int width, int height){
		
		Point coord = new Point();
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				Grid.instance().map.put(new Point(i,j), 0);
			}
		}
	}
	public static void updateGrid(int width, int height){
		HashMap<Point, Integer> tempMap = new HashMap();
		Iterator it = instance().map.entrySet().iterator();
		for (Point key : instance().map.keySet()) {
		//while (it.hasNext()) {
	    //    Map.Entry pair = (Map.Entry)it.next();
	    //    Point key = (Point) pair.getKey();
			for (int i = 0; i < Math.max(application.Settings.Rules.rules.size(),application.Settings.Rules.r.size()); i++) {		
				if(i<application.Settings.Rules.r.size()){
					if(Collections.frequency(new ArrayList<>(Cell.getNeighborhood(key).values()),2) == application.Settings.Rules.r.get(i).x){
						tempMap.put(new Point(key.x,key.y), application.Settings.Rules.r.get(i).y);
					}
				}
				Cell.instance();
				if(i<application.Settings.Rules.rules.size()){
					if(ru(Cell.getNeighborhood(key)).equals(ru(application.Settings.Rules.rules.get(i)))){
						tempMap.put(new Point(key.x,key.y), application.Settings.Rules.mid.get(i));
					}
				}
			}
			//it.remove();
		}
		for (Point key : tempMap.keySet()) {
			instance().map.put(key, tempMap.get(key));
		}
	}
	public static HashMap ru (HashMap hm){
		HashMap x = new HashMap();
		for (int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				//if (i != 2 && j != 2){
					x.put(new Point(i,j), hm.get(new Point(i,j)));
				//}
			}
		}
		x.remove(new Point(2,2));
		return x;
		
	}
	public static void updateCell(Cell cell){
		Main main = new Main();
		main.panel.repaint();
	}
	public static void saveToFile (){
		String usr = System.getProperty("user.name");
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("grid.bubu");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(instance().map);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in grid.bubu");

	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	@SuppressWarnings("unchecked")
	public static void loadFromFile (){
		String usr = System.getProperty("user.name");
		try
	      {
	         FileInputStream fileIn = new FileInputStream("grid.bubu");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         instance().map = (HashMap<Point, Integer>) in.readObject();
	         in.close();
	         fileIn.close();

	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Map class not found");
	         c.printStackTrace();
	         return;
	      }
	}
}
