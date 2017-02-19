package com.facilities.model.service;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class TransferTransaction extends ATMTransaction {
	private Double amount;
	private Account transferTo;

	public TransferTransaction(Account account, Card card, Double amount, Account transferTo) {
		this.account = account;
		this.card = card;
		this.amount = amount;
		this.transferTo = transferTo;
	}

	@Override
	public boolean processTransaction(ATM atm) {
		if (transferTo.credit(amount)) {
			return account.debit(amount);
		}
		return false;
	}

}
