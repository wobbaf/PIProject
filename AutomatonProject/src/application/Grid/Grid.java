package application.Grid;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import GUI.Main;

public class Grid {
	public static Grid instance;
	public static HashMap<Point, Cell> map = new HashMap<Point, Cell>();
	public static Grid instance(){
		return instance;
	}
	public Grid(){
		Grid.instance = this;
	}
	
	public static void initGrid(int width, int height, List<Cell> cells){
		
		Cell cell = new Cell();
		Cell.state = 0;
		Point coord = new Point();
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				coord = new Point(i,j);
				Cell.coords = coord;
				map.put(coord, cell);
			}
		}
		cells.forEach((temp)->{
			map.put(Cell.coords, temp);
		});
	}
	public static void updateGrid(int width, int height){
		HashMap<Point, Cell> tempMap = new HashMap<Point, Cell>();
		for ( int i = 0; i <= width; i++){
			for (int j = 0; j <= height; j++){
				Cell cell = map.get(new Point(i,j));
				Cell.checkRule(cell);
				tempMap.put(cell.coords, cell);
			}
		}
		map = tempMap;
		
	}
	public static void updateCell(Cell cell){
		Main main = new Main();
		main.panel.repaint();
	}
}
