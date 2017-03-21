package com.facilities.view.atm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.facilities.client.interfaces.FacilityUserInterface;
import com.facilities.client.interfacesImpl.FacilityClientInterfaceImpl;
import com.facilities.client.interfacesImpl.FacilityUserInterfaceImpl;
import com.facilities.commons.utils.BankLoader;
import com.facilities.model.atm.ATM;

public class ClientCalculaion extends JFrame {

	private JPanel contentPane;
	private FacilityUserInterface user;
	private JPanel panel;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public ClientCalculaion(final String arg) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");
		BankLoader.loadTransactionsPNC(BankLoader.getBankPNC(context), context,
				(FacilityClientInterfaceImpl) context.getBean("facilityClientInterface"));
		label = new JLabel("Select the Facility");
		panel = new JPanel(new FlowLayout());
		setBounds(100, 100, 331, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ArrayList<ATM> atmsList = new ArrayList<ATM>() {
			{
				addAll(BankLoader.getBankPNC(context).getAtms());
			}
		};
		panel.add(label);
		JComboBox comboBox = new JComboBox(atmsList.toArray());
		panel.add(comboBox);
		comboBox.setRenderer(new ComboBoxRenderer());

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = new FacilityUserInterfaceImpl();
				JComboBox cb = (JComboBox) e.getSource();
				ATM atm = (ATM) cb.getSelectedItem();
				if (arg.equals("Usage Rate")) {
					long val = user.calcUsageRate(atm);
					JOptionPane.showMessageDialog(panel.getComponent(0), "Usage Rate : " + String.valueOf(val));
				} else {
					long val = user.listActualUsage(atm);
					JOptionPane.showMessageDialog(panel.getComponent(0), "Actual Usage : " + String.valueOf(val));
				}
			}
		});
		contentPane.add(panel, BorderLayout.LINE_START);

	}

}
