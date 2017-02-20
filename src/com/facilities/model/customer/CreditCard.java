package com.facilities.model.customer;

import java.util.Calendar;
import java.util.List;

public class CreditCard extends Card {

	public CreditCard(Customer owner, String cardNumber, String pinNumber, String securityCode, Calendar validDate,
			Address address, List<Account> accounts) {
		super(owner, cardNumber, pinNumber, securityCode, validDate, address, accounts);
		// TODO Auto-generated constructor stub
	}

}
