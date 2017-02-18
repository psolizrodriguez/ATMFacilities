package com.facilities.client.interfacesImpl;

import java.util.List;

import com.facilities.client.interfaces.FacilityClientInterface;
import com.facilities.commons.utils.PrinterHelper;
import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;
import com.facilities.model.service.ATMTransaction;

public class FacilityClientInterfaceImpl implements FacilityClientInterface {

	public List<ATM> listFacilities(Bank bank) {
		return bank.getAtms();
	}

	public PrinterHelper getFacilityInformation(ATM atm) {
		PrinterHelper printerHelper = new PrinterHelper();
		printerHelper.setTextToPrint("Add Print Info of ATM");
		return printerHelper;
	}

	public Double requestAvailableCapacity(ATM atm) {

		return atm.getCurrentAmount();
	}

	public boolean addNewFacility(Bank bank, ATM atm) {
		if (bank.getAtms() != null && !bank.getAtms().contains(atm)) {
			return bank.getAtms().add(atm);
		}
		return false;
	}

	public void addFacilityDetail(ATM atm, ATMTransaction atmTransaction) {
		atm.getAtmTransactions().add(atmTransaction);

	}

	public boolean removeFacility(Bank bank, ATM atm) {
		if (bank.getAtms() != null && !bank.getAtms().isEmpty() && bank.getAtms().contains(atm)) {
			return bank.getAtms().remove(atm);
		}
		return false;
	}

}
