package com.facilities.model.customer;

public interface Account {

	public Customer getOwner();

	public void setOwner(Customer owner);

	public String getType();

	public void setType(String type);

	public String getAccountNumber();

	public void setAccountNumber(String accountNumber);

	public Double getBalance();

	public void setBalance(Double balance);

	public abstract boolean credit(Double ammount);

	public abstract boolean debit(Double ammount);
}
