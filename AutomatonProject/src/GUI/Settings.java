package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Settings {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
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
	public Settings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 188);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblSetWidth = new JLabel("Set width:");
		GridBagConstraints gbc_lblSetWidth = new GridBagConstraints();
		gbc_lblSetWidth.anchor = GridBagConstraints.EAST;
		gbc_lblSetWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetWidth.gridx = 1;
		gbc_lblSetWidth.gridy = 3;
		frame.getContentPane().add(lblSetWidth, gbc_lblSetWidth);
		
		textField = new JTextField();
		textField.setText("500");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblSetHeight = new JLabel("Set height:");
		GridBagConstraints gbc_lblSetHeight = new GridBagConstraints();
		gbc_lblSetHeight.anchor = GridBagConstraints.EAST;
		gbc_lblSetHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetHeight.gridx = 1;
		gbc_lblSetHeight.gridy = 4;
		frame.getContentPane().add(lblSetHeight, gbc_lblSetHeight);
		
		textField_1 = new JTextField();
		textField_1.setText("500");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnRules = new JButton("Rules");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rules rules = new Rules();
				rules.frame.setVisible(true);
			}
		});
		
		JButton btnReset = new JButton("Reset");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 5, 0);
		gbc_btnReset.gridx = 10;
		gbc_btnReset.gridy = 5;
		frame.getContentPane().add(btnReset, gbc_btnReset);
		GridBagConstraints gbc_btnRules = new GridBagConstraints();
		gbc_btnRules.insets = new Insets(0, 0, 5, 5);
		gbc_btnRules.gridx = 1;
		gbc_btnRules.gridy = 6;
		frame.getContentPane().add(btnRules, gbc_btnRules);
		
		JButton btnApply = new JButton("Apply");
		GridBagConstraints gbc_btnApply = new GridBagConstraints();
		gbc_btnApply.insets = new Insets(0, 0, 5, 0);
		gbc_btnApply.gridx = 10;
		gbc_btnApply.gridy = 6;
		frame.getContentPane().add(btnApply, gbc_btnApply);
	}

}
