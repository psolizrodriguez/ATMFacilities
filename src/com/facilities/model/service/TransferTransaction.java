package com.facilities.model.service;

import java.util.Calendar;

import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class TransferTransaction extends ATMTransaction {
	private Double amount;
	private Account transferTo;

	public TransferTransaction(Account account, Card card, Calendar startTime, Double amount, Account transferTo) {
		super(card, startTime);
		this.account = account;
		this.amount = amount;
		this.transferTo = transferTo;
		setAverageMinutes(10);
	}

	@Override
	public boolean processTransaction(ATM atm) {
		this.setEndTime(CommonsUtils.getFinalizationTime(getStartTime(), getAverageMinutes()));
		if (transferTo.credit(amount)) {
			return account.debit(amount);
		}
		return false;
	}

}
