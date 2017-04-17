package com.facilities.client.observer;

import com.facilities.model.customer.Account;

public interface Observer {
	public abstract void update(Double ammount, Account account, String operationType);
}
