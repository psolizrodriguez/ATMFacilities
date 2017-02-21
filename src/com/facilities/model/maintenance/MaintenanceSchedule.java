package com.facilities.model.maintenance;

import java.util.Calendar;

public class MaintenanceSchedule {
	private Calendar startMaintenance;
	private Calendar endMaintenance;
	private String description;
	private int status;

	public MaintenanceSchedule(Calendar startMaintenance, Calendar endMaintenance, String description) {
		this.startMaintenance = startMaintenance;
		this.endMaintenance = endMaintenance;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
