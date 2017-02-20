package com.facilities.model.service;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class WithdrawlTransaction extends ATMTransaction {
	private Double amount;

	public WithdrawlTransaction(Account account, Card card, Double amount) {
		this.account = account;
		this.card = card;
		this.amount = amount;
	}

	public boolean processTransaction(ATM atm) {
		if (atm.substractBalance(amount)) {

			return account.debit(amount);
		}
		return false;
	}

}
