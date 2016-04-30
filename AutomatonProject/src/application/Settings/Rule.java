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
	
	public static HashMap getRuleNeighborhood(){
		HashMap map = new HashMap();
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				if (i == 2 && j == 2){
					
				}
				else
				map.put(new Point(i,j), rule.get(new Point(i,j)));
			}
		}
		return map;
	}
}
