package com.facilities.view.atm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.facilities.commons.utils.BankLoader;
import com.facilities.model.atm.ATM;

public class Main {

	private JFrame frmCompProject;
	private final Action action = new SwingAction();
	private BankLoader bankLoader;
	private final Action usageRate = new usageRateAction();
	private final Action actualUsage = new actualUsageAction();
	private final Action checkUsage = new checkUsageAction();

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
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");
		bankLoader = new BankLoader(context);
		frmCompProject = new JFrame();
		frmCompProject.setTitle("COMP 477 Project 1");
		frmCompProject.setBounds(100, 100, 663, 511);
		frmCompProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmCompProject.setJMenuBar(menuBar);

		JMenu mnBanks = new JMenu("Banks");
		menuBar.add(mnBanks);

		JMenu mnUserInterface = new JMenu("Facility Statistics");
		menuBar.add(mnUserInterface);

		JMenuItem mntmNewMenuItem = new JMenuItem("Usage Rate");
		mntmNewMenuItem.setAction(usageRate);
		mnUserInterface.add(mntmNewMenuItem);

		JMenuItem mntmActualUsage = new JMenuItem("Actual Usage");
		mntmActualUsage.setAction(actualUsage);
		mnUserInterface.add(mntmActualUsage);

		JMenuItem mntmCheckUsage = new JMenuItem("Check Usage");
		mntmCheckUsage.setAction(checkUsage);
		mnUserInterface.add(mntmCheckUsage);

		JMenu mntmBanks;
		HashMap<String, List<ATM>> values = bankLoader.getBankLists();

		for (String value : bankLoader.toString().split(",")) {
			mntmBanks = new JMenu(value);
			mntmBanks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("here");
				}
			});
			for (final ATM atm : values.get(value)) {
				JMenuItem mntmATMs = new JMenuItem(atm.getAtmId());
				mntmBanks.add(mntmATMs);
				mntmATMs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame atmFrame = new ATMDetail(atm);
						atmFrame.setVisible(true);
					}
				});
			}
			mntmBanks.setText(value);
			mnBanks.add(mntmBanks);
		}

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

	private class usageRateAction extends AbstractAction {
		public usageRateAction() {
			putValue(NAME, "Usage Rate");
			putValue(SHORT_DESCRIPTION, "Calculate the usage rate of the facility");
		}

		public void actionPerformed(ActionEvent e) {
			JFrame usageRateCalFrame = new ClientCalculaion("Usage Rate");
			usageRateCalFrame.setVisible(true);
		}
	}

	private class actualUsageAction extends AbstractAction {
		public actualUsageAction() {
			putValue(NAME, "Actual Usage");
			putValue(SHORT_DESCRIPTION, "Calculate the actual usage of the facility");
		}

		public void actionPerformed(ActionEvent e) {
			JFrame usageRateCalFrame = new ClientCalculaion("Actual Usage");
			usageRateCalFrame.setVisible(true);
		}
	}

	private class checkUsageAction extends AbstractAction {
		public checkUsageAction() {
			putValue(NAME, "Check Usage");
			putValue(SHORT_DESCRIPTION, "Check the usage of the facility");
		}

		public void actionPerformed(ActionEvent e) {
			JFrame checkUsageFrame = new ClientUsage();
			checkUsageFrame.setVisible(true);
		}
	}
}
