package com.facilities.model.atm;

import java.util.ArrayList;
import java.util.List;

import com.facilities.model.customer.Address;
import com.facilities.model.service.ATMTransaction;

public class ATM {

	private String atmId;
	private Double limit;
	private Double currentAmount;
	private boolean active;
	private List<ATMTransaction> atmTransactions;
	private Address address;

	public ATM(String atmId, Double limit, Double currentAmount, boolean active, Address address) {
		this.atmId = atmId;
		this.limit = limit;
		this.currentAmount = currentAmount;
		this.active = active;
		this.address = address;
	}

	public boolean addBalance(Double amount) {
		currentAmount += amount;
		return true;
	}

	public boolean substractBalance(Double amount) {
		if (currentAmount >= amount) {
			currentAmount -= amount;
			return true;
		}
		return false;
	}

	public Double getLimit() {
		return limit;
	}

	public void setLimit(Double limit) {
		this.limit = limit;
	}

	public Double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(Double currentAmount) {
		this.currentAmount = currentAmount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAtmId() {
		return atmId;
	}

	public void setAtmId(String atmId) {
		this.atmId = atmId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<ATMTransaction> getAtmTransactions() {
		return atmTransactions;
	}

	public void setAtmTransactions(List<ATMTransaction> atmTransactions) {
		this.atmTransactions = atmTransactions;
	}

	public boolean performTransaction(ATMTransaction aTMTransaction) {
		if (active) {
			if (aTMTransaction.processTransaction(this)) {
				if (atmTransactions == null) {
					atmTransactions = new ArrayList<>();
				}
				atmTransactions.add(aTMTransaction);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "ATM [atmId=" + atmId + ", limit=" + limit + ", currentAmount=" + currentAmount + ", active=" + active
				+ ", atmTransactions=" + atmTransactions + ", address=" + address + "]";
	}
}
