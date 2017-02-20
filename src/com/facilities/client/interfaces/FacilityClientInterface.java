package com.facilities.client.interfaces;

import java.util.List;

import com.facilities.commons.utils.PrinterHelper;
import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;
import com.facilities.model.service.ATMTransaction;

public interface FacilityClientInterface {
	public List<ATM> listFacilities(Bank bank);// List ATMs

	public PrinterHelper getFacilityInformation(ATM atm); // Print ATM
															// Information

	public Double requestAvailableCapacity(ATM atm); // Print money left in ATM

	public boolean addNewFacility(Bank bank, ATM atm);// Add new ATM to Bank

	public boolean addFacilityDetail(ATM atm, ATMTransaction atmTransaction);// Perform
																			// transactions
																			// to
																			// the
																			// ATM

	public boolean removeFacility(Bank bank, ATM atm);// Delete ATM from Bank
}
