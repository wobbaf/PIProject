package application.Grid;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.Settings.Rule;
import application.Settings.Rules;

public class Cell {
	private static Cell instance;
	
	public static int state = 0;
	
	public static Point coords;
	
	public static HashMap neighborhood;
	
	public static Point getPosition(){
		return coords;
	}
	public static Cell instance(){
		if(instance == null)
			instance = new Cell();
		return instance;
	}
	public static int getState(){
		return state;
	}
	public void setPosition(Point p){
		this.coords = p;
	}
	
	public void setState(int s){
		this.state = s;
	}
	public Cell(Point coord, int stat){
		//Cell.instance = this;
		this.coords = coord;
		this.state = stat;
	}
	public Cell(){
		//Cell.instance = this;
		this.coords = new Point(0,0);
		this.state = 0;
	}
	public static HashMap getNeighborhood(Point p){
		HashMap<Point, Integer> ne = new HashMap();
		int y=0;
		for (int i = p.x - 2; i <= p.x+2; i++){
			int x=0;
			for (int j = p.y - 2; j <= p.y+2; j++){
				if(j >=0 && i >=0){
					//if(i != p.x && j != p.y){
						ne.put(new Point(x,y), Grid.instance().map.get(new Point(i,j)));
					//}
				}
				else{
					ne.put(new Point(x,y), 0);
				}
				x++;
			}
			y++;
		}
		//System.out.println(ne);
//		for (Point key : ne.keySet()) {
//			if(ne.get(key) == 2)
//		System.out.println(key);
//		}
		//neighborhood = ne;
		return ne;
		
	}
	
//	public static int checkRule(Cell cell){
//		int state = cell.state;
//		Rules rules = new Rules();
//		Cell tempCell = cell;
//		//System.out.println(rules);
//		Rules.rules.forEach((temp)->{
//			if (temp.rule == getNeighborhood(cell.coords)){
//				cell.state = 0;//temp.center.state;
//			}
//			else{
//				cell.state = 2;
//			}
//		});
//		return cell.state;
//	}
}
