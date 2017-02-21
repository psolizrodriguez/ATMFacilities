package com.facilities.client.interfaces;

import java.util.List;

import com.facilities.commons.utils.PrinterHelper;
import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;
import com.facilities.model.service.ATMTransaction;

public interface FacilityClientInterface {
	// List ATMs
	public List<ATM> listFacilities(Bank bank);

	// Print ATM Information
	public PrinterHelper getFacilityInformation(ATM atm);

	// Print money left in ATM
	public Double requestAvailableCapacity(ATM atm);

	// Add new ATM to Bank
	public boolean addNewFacility(Bank bank, ATM atm);

	// Perform transactions to the ATM
	public boolean addFacilityDetail(ATM atm, ATMTransaction atmTransaction);

	// Delete ATM from Bank
	public boolean removeFacility(Bank bank, ATM atm);
}
