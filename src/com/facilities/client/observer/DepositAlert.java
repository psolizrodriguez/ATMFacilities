package com.facilities.client.observer;

import com.facilities.client.bridge.DepositMessage;
import com.facilities.client.bridge.EmailAlertMessage;
import com.facilities.client.bridge.Message;
import com.facilities.client.bridge.SMSAlertMessage;
import com.facilities.client.decorator.Decorator;
import com.facilities.client.decorator.NotificationDecorator;
import com.facilities.client.decorator.TransactionalDecorator;
import com.facilities.model.customer.Account;

public class DepositAlert implements Observer {

	@Override
	public void update(Double ammount, Account account, String operationType) {
		if (operationType.equals("credit")) {
			// Depending on the preferences of the account we proceed to send the respective alerts
			Message[] messages = new Message[] { new DepositMessage(new NotificationDecorator(new EmailAlertMessage()), account, ammount),
					new DepositMessage(new NotificationDecorator(new SMSAlertMessage()), account, ammount) };
			for (Message message : messages) {
				message.format(); // We send the messages
			}
		}
	}

}