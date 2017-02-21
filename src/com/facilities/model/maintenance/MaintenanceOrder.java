package com.facilities.model.maintenance;

import java.util.List;

public class MaintenanceOrder {
	private MaintenanceRequest maintenanceRequest;
	private MaintenanceCost maintenanceCost;
	private String orderStatus;
	private List<MaintenanceSchedule> listMaintenanceSchedule;

	public MaintenanceOrder(MaintenanceRequest maintenanceRequest, MaintenanceCost maintenanceCost) {
		this.maintenanceRequest = maintenanceRequest;
		this.maintenanceCost = maintenanceCost;
	}

	public MaintenanceCost getMaintenanceCost() {
		return maintenanceCost;
	}

	public void setMaintenanceCost(MaintenanceCost maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	public MaintenanceRequest getMaintenanceRequest() {
		return maintenanceRequest;
	}

	public void setMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
		this.maintenanceRequest = maintenanceRequest;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<MaintenanceSchedule> getListMaintenanceSchedule() {
		return listMaintenanceSchedule;
	}

	public void setListMaintenanceSchedule(List<MaintenanceSchedule> listMaintenanceSchedule) {
		this.listMaintenanceSchedule = listMaintenanceSchedule;
	}

}
