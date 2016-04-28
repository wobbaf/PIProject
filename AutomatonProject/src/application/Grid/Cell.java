package application.Grid;

import java.awt.Point;
import java.util.HashMap;

public class Cell {
	public static Cell instance;
	
	public static int state;
	
	public static Point coords;
	
	public static HashMap neighborhood = new HashMap();
	
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
	
	public static void getNeighborhoodState (Cell cell){
		HashMap neighborhood = new HashMap();
		Grid grid = new Grid();
		Cell.neighborhood = neighborhood;
		
	}
}
