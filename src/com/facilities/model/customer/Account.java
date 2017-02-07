package com.facilities.model.customer;

import java.util.ArrayList;
import java.util.List;

import com.facilities.model.service.ATMTransaction;

public class Account {
	private List<ATMTransaction> atmTransactions = new ArrayList<ATMTransaction>();

	public List<ATMTransaction> getAtmTransactions() {
		return atmTransactions;
	}

	public void setAtmTransactions(List<ATMTransaction> atmTransactions) {
		this.atmTransactions = atmTransactions;
	}
}
