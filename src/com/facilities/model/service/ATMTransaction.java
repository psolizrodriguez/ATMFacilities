package com.facilities.model.service;

import java.util.Calendar;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public abstract class ATMTransaction {
	Account account;
	Card card;
	private Calendar startTime;
	private Calendar endTime;
	private int averageMinutes;

	public ATMTransaction(Card card, Calendar startTime) {
		
		this.card = card;
		this.startTime = startTime;
	}

	public int getAverageMinutes() {
		return averageMinutes;
	}

	public void setAverageMinutes(int averageMinutes) {
		this.averageMinutes = averageMinutes;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public abstract boolean processTransaction(ATM atm);
}
