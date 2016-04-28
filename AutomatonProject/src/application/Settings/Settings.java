package application.Settings;

import java.awt.Point;
import java.util.HashMap;

import application.Grid.Cell;
import application.Grid.Grid;

public class Settings {
	public static Settings instance;
	
	public static Settings instance(){
		return instance;
	}
	
	public Settings(){
		Settings.instance = this;
	}
	
}
