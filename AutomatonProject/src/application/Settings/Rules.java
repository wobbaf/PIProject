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
	public static Rules instance;
	
	public static List<Rule> rules = new ArrayList();
	
	public static Rules instance(){
		return instance;
	}
	
	public Rules(){
		Rules.instance = this;
	}
	
	public static void checkRule (Rule rule){
		rules.forEach((temp)->{
			if (rule == temp){
				return;
			}
		});
		rules.add(rule);
	}
	
	public static void addRule (Rule rule){
		checkRule(rule);
	}
	
	public static void removeRule (Rule rule){
		rules.remove(rule);
	}
	
	public static void saveToFile (){
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("/tmp/rules.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(rules);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/rules.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public static void loadFromFile (){
		try
	      {
	         FileInputStream fileIn = new FileInputStream("/tmp/rules.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         rules = (List<Rule>) in.readObject();
	         in.close();
	         fileIn.close();
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
