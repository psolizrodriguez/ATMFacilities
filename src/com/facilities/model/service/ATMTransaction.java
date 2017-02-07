package com.facilities.model.service;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;

public class ATMTransaction {
	Account account;
	ATM atm;

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
