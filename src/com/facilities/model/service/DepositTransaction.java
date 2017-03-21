package com.facilities.model.service;

import java.util.Calendar;

import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public class DepositTransaction implements ATMTransaction {
	private Double amountDeposit;
	Account account;
	Card card;
	private Calendar startTime;
	private Calendar endTime;
	private int averageMinutes;
	private String transactionType;

	public DepositTransaction(Account account, Card card, Calendar startTime, Double amountDeposit) {
		this.card = card;
		this.startTime = startTime;
		this.account = account;
		this.amountDeposit = amountDeposit;
		setAverageMinutes(10);
		setTransactionType("Deposit");
	}
	
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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
