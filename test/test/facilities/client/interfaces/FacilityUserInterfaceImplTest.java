package test.facilities.client.interfaces;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.facilities.client.interfaces.FacilityUserInterface;
import com.facilities.client.interfacesImpl.FacilityUserInterfaceImpl;
import com.facilities.commons.utils.ATMTransactionsLoader;
import com.facilities.commons.utils.BankLoader;
import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;
import com.facilities.model.service.ATMTransaction;
import com.facilities.model.service.WithdrawlTransaction;

public class FacilityUserInterfaceImplTest {

	private FacilityUserInterface facilityUserInterface;
	private BankLoader bankLoader;

	@Before
	public void initialize() {
		facilityUserInterface = new FacilityUserInterfaceImpl();
		bankLoader = new BankLoader();
		ATMTransactionsLoader.loadTransactionsPNC(bankLoader.getBankPNC());
	}

	@Test
	public void isInUseDuringInterval() {
		ATM PNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println("@Test isInUseDuringInterval()");
		System.out.println("ATM was not in use from 12:30:00 02-18-2017 to 16:35:00 02-18-2017");
		Calendar fromTime = CommonsUtils.getCalendar(02, 18, 2017, 12, 00, 00);
		Calendar toTime = CommonsUtils.getCalendar(02, 18, 2017, 16, 35, 00);
		assertEquals(facilityUserInterface.isInUseDuringInterval(PNC_001, fromTime, toTime), true);
		fromTime = CommonsUtils.getCalendar(02, 18, 2017, 12, 30, 00);
		assertEquals(facilityUserInterface.isInUseDuringInterval(PNC_001, fromTime, toTime), false);
	}

	@Test
	public void assignFacilityToUse() {
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println("@Test assignFacilityToUse for ATM PNC_001");
		Card debitCard = bankLoader.getBankPNC().getDebitCards().get(0);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 13, 20, 0), 10.0);
		assertEquals(facilityUserInterface.assignFacilityToUse(atmPNC_001, withdrawFromAccount), true);
		assertEquals((Object) atmPNC_001.getCurrentAmount(), (Object) 490.0);
	}

	@Test
	public void vacateFacility() {
		//Need to make a test case where you have the ATM active and then perform a transaction
	}

	@Test
	public void listInspections() {
		//Need to finish maintenance for this, skip it for now.
	}

	@Test
	public void listActualUsage() {
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println("@Test listActualUsage for ATM PNC_001");
		assertEquals(facilityUserInterface.listActualUsage(atmPNC_001), 28);
		//Something is wrong here, the total used minutes should be 28
	}

	@Test
	public void calcUsageRate() {
		//Plase do a similar use case as in the previous example

	}

}
