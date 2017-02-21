package com.facilities.client.interfaces;

import java.util.Calendar;
import java.util.List;

import com.facilities.model.atm.ATM;
import com.facilities.model.service.ATMTransaction;

public interface FacilityUserInterface {
	// Verifies if an ATM was in use between a defined period of time
	public boolean isInUseDuringInterval(ATM atm, Calendar fromDate, Calendar toDate);

	// Perform a transaction in an ATM
	public boolean assignFacilityToUse(ATM atm, ATMTransaction atmTransaction);

	// Change ATM status to inactive
	public boolean vacateFacility(ATM atm);

	// List all the Transactions performed on that ATM of an specific Type (Query, Deposit, etc.)
	public List<ATMTransaction> listInspections(ATM atm, String transactionType);

	// List all the minutes that an ATM has been used
	public long listActualUsage(ATM atm);

	// List the average time for an user to make a transaction
	public long calcUsageRate(ATM atm);
}
