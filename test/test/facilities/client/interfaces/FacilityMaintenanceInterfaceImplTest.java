package test.facilities.client.interfaces;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.facilities.client.interfaces.FacilityMaintenanceInterface;
import com.facilities.client.interfacesImpl.FacilityMaintenanceInterfaceImpl;
import com.facilities.commons.utils.BankLoader;
import com.facilities.commons.utils.CommonsUtils;
import com.facilities.commons.utils.MaintenanceOrdersLoader;
import com.facilities.commons.utils.ServiceProviderLoader;
import com.facilities.model.atm.ATM;
import com.facilities.model.maintenance.Diagnostic;
import com.facilities.model.maintenance.MaintenanceCost;
import com.facilities.model.maintenance.MaintenanceRequest;
import com.facilities.model.maintenance.Repair;
import com.facilities.model.maintenance.ServiceProvider;

public class FacilityMaintenanceInterfaceImplTest {
	private FacilityMaintenanceInterface facilityMaintenanceInterface;
	private BankLoader bankLoader;
	private ServiceProviderLoader serviceProviderLoader;
	private List<MaintenanceRequest> listMaintenanceRequest;

	@Before
	public void initialize() {
		facilityMaintenanceInterface = new FacilityMaintenanceInterfaceImpl();
		bankLoader = new BankLoader();
		serviceProviderLoader = new ServiceProviderLoader();
		listMaintenanceRequest = MaintenanceOrdersLoader.getCreateMaintenanceOrdersForPNCATM(bankLoader.getBankPNC());
	}

	// Method to make a Maintenance Request(refill, repair,etc)
	/*
	 * public boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest, ServiceProvider serviceProvider, Calendar startDate, Calendar enDate);
	 */
	@Test
	public void makeFacilityMaintRequestTest() {
		System.out.println("\n@makeFacilityMaintRequestTest");
		System.out.println("We get the PNC_001 atm and create a Diagnostic Maintenance Request");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		MaintenanceRequest maintenanceRequest = new Diagnostic(atmPNC_001, "First Diagnostic Maintenenance");
		assertEquals(maintenanceRequest != null, true);
	}

	// Method to accept the Maintenance Cost and Schedule it
	/* public boolean scheduleMaintenance(MaintenanceRequest maintenanceRequest, MaintenanceCost maintenanceCost); */

	@Test
	public void scheduleMaintenanceTest() {
		System.out.println("\n@scheduleMaintenanceTest");
		System.out.println("We get the PNC_001 atm and create a Diagnostic Maintenance Request");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		MaintenanceRequest maintenanceRequest = new Diagnostic(atmPNC_001, "First Diagnostic Maintenenance");
		ServiceProvider brinks = serviceProviderLoader.getBrinks();
		Calendar startDate = CommonsUtils.getCalendar(02, 25, 2017, 2, 0, 0, 0);
		Calendar endDate = CommonsUtils.getCalendar(02, 25, 2017, 6, 0, 0, 0);
		System.out.println("We process the request and create the cost according to the provider Brinks");
		assertEquals(
				facilityMaintenanceInterface.makeFacilityMaintRequest(maintenanceRequest, brinks, startDate, endDate),
				true);
		System.out.println("A Maintenance Cost is generated, we compare the list size with 1");
		assertEquals(maintenanceRequest.getListMaintenanceCost().size(), 1);
		MaintenanceCost maintenanceCostBrinks = maintenanceRequest.getListMaintenanceCost().get(0);
		System.out.println("Our Maintenance Order should be null");
		assertEquals(maintenanceRequest.getMaintenanceOrder(), null);
		System.out.println("We accept the cost of Brinks and create a Maintenance Order");
		assertEquals(maintenanceCostBrinks.acceptMaintenance(maintenanceRequest), true);
		System.out.println("Our Maintenance Order should not be null");
		assertEquals(maintenanceRequest.getMaintenanceOrder() != null, true);
		System.out.println("Our Maintenance Schedule should 4 because is a Diagnostic Request");
		assertEquals(maintenanceRequest.getMaintenanceOrder().getListMaintenanceSchedule().size(), 4);
	}

	// Cost of all the maintenance in an specific ATM
	/* public Double calcMaintenanceCostForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder); */

