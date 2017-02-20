package com.facilities.model.maintenance;

import java.util.List;

import com.facilities.model.customer.Address;

public class ServiceProvider {
	private String legalName;
	private int rating;
	private List<Address> listAddress;
	private List<MaintenanceOrder> maintenanceOrder;

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Address> getListAddress() {
		return listAddress;
	}

	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}

	public List<MaintenanceOrder> getMaintenanceOrder() {
		return maintenanceOrder;
	}

	public void setMaintenanceOrder(List<MaintenanceOrder> maintenanceOrder) {
		this.maintenanceOrder = maintenanceOrder;
	}

}
