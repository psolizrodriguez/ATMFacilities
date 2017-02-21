package com.facilities.commons.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.facilities.model.customer.Account;
import com.facilities.model.customer.Address;
import com.facilities.model.customer.Card;
import com.facilities.model.customer.CheckingAccount;
import com.facilities.model.customer.Customer;
import com.facilities.model.customer.DebitCard;
import com.facilities.model.customer.SavingAccount;

public class CardLoader {
	public static List<Card> getPNCCards() {
		List<Card> listCards = new ArrayList<>();
		Address billingAddress = AddressLoader.getAddress_01();
		Customer customer = new Customer("CUST001", "SOLIZ", "PERCY", billingAddress, billingAddress);
		Account checkingAccount = new CheckingAccount(customer, "0000001", 0.0);
		Account savingAccount = new SavingAccount(customer, "0000002", 0.0);
		List<Account> listAccounts = new ArrayList<>();
		listAccounts.add(checkingAccount);
		listAccounts.add(savingAccount);
		Calendar validDate = CommonsUtils.getCalendar(12, 31, 2020, 0, 0, 0,0);
		Card debitCard = new DebitCard(customer, "0000001", "1111", "001", validDate, billingAddress, listAccounts);
		listCards.add(debitCard);
		return listCards;
	}
	
	public static List<Card> getBOACards() {
		List<Card> listCards = new ArrayList<>();
		Address billingAddress = AddressLoader.getAddress_02();
		Customer customer = new Customer("CUST002", "SINDHU", "PINKY", billingAddress, billingAddress);
		Account checkingAccount = new CheckingAccount(customer, "0000003", 0.0);
		Account savingAccount = new SavingAccount(customer, "0000004", 0.0);
		List<Account> listAccounts = new ArrayList<>();
		listAccounts.add(checkingAccount);
		listAccounts.add(savingAccount);
		Calendar validDate = CommonsUtils.getCalendar(12, 31, 2020, 0, 0, 0,0);
		Card debitCard = new DebitCard(customer, "0000003", "1113", "003", validDate, billingAddress, listAccounts);
		listCards.add(debitCard);
		return listCards;
	}
}
