package com.javatdd.atmtdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class bankaccountTest {
	private BankAccount account;

	@Test
	public void testForSetAndGetBalance() {
		account = new BankAccount();
		int testAmount = 1000; // in this application, we will only test withdraw integer amount of money 
		account.setBalance(testAmount);
		int balance = account.getBalance();
		assertEquals(balance, testAmount); // assert they 
	}
	
	@Test
	//alothough we do not need login, the account number is requried for a account class
	public void testForSetAndGetAccountNum() {
		account = new BankAccount();
		int testNum = 10001;
		account.setAccountNum(testNum);
		int accountNum = account.getAccountNum();
		assertEquals(accountNum, testNum);
		
	}
	
	
}
