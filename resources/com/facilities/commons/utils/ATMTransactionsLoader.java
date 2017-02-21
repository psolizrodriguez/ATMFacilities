package com.facilities.commons.utils;

import com.facilities.client.interfaces.FacilityClientInterface;
import com.facilities.client.interfacesImpl.FacilityClientInterfaceImpl;
import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;
import com.facilities.model.service.ATMTransaction;
import com.facilities.model.service.DepositTransaction;
import com.facilities.model.service.PINValidationTransaction;
import com.facilities.model.service.TransferTransaction;
import com.facilities.model.service.WithdrawlTransaction;

public class ATMTransactionsLoader {

	public static void loadTransactionsPNC(Bank bank) {
		FacilityClientInterface facilityClientInterface = new FacilityClientInterfaceImpl();
		Card debitCard = bank.getDebitCards().get(0);
		ATM atmPNC_001 = bank.getAtms().get(0);
		ATMTransaction pinValidation = new PINValidationTransaction(debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 11, 10, 0, 1), "1111");
		facilityClientInterface.addFacilityDetail(atmPNC_001, pinValidation);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction depositToAccount = new DepositTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 11, 21, 0, 1), 1000.0);
		facilityClientInterface.addFacilityDetail(atmPNC_001, depositToAccount);
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 12, 33, 0, 1), 500.0);
		facilityClientInterface.addFacilityDetail(atmPNC_001, withdrawFromAccount);
		Account savingAccount = debitCard.getAccounts().get(1);
		ATMTransaction transferFromAccount = new TransferTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 12, 50, 0, 1), 300.0, savingAccount);
		facilityClientInterface.addFacilityDetail(atmPNC_001, transferFromAccount);
		
		ATM atmPNC_002 = bank.getAtms().get(1);
		ATMTransaction pinValidation2 = new PINValidationTransaction(debitCard,
				CommonsUtils.getCalendar(02, 17, 2017, 1, 10, 0, 1), "1111");
		facilityClientInterface.addFacilityDetail(atmPNC_002, pinValidation2);
		Account checkingAccount2 = debitCard.getAccounts().get(0);
		ATMTransaction depositToAccount2 = new DepositTransaction(checkingAccount2, debitCard,
				CommonsUtils.getCalendar(02, 17, 2017, 2, 21, 0, 1), 2000.0);
		facilityClientInterface.addFacilityDetail(atmPNC_002, depositToAccount2);
		ATMTransaction withdrawFromAccount2 = new WithdrawlTransaction(checkingAccount2, debitCard,
				CommonsUtils.getCalendar(02, 17, 2017, 2, 33, 0, 1), 800.0);
		facilityClientInterface.addFacilityDetail(atmPNC_002, withdrawFromAccount2);
		Account savingAccount2 = debitCard.getAccounts().get(1);
		ATMTransaction transferFromAccount2 = new TransferTransaction(checkingAccount2, debitCard,
				CommonsUtils.getCalendar(02, 17, 2017, 3, 50, 0, 1), 150.0, savingAccount2);
		facilityClientInterface.addFacilityDetail(atmPNC_002, transferFromAccount2);
		
		ATM atmPNC_003 = bank.getAtms().get(2);
		ATMTransaction pinValidation3 = new PINValidationTransaction(debitCard,
				CommonsUtils.getCalendar(02, 15, 2017, 1, 10, 0, 1), "1111");
		facilityClientInterface.addFacilityDetail(atmPNC_003, pinValidation3);
		Account checkingAccount3 = debitCard.getAccounts().get(0);
		ATMTransaction depositToAccount3 = new DepositTransaction(checkingAccount3, debitCard,
				CommonsUtils.getCalendar(02, 15, 2017, 2, 21, 0, 1), 222.0);
		facilityClientInterface.addFacilityDetail(atmPNC_003, depositToAccount3);
		ATMTransaction withdrawFromAccount3 = new WithdrawlTransaction(checkingAccount3, debitCard,
				CommonsUtils.getCalendar(02, 15, 2017, 2, 33, 0, 1), 1000.0);
		facilityClientInterface.addFacilityDetail(atmPNC_003, withdrawFromAccount3);
		Account savingAccount3 = debitCard.getAccounts().get(1);
		ATMTransaction transferFromAccount3 = new TransferTransaction(checkingAccount3, debitCard,
				CommonsUtils.getCalendar(02, 15, 2017, 3, 50, 0, 1), 600.0, savingAccount3);
		facilityClientInterface.addFacilityDetail(atmPNC_003, transferFromAccount3);
	}
	
	public static void loadTransactionsBOA(Bank bank) {
		FacilityClientInterface facilityClientInterface = new FacilityClientInterfaceImpl();
		Card debitCard = bank.getDebitCards().get(0);
		ATM atmBOA_001 = bank.getAtms().get(0);
		ATMTransaction pinValidation = new PINValidationTransaction(debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 1, 30, 0, 1), "1113");
		facilityClientInterface.addFacilityDetail(atmBOA_001, pinValidation);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction depositToAccount = new DepositTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 3, 50, 0, 1), 999.0);
		facilityClientInterface.addFacilityDetail(atmBOA_001, depositToAccount);
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 6, 15, 0, 1), 770.0);
		facilityClientInterface.addFacilityDetail(atmBOA_001, withdrawFromAccount);
		Account savingAccount = debitCard.getAccounts().get(1);
		ATMTransaction transferFromAccount = new TransferTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 8, 59, 0, 1), 330.0, savingAccount);
		facilityClientInterface.addFacilityDetail(atmBOA_001, transferFromAccount);
		
		ATM atmBOA_002 = bank.getAtms().get(1);
		ATMTransaction pinValidation2 = new PINValidationTransaction(debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 1, 30, 0, 1), "1113");
		facilityClientInterface.addFacilityDetail(atmBOA_002, pinValidation2);
		Account checkingAccount2 = debitCard.getAccounts().get(0);
		ATMTransaction depositToAccount2 = new DepositTransaction(checkingAccount2, debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 3, 50, 0, 1), 1000.0);
		facilityClientInterface.addFacilityDetail(atmBOA_002, depositToAccount2);
		ATMTransaction withdrawFromAccount2 = new WithdrawlTransaction(checkingAccount2, debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 6, 15, 0, 1), 500.0);
		facilityClientInterface.addFacilityDetail(atmBOA_002, withdrawFromAccount2);
		Account savingAccount2 = debitCard.getAccounts().get(1);
		ATMTransaction transferFromAccount2 = new TransferTransaction(checkingAccount2, debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 8, 59, 0, 1), 300.0, savingAccount2);
		facilityClientInterface.addFacilityDetail(atmBOA_002, transferFromAccount2);
		
		ATM atmBOA_003 = bank.getAtms().get(2);
		ATMTransaction pinValidation3 = new PINValidationTransaction(debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 1, 30, 0, 1), "1113");
		facilityClientInterface.addFacilityDetail(atmBOA_003, pinValidation3);
		Account checkingAccount3 = debitCard.getAccounts().get(0);
		ATMTransaction depositToAccount3 = new DepositTransaction(checkingAccount3, debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 3, 50, 0, 1), 1000.0);
		facilityClientInterface.addFacilityDetail(atmBOA_003, depositToAccount3);
		ATMTransaction withdrawFromAccount3 = new WithdrawlTransaction(checkingAccount3, debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 6, 15, 0, 1), 500.0);
		facilityClientInterface.addFacilityDetail(atmBOA_003, withdrawFromAccount3);
		Account savingAccount3 = debitCard.getAccounts().get(1);
		ATMTransaction transferFromAccount3 = new TransferTransaction(checkingAccount3, debitCard,
				CommonsUtils.getCalendar(02, 11, 2017, 8, 59, 0, 1), 300.0, savingAccount3);
		facilityClientInterface.addFacilityDetail(atmBOA_003, transferFromAccount3);
	}
}
