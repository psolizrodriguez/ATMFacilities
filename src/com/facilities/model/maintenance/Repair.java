package com.facilities.model.maintenance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.facilities.model.atm.ATM;

public class Repair implements MaintenanceRequest {
	public Repair(ATM atm, String description) {
		this.atm = atm;
		this.description = description;
		this.setAverageHours(8);
		this.setAverageCost(2000.0);
		this.setMaintenanceType("REPAIR");
	}

	@Override
	public boolean calculateCosts(ServiceProvider serviceProvider, Calendar startDate, Calendar enDate) {
		return serviceProvider.calculateCosts(this, startDate, enDate);
	}

	private String description;
	private boolean closed;
	private ATM atm;
	private int averageHours;
	private Double averageCost;
	private String maintenanceType;
	private MaintenanceOrder maintenanceOrder;
	private Double amountToReplenish;

	public Double getAmountToReplenish() {
		return amountToReplenish;
	}

	public void setAmountToReplenish(Double amountToReplenish) {
		this.amountToReplenish = amountToReplenish;
	}

	public MaintenanceOrder getMaintenanceOrder() {
		return maintenanceOrder;
	}

	public void setMaintenanceOrder(MaintenanceOrder maintenanceOrder) {
		this.maintenanceOrder = maintenanceOrder;
	}

	private List<MaintenanceCost> listMaintenanceCost;

	public String getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(String maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

	public int getAverageHours() {
		return averageHours;
	}

	public void setAverageHours(int averageHours) {
		this.averageHours = averageHours;
	}

	public Double getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(Double averageCost) {
		this.averageCost = averageCost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	public List<MaintenanceCost> getListMaintenanceCost() {
		return listMaintenanceCost;
	}

	public void setListMaintenanceCost(List<MaintenanceCost> listMaintenanceCost) {
		this.listMaintenanceCost = listMaintenanceCost;
	}

	public boolean addCostsToList(MaintenanceCost maintenanceCost) {
		if (listMaintenanceCost == null) {
			listMaintenanceCost = new ArrayList<>();
		}
		return listMaintenanceCost.add(maintenanceCost);

	}
}
