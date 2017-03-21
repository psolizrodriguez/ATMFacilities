package com.facilities.commons.utils;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.facilities.client.interfaces.FacilityClientInterface;
import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;
import com.facilities.model.atm.BankImpl;
import com.facilities.model.maintenance.MaintenanceRequest;
import com.facilities.model.maintenance.ServiceProvider;
import com.facilities.model.maintenance.ServiceProviderImpl;
import com.facilities.model.service.DepositTransaction;
import com.facilities.model.service.PINValidationTransaction;
import com.facilities.model.service.TransferTransaction;
import com.facilities.model.service.WithdrawlTransaction;

public class BankLoader {

	public static Bank getBankPNC(ApplicationContext context) {
		return (BankImpl) context.getBean("bankPNC");
	}

	public static ServiceProvider getPls247(ApplicationContext context) {
		return (ServiceProviderImpl) context.getBean("pls247");
	}

	public static ServiceProvider getBrinks(ApplicationContext context) {
		return (ServiceProviderImpl) context.getBean("brinks");
	}

	public static void loadTransactionsPNC(Bank bank, ApplicationContext context,
			FacilityClientInterface facilityClientInterface) {

		ATM atmPNC_001 = bank.getAtms().get(0);
		facilityClientInterface.addFacilityDetail(atmPNC_001,
				(PINValidationTransaction) context.getBean("atm_PNC_001_pinValidation"));
		facilityClientInterface.addFacilityDetail(atmPNC_001,
				(DepositTransaction) context.getBean("atm_PNC_001_depositTransaction"));
		facilityClientInterface.addFacilityDetail(atmPNC_001,
				(WithdrawlTransaction) context.getBean("atm_PNC_001_withdrawlTransaction"));
		facilityClientInterface.addFacilityDetail(atmPNC_001,
				(TransferTransaction) context.getBean("atm_PNC_001_transferTransaction"));
	}
	
	public static void getCreateMaintenanceOrdersForPNCATM(List<MaintenanceRequest> listMaintenanceRequest,
			ServiceProvider brinks, ServiceProvider pls247) {

		listMaintenanceRequest.get(0).calculateCosts(brinks, CommonsUtils.getCalendar(02, 25, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 25, 2017, 6, 0, 0, 0));
		listMaintenanceRequest.get(1).calculateCosts(brinks, CommonsUtils.getCalendar(02, 26, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 26, 2017, 6, 0, 0, 0));
		listMaintenanceRequest.get(2).calculateCosts(brinks, CommonsUtils.getCalendar(02, 27, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 27, 2017, 6, 0, 0, 0));
		listMaintenanceRequest.get(3).calculateCosts(brinks, CommonsUtils.getCalendar(02, 28, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 28, 2017, 6, 0, 0, 0));
		System.out.println("PLS247 Calculate Costs for all the Requests");
		listMaintenanceRequest.get(0).calculateCosts(pls247, CommonsUtils.getCalendar(02, 25, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 25, 2017, 6, 0, 0, 0));
		listMaintenanceRequest.get(1).calculateCosts(pls247, CommonsUtils.getCalendar(02, 26, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 26, 2017, 6, 0, 0, 0));
		listMaintenanceRequest.get(2).calculateCosts(pls247, CommonsUtils.getCalendar(02, 27, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 27, 2017, 6, 0, 0, 0));
		listMaintenanceRequest.get(3).calculateCosts(pls247, CommonsUtils.getCalendar(02, 28, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 28, 2017, 6, 0, 0, 0));
		System.out.println("We accept all the Brinks Cost and proceed to create an order");
		listMaintenanceRequest.get(0).getListMaintenanceCost().get(0).acceptMaintenance(listMaintenanceRequest.get(0));
		listMaintenanceRequest.get(1).getListMaintenanceCost().get(0).acceptMaintenance(listMaintenanceRequest.get(1));
		listMaintenanceRequest.get(2).getListMaintenanceCost().get(0).acceptMaintenance(listMaintenanceRequest.get(2));
		listMaintenanceRequest.get(3).getListMaintenanceCost().get(0).acceptMaintenance(listMaintenanceRequest.get(3));
	}
}
