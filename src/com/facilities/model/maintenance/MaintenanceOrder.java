package com.facilities.model.maintenance;

import java.util.List;

public class MaintenanceOrder {
	private MaintenanceCost maintenanceCost;
	private String orderStatus;
	private List<MaintenanceSchedule> listMaintenanceSchedule;

	public MaintenanceOrder(MaintenanceCost maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	public MaintenanceCost getMaintenanceCost() {
		return maintenanceCost;
	}

	public void setMaintenanceCost(MaintenanceCost maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
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
