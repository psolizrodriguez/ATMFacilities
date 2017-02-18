package com.facilities.commons.utils;

import java.util.ArrayList;
import java.util.List;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Address;

public class ATMLoader {
	public static List<ATM> getPNCATMList() {
		List<ATM> listATMPNC = new ArrayList<>();
		// We start adding the facilities
		ATM atm_PNC_001 = new ATM("PNC_001", 20000.0, 0.0, true,
				new Address("ADDRESS_1", "26 E Pearson St", "1", "Chicago", "IL", "60611"));
		listATMPNC.add(atm_PNC_001);
		ATM atm_PNC_002 = new ATM("PNC_002", 20000.0, 0.0, true,
				new Address("ADDRESS_2", "1068 W Granville Ave", "2", "Chicago", "IL", "60660"));
		listATMPNC.add(atm_PNC_002);
		return listATMPNC;
	}
}
