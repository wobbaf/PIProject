package application.Settings;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.Grid.Cell;
import application.Grid.Grid;

public class Rules implements java.io.Serializable{
	private static Rules instance;
	
	public static List<HashMap> rules = new ArrayList<HashMap>();
	public static List<Point> r = new ArrayList<Point>();
	public static Rules instance(){
		if(instance == null)
			instance = new Rules();
		return instance;
	}
	
	public Rules(){
		Rules.instance = this;
	}
	
	public static void checkRule (HashMap rule){
		rules.forEach((temp)->{
			if (rule == temp){
				return;
			}
		});
		rules.add(rule);
	}
	
	public static void addRule (HashMap rule){
		checkRule(rule);
	}
	
	public static void removeRule (HashMap rule){
		rules.remove(rule);
	}
	
	public static void saveToFile (){
		String usr = System.getProperty("user.name");
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("/Users/maciej/Documents/rules.bubu");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(instance().rules);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /Users/maciej/Documents/rules.bubu");
	         FileOutputStream fileOut1 =
	    	         new FileOutputStream("/Users/maciej/Documents/textrules.bubu");
	    	         ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
	    	         out1.writeObject(instance().r);
	    	         out1.close();
	    	         fileOut1.close();
	    	         System.out.printf("Serialized data is saved in /Users/maciej/Documents/textrules.bubu");
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
	         FileInputStream fileIn = new FileInputStream("/Users/maciej/Documents/rules.bubu");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         instance().rules = (List<HashMap>) in.readObject();
	         in.close();
	         fileIn.close();
	         FileInputStream fileIn1 = new FileInputStream("/Users/maciej/Documents/textrules.bubu");
	         ObjectInputStream in1 = new ObjectInputStream(fileIn1);
	         instance().r = (List<Point>) in1.readObject();
	         in1.close();
	         fileIn1.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Rules class not found");
	         c.printStackTrace();
	         return;
	      }
	}
}
