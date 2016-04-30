package application.Grid;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.Settings.Rule;
import application.Settings.Rules;

public class Cell {
	public static Cell instance;
	
	public static int state;
	
	public static Point coords;
	
	public static HashMap neighborhood = getNeighborhoodState(instance);
	
	public static Point getPosition(){
		return coords;
	}
	
	public static int getState(){
		return state;
	}
	public static Cell instance(){
		return instance;
	}
	
	public Cell(){
		Cell.instance = this;
	}
	
	public static HashMap getNeighborhoodState (Cell cell){
		HashMap map = new HashMap();
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				if (i == 2 && j == 2){}
				else
				map.put(new Point(i,j), cell.neighborhood.get(new Point(2,2)));
			}
		}
		Cell.neighborhood = map;
		return map;
	}
	
	public static void checkRule(Cell cell){
		int state = cell.state;
		Rules rules = new Rules();
		Cell tempCell = cell;
		Rules.rules.forEach((temp)->{
			if (temp.rule == neighborhood){
				//tempCell.
				cell.state = ((Cell)temp.rule.get(new Point(2,2))).state;
			}
		});
		cell.state = state;
	}
}
