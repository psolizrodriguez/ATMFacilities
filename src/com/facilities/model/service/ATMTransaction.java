package com.facilities.model.service;

import java.util.Calendar;

import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;

public interface ATMTransaction {

	public String getTransactionType();

	public void setTransactionType(String transactionType);

	public int getAverageMinutes();

	public void setAverageMinutes(int averageMinutes);

	public Calendar getStartTime();

	public void setStartTime(Calendar startTime);

	public Calendar getEndTime();

	public void setEndTime(Calendar endTime);

	public Card getCard();

	public void setCard(Card card);

	public Account getAccount();

	public void setAccount(Account account);

	public boolean processTransaction(ATM atm);
}
