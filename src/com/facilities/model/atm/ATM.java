package com.facilities.model.atm;

import java.util.List;

import com.facilities.model.customer.Address;
import com.facilities.model.service.ATMTransaction;

public interface ATM {

	public boolean addBalance(Double amount);

	public boolean substractBalance(Double amount);

	public Double getLimit();

	public void setLimit(Double limit);

	public Double getCurrentAmount();

	public void setCurrentAmount(Double currentAmount);

	public boolean isActive();

	public void setActive(boolean active);

	public String getAtmId();

	public void setAtmId(String atmId);

	public Address getAddress();

	public void setAddress(Address address);

	public List<ATMTransaction> getAtmTransactions();

	public void setAtmTransactions(List<ATMTransaction> atmTransactions);

	public boolean performTransaction(ATMTransaction aTMTransaction);

	public String toString();
}
