package com.facilities.model.maintenance;

import java.util.List;

public class MaintenanceOrder {
	private MaintenanceRequest maintenanceRequest;
	private MaintenanceCost maintenanceCost;
	private int orderStatus;

	public MaintenanceCost getMaintenanceCost() {
		return maintenanceCost;
	}

	public void setMaintenanceCost(MaintenanceCost maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	private List<MaintenanceSchedule> listMaintenanceSchedule;

	public MaintenanceRequest getMaintenanceRequest() {
		return maintenanceRequest;
	}

	public void setMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
		this.maintenanceRequest = maintenanceRequest;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<MaintenanceSchedule> getListMaintenanceSchedule() {
		return listMaintenanceSchedule;
	}

	public void setListMaintenanceSchedule(List<MaintenanceSchedule> listMaintenanceSchedule) {
		this.listMaintenanceSchedule = listMaintenanceSchedule;
	}

}
