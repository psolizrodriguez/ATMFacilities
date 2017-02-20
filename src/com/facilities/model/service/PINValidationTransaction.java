package com.facilities.model.service;

import java.util.Calendar;

import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Card;

public class PINValidationTransaction extends ATMTransaction {
	private String pinNumber;

	public PINValidationTransaction(Card card, Calendar startTime, String pinNumber) {
		super(card, startTime);
		this.pinNumber = pinNumber;
		setAverageMinutes(3);
	}

	public boolean processTransaction(ATM atm) {
		this.setEndTime(CommonsUtils.getFinalizationTime(getStartTime(), getAverageMinutes()));
		return card.getPinNumber().equals(pinNumber);
	}

}
