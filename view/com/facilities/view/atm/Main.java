package com.facilities.view.atm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

public class Main {

	private JFrame frmCompProject;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmCompProject.setVisible(true);
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
		frmCompProject = new JFrame();
		frmCompProject.setTitle("COMP 477 Project 1");
		frmCompProject.setBounds(100, 100, 663, 511);
		frmCompProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmCompProject.setJMenuBar(menuBar);

		JMenu mnBanks = new JMenu("Banks");
		menuBar.add(mnBanks);

		JMenuItem mntmBanks = new JMenuItem("Banks");
		mntmBanks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("here");
			}
		});
		mntmBanks.setAction(action);
		mnBanks.add(mntmBanks);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("here");
		}
	}
}
