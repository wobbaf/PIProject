package application.Settings;

import java.awt.Point;
import java.util.HashMap;

import application.Grid.Cell;
import application.Grid.Grid;

public class Rule {
	public static Rule instance;
	
	public static HashMap rule = new HashMap();
	
	public static Rule instance(){
		return instance;
	}
	
	public Rule(){
		Rule.instance = this;
	}
	
	public static boolean checkRule (Cell cell){
		HashMap neighborhood = cell.neighborhood;
		if (neighborhood != rule){
			return false;
		}
		return true;
		
	}
}
