package application.Grid;

import java.util.HashMap;
import java.util.List;

public class Grid {
	public static Grid instance;
	public static Grid instance(){
		return instance;
	}
	public Grid(){
		Grid.instance = this;
	}
	
	public static void initGrid(int width, int height, List<Cell> cells){
		HashMap map = new HashMap();
	}
}
