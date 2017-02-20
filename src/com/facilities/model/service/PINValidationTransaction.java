package com.facilities.model.service;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Card;

public class PINValidationTransaction extends ATMTransaction {
	private String pinNumber;

	public PINValidationTransaction(Card card, String pinNumber) {
		this.card = card;
		this.pinNumber = pinNumber;
	}

	public boolean processTransaction(ATM atm) {
		return card.getPinNumber().equals(pinNumber);
	}

}
