package com.facilities.client.interfacesImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.facilities.client.interfaces.FacilityUserInterface;
import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.service.ATMTransaction;

public class FacilityUserInterfaceImpl implements FacilityUserInterface {

	@Override
	public boolean isInUseDuringInterval(ATM atm, Calendar fromDate, Calendar toDate) {
		List<ATMTransaction> listATMTransaction = atm.getAtmTransactions();
		if (listATMTransaction != null && listATMTransaction.size() > 0) {
			for (ATMTransaction atmTransaction : listATMTransaction) {

				if (CommonsUtils.isCalendarBetween(atmTransaction.getStartTime(), fromDate, toDate)
						|| CommonsUtils.isCalendarBetween(atmTransaction.getEndTime(), fromDate, toDate)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean assignFacilityToUse(ATM atm, ATMTransaction atmTransaction) {
		return atm.performTransaction(atmTransaction);

	}

	@Override
	public boolean vacateFacility(ATM atm) {
		if (atm.isActive()) {
			atm.setActive(false);
			return true;
		}
		return false;
	}

	@Override
	public List<ATMTransaction> listInspections(ATM atm, String transactionType) {
		List<ATMTransaction> result = new ArrayList<>();
		//Have to look in the transactions for equals to the type in the string
		return result;
	}

	@Override
	public long listActualUsage(ATM atm) {
		long result = 0;
		List<ATMTransaction> listATMTransaction = atm.getAtmTransactions();
		if (listATMTransaction != null && listATMTransaction.size() > 0) {
			for (ATMTransaction atmTransaction : listATMTransaction) {
				System.out.println(CommonsUtils.CalendarToString(atmTransaction.getStartTime()) + " "
						+ CommonsUtils.CalendarToString(atmTransaction.getEndTime()));
				result += CommonsUtils.minutesBetween(atmTransaction.getStartTime(), atmTransaction.getEndTime());

			}
		}

		return result;
	}

	@Override
	public long calcUsageRate(ATM atm) {
		long result = 0;
		List<ATMTransaction> listATMTransaction = atm.getAtmTransactions();
		if (listATMTransaction != null && listATMTransaction.size() > 0) {
			for (ATMTransaction atmTransaction : listATMTransaction) {
				result += CommonsUtils.minutesBetween(atmTransaction.getStartTime(), atmTransaction.getEndTime());
			}
			result /= listATMTransaction.size();
		}

		return result;
	}

}
