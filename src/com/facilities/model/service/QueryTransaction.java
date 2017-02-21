package com.facilities.model.service;

import java.util.Calendar;

import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class QueryTransaction extends ATMTransaction {
	private Double balance;

	public QueryTransaction(Account account, Card card, Calendar startTime) {
		super(card, startTime);
		this.account = account;
		setAverageMinutes(5);
		setTransactionType("Query");
	}

	public boolean processTransaction(ATM atm) {
		this.setEndTime(CommonsUtils.getFinalizationTime(getStartTime(), getAverageMinutes()));
		this.balance = account.getBalance();
		return true;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
