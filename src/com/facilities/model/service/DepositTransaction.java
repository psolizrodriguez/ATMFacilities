package com.facilities.model.service;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class DepositTransaction extends ATMTransaction {
	private Double amountDeposit;

	public DepositTransaction(Account account, Card card, Double amountDeposit) {
		this.account = account;
		this.card = card;
		this.amountDeposit = amountDeposit;
	}

	public Double getAmountDeposit() {
		return amountDeposit;
	}

	public void setAmountDeposit(Double amountDeposit) {
		this.amountDeposit = amountDeposit;
	}

	public boolean processTransaction(ATM atm) {
		if (atm.addBalance(amountDeposit)) {
			return account.credit(amountDeposit);
		}
		return false;
	}

}
