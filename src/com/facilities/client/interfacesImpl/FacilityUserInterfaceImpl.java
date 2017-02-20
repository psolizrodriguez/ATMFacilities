package com.facilities.client.interfacesImpl;

import java.util.Calendar;
import java.util.List;

import com.facilities.client.interfaces.FacilityUserInterface;
import com.facilities.model.atm.ATM;
import com.facilities.model.service.ATMTransaction;

public class FacilityUserInterfaceImpl implements FacilityUserInterface {

	@Override
	public boolean isInUseDuringInterval(ATM atm, Calendar fromDate, Calendar toDate) {
		List<ATMTransaction> listATMTransaction = atm.getAtmTransactions();
		if (listATMTransaction != null && listATMTransaction.size() > 0) {
			for (ATMTransaction atmTransaction : listATMTransaction) {
				if (atmTransaction.getStartTime().getTimeInMillis() >= fromDate.getTimeInMillis()
						&& atmTransaction.getEndTime().getTimeInMillis() <= toDate.getTimeInMillis()) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public Object assignFacilityToUse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object vacateFacility() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object listInspections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object listActualUsage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object calcUsageRate() {
		// TODO Auto-generated method stub
		return null;
	}

}
