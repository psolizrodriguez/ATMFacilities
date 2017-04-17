package com.facilities.client.bridge;

import com.facilities.model.customer.Account;

public interface FormatMessage {

	public void prepareMessage(Account account, Double ammount, Message message);

}
