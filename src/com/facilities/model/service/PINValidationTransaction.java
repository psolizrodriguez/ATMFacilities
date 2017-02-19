package com.facilities.model.service;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class PINValidationTransaction extends ATMTransaction {
	private int pinNumber;

	public PINValidationTransaction(Account account, Card card, int pinNumber) {
		this.account = account;
		this.card = card;
		this.pinNumber = pinNumber;
	}

	public boolean processTransaction(ATM atm) {
		return card.getPinNumber() == pinNumber;
	}

}
