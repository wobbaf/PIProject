package application.Settings;

import java.awt.Point;
import java.util.HashMap;

import application.Grid.Cell;
import application.Grid.Grid;

public class Settings {
	public static Settings instance;
	int w = 20;
	int h = 20;
	public Size size;
	public void initSize(){
		this.size.height = h;
		this.size.width = w;
	}
	public void setSize(int width, int height){
		this.size.height = height;
		this.size.width = width;
	}

	public static Settings instance(){
		return instance;
	}
	
	public Settings(){
		Settings.instance = this;
	}
	public static class Size{
		public static Size size;
		public static int width = 200;
		public static int height = 200;
		public static int cellSize = 8;
		public static Size initSize(){
			size.height = height;
			size.width = width;
			return size;
		}
	}

}
