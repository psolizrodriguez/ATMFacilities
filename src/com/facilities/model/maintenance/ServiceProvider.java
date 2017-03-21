package com.facilities.model.maintenance;

import java.util.Calendar;
import java.util.List;

import com.facilities.model.customer.Address;

public interface ServiceProvider {

	public String getLegalName();

	public void setLegalName(String legalName);

	public int getRating();

	public void setRating(int rating);

	public List<Address> getListAddress();

	public void setListAddress(List<Address> listAddress);

	public boolean calculateCosts(MaintenanceRequest maintenanceRequest, Calendar startDate, Calendar endDate);

	public boolean generateMaintainingSchedule(MaintenanceCost maintenanceCost, MaintenanceRequest maintenanceRequest);

}
