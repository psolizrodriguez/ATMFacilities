package com.facilities.client.interfaces;

import java.util.Calendar;

import com.facilities.model.atm.ATM;

public interface FacilityUserInterface {
	/** This method will test if a ATM was in use during an interval of time **/
	public boolean isInUseDuringInterval(ATM atm, Calendar fromDate, Calendar toDate);// This

	public Object assignFacilityToUse();

	public Object vacateFacility();

	public Object listInspections();

	public Object listActualUsage();

	public Object calcUsageRate();
}
