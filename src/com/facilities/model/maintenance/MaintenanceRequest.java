package com.facilities.model.maintenance;

import java.util.Calendar;

import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;

public abstract class MaintenanceRequest {
	private Double cost;
	private String description;
	private int requestStatus;
	private Bank bank;
	private ATM atm;
	private Calendar startMaintenance;
	private Calendar endMaintenance;
	private ServiceProvider serviceProvider;

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	public Calendar getStartMaintenance() {
		return startMaintenance;
	}

	public void setStartMaintenance(Calendar startMaintenance) {
		this.startMaintenance = startMaintenance;
	}

	public Calendar getEndMaintenance() {
		return endMaintenance;
	}

	public void setEndMaintenance(Calendar endMaintenance) {
		this.endMaintenance = endMaintenance;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

}
