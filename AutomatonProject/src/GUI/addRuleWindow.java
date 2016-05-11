package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import application.Grid.Cell;
import application.Settings.Rule;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;

public class addRuleWindow {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addRuleWindow window = new addRuleWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addRuleWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 235, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		common.Rule panel = new common.Rule();
		panel.setBounds(6, 6, 83, 84);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAddRule = new JButton("Add rule");
		btnAddRule.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				//application.Settings.Rule r = new application.Settings.Rule();
				//HashMap<Point,Integer> m = new HashMap<Point,Integer>();
				//m = panel.hmap;
				application.Settings.Rules.instance().rules.add(new HashMap<Point, Integer>(panel.hmap));
				Rules.listModel.removeAllElements();
				for (int i = 0; i < application.Settings.Rules.instance().rules.size(); i++){
					Rules.listModel.addElement(application.Settings.Rules.instance().rules.get(i));
				//Rules.listModel.addElement(application.Settings.Rules.instance().rules.get(i));
				}
				//System.out.println(map);
				//application.Settings.Rules.rules.add(r);
				//System.out.println(r.toString());
				//Rules gui = new Rules();
//				JTextField text = new JTextField();
//				text.setText(r.toString());
//				gui.model.addElement(text.getText());
//				gui.list = new JList(gui.model);
				frame.dispose();
			}
		});
		btnAddRule.setBounds(40, 207, 117, 29);
		frame.getContentPane().add(btnAddRule);
	}
}
