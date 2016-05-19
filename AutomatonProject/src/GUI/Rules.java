package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListModel;
import java.awt.Component;
import javax.swing.SwingConstants;

public class Rules {

	public static JFrame frame;
	public static DefaultListModel<String> listModel1 = new DefaultListModel();
	public static JList list1 = new JList(listModel1);
	JScrollPane scrollPane_1 = new JScrollPane(list1);
	public static DefaultListModel listModel = new DefaultListModel();
	public static JList list = new JList(listModel);
	JScrollPane scrollPane = new JScrollPane(list);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Rules window = new Rules();
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
	public Rules() {
		
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		list.setCellRenderer(new RuleIcons());
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 474);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		//scrollPane.setViewportView(list);

		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 5;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_list);
		
		JButton btnAddRule = new JButton("Add rule");
		btnAddRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRuleWindow addRule = new addRuleWindow();
				addRule.frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAddRule = new GridBagConstraints();
		gbc_btnAddRule.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddRule.gridx = 0;
		gbc_btnAddRule.gridy = 2;
		frame.getContentPane().add(btnAddRule, gbc_btnAddRule);
		
		JButton btnRemoveRule = new JButton("Remove rule");
		btnRemoveRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				if (selectedIndex != -1) {
				    listModel.remove(selectedIndex);
				    application.Settings.Rules.instance().rules.remove(selectedIndex);
				}
			}
		});
		GridBagConstraints gbc_btnRemoveRule = new GridBagConstraints();
		gbc_btnRemoveRule.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveRule.gridx = 0;
		gbc_btnRemoveRule.gridy = 3;
		frame.getContentPane().add(btnRemoveRule, gbc_btnRemoveRule);
		

		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 5;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 7;
		frame.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		JButton button_1 = new JButton("Remove rule");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list1.getSelectedIndex();
				if (selectedIndex != -1) {
				    listModel1.remove(selectedIndex);
				    application.Settings.Rules.instance().r.remove(selectedIndex);
				}
			}
		});
		
		JButton button = new JButton("Add rule");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTextRuleWindow a = new addTextRuleWindow();
				a.frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 8;
		frame.getContentPane().add(button, gbc_button);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 9;
		frame.getContentPane().add(button_1, gbc_button_1);
		
		JButton btnSaveToFile = new JButton("Save to file");
		btnSaveToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.Settings.Rules.saveToFile();
			}
		});
		GridBagConstraints gbc_btnSaveToFile = new GridBagConstraints();
		gbc_btnSaveToFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaveToFile.gridx = 1;
		gbc_btnSaveToFile.gridy = 12;
		frame.getContentPane().add(btnSaveToFile, gbc_btnSaveToFile);
		
		JButton btnLoadFromFile = new JButton("Load from file");
		btnLoadFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.Settings.Rules.loadFromFile();
				Rules.listModel.removeAllElements();
				for (int i = 0; i < application.Settings.Rules.instance().rules.size(); i++){
					Rules.listModel.addElement(application.Settings.Rules.instance().rules.get(i));
				//Rules.listModel.addElement(application.Settings.Rules.instance().rules.get(i));
				}
				Rules.listModel1.removeAllElements();
				for (int i = 0; i < application.Settings.Rules.instance().r.size(); i++){
					Rules.listModel1.addElement("If "+ application.Settings.Rules.instance().r.get(i).getP().x
							+ " cells"+ addTextRuleWindow.isdead(application.Settings.Rules.instance().r.get(i).getS()) +"then "
							+ addTextRuleWindow.isdead(application.Settings.Rules.instance().r.get(i).getP().y));
				//Rules.listModel.addElement(application.Settings.Rules.instance().rules.get(i));
				}
			}
		});
		GridBagConstraints gbc_btnLoadFromFile = new GridBagConstraints();
		gbc_btnLoadFromFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoadFromFile.gridx = 1;
		gbc_btnLoadFromFile.gridy = 13;
		frame.getContentPane().add(btnLoadFromFile, gbc_btnLoadFromFile);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnApply.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnApply = new GridBagConstraints();
		gbc_btnApply.insets = new Insets(0, 0, 0, 5);
		gbc_btnApply.anchor = GridBagConstraints.WEST;
		gbc_btnApply.gridx = 0;
		gbc_btnApply.gridy = 14;
		frame.getContentPane().add(btnApply, gbc_btnApply);
	}

}
