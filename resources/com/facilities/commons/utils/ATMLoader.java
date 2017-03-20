package com.facilities.commons.utils;

import java.util.ArrayList;
import java.util.List;

import com.facilities.model.atm.ATM;
import com.facilities.model.atm.ATMImpl;
import com.facilities.model.customer.AddressImpl;

public class ATMLoader {
	public static List<ATM> getPNCATMList() {
		List<ATM> listATMPNC = new ArrayList<>();
		// We start adding the facilities
		ATM atm_PNC_001 = new ATMImpl("PNC_001", 20000.0, 0.0, true,
				new AddressImpl("ADDRESS_1", "26 E Pearson St", "1", "Chicago", "IL", "60611"));
		listATMPNC.add(atm_PNC_001);
		ATM atm_PNC_002 = new ATMImpl("PNC_002", 20000.0, 100000.0, true,
				new AddressImpl("ADDRESS_2", "1068 W Granville Ave", "2", "Chicago", "IL", "60660"));
		listATMPNC.add(atm_PNC_002);
		ATM atm_PNC_003 = new ATMImpl("PNC_003", 30000.0, 6600000.0, true,
				new AddressImpl("ADDRESS_3", "4309 S Morgan St", "3", "Chicago", "IL", "60609"));
		listATMPNC.add(atm_PNC_003);
		ATM atm_PNC_004 = new ATMImpl("PNC_004", 50000.0, 55000.0, true,
				new AddressImpl("ADDRESS_4", "13 Garden St", "4", "Chicago", "IL", "60661"));
		listATMPNC.add(atm_PNC_004);
		return listATMPNC;
	}
	
	public static List<ATM> getBOAATMList() {
		List<ATM> listATMBOA = new ArrayList<>();
		// We start adding the facilities
		ATM atm_BOA_001 = new ATMImpl("BOA_001", 40000.0, 99999.0, true,
				new AddressImpl("ADDRESS_1", "11 E Wabash Ct", "5", "Evanston", "IL", "60634"));
		listATMBOA.add(atm_BOA_001);
		ATM atm_BOA_002 = new ATMImpl("BOA_002", 70000.0, 534000.0, true,
				new AddressImpl("ADDRESS_2", "1432 S Canal St", "6", "Chicago", "IL", "60687"));
		listATMBOA.add(atm_BOA_002);
		ATM atm_BOA_003 = new ATMImpl("BOA_003", 90000.0, 89000.0, true,
				new AddressImpl("ADDRESS_3", "88 Madison Park", "7", "Ravenswood", "IL", "60600"));
		listATMBOA.add(atm_BOA_003);
		ATM atm_BOA_004 = new ATMImpl("BOA_004", 10000.0, 789021.0, true,
				new AddressImpl("ADDRESS_4", "88 Glenlake Ave", "8", "Lake Forest", "IL", "60169"));
		listATMBOA.add(atm_BOA_004);
		return listATMBOA;
	}
	
	public static List<ATM> getCBATMList() {
		List<ATM> listATMCB = new ArrayList<>();
		// We start adding the facilities
		ATM atm_CB_001 = new ATMImpl("CB_001", 55000.0, 344590.0, true,
				new AddressImpl("ADDRESS_1", "26 E Arch Drive", "9", "Elgin", "IL", "60611"));
		listATMCB.add(atm_CB_001);
		ATM atm_CB_002 = new ATMImpl("CB_001", 23000.0, 550324.0, true,
				new AddressImpl("ADDRESS_2", "145 Bay Drive", "10", "Chicago", "IL", "60660"));
		listATMCB.add(atm_CB_002);
		ATM atm_CB_003 = new ATMImpl("CB_001", 44000.0, 2334234.0, true,
				new AddressImpl("ADDRESS_3", "89 Fairview St", "11", "Highwood", "IL", "60660"));
		listATMCB.add(atm_CB_003);
		ATM atm_CB_004 = new ATMImpl("CB_001", 77000.0, 453523.0, true,
				new AddressImpl("ADDRESS_4", "490 Nulla St", "12", "Fort Sheridan", "IL", "60660"));
		listATMCB.add(atm_CB_004);
		return listATMCB;
	}
	
	public static List<ATM> getCHASEATMList() {
		List<ATM> listATMCB = new ArrayList<>();
		// We start adding the facilities
		ATM atm_CHASE_001 = new ATMImpl("CHASE_001", 20000.0, 455677.0, true,
				new AddressImpl("ADDRESS_1", "1078 Dictum Ave", "13", "Windermere", "IL", "60611"));
		listATMCB.add(atm_CHASE_001);
		ATM atm_CHASE_002 = new ATMImpl("CHASE_002", 39000.0, 564234.0, true,
				new AddressImpl("ADDRESS_2", "7666 Iaculis St", "14", "Prairie", "IL", "60660"));
		listATMCB.add(atm_CHASE_002);
		ATM atm_CHASE_003 = new ATMImpl("CHASE_003", 42000.0, 984234.0, true,
				new AddressImpl("ADDRESS_3", "5543 Aliquet St", "15", "Arlignton Heights", "IL", "60660"));
		listATMCB.add(atm_CHASE_003);
		ATM atm_CHASE_004 = new ATMImpl("CHASE_004", 47000.0, 23423498.0, true,
				new AddressImpl("ADDRESS_4", "5037 Diam Rd", "16", "Chicago", "IL", "60660"));
		listATMCB.add(atm_CHASE_004);
		return listATMCB;
	}
}
