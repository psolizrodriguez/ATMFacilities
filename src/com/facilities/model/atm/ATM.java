package com.facilities.model.atm;

import java.util.ArrayList;
import java.util.List;

import com.facilities.model.service.ATMTransaction;

public class ATM {
	private List<ATMTransaction> accounts = new ArrayList<ATMTransaction>();

	public List<ATMTransaction> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<ATMTransaction> accounts) {
		this.accounts = accounts;
	}

}
