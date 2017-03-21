package test.facilities.client.interfaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.facilities.client.interfaces.FacilityClientInterface;
import com.facilities.client.interfacesImpl.FacilityClientInterfaceImpl;
import com.facilities.commons.utils.BankLoader;
import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.atm.ATMImpl;
import com.facilities.model.atm.Bank;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.AddressImpl;
import com.facilities.model.customer.Card;
import com.facilities.model.service.ATMTransaction;
import com.facilities.model.service.DepositTransaction;
import com.facilities.model.service.PINValidationTransaction;
import com.facilities.model.service.TransferTransaction;
import com.facilities.model.service.WithdrawlTransaction;

public class FacilityClientInterfaceImplTest {
	private FacilityClientInterface facilityClientInterface;
	ApplicationContext context;
	Bank pncBank;

	@Before
	public void initialize() {
		context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");
		facilityClientInterface = (FacilityClientInterfaceImpl) context.getBean("facilityClientInterface");
		pncBank = BankLoader.getBankPNC(context);
	}

	@Test
	public void testListFacilities() {
		System.out.println("@Test testListFacilities()");
		assertEquals(facilityClientInterface.listFacilities(pncBank).size(), pncBank.getAtms().size());
		System.out.println("@Test PNB Bank ATM Count = " + pncBank.getAtms().size());
	}

	@Test
	public void testAddNewFacility() {

		System.out.println("@Test testAddNewFacility()");
		// PNC
		ATM atm_PNC_001 = new ATMImpl("PNC_001", 20000.0, 0.0, true,
				new AddressImpl("ADDRESS_1", "26 E Pearson St", "1", "Chicago", "IL", "60611"));
		assertNotNull(atm_PNC_001);
		assertEquals(facilityClientInterface.addNewFacility(pncBank, atm_PNC_001), true);
		System.out.println("Added : " + atm_PNC_001.toString());

		ATM atm_PNC_002 = new ATMImpl("PNC_002", 20000.0, 0.0, true,
				new AddressImpl("ADDRESS_2", "1068 W Granville Ave", "2", "Chicago", "IL", "60660"));
		assertNotNull(atm_PNC_002);
		assertEquals(facilityClientInterface.addNewFacility(pncBank, atm_PNC_002), true);
		System.out.println("Added : " + atm_PNC_002.toString());

		ATM atm_PNC_003 = new ATMImpl("PNC_003", 30000.0, 0.0, true,
				new AddressImpl("ADDRESS_3", "4309 S Morgan St", "3", "Chicago", "IL", "60609"));
		assertNotNull(atm_PNC_003);
		assertEquals(facilityClientInterface.addNewFacility(pncBank, atm_PNC_003), true);
		System.out.println("Added : " + atm_PNC_003.toString());

		ATM atm_PNC_004 = new ATMImpl("PNC_004", 50000.0, 0.0, true,
				new AddressImpl("ADDRESS_4", "13 Garden St", "4", "Chicago", "IL", "60661"));
		assertNotNull(atm_PNC_004);
		assertEquals(facilityClientInterface.addNewFacility(pncBank, atm_PNC_004), true);
		System.out.println("Added : " + atm_PNC_004.toString());

	}

	@Test
	public void testAddFacilityDetail() {
		Card debitCard = pncBank.getDebitCards().get(0);
		ATM atmPNC_001 = pncBank.getAtms().get(0);
		System.out.println("@Test addFacilityDetail for Pin Validation for card 0000001 with ping 1111");
		ATMTransaction pinValidation = new PINValidationTransaction(debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 11, 30, 0, 0), "1111");
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, pinValidation), true);
		System.out.println("@Test addFacilityDetail for Pin Validation for card 0000001 with ping 1112");
		ATMTransaction pinValidationFailed = new PINValidationTransaction(debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 11, 40, 0, 0), "1112");
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, pinValidationFailed), false);
		// Account 0000001
		System.out.println("@Test addFacilityDetail for deposit 0000001");
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction depositToAccount = new DepositTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 11, 50, 0, 0), 1000.0);
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, depositToAccount), true);
		assertEquals((Object) checkingAccount.getBalance(), (Object) 1000.0);
		System.out.println("@Test addFacilityDetail for withdrawal 0000001");
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 12, 00, 0, 0), 500.0);
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, withdrawFromAccount), true);
		assertEquals((Object) checkingAccount.getBalance(), (Object) 500.0);
		// Account 0000002
		System.out.println("@Test addFacilityDetail for transfer from 0000001 to 0000002");
		Account savingAccount = debitCard.getAccounts().get(1);
		ATMTransaction transferFromAccount = new TransferTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 12, 10, 0, 0), 300.0, savingAccount);
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, transferFromAccount), true);
		assertEquals((Object) checkingAccount.getBalance(), (Object) 200.0);
		assertEquals((Object) savingAccount.getBalance(), (Object) 300.0);
	}

	@Test
	public void requestAvailableCapacity() {
		ATM atmPNC_001 = pncBank.getAtms().get(0);
		System.out.println("@Test requestAvailableCapacity for ATM PNC_001");
		assertEquals(facilityClientInterface.requestAvailableCapacity(atmPNC_001), (Object) 0.0);
		Card debitCard = pncBank.getDebitCards().get(0);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 12, 20, 0, 0), 500.0);
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, withdrawFromAccount), false);
		System.out.println(
				"@Test requestAvailableCapacity the ATM PNC_001 is unavailable for a withdaw transaction with a capacity of $0.0");
		assertEquals(facilityClientInterface.requestAvailableCapacity(atmPNC_001), (Object) 0.0);
		ATMTransaction depositToAccount = new DepositTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 12, 30, 0, 0), 1000.0);
		System.out.println("@Test requestAvailableCapacity deposited an ammount of $1000 into ATM PNC_001");
		assertEquals(facilityClientInterface.addFacilityDetail(atmPNC_001, depositToAccount), true);
		assertEquals(facilityClientInterface.requestAvailableCapacity(atmPNC_001), (Object) 1000.0);
		System.out.println("@Test requestAvailableCapacity the ATM PNC_001 has now an available capacity of $1000");

	}

	/**
	 * To do Fix printing method comparison
	 */
	@Test
	public void testGetFacilityInformation() {
		System.out.println("@Test testGetFacilityInformation for ATM PNC_001");
		ATM atmPNC_001 = pncBank.getAtms().get(0);
		String printFormat = "ATM [atmId=PNC_001, limit=20000.0, currentAmount=0.0, active=true, atmTransactions=null, address=Address [addressId=ADDRESS_1, street=26 E Pearson St, unit=1, city=Chicago, state=IL, zip=60611]]";
		assertEquals(facilityClientInterface.getFacilityInformation(atmPNC_001).getTextToPrint(), printFormat);
		System.out.println("@Test testGetFacilityInformation for ATM PNC_001 = " + printFormat);

	}

	@Test
	public void testRemoveFacility() {
		System.out.println("@Test testRemoveFacility of ATM PNC_001");
		ATM atmPNC_001 = pncBank.getAtms().get(0);
		assertEquals(facilityClientInterface.removeFacility(pncBank, atmPNC_001), true);
		assertEquals(facilityClientInterface.listFacilities(pncBank).size(), 3);
		System.out.println("@Test testRemoveFacility worked and now the size of facility is reduced to 3");
	}

}
