package com.facilities.model.customer;

import java.util.ArrayList;
import java.util.List;

public class DebitCard {
	private List<Account> accounts = new ArrayList<Account>();

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
