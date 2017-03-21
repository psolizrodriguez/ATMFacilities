package com.facilities.model.maintenance;

import java.util.Calendar;
import java.util.List;

import com.facilities.model.atm.ATM;

public interface MaintenanceRequest {

	public Double getAmountToReplenish();

	public void setAmountToReplenish(Double amountToReplenish);

	public MaintenanceOrder getMaintenanceOrder();

	public void setMaintenanceOrder(MaintenanceOrder maintenanceOrder);

	public String getMaintenanceType();

	public void setMaintenanceType(String maintenanceType);

	public int getAverageHours();

	public void setAverageHours(int averageHours);

	public Double getAverageCost();

	public void setAverageCost(Double averageCost);

	public String getDescription();

	public void setDescription(String description);

	public boolean isClosed();

	public void setClosed(boolean closed);

	public ATM getAtm();

	public void setAtm(ATM atm);

	public List<MaintenanceCost> getListMaintenanceCost();

	public void setListMaintenanceCost(List<MaintenanceCost> listMaintenanceCost);

	public boolean calculateCosts(ServiceProvider serviceProvider, Calendar startDate, Calendar enDate);

	public boolean addCostsToList(MaintenanceCost maintenanceCost);

}
