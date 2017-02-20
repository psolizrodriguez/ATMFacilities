package test.facilities.client.interfaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.facilities.client.interfaces.FacilityClientInterface;
import com.facilities.client.interfacesImpl.FacilityClientInterfaceImpl;
import com.facilities.commons.utils.ATMLoader;
import com.facilities.commons.utils.BankLoader;
import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Address;
import com.facilities.model.customer.Card;
import com.facilities.model.service.ATMTransaction;
import com.facilities.model.service.DepositTransaction;
import com.facilities.model.service.PINValidationTransaction;
import com.facilities.model.service.TransferTransaction;
import com.facilities.model.service.WithdrawlTransaction;

public class FacilityClientInterfaceImplTest {
	private FacilityClientInterface facilityClientInterface;
	private BankLoader bankLoader;

	@Before
	public void initialize() {
		facilityClientInterface = new FacilityClientInterfaceImpl();
		bankLoader = new BankLoader();
	}

	@Test
	public void testListFacilities() {
		System.out.println("@Test testListFacilities()");
		assertEquals(facilityClientInterface.listFacilities(bankLoader.getBankPNC()).size(),
				ATMLoader.getPNCATMList().size());
		System.out.println("@Test PNB Bank ATM Count = " + ATMLoader.getPNCATMList().size());

		assertEquals(facilityClientInterface.listFacilities(bankLoader.getBankOfAmerica()).size(),
				ATMLoader.getBOAATMList().size());
		System.out.println("@Test BOA Bank ATM Count = " + ATMLoader.getBOAATMList().size());

		assertEquals(facilityClientInterface.listFacilities(bankLoader.getBankCitibank()).size(),
				ATMLoader.getCBATMList().size());
		System.out.println("@Test Citi Bank ATM Count = " + ATMLoader.getCBATMList().size());

		assertEquals(facilityClientInterface.listFacilities(bankLoader.getChaseBank()).size(),
				ATMLoader.getCHASEATMList().size());
		System.out.println("@Test Chase Bank ATM Count = " + ATMLoader.getCHASEATMList().size());
	}

