package com.facilities.client.observer;

import com.facilities.client.bridge.EmailAlertMessage;
import com.facilities.client.bridge.Message;
import com.facilities.client.bridge.SMSAlertMessage;
import com.facilities.client.bridge.WithdrawalMessage;
import com.facilities.client.decorator.NotificationDecorator;
import com.facilities.client.decorator.TransactionalDecorator;
import com.facilities.model.customer.Account;

public class WithdrawAlert implements Observer {

	@Override
	public void update(Double ammount, Account account, String operationType) {
		if (operationType.equals("debit")) {
		// Depending on the preferences of the account we proceed to send the respective alerts
		Message[] messages = new Message[] { new WithdrawalMessage(new TransactionalDecorator(new EmailAlertMessage()), account, ammount),
				new WithdrawalMessage(new TransactionalDecorator(new SMSAlertMessage()), account, ammount) };
		for (Message message : messages) {
			message.format(); // We send the messages
		}
		}
	}

}