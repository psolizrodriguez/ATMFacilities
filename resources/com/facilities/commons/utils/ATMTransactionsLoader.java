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
				CommonsUtils.getCalendar(02, 18, 2017, 11, 30, 0), "1111");
		facilityClientInterface.addFacilityDetail(atmPNC_001, pinValidation);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction depositToAccount = new DepositTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 11, 50, 0), 1000.0);
		facilityClientInterface.addFacilityDetail(atmPNC_001, depositToAccount);
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 11, 58, 0), 500.0);
		facilityClientInterface.addFacilityDetail(atmPNC_001, withdrawFromAccount);
		Account savingAccount = debitCard.getAccounts().get(1);
		ATMTransaction transferFromAccount = new TransferTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 11, 59, 0), 300.0, savingAccount);
		facilityClientInterface.addFacilityDetail(atmPNC_001, transferFromAccount);
	}
}
