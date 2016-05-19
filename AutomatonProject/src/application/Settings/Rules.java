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
	public static List<Integer> mid = new ArrayList<Integer>();
	public static List<Foo> r = new ArrayList<Foo>();
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
	         new FileOutputStream("rules.bubu");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(instance().rules);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in rules.bubu");
	         FileOutputStream fileOut1 =
	         new FileOutputStream("textrules.bubu");
	         ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
	         out1.writeObject(instance().r);
	         out1.close();
	         fileOut1.close();
	         System.out.printf("Serialized data is saved in textrules.bubu");
	         FileOutputStream fileOut2 =
	         new FileOutputStream("rulesst.bubu");
	         ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
	         out2.writeObject(instance().mid);
	         out2.close();
	         fileOut2.close();
	         System.out.printf("Serialized data is saved in rulesst.bubu");
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
	         FileInputStream fileIn = new FileInputStream("rules.bubu");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         instance().rules = (List<HashMap>) in.readObject();
	         in.close();
	         fileIn.close();
	         FileInputStream fileIn2 = new FileInputStream("rulesst.bubu");
	         ObjectInputStream in2 = new ObjectInputStream(fileIn2);
	         instance().mid = (List<Integer>) in2.readObject();
	         in2.close();
	         fileIn2.close();
	         FileInputStream fileIn1 = new FileInputStream("textrules.bubu");
	         ObjectInputStream in1 = new ObjectInputStream(fileIn1);
	         instance().r = (List<Foo>) in1.readObject();
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
	public class Foo {
	    public Foo(Point point, int i) {
	    	this.p = point;
	    	this.s = i;
			// TODO Auto-generated constructor stub
		}
		private Point p;
	    private int s; 
	    public Point getP(){
	    	return this.p;
	    }
	    public int getS(){
	    	return this.s;
	    }
	    // ctors, getters, etc.
	}
}

