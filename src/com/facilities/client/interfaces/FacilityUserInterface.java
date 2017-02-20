package com.facilities.client.interfaces;

import java.util.Calendar;
import java.util.List;

import com.facilities.model.atm.ATM;
import com.facilities.model.maintenance.MaintenanceOrder;
import com.facilities.model.service.ATMTransaction;

public interface FacilityUserInterface {
	/** This method will test if a ATM was in use during an interval of time **/
	public boolean isInUseDuringInterval(ATM atm, Calendar fromDate, Calendar toDate);// Verifies
																						// if
																						// an
																						// ATM
																						// was
																						// in
																						// use
																						// between
																						// a
																						// defined
																						// period
																						// of
																						// time

	public boolean assignFacilityToUse(ATM atm, ATMTransaction atmTransaction); // Perform
																				// a
																				// transaction
																				// in
																				// an
																				// ATM

	public boolean vacateFacility(ATM atm); // Change ATM status to inactive

	public List<MaintenanceOrder> listInspections(ATM atm); // List all the
															// Diagnostic
															// Maintenance
															// Orders performed
															// on that ATM

	public long listActualUsage(ATM atm); // List all the minutes that an ATM
											// has been used

	public long calcUsageRate(ATM atm); // List the average time for an user
										// to make a transaction
}
