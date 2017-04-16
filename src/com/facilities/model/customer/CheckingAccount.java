package com.facilities.model.customer;

import java.util.ArrayList;

import com.facilities.client.observer.Observer;
import com.facilities.client.observer.Subject;

public class CheckingAccount implements Account, Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private Customer owner;
	private String type;
	private String accountNumber;
	private Double balance;

	public CheckingAccount(Customer owner, String accountNumber, Double balance) {
		this.owner = owner;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.type = "Checking";
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public boolean credit(Double ammount) {
		this.setBalance(this.getBalance() + ammount);
		notifyObservers(ammount, "credit");
		return true;
	}

	@Override
	public boolean debit(Double ammount) {
		this.setBalance(this.getBalance() - ammount);
		notifyObservers(ammount, "debit");
		return true;
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObservers(Double ammount, String operationType) {
		for (Observer ob : observers) {
			ob.update(ammount, this, operationType);
		}

	}

}
