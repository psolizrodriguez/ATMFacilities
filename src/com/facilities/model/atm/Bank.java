package com.facilities.model.atm;

import java.util.List;

import com.facilities.model.customer.Card;
import com.facilities.model.customer.Customer;

public interface Bank {
	public List<Customer> getCustomers();

	public void setCustomers(List<Customer> customers);

	public List<Card> getDebitCards();

	public void setDebitCards(List<Card> debitCards);

	public List<ATM> getAtms();

	public void setAtms(List<ATM> atms);

}
