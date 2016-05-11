package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import common.Icon;
import common.Rule;

public class RuleIcons extends JPanel implements ListCellRenderer {
	 
	JPanel p = new JPanel();
	Icon i;
	JLabel l = new JLabel();
	List<Shape> grid;
    List<Shape> fill;
    public RuleIcons() {
    	//setLayout(new GridLayout(0,2,20,20));
        //p = new Rule();
    	//l = new JLabel("",JLabel.RIGHT);
    	add(l);
        add(p);
        
        
    }
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
//
		HashMap<Point,Integer> map = (HashMap<Point, Integer>) value;
		l.setText(String.valueOf(index)+" ");
        i=(new Icon(map));
        p.removeAll();
        p.add(i);
        //p.hmap = application.Settings.Rules.instance().rules.get(index);
	    if(isSelected) setBackground(Color.gray);
	    else setBackground(Color.WHITE);
	    return this;
	} 
}
