package com.facilities.view.atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.facilities.client.interfaces.FacilityClientInterface;
import com.facilities.client.interfacesImpl.FacilityClientInterfaceImpl;
import com.facilities.commons.utils.PrinterHelper;
import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Address;

import javax.swing.JTable;
import javax.swing.JLabel;

public class ATMDetail extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private FacilityClientInterface client;

	/**
	 * Create the frame.
	 */
	public ATMDetail(ATM atm) {
		System.out.println("testing");
		client = new FacilityClientInterfaceImpl();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		drawATMTable(atm);
		JLabel lblNewLabel = new JLabel(atm.getAtmId());
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
	}

	private void drawATMTable(ATM atm) {
		PrinterHelper data = client.getFacilityInformation(atm);
		ATM atmClient = (ATM)data.getDataObject(); 
		Address addressClient = atmClient.getAddress();
		String[] columns = new String[] {"Label", "Value"};
	         
        //actual data for the table in a 2d array
        Object[][] datas = new Object[][] {
            {"Address" , addressClient.getStreet()+","+ addressClient.getCity() + "\t" + addressClient.getState(), "," + addressClient.getZip()},
            {"ATM Active(T/F)", atmClient.isActive()},
            {"Limit Amount", atmClient.getLimit()},
            {"Current Amount" , atmClient.getCurrentAmount()}
        };
		table = new JTable(datas, columns);
		contentPane.add(table, BorderLayout.CENTER);
		
		
		
	}

}