	@Test
	public void calcMaintenanceCostForFacilityTest() {
		System.out.println("\n@calcMaintenanceCostForFacilityTest");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println("We calculate the cost of all the maintenance that has been done to the PNC_001 ATM");
		System.out.println(
				"Teh costs are 1000, 2000, 500, 700 and the rating of Brinks is 3, so we should have a total cost of 12600");
		assertEquals((Object) facilityMaintenanceInterface.calcMaintenanceCostForFacility(atmPNC_001,
				listMaintenanceRequest), (Object) 12600.0);
		System.out.println("We add one more Diagnostic Request");
		MaintenanceRequest maintenanceRequest = new Diagnostic(atmPNC_001, "Second Diagnostic Maintenenance");
		listMaintenanceRequest.add(maintenanceRequest);
		ServiceProvider brinks = serviceProviderLoader.getBrinks();
		Calendar startDate = CommonsUtils.getCalendar(02, 19, 2017, 2, 0, 0, 0);
		Calendar endDate = CommonsUtils.getCalendar(02, 19, 2017, 6, 0, 0, 0);
		maintenanceRequest.calculateCosts(brinks, startDate, endDate);
		System.out.println(
				"We calculate the cost of all the maintenance, this should be 12600 again because we have not approved the request");
		assertEquals(facilityMaintenanceInterface.calcMaintenanceCostForFacility(atmPNC_001, listMaintenanceRequest),
				(Object) 12600.0);
		System.out.println("Once we aprove the cost, this should increase by 3000 (1000 x 3) because is diagostic");
		maintenanceRequest.getListMaintenanceCost().get(0).acceptMaintenance(maintenanceRequest);
		assertEquals(facilityMaintenanceInterface.calcMaintenanceCostForFacility(atmPNC_001, listMaintenanceRequest),
				(Object) 15600.0);
	}

	// Total times and ATM has been to maintenance
	/* public long calcProblemRateForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder); */

	@Test
	public void calcProblemRateForFacilityTest() {
		System.out.println("\n@calcProblemRateForFacilityTest");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println("We calculate how many times the PNC_001 ATM has been in maintenance, this should list 4");
		assertEquals(facilityMaintenanceInterface.calcProblemRateForFacility(atmPNC_001, listMaintenanceRequest), 4);
		System.out.println("We add one more Diagnostic Request");
		MaintenanceRequest maintenanceRequest = new Diagnostic(atmPNC_001, "Second Diagnostic Maintenenance");
		listMaintenanceRequest.add(maintenanceRequest);
		ServiceProvider brinks = serviceProviderLoader.getBrinks();
		Calendar startDate = CommonsUtils.getCalendar(02, 19, 2017, 2, 0, 0, 0);
		Calendar endDate = CommonsUtils.getCalendar(02, 19, 2017, 6, 0, 0, 0);
		maintenanceRequest.calculateCosts(brinks, startDate, endDate);
		System.out.println(
				"We calculate how many times the PNC_001 ATM has been in maintenance, this should list 4 again because we have not approved the request");
		assertEquals(facilityMaintenanceInterface.calcProblemRateForFacility(atmPNC_001, listMaintenanceRequest), 4);
		System.out
				.println("Once we aprove the cost, this should list 5 again because we have not approved the request");
		maintenanceRequest.getListMaintenanceCost().get(0).acceptMaintenance(maintenanceRequest);
		assertEquals(facilityMaintenanceInterface.calcProblemRateForFacility(atmPNC_001, listMaintenanceRequest), 5);

	}

	// Total hours of maintenance for facility
	/* public long calcDownTimeForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder); */

	@Test
	public void calcDownTimeForFacilityTest() {
		System.out.println("\n@calcDownTimeForFacilityTest");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println(
				"We calculate how many hours the PNC_001 ATM has been under maintenance, (4,4,4,4) this should list 16");
		assertEquals(facilityMaintenanceInterface.calcDownTimeForFacility(atmPNC_001, listMaintenanceRequest), 16);
		System.out.println("We add one more Diagnostic Request, meaning 4 hours maintenance more");
		MaintenanceRequest maintenanceRequest = new Diagnostic(atmPNC_001, "Second Diagnostic Maintenenance");
		listMaintenanceRequest.add(maintenanceRequest);
		ServiceProvider brinks = serviceProviderLoader.getBrinks();
		Calendar startDate = CommonsUtils.getCalendar(02, 19, 2017, 2, 0, 0, 0);
		Calendar endDate = CommonsUtils.getCalendar(02, 19, 2017, 6, 0, 0, 0);
		maintenanceRequest.calculateCosts(brinks, startDate, endDate);
		System.out.println(
				"We calculate how many hours the PNC_001 ATM has been under maintenance, this should list 16 again because we have not approved the cost");
		assertEquals(facilityMaintenanceInterface.calcDownTimeForFacility(atmPNC_001, listMaintenanceRequest), 16);
		System.out.println("Once we aprove the cost, this should be 20 this time because we are adding 4 hours");
		maintenanceRequest.getListMaintenanceCost().get(0).acceptMaintenance(maintenanceRequest);
		assertEquals(facilityMaintenanceInterface.calcDownTimeForFacility(atmPNC_001, listMaintenanceRequest), 20);
	}
	// All maintenance Request on a ATM
	/* public List<MaintenanceRequest> listMaintRequests(ATM atm, List<MaintenanceRequest> MaintenanceRequest); */

