package com.facilities.model.maintenance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.customer.Address;

public class ServiceProvider {
	private String legalName;
	private int rating;
	private List<Address> listAddress;

	public ServiceProvider(String legalName, int rating) {
		this.legalName = legalName;
		this.rating = rating;
	}

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

	public boolean calculateCosts(MaintenanceRequest maintenanceRequest, Calendar startDate, Calendar endDate) {
		MaintenanceCost maintenanceCost = new MaintenanceCost(maintenanceRequest.getAverageCost() * rating,
				legalName + rating, startDate, endDate, this, CommonsUtils.hoursBetween(startDate, endDate));
		return maintenanceRequest.addCostsToList(maintenanceCost);
	}

	public boolean generateMaintainingSchedule(MaintenanceCost maintenanceCost, MaintenanceRequest maintenanceRequest) {
		MaintenanceOrder maintenanceOrder = new MaintenanceOrder(maintenanceCost);
		List<MaintenanceSchedule> listMaintenanceSchedule = new ArrayList<>();
		Calendar startDate = CommonsUtils.copyCalendar(maintenanceCost.getStartMaintenance());
		Calendar endDate = CommonsUtils.copyCalendar(maintenanceCost.getStartMaintenance());
		for (int i = 0; i < maintenanceCost.getRequiredHours(); i++) {
			endDate.add(Calendar.HOUR, 1);
			listMaintenanceSchedule.add(new MaintenanceSchedule(startDate, endDate, "Hour " + (i + 1)));
		}
		maintenanceOrder.setListMaintenanceSchedule(listMaintenanceSchedule);
		maintenanceRequest.setMaintenanceOrder(maintenanceOrder);
		return true;
	}

}
