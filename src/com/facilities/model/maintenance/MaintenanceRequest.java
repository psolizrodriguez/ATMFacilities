package com.facilities.model.maintenance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.facilities.model.atm.ATM;

public abstract class MaintenanceRequest {
	private String description;
	private boolean closed;
	private ATM atm;
	private int averageHours;
	private Double averageCost;
	private String maintenanceType;
	private MaintenanceOrder maintenanceOrder;

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

	public MaintenanceRequest(ATM atm, String description) {
		this.atm = atm;
		this.description = description;
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

	public abstract boolean calculateCosts(ServiceProvider serviceProvider, Calendar startDate, Calendar enDate);

	public boolean addCostsToList(MaintenanceCost maintenanceCost) {
		if (listMaintenanceCost == null) {
			listMaintenanceCost = new ArrayList<>();
		}
		return listMaintenanceCost.add(maintenanceCost);

	}

}
