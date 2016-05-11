package GUI;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.SwingConstants;

import application.Grid.Cell;
import application.Grid.Grid;
import application.Settings.Settings.Size;
import common.Panel2;

public class Main {

	public static JFrame frmCellularAutomaton;
	static JTextField txtEg;
	static boolean flag = false;
	public static Panel2 panel;
	LoopThread aLoopThread = new LoopThread();

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
		aLoopThread.start();
		Grid.initGrid(application.Settings.Settings.Size.height, application.Settings.Settings.Size.width);
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
				try {
					aLoopThread.pauseThread();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnMenu.add(mntmSettings);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnMenu.add(mntmAbout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frmCellularAutomaton.getContentPane().setLayout(gridBagLayout);
		
		panel = new Panel2();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 14;
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		frmCellularAutomaton.getContentPane().add(panel, gbc_panel_1,0);
		
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					aLoopThread.resumeThread();
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 0, 5);
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 15;
		frmCellularAutomaton.getContentPane().add(btnStart, gbc_btnStart);
		
		JButton btnStopreset = new JButton("Stop/Reset");
		btnStopreset.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
					try {
						aLoopThread.pauseThread();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		GridBagConstraints gbc_btnStopreset = new GridBagConstraints();
		gbc_btnStopreset.insets = new Insets(0, 0, 0, 5);
		gbc_btnStopreset.gridx = 2;
		gbc_btnStopreset.gridy = 15;
		frmCellularAutomaton.getContentPane().add(btnStopreset, gbc_btnStopreset);
		
		JLabel lblStep = new JLabel("Step");
		GridBagConstraints gbc_lblStep = new GridBagConstraints();
		gbc_lblStep.insets = new Insets(0, 0, 0, 5);
		gbc_lblStep.anchor = GridBagConstraints.EAST;
		gbc_lblStep.gridx = 3;
		gbc_lblStep.gridy = 15;
		frmCellularAutomaton.getContentPane().add(lblStep, gbc_lblStep);
		
		txtEg = new JTextField();
		txtEg.setText("1");
		GridBagConstraints gbc_txtEg = new GridBagConstraints();
		gbc_txtEg.insets = new Insets(0, 0, 0, 5);
		gbc_txtEg.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEg.gridx = 4;
		gbc_txtEg.gridy = 15;
		frmCellularAutomaton.getContentPane().add(txtEg, gbc_txtEg);
		txtEg.setColumns(10);
		
		JButton btnApplyStep = new JButton("Apply step");
		GridBagConstraints gbc_btnApplyStep = new GridBagConstraints();
		gbc_btnApplyStep.gridx = 5;
		gbc_btnApplyStep.gridy = 15;
		frmCellularAutomaton.getContentPane().add(btnApplyStep, gbc_btnApplyStep);
	}
    }
	class LoopThread extends Thread {
		private volatile boolean running = false;
	    public void run() {
	    	while(true){
	    		while(!running) {}
				while (running){
					for (int i = 0; i < Integer.parseInt(Main.txtEg.getText()); i++){
						Grid.updateGrid(application.Settings.Settings.Size.height, application.Settings.Settings.Size.width);
						Main.panel.re();
					}
					Main.panel.paintImmediately(0, 0, application.Settings.Settings.Size.height*application.Settings.Settings.Size.cellSize,
							application.Settings.Settings.Size.width*application.Settings.Settings.Size.cellSize);
				}
	    	}
	    }
	    public void pauseThread() throws InterruptedException
	    {
	        running = false;
	    }

	    public void resumeThread()
	    {
	        running = true;
	    }
	
	  }
