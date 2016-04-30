package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rules {

	public JFrame frame;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
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
		gbc_btnAddRule.gridy = 1;
		frame.getContentPane().add(btnAddRule, gbc_btnAddRule);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		frame.getContentPane().add(list, gbc_list);
		
		JButton btnRemoveRule = new JButton("Remove rule");
		GridBagConstraints gbc_btnRemoveRule = new GridBagConstraints();
		gbc_btnRemoveRule.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveRule.gridx = 0;
		gbc_btnRemoveRule.gridy = 3;
		frame.getContentPane().add(btnRemoveRule, gbc_btnRemoveRule);
		
		JButton btnSaveToFile = new JButton("Save to file");
		GridBagConstraints gbc_btnSaveToFile = new GridBagConstraints();
		gbc_btnSaveToFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveToFile.gridx = 0;
		gbc_btnSaveToFile.gridy = 6;
		frame.getContentPane().add(btnSaveToFile, gbc_btnSaveToFile);
		
		JButton btnLoadFromFile = new JButton("Load from file");
		GridBagConstraints gbc_btnLoadFromFile = new GridBagConstraints();
		gbc_btnLoadFromFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoadFromFile.gridx = 0;
		gbc_btnLoadFromFile.gridy = 7;
		frame.getContentPane().add(btnLoadFromFile, gbc_btnLoadFromFile);
		
		JButton btnApply = new JButton("Apply");
		GridBagConstraints gbc_btnApply = new GridBagConstraints();
		gbc_btnApply.anchor = GridBagConstraints.EAST;
		gbc_btnApply.insets = new Insets(0, 0, 5, 0);
		gbc_btnApply.gridx = 1;
		gbc_btnApply.gridy = 7;
		frame.getContentPane().add(btnApply, gbc_btnApply);
	}

}
