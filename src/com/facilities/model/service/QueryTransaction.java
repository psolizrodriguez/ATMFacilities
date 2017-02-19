package com.facilities.model.service;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class QueryTransaction extends ATMTransaction {
	private Double balance;

	public QueryTransaction(Account account, Card card) {
		this.account = account;
		this.card = card;
	}

	public boolean processTransaction(ATM atm) {
		this.balance = account.getBalance();
		return false;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
