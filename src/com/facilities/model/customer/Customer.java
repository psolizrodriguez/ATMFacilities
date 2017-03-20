package com.facilities.model.customer;

import java.util.List;

public interface Customer {

	public List<Account> getAccounts();

	public void setAccounts(List<Account> accounts);

	public List<Card> getDebitCards();

	public void setDebitCards(List<Card> debitCards);

	public Address getBillingAddress();

	public void setBillingAddress(Address billingAddress);

	public Address getShippingAddress();

	public void setShippingAddress(Address shippingAddress);

	public String getCustomerId();

	public void setCustomerId(String id);

	public String getLastName();

	public void setLastName(String lastName);

	public String getFirstName();

	public void setFirstName(String firstName);
}
