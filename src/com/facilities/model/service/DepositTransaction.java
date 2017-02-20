package com.facilities.model.service;

import java.util.Calendar;

import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class DepositTransaction extends ATMTransaction {
	private Double amountDeposit;

	public DepositTransaction(Account account, Card card, Calendar startTime, Double amountDeposit) {
		super( card, startTime);
		this.account = account;
		this.amountDeposit = amountDeposit;
		setAverageMinutes(10);
	}

	public Double getAmountDeposit() {
		return amountDeposit;
	}

	public void setAmountDeposit(Double amountDeposit) {
		this.amountDeposit = amountDeposit;
	}

	public boolean processTransaction(ATM atm) {
		if (atm.addBalance(amountDeposit)) {
			this.setEndTime(CommonsUtils.getFinalizationTime(getStartTime(), getAverageMinutes()));
			return account.credit(amountDeposit);
		}
		return false;
	}

}
