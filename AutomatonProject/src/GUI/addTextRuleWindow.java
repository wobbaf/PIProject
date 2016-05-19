package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import application.Grid.Cell;
import application.Settings.Rule;
import application.Settings.Rules.Foo;
import javafx.scene.control.ComboBox;

import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class addTextRuleWindow {

	public JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addTextRuleWindow window = new addTextRuleWindow();
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
	public addTextRuleWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 411, 236);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JLabel lblIf = new JLabel("If");
		lblIf.setBounds(28, 36, 22, 16);
		frame.getContentPane().add(lblIf);
		
		textField = new JTextField();
		textField.setText("4");
		textField.setBounds(55, 31, 63, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCellsAliveIn = new JLabel("cells ");
		lblCellsAliveIn.setBounds(130, 36, 33, 16);
		frame.getContentPane().add(lblCellsAliveIn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dead", "Alive"}));
		comboBox.setBounds(147, 74, 94, 27);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Dead", "Alive"}));
		comboBox_1.setSelectedIndex(1);
		comboBox_1.setBounds(168, 32, 81, 27);
		frame.getContentPane().add(comboBox_1);
		
		
		JButton btnAddRule = new JButton("Add rule");
		btnAddRule.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				//Point p = ;

				for (int i = 0; i < application.Settings.Rules.instance().r.size(); i++){
				if(Integer.parseInt(textField.getText()) == application.Settings.Rules.instance().r.get(i).getP().x
						&& comboBox_1.getSelectedIndex()+1 == application.Settings.Rules.instance().r.get(i).getS())
					application.Settings.Rules.instance().r.remove(i);
				}
				application.Settings.Rules.instance().r.add(
						application.Settings.Rules.instance().new Foo(new Point(Integer.parseInt(textField.getText()),
								comboBox.getSelectedIndex()+1),
								comboBox_1.getSelectedIndex()+1));
				System.out.println(application.Settings.Rules.instance().r);
				Rules.listModel1.removeAllElements();
				for (int i = 0; i < application.Settings.Rules.instance().r.size(); i++){
					Rules.listModel1.addElement("If "+ application.Settings.Rules.instance().r.get(i).getP().x
							+ " cells "+isdead(application.Settings.Rules.instance().r.get(i).getS())+" then "
							+ isdead(application.Settings.Rules.instance().r.get(i).getP().y));
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
		btnAddRule.setBounds(147, 175, 117, 29);
		frame.getContentPane().add(btnAddRule);
		

		JLabel lblNewLabel = new JLabel(" in neighborhood then ");
		lblNewLabel.setBounds(249, 36, 144, 16);
		frame.getContentPane().add(lblNewLabel);
		
	}
	public static String isdead(int i){
		if(i == 2)
		return "alive";
		return "dead";
	}
}
