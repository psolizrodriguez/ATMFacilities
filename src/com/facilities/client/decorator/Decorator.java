package com.facilities.client.decorator;

import com.facilities.client.bridge.FormatMessage;
import com.facilities.client.bridge.Message;
import com.facilities.model.customer.Account;

public abstract class Decorator implements FormatMessage {

	protected FormatMessage formatMessage;
	
	public Decorator(FormatMessage formatMessage){
		this.formatMessage = formatMessage;
	}
	
	@Override
	public void prepareMessage(Account account, Double ammount, Message message) {
		formatMessage.prepareMessage(account, ammount, message);
		
	}

}
