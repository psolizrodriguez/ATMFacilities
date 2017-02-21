package com.facilities.model.service;

import java.util.Calendar;

import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class WithdrawlTransaction extends ATMTransaction {
	private Double amount;

	public WithdrawlTransaction(Account account, Card card, Calendar startTime, Double amount) {
		super(card, startTime);
		this.account = account;
		this.card = card;
		this.amount = amount;
		setAverageMinutes(5);
		setTransactionType("Withdraw");
	}

	public boolean processTransaction(ATM atm) {
		this.setEndTime(CommonsUtils.getFinalizationTime(getStartTime(), getAverageMinutes()));
		if (atm.substractBalance(amount)) {

			return account.debit(amount);
		}
		return false;
	}

}
