package com.facilities.model.customer;

import java.util.Calendar;
import java.util.List;

public class DebitCard extends Card {

	public DebitCard(Customer owner, String cardNumber, String pinNumber, String securityCode, Calendar validDate,
			Address address, List<Account> accounts) {
		super(owner, cardNumber, pinNumber, securityCode, validDate, address, accounts);
	}

}
