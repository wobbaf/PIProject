package common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import GUI.Main;
import application.Grid.Cell;
import application.Grid.Grid;
import application.Settings.Settings.Size;

public class Icon extends JPanel {
	protected Size size;
	//public static HashMap<Point, Integer> hmap = new HashMap<Point, Integer>();
	public static List<Shape> grid;
    public static List<Shape> fill;
    public static List<Cell> cells = new ArrayList<>();
    application.Settings.Settings set = new application.Settings.Settings();
    public Size s = application.Settings.Settings.Size.initSize();
    public Icon(HashMap<Point,Integer> hmap) {

        grid = new ArrayList<>(5);
        fill = new ArrayList<>(5);
        

        
        int colWidth = 6;
        int rowHeight = 6;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                grid.add(new Rectangle(colWidth * col, rowHeight * row, colWidth, rowHeight));
            }
        }
        for (Shape shape : grid) {
            if (hmap.get(new Point(shape.getBounds().y/6,shape.getBounds().x/6)) == 2) {
                if (fill.contains(shape)) {
                    fill.remove(shape);
                    //hmap.put(new Point((shape.getBounds().y)/16,(shape.getBounds().x)/16),0);
                    
                } else {
                    fill.add(shape);
                   // hmap.put(new Point((shape.getBounds().y)/16,(shape.getBounds().x)/16),2);
                }
            }
        }
        
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(36, 36);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        for (Shape cell : fill) {
        	
            g2d.fill(cell);
        }
        g2d.setColor(Color.BLACK);
        for (Shape cell : grid) {
            g2d.draw(cell);
        }
    }
        
    }
