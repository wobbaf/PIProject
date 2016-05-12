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

public class Rule extends JPanel {
	protected Size size;
	public static HashMap<Point, Integer> hmap = new HashMap<Point, Integer>();
	public static List<Shape> grid;
    public static List<Shape> fill;
    public static List<Shape> fill2;
    public static List<Cell> cells = new ArrayList<>();
    application.Settings.Settings set = new application.Settings.Settings();
    public Size s = application.Settings.Settings.Size.initSize();
    public Rule() {
		for (int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				hmap.put(new Point(i,j), 0);
			}
		}
        grid = new ArrayList<>(5);
        fill = new ArrayList<>(5);
        fill2 = new ArrayList<>(5);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (Shape shape : grid) {
                    if (shape.contains(e.getPoint())) {
                    if (fill2.contains(shape) || fill.contains(shape)){
                		{
                			if (fill.contains(shape)) {
                			fill.remove(shape);
                            fill2.add(shape);
                            hmap.put(new Point((shape.getBounds().y)/16,(shape.getBounds().x)/16),1);
                			}
                			else{
                				fill2.remove(shape);
                				hmap.put(new Point((shape.getBounds().y)/16,(shape.getBounds().x)/16),0);
                                //fill.add(shape);
                			}
                			
                		}
                     }
                	else{
                		fill.add(shape);
                    	hmap.put(new Point((shape.getBounds().y)/16,(shape.getBounds().x)/16),2);
                	}
                }
                }
                repaint();
            }
        });
        
        int colWidth = 16;
        int rowHeight = 16;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                grid.add(new Rectangle(colWidth * col, rowHeight * row, colWidth, rowHeight));
            }
        }
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
		Main.frmCellularAutomaton.getContentPane().remove(1);
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