	@Test
	public void listMaintRequestsTest() {
		System.out.println("\n@listMaintRequestsTest");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println(
				"We calculate how many maintenance request had been set on the PNC_001 ATM, this should list 4");
		assertEquals(facilityMaintenanceInterface.listMaintRequests(atmPNC_001, listMaintenanceRequest).size(), 4);
		System.out.println("We add one more Diagnostic Request, meaning 1 more request on the list");
		MaintenanceRequest maintenanceRequest = new Diagnostic(atmPNC_001, "Second Diagnostic Maintenenance");
		listMaintenanceRequest.add(maintenanceRequest);
		ServiceProvider brinks = serviceProviderLoader.getBrinks();
		Calendar startDate = CommonsUtils.getCalendar(02, 19, 2017, 2, 0, 0, 0);
		Calendar endDate = CommonsUtils.getCalendar(02, 19, 2017, 6, 0, 0, 0);
		maintenanceRequest.calculateCosts(brinks, startDate, endDate);
		System.out.println(
				"We calculate how maintenance request had been set on the PNC_001 ATM, this should list 5 because is independant of approval");
		assertEquals(facilityMaintenanceInterface.listMaintRequests(atmPNC_001, listMaintenanceRequest).size(), 5);
		System.out.println("Once we aprove, it should still be listing 5");
		maintenanceRequest.getListMaintenanceCost().get(0).acceptMaintenance(maintenanceRequest);
		assertEquals(facilityMaintenanceInterface.listMaintRequests(atmPNC_001, listMaintenanceRequest).size(), 5);
	}
	// List all Maintenance Orders in a Specific ATM
	/* public List<MaintenanceOrder> listMaintenance(ATM atm, List<MaintenanceOrder> listMaintenanceRequest); */

	@Test
	public void listMaintenanceTest() {
		System.out.println("\n@listMaintenanceTest");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println(
				"We calculate how maintenance request had been processed on the PNC_001 ATM, this should list 4");
		assertEquals(facilityMaintenanceInterface.listMaintenance(atmPNC_001, listMaintenanceRequest).size(), 4);
		System.out.println("We add one more Diagnostic Request, meaning 1 more request on the list");
		MaintenanceRequest maintenanceRequest = new Diagnostic(atmPNC_001, "Second Diagnostic Maintenenance");
		listMaintenanceRequest.add(maintenanceRequest);
		ServiceProvider brinks = serviceProviderLoader.getBrinks();
		Calendar startDate = CommonsUtils.getCalendar(02, 19, 2017, 2, 0, 0, 0);
		Calendar endDate = CommonsUtils.getCalendar(02, 19, 2017, 6, 0, 0, 0);
		maintenanceRequest.calculateCosts(brinks, startDate, endDate);
		System.out.println(
				"We calculate how maintenance request had been processed on the PNC_001 ATM,, this should list 4 because it requires approval");
		assertEquals(facilityMaintenanceInterface.listMaintenance(atmPNC_001, listMaintenanceRequest).size(), 4);
		System.out.println("Once we aprove, it should still be listing 5");
		maintenanceRequest.getListMaintenanceCost().get(0).acceptMaintenance(maintenanceRequest);
		List<MaintenanceRequest> result = facilityMaintenanceInterface.listMaintenance(atmPNC_001,
				listMaintenanceRequest);
		assertEquals(result.size(), 5);
		System.out.println("last position on List should be the las request that was approved");
		assertEquals(result.get(result.size() - 1), maintenanceRequest);
	}

	// List all Maintenance Orders of an specific type of an ATM
	/*
	 * public List<MaintenanceOrder> listFacilityProblems(ATM atm, List<MaintenanceOrder> listMaintenanceOrder, String maintenanceType);
	 */
	@Test
	public void listFacilityProblemsTest() {
		System.out.println("\n@listFacilityProblemsTest");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println(
				"We calculate how maintenance REPAIR request had been made on the PNC_001 ATM, this should list 1");
		assertEquals(
				facilityMaintenanceInterface.listFacilityProblems(atmPNC_001, listMaintenanceRequest, "REPAIR").size(),
				1);
		System.out.println("We add one more Repair Request, meaning 1 more request on the list");
		MaintenanceRequest maintenanceRequest = new Repair(atmPNC_001, "Second Repair Maintenenance");
		listMaintenanceRequest.add(maintenanceRequest);
		ServiceProvider brinks = serviceProviderLoader.getBrinks();
		Calendar startDate = CommonsUtils.getCalendar(02, 19, 2017, 2, 0, 0, 0);
		Calendar endDate = CommonsUtils.getCalendar(02, 19, 2017, 6, 0, 0, 0);
		maintenanceRequest.calculateCosts(brinks, startDate, endDate);
		System.out.println(
				"We calculate how maintenance REPAIR request had been made on the PNC_001 ATM, this should list 1 because it requires approval");
		assertEquals(
				facilityMaintenanceInterface.listFacilityProblems(atmPNC_001, listMaintenanceRequest, "REPAIR").size(),
				1);
		System.out.println("Once we aprove, it should still be listing 2");
		maintenanceRequest.getListMaintenanceCost().get(0).acceptMaintenance(maintenanceRequest);
		List<MaintenanceRequest> result = facilityMaintenanceInterface.listFacilityProblems(atmPNC_001,
				listMaintenanceRequest, "REPAIR");
		assertEquals(result.size(), 2);
		System.out.println("last position on List should be the las request that was approved");
		assertEquals(result.get(result.size() - 1), maintenanceRequest);
	}
}
