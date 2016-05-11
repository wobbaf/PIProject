package application.Grid;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import GUI.Main;
import application.Settings.Rules;
import common.Panel2;

public class Grid {
	private static Grid instance;
	public static HashMap<Point, Integer> map ;
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
		for (Point key : instance().map.keySet()) {
			for (int i = 0; i < Math.max(application.Settings.Rules.rules.size(),application.Settings.Rules.r.size()); i++) {		
				if(i<application.Settings.Rules.r.size()){
					if(Collections.frequency(new ArrayList<>(Cell.getNeighborhood(key).values()),2) == application.Settings.Rules.r.get(i).x){
						tempMap.put(new Point(key.x,key.y), application.Settings.Rules.r.get(i).y);
					}
				}
				Cell.instance();
				if(i<application.Settings.Rules.rules.size()){
					if(Cell.getNeighborhood(key).equals(application.Settings.Rules.rules.get(i))){
						tempMap.put(new Point(key.x,key.y), 2);
					}
				}
			}
		}
		for (Point key : tempMap.keySet()) {
			instance().map.put(key, tempMap.get(key));
		}
	}
	public static void updateCell(Cell cell){
		Main main = new Main();
		main.panel.repaint();
	}
}
