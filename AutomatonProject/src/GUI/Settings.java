package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Shape;

import javax.swing.JTextField;

import common.Panel2;
import application.Grid.Cell;
import application.Grid.Grid;
import application.Settings.Settings.Size;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Settings {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		frame.setBounds(100, 100, 314, 188);
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
		textField.setText(String.valueOf(application.Settings.Settings.Size.width));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		frame.getContentPane().add(textField, gbc_textField);
		
		JLabel lblSetHeight = new JLabel("Set height:");
		GridBagConstraints gbc_lblSetHeight = new GridBagConstraints();
		gbc_lblSetHeight.anchor = GridBagConstraints.EAST;
		gbc_lblSetHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetHeight.gridx = 1;
		gbc_lblSetHeight.gridy = 4;
		frame.getContentPane().add(lblSetHeight, gbc_lblSetHeight);
		
		textField_1 = new JTextField();
		textField_1.setText(String.valueOf(application.Settings.Settings.Size.height));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		
		JLabel lblCellSize = new JLabel("Cell size:");
		GridBagConstraints gbc_lblCellSize = new GridBagConstraints();
		gbc_lblCellSize.anchor = GridBagConstraints.EAST;
		gbc_lblCellSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblCellSize.gridx = 1;
		gbc_lblCellSize.gridy = 5;
		frame.getContentPane().add(lblCellSize, gbc_lblCellSize);
		
		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(application.Settings.Settings.Size.cellSize));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText()+"\n");
				application.Settings.Settings.Size.height = Integer.parseInt(textField_1.getText());
				application.Settings.Settings.Size.width = Integer.parseInt(textField.getText());
				application.Settings.Settings.Size.cellSize = Integer.parseInt(textField_2.getText());
				Main.panel.sized();
				Main.panel.re();
				Main.panel.paintImmediately(0, 0, application.Settings.Settings.Size.height*application.Settings.Settings.Size.cellSize, application.Settings.Settings.Size.width*application.Settings.Settings.Size.cellSize);
				Grid.instance().map.clear();
				Grid.instance().initGrid(application.Settings.Settings.Size.height,application.Settings.Settings.Size.width);
				Main.frmCellularAutomaton.revalidate();
				Main.panel.paintImmediately(0, 0, application.Settings.Settings.Size.height*8, application.Settings.Settings.Size.width*8);
//				Main.aLoopThread = new LoopThread();
//				Main.aLoopThread.start();
				frame.dispose();
			}
		});
		GridBagConstraints gbc_btnApply = new GridBagConstraints();
		gbc_btnApply.insets = new Insets(0, 0, 5, 5);
		gbc_btnApply.gridx = 1;
		gbc_btnApply.gridy = 6;
		frame.getContentPane().add(btnApply, gbc_btnApply);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.Settings.Settings.Size.height = 50;
				application.Settings.Settings.Size.width = 50;
				application.Settings.Settings.Size.cellSize = 8;
				textField_1.setText(String.valueOf(application.Settings.Settings.Size.height));
				textField.setText(String.valueOf(application.Settings.Settings.Size.width));
				textField_2.setText(String.valueOf(application.Settings.Settings.Size.cellSize));
				Main.panel.sized();
				Main.panel.paintImmediately(0, 0, application.Settings.Settings.Size.height*application.Settings.Settings.Size.cellSize, application.Settings.Settings.Size.width*application.Settings.Settings.Size.cellSize);
				Grid.instance().map.clear();
				Grid.instance().initGrid(application.Settings.Settings.Size.height,application.Settings.Settings.Size.width);
				Main.frmCellularAutomaton.revalidate();
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnReset.gridx = 2;
		gbc_btnReset.gridy = 6;
		frame.getContentPane().add(btnReset, gbc_btnReset);
		
		JButton btnRules = new JButton("Rules");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rules rules = new Rules();
				rules.frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnRules = new GridBagConstraints();
		gbc_btnRules.insets = new Insets(0, 0, 5, 5);
		gbc_btnRules.gridx = 3;
		gbc_btnRules.gridy = 6;
		frame.getContentPane().add(btnRules, gbc_btnRules);
	}

}
