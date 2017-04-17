package com.facilities.client.bridge;

import com.facilities.model.customer.Customer;

public interface AlertMessage {
	
	public void sendAlert(Customer customer, String operationType);

}
