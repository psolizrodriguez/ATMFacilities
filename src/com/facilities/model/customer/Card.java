package com.facilities.model.customer;

import java.util.Calendar;
import java.util.List;

public interface Card {

	public Customer getOwner();

	public void setOwner(Customer owner);

	public String getCardNumber();

	public void setCardNumber(String cardNumber);

	public String getPinNumber();

	public void setPinNumber(String pinNumber);

	public String getSecurityCode();

	public void setSecurityCode(String securityCode);

	public Calendar getValidDate();

	public void setValidDate(Calendar validDate);

	public Address getAddress();

	public void setAddress(Address address);

	public List<Account> getAccounts();

	public void setAccounts(List<Account> accounts);
}
