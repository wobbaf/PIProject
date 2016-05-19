package application.Settings;

import java.awt.Point;
import java.util.HashMap;

import application.Grid.Cell;
import application.Grid.Grid;

public class Rule {
	private static Rule instance;
	
	public static HashMap rule = new HashMap();
	public static Cell center = new Cell(new Point(2,2),2);
	public static Rule instance(){
		return instance;
	}
	
	public Rule(){
		if(instance == null)
			instance = new Rule();
		Rule.instance = this;
	}
	
	public static void checkRule (HashMap rule){
		HashMap neighborhood = new HashMap(rule);
		neighborhood.remove(new Point(2,2));
		for(int i = 0; i < Rules.instance().rules.size(); i++){
			HashMap r = new HashMap(Rules.instance().rules.get(i));
			r.remove(new Point(2,2));
			if (neighborhood.equals(r)){
				System.out.println(r);
				System.out.println(neighborhood);
				Rules.instance().rules.remove(i);
				Rules.instance().mid.remove(i);
				//return i;
			}
		}
		//return null;
	}
//	
//	public static HashMap getRuleNeighborhood(){
//		HashMap map = new HashMap();
//		for (int i = 0; i < 5; i++){
//			for (int j = 0; j < 5; j++){
//				if (i == 2 && j == 2){
//					
//				}
//				else
//				map.put(new Point(i,j), rule.get(new Point(i,j)));
//			}
//		}
//		return map;
//	}
}