	@Test
	public void testAddNewFacility() {

		System.out.println("@Test testAddNewFacility()");
		// PNC
		ATM atm_PNC_001 = new ATM("PNC_001", 20000.0, 0.0, true,
				new Address("ADDRESS_1", "26 E Pearson St", "1", "Chicago", "IL", "60611"));
		assertNotNull(atm_PNC_001);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankPNC(), atm_PNC_001), true);
		System.out.println("Added : " + atm_PNC_001.toString());

		ATM atm_PNC_002 = new ATM("PNC_002", 20000.0, 0.0, true,
				new Address("ADDRESS_2", "1068 W Granville Ave", "2", "Chicago", "IL", "60660"));
		assertNotNull(atm_PNC_002);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankPNC(), atm_PNC_002), true);
		System.out.println("Added : " + atm_PNC_002.toString());

		ATM atm_PNC_003 = new ATM("PNC_003", 30000.0, 0.0, true,
				new Address("ADDRESS_3", "4309 S Morgan St", "3", "Chicago", "IL", "60609"));
		assertNotNull(atm_PNC_003);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankPNC(), atm_PNC_003), true);
		System.out.println("Added : " + atm_PNC_003.toString());

		ATM atm_PNC_004 = new ATM("PNC_004", 50000.0, 0.0, true,
				new Address("ADDRESS_4", "13 Garden St", "4", "Chicago", "IL", "60661"));
		assertNotNull(atm_PNC_004);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankPNC(), atm_PNC_004), true);
		System.out.println("Added : " + atm_PNC_004.toString());

		// BOA
		ATM atm_BOA_001 = new ATM("BOA_001", 40000.0, 0.0, true,
				new Address("ADDRESS_1", "11 E Wabash Ct", "5", "Evanston", "IL", "60634"));
		assertNotNull(atm_BOA_001);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankOfAmerica(), atm_BOA_001), true);
		System.out.println("Added : " + atm_BOA_001.toString());

		ATM atm_BOA_002 = new ATM("BOA_002", 70000.0, 0.0, true,
				new Address("ADDRESS_2", "1432 S Canal St", "6", "Chicago", "IL", "60687"));
		assertNotNull(atm_BOA_002);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankOfAmerica(), atm_BOA_002), true);
		System.out.println("Added : " + atm_BOA_002.toString());

		ATM atm_BOA_003 = new ATM("BOA_003", 90000.0, 0.0, true,
				new Address("ADDRESS_3", "88 Madison Park", "7", "Ravenswood", "IL", "60600"));
		assertNotNull(atm_BOA_003);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankOfAmerica(), atm_BOA_003), true);
		System.out.println("Added : " + atm_BOA_003.toString());

		ATM atm_BOA_004 = new ATM("BOA_004", 10000.0, 0.0, true,
				new Address("ADDRESS_4", "88 Glenlake Ave", "8", "Lake Forest", "IL", "60169"));
		assertNotNull(atm_BOA_004);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankOfAmerica(), atm_BOA_004), true);
		System.out.println("Added : " + atm_BOA_004.toString());

		// Citi Bank
		ATM atm_CB_001 = new ATM("CB_001", 55000.0, 0.0, true,
				new Address("ADDRESS_1", "26 E Arch Drive", "9", "Elgin", "IL", "60611"));
		assertNotNull(atm_CB_001);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankCitibank(), atm_CB_001), true);
		System.out.println("Added : " + atm_CB_001.toString());

		ATM atm_CB_002 = new ATM("CB_001", 23000.0, 0.0, true,
				new Address("ADDRESS_2", "145 Bay Drive", "10", "Chicago", "IL", "60660"));
		assertNotNull(atm_CB_002);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankCitibank(), atm_CB_002), true);
		System.out.println("Added : " + atm_CB_002.toString());

		ATM atm_CB_003 = new ATM("CB_001", 44000.0, 0.0, true,
				new Address("ADDRESS_3", "89 Fairview St", "11", "Highwood", "IL", "60660"));
		assertNotNull(atm_CB_003);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankCitibank(), atm_CB_003), true);
		System.out.println("Added : " + atm_CB_003.toString());

		ATM atm_CB_004 = new ATM("CB_001", 77000.0, 0.0, true,
				new Address("ADDRESS_4", "490 Nulla St", "12", "Fort Sheridan", "IL", "60660"));
		assertNotNull(atm_CB_004);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankCitibank(), atm_CB_004), true);
		System.out.println("Added : " + atm_CB_004.toString());

		// Chase
		ATM atm_CHASE_001 = new ATM("CHASE_001", 20000.0, 0.0, true,
				new Address("ADDRESS_1", "1078 Dictum Ave", "13", "Windermere", "IL", "60611"));
		assertNotNull(atm_CHASE_001);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getChaseBank(), atm_CHASE_001), true);
		System.out.println("Added : " + atm_CHASE_001.toString());

		ATM atm_CHASE_002 = new ATM("CHASE_002", 39000.0, 0.0, true,
				new Address("ADDRESS_2", "7666 Iaculis St", "14", "Prairie", "IL", "60660"));
		assertNotNull(atm_CHASE_002);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getChaseBank(), atm_CHASE_002), true);
		System.out.println("Added : " + atm_CHASE_002.toString());

		ATM atm_CHASE_003 = new ATM("CHASE_003", 42000.0, 0.0, true,
				new Address("ADDRESS_3", "5543 Aliquet St", "15", "Arlignton Heights", "IL", "60660"));
		assertNotNull(atm_CHASE_003);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getChaseBank(), atm_CHASE_003), true);
		System.out.println("Added : " + atm_CHASE_003.toString());

		ATM atm_CHASE_004 = new ATM("CHASE_004", 47000.0, 0.0, true,
				new Address("ADDRESS_4", "5037 Diam Rd", "16", "Chicago", "IL", "60660"));
		assertNotNull(atm_CHASE_004);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getChaseBank(), atm_CHASE_004), true);
		System.out.println("Added : " + atm_CHASE_004.toString());

	}

	@Test
	public void testAddFacilityDetail() {
		Card debitCard = bankLoader.getBankPNC().getDebitCards().get(0);
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println("@Test addFacilityDetail for Pin Validation for card 0000001 with ping 1111");
		ATMTransaction pinValidation = new PINValidationTransaction(debitCard, "1111");
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, pinValidation), true);
		System.out.println("@Test addFacilityDetail for Pin Validation for card 0000001 with ping 1112");
		ATMTransaction pinValidationFailed = new PINValidationTransaction(debitCard, "1112");
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, pinValidationFailed), false);
		// Account 0000001
		System.out.println("@Test addFacilityDetail for deposit 0000001");
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction depositToAccount = new DepositTransaction(checkingAccount, debitCard, 1000.0);
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, depositToAccount), true);
		assertEquals((Object) checkingAccount.getBalance(), (Object) 1000.0);
		System.out.println("@Test addFacilityDetail for withdrawal 0000001");
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard, 500.0);
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, withdrawFromAccount), true);
		assertEquals((Object) checkingAccount.getBalance(), (Object) 500.0);
		// Account 0000002
		System.out.println("@Test addFacilityDetail for transfer from 0000001 to 0000002");
		Account savingAccount = debitCard.getAccounts().get(1);
		ATMTransaction transferFromAccount = new TransferTransaction(checkingAccount, debitCard, 300.0, savingAccount);
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, transferFromAccount), true);
		assertEquals((Object) checkingAccount.getBalance(), (Object) 200.0);
		assertEquals((Object) savingAccount.getBalance(), (Object) 300.0);
	}

	@Test
	public void requestAvailableCapacity() {
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println("@Test requestAvailableCapacity for ATM PNC_001");
		assertEquals(facilityClientInterface.requestAvailableCapacity(atmPNC_001), (Object) 0.0);
		Card debitCard = bankLoader.getBankPNC().getDebitCards().get(0);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard, 500.0);
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, withdrawFromAccount), false);
		assertEquals(facilityClientInterface.requestAvailableCapacity(atmPNC_001), (Object) 0.0);
		ATMTransaction depositToAccount = new DepositTransaction(checkingAccount, debitCard, 1000.0);
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, depositToAccount), true);
		assertEquals(facilityClientInterface.requestAvailableCapacity(atmPNC_001), (Object) 1000.0);
	}

	/**
	 * To do Fix printing method comparison
	 */
	@Test
	public void getFacilityInformation() {
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		String printFormat = "ATM [atmId=PNC_001, limit=20000.0, currentAmount=0.0, active=true, atmTransactions=null, address=Address [addressId=ADDRESS_1, street=26 E Pearson St, unit=1, city=Chicago, state=IL, zip=60611]]";
		assertEquals(facilityClientInterface.getFacilityInformation(atmPNC_001).getTextToPrint(), printFormat);
	}

	@Test
	public void removeFacility() {
		Bank bankPNC = bankLoader.getBankPNC();
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		assertEquals(facilityClientInterface.removeFacility(bankPNC, atmPNC_001), true);
		assertEquals(facilityClientInterface.listFacilities(bankLoader.getBankPNC()).size(), 3);
	}

}
