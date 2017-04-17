package com.facilities.client.observer;

import com.facilities.client.bridge.AlertMessage;
import com.facilities.model.customer.Account;

public abstract class Observer {
	
	public AlertMessage message;
	
	public Observer(AlertMessage message){
		this.message=message;
	}
	public abstract void update(Double ammount, Account account, String operationType);
}
