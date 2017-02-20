package com.facilities.model.maintenance;

import java.util.Calendar;

public class MaintenanceCost {
	private Double cost;
	private String description;
	private Calendar startMaintenance;
	private Calendar endMaintenance;
	private ServiceProvider serviceProvider;
	private long requiredHours;

	public MaintenanceCost(Double cost, String description, Calendar startMaintenance, Calendar endMaintenance,
			ServiceProvider serviceProvider, long requiredHours) {
		this.cost = cost;
		this.description = description;
		this.startMaintenance = startMaintenance;
		this.endMaintenance = endMaintenance;
		this.serviceProvider = serviceProvider;
		this.requiredHours = requiredHours;
	}

	public long getRequiredHours() {
		return requiredHours;
	}

	public void setRequiredHours(long requiredHours) {
		this.requiredHours = requiredHours;
	}

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
