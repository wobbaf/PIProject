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

public class Panel2 extends JPanel {
	protected Size size;
	public static List<Shape> grid;
    public static List<Shape> fill;
    public static List<Shape> fill2;
    application.Settings.Settings set = new application.Settings.Settings();
    public Size s = application.Settings.Settings.Size.initSize();
    public int width = application.Settings.Settings.Size.width,height = application.Settings.Settings.Size.height;
    
    public Panel2() {
    	Grid.instance();
        //Grid.initGrid(width, height);
        grid = new ArrayList<>(5);
        fill = new ArrayList<>(5);
        fill2 = new ArrayList<>(5);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (Shape shape : grid) {
                    if (shape.contains(e.getPoint())) {
                        if (fill.contains(shape)) {
                            fill.remove(shape);
                            fill2.add(shape);
                            Grid.instance().map.put(new Point(shape.getBounds().x/application.Settings.Settings.Size.cellSize,shape.getBounds().y/application.Settings.Settings.Size.cellSize),1);
                        } else if (fill2.contains(shape)){
                        	fill2.remove(shape);
                            
                            Grid.instance().map.put(new Point(shape.getBounds().x/application.Settings.Settings.Size.cellSize,shape.getBounds().y/application.Settings.Settings.Size.cellSize),0);
                        }
                        else{
                        	fill.add(shape);
                        	Grid.instance().map.put(new Point(shape.getBounds().x/application.Settings.Settings.Size.cellSize,shape.getBounds().y/application.Settings.Settings.Size.cellSize),2);
                        }
                    }
                }
                
                repaint();
            }
        });
        
        int colWidth = application.Settings.Settings.Size.cellSize;
        int rowHeight = application.Settings.Settings.Size.cellSize;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid.add(new Rectangle(colWidth * col, rowHeight * row, colWidth, rowHeight));
            }
        }
//        for (Shape shape : grid) {
//        	fill.add(shape);
//        }
//    	repaint();

    }
    public void sized(){
    	int colWidth = application.Settings.Settings.Size.cellSize;
        int rowHeight = application.Settings.Settings.Size.cellSize;
        width = application.Settings.Settings.Size.width;
        height = application.Settings.Settings.Size.height;
        grid.clear();
        fill.clear();
        fill2.clear();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid.add(new Rectangle(colWidth * col, rowHeight * row, colWidth, rowHeight));
            }
        }
        repaint();
    }
    public void re(){
    	//System.out.println(Grid.map);
    	for (Shape shape : grid) {
    				if(Grid.instance().map.containsKey(new Point(shape.getBounds().x/application.Settings.Settings.Size.cellSize,shape.getBounds().y/application.Settings.Settings.Size.cellSize)) && Grid.instance().map.get(new Point(shape.getBounds().x/application.Settings.Settings.Size.cellSize,shape.getBounds().y/application.Settings.Settings.Size.cellSize)) == 2){
    					//System.out.println(Grid.map.get(new Point(shape.getBounds().x,shape.getBounds().y)));
    		        	fill.add(shape);}
    				if(Grid.instance().map.containsKey(new Point(shape.getBounds().x/application.Settings.Settings.Size.cellSize,shape.getBounds().y/application.Settings.Settings.Size.cellSize)) && Grid.instance().map.get(new Point(shape.getBounds().x/application.Settings.Settings.Size.cellSize,shape.getBounds().y/application.Settings.Settings.Size.cellSize)) == 1){
    					//System.out.println(Grid.map.get(new Point(shape.getBounds().x,shape.getBounds().y)));
    		        	fill2.add(shape);}
        }
    	repaint();
    }
    public static void rep (){
		Panel2 panel = new Panel2();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 14;
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		Main.frmCellularAutomaton.getContentPane().remove(0);
		Main.frmCellularAutomaton.getContentPane().add(panel,gbc_panel_1,0);
		Main.frmCellularAutomaton.revalidate();
		Main.frmCellularAutomaton.repaint();
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        for (Shape cell : fill) {
            g2d.fill(cell);
        }
        g2d.setColor(Color.DARK_GRAY);
        for (Shape cell : fill2) {
            g2d.fill(cell);
        }
        g2d.setColor(Color.BLACK);
        for (Shape cell : grid) {
            g2d.draw(cell);
        }
    }
        
    }
