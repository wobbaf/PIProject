package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class Main {

	public JFrame frmCellularAutomaton;
	private JTextField txtEg;
	public JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmCellularAutomaton.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCellularAutomaton = new JFrame();
		frmCellularAutomaton.setTitle("Cellular Automaton\n");
		frmCellularAutomaton.setBounds(100, 100, 676, 489);
		frmCellularAutomaton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar Menu = new JMenuBar();
		frmCellularAutomaton.setJMenuBar(Menu);
		
		JMenu mnMenu = new JMenu("Menu");
		Menu.add(mnMenu);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings set = new Settings();
				set.frame.setVisible(true);
			}
		});
		mnMenu.add(mntmSettings);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnMenu.add(mntmAbout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frmCellularAutomaton.getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 14;
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmCellularAutomaton.getContentPane().add(panel, gbc_panel);
		
		JButton btnStart = new JButton("Start");
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 0, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 14;
		frmCellularAutomaton.getContentPane().add(btnStart, gbc_btnStart);
		
		JButton btnStopreset = new JButton("Stop/Reset");
		GridBagConstraints gbc_btnStopreset = new GridBagConstraints();
		gbc_btnStopreset.insets = new Insets(0, 0, 0, 5);
		gbc_btnStopreset.gridx = 1;
		gbc_btnStopreset.gridy = 14;
		frmCellularAutomaton.getContentPane().add(btnStopreset, gbc_btnStopreset);
		
		JLabel lblStep = new JLabel("Step");
		GridBagConstraints gbc_lblStep = new GridBagConstraints();
		gbc_lblStep.insets = new Insets(0, 0, 0, 5);
		gbc_lblStep.anchor = GridBagConstraints.EAST;
		gbc_lblStep.gridx = 2;
		gbc_lblStep.gridy = 14;
		frmCellularAutomaton.getContentPane().add(lblStep, gbc_lblStep);
		
		txtEg = new JTextField();
		txtEg.setText("e.g. 5");
		GridBagConstraints gbc_txtEg = new GridBagConstraints();
		gbc_txtEg.insets = new Insets(0, 0, 0, 5);
		gbc_txtEg.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEg.gridx = 3;
		gbc_txtEg.gridy = 14;
		frmCellularAutomaton.getContentPane().add(txtEg, gbc_txtEg);
		txtEg.setColumns(10);
		
		JButton btnApplyStep = new JButton("Apply step");
		GridBagConstraints gbc_btnApplyStep = new GridBagConstraints();
		gbc_btnApplyStep.gridx = 5;
		gbc_btnApplyStep.gridy = 14;
		frmCellularAutomaton.getContentPane().add(btnApplyStep, gbc_btnApplyStep);
	}
}
