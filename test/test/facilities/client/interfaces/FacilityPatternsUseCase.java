package test.facilities.client.interfaces;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.facilities.client.bridge.EmailAlertMessage;
import com.facilities.client.bridge.SMSAlertMessage;
import com.facilities.client.interfaces.FacilityUserInterface;
import com.facilities.client.interfacesImpl.FacilityClientInterfaceImpl;
import com.facilities.client.interfacesImpl.FacilityUserInterfaceImpl;
import com.facilities.client.observer.DepositAlert;
import com.facilities.client.observer.Observer;
import com.facilities.client.observer.Subject;
import com.facilities.client.observer.WithdrawAlert;
import com.facilities.commons.utils.BankLoader;
import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Card;
import com.facilities.model.customer.CheckingAccount;
import com.facilities.model.service.ATMTransaction;
import com.facilities.model.service.DepositTransaction;
import com.facilities.model.service.WithdrawlTransaction;

public class FacilityPatternsUseCase {

	private FacilityUserInterface facilityUserInterface;
	private EmailAlertMessage emailMessage;
	private SMSAlertMessage SMSMessage;

	ApplicationContext context;
	Bank pncBank;

	@Before
	public void initialize() {
		context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
		System.out.println("***************** Application Context instantiated! ******************");
		facilityUserInterface = (FacilityUserInterfaceImpl) context.getBean("facilityUserInterface");
		pncBank = BankLoader.getBankPNC(context);
		BankLoader.loadTransactionsPNC(pncBank, context,
				(FacilityClientInterfaceImpl) context.getBean("facilityClientInterface"));
		// this will add the observers
		Subject checkingAccount = (CheckingAccount) context.getBean("customer_001_checking_account");
		emailMessage = new EmailAlertMessage();
		SMSMessage = new SMSAlertMessage();
		Observer depositAlert = new DepositAlert(emailMessage);
		Observer withdrawAlert = new WithdrawAlert(SMSMessage);
		checkingAccount.registerObserver(depositAlert);
		checkingAccount.registerObserver(withdrawAlert);
	}

	@Test
	public void observerPatternTestDepositListener() {
		System.out.println("@Testing Observer Pattern for Deposit");
		ATM atmPNC_001 = pncBank.getAtms().get(0);
		Card debitCard = pncBank.getDebitCards().get(0);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction withdrawFromAccount = new DepositTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 13, 20, 0, 0), 10.0);
		assertEquals(facilityUserInterface.assignFacilityToUse(atmPNC_001, withdrawFromAccount), true);

	}
	
	@Test
	public void observerPatternTestWithdrawalListener() {
		System.out.println("@Testing Observer Pattern for Withdrawal");
		ATM atmPNC_001 = pncBank.getAtms().get(0);
		Card debitCard = pncBank.getDebitCards().get(0);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 13, 20, 0, 0), 20.0);
		assertEquals(facilityUserInterface.assignFacilityToUse(atmPNC_001, withdrawFromAccount), true);

	}
	
	@Test
	public void bridgePatternTestEmailAlert() {
		System.out.println("@Testing Bridge Pattern for Email Alert");
		ATM atmPNC_001 = pncBank.getAtms().get(0);
		Card debitCard = pncBank.getDebitCards().get(0);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction withdrawFromAccount = new DepositTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 13, 20, 0, 0), 10.0);
		assertEquals(facilityUserInterface.assignFacilityToUse(atmPNC_001, withdrawFromAccount), true);

	}
	
	@Test
	public void bridgePatternTestSMSAlert() {
		System.out.println("@Testing Bridge Pattern for SMS Alert");
		ATM atmPNC_001 = pncBank.getAtms().get(0);
		Card debitCard = pncBank.getDebitCards().get(0);
		Account checkingAccount = debitCard.getAccounts().get(0);
		ATMTransaction withdrawFromAccount = new WithdrawlTransaction(checkingAccount, debitCard,
				CommonsUtils.getCalendar(02, 18, 2017, 13, 20, 0, 0), 20.0);
		assertEquals(facilityUserInterface.assignFacilityToUse(atmPNC_001, withdrawFromAccount), true);

	}
}
