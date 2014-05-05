package com.javatdd.atmtdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class ATMTest {
	private ATM atm;

	@Test
	public void testForGetTwenty() { //get 20 notes number in the atm
		atm = new ATM(); //initiate ATM
		int testTwentyNum =0; // we did not set the twenty number yet. Hence it should be zero.
		int atmTwentyNum = atm.getTwentyNum();
		assertEquals(testTwentyNum, atmTwentyNum);
	}
	
	@Test
	public void testForSetGetTwenty() { 
		int initialTwenty=40; // 40 twenty notes which is $800
		int atmTwentyNum =0;
		atm = new ATM();
		atm.setTwentyNum(initialTwenty);
		atmTwentyNum = atm.getTwentyNum();
		assertEquals(initialTwenty, atmTwentyNum);
		}
	@Test
	public void testFoGetFifty() { 
		atm = new ATM(); //initiate ATM
		int testFiftyNum =0; // we did not set the twenty number yet. Hence it should be zero.
		int atmFiftyNum = atm.getFiftyNum();
		assertEquals(testFiftyNum, atmFiftyNum);
		
	}
	@Test
	public void testFoSetGetFifty() {
		int initialFifty=40; // 40 twenty notes which is $2000
		int atmTwentyNum =0;
		atm = new ATM();
		atm.setFiftyNum(initialFifty);
		atmTwentyNum = atm.getFiftyNum();
		assertEquals(initialFifty, atmTwentyNum);
	} 
	
	
	@Test
	public void testFoDvidableBy50() { // we dispence money from 50 to 20,only when 50 is not enough we will use 20
		int testAmount = 100; 
		int expectedFifty = testAmount/50; // 40 expect return 2 twenty notes
		int expectedTwenty = 0;  // 100 expect return 0 fifty notes.
		int initialTwenty =40; //enough 50
		int initialFifty =40; 
		NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
		atm = new ATM();
		atm.setFiftyNum(initialFifty); // we have 20 fifty notes in atm
		atm.setTwentyNum(initialTwenty); // we have 20 twenty notes in atm as well.
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		
	}
	
	@Test
	public void testFoDvidableBy50notEnough50Enough20() { // can be dividbale by 50 however not enough 50 engough 20 notes
		int testAmount = 2200; 
		int initialTwenty =40;
		int initialFifty =40; 
		int expectedFifty = initialFifty; // We will set only have 40 fifty notes. 2200 expect return  40
		int expectedTwenty = (testAmount - initialFifty * 50)/20;  // the left 200 expect 10 twenty notes
		boolean expectedStatus = true; //should success
		NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
		atm = new ATM();
		atm.setFiftyNum(initialFifty); 
		atm.setTwentyNum(initialTwenty); 
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		}
	
	
	@Test
	public void testFoDvidableBy50notEnough50notEnough20() { // can be dividbale by 50 however not enough 50 also not engough 20 notes
		int testAmount = 2200; 
		int initialTwenty =5; // 5 twenty notes are note enough for $2200 test
		int initialFifty =40; 
		int expectedFifty = 0; // should fail, fifty notes should set 0
		int expectedTwenty = 0;  // should fail, twenty notes should set 0
		int suggestAmount = initialFifty*50 + initialTwenty *20; // the maxmum money customer can withdraw
		String expectedIndictaion = String.format("Not engough notes, please withdraw the amount less than %d \n Thanks. \n", suggestAmount);
		boolean expectedStatus = false; //should fail
		NoteResult noteResult; 
		atm = new ATM();
		atm.setFiftyNum(initialFifty); 
		atm.setTwentyNum(initialTwenty); 
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		String indication = noteResult.getIndication();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		assertEquals(expectedIndictaion, indication);
		}
	
	@Test
	public void testFoDvidableBy50notDivisableBy20() { // can be dividbale by 50 however not divisable by 20
		int testAmount = 2150; // can be divided by 50, the left 150 can not be divided by 20
		int initialTwenty =40; 
		int initialFifty =40; 
		int expectedFifty = 0; // should fail, fifty notes should set 0
		int expectedTwenty = 0;  // should fail, twenty notes should set 0
		boolean expectedStatus = false; //should fail
		String expectedIndictaion = "This ATM only provide $20 and $50 notes.\n Thanks. \n";
		NoteResult noteResult; 
		atm = new ATM();
		atm.setFiftyNum(initialFifty); 
		atm.setTwentyNum(initialTwenty); 
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		String indication = noteResult.getIndication();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		assertEquals(expectedIndictaion, indication);
		}
	
	// Following test is for the amount Not divisiable by 50 
	@Test
	public void testLess50DvidableBy20() {
		int testAmount = 40; 
		int expectedTwenty = testAmount/20; // 40 expect return 2 twenty notes
		int expectedFifty = 0;  // 40 expect return 0 fifty notes.int initialFifty =10;
		int initialFifty =10;
		int initialTwenty = 10; //  enough for 40.
		boolean expectedStatus = true;
		String expectedIndication = "Withdraw sucessed. Thanks \n";
		NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
		atm = new ATM();
		atm.setTwentyNum(initialTwenty);
		atm.setFiftyNum(initialFifty);
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		String indication = noteResult.getIndication();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		assertEquals(expectedIndication, indication);
		}
	
	@Test
	public void testLess50DvidableBy20notEnough20() {
		int testAmount = 40; 
		int expectedTwenty = 0; // 40 expect return 2 twenty notes
		int expectedFifty = 0;  // 40 expect return 0 fifty notes.
		int initialFifty =10;
		int initialTwenty = 1; // not enough for 40.
		boolean expectedStatus = false;
		String expectedIndication = "Not enough $20 notes, Sorry about this. \n";
		NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
		atm = new ATM();
		atm.setTwentyNum(initialTwenty);
		atm.setFiftyNum(initialFifty);
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		String indication = noteResult.getIndication();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		assertEquals(expectedIndication, indication);
		}
	
	@Test
	public void testMore50notDivisialbeBy50DvidableBy20() {
		int testAmount = 140; 
		int expectedTwenty = 2; // 140 expect return 2 twenty notes
		int expectedFifty = 2;  // 140 expect return 2 fifty notes.
		int initialFifty =10;
		int initialTwenty = 10; // not enough for 40.
		boolean expectedStatus = true;
		String expectedIndication = "Withdraw sucessed. Thanks \n";
		NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
		atm = new ATM();
		atm.setTwentyNum(initialTwenty);
		atm.setFiftyNum(initialFifty);
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		String indication = noteResult.getIndication();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		assertEquals(expectedIndication, indication);
	}
	
	@Test
	public void testMore50notDivisialbeBy50NotEnought50LeftDivisalbeBy20() {
		int testAmount = 240; 
		int initialFifty =2;
		int initialTwenty = 10; // not enough for 40.
		int expectedTwenty = 7; // expect return 7 twenty notes
		int expectedFifty = 2;  // expect return 2 fifty notes, only have 2 fithy in atm.
		boolean expectedStatus = true;
		String expectedIndication = "Withdraw sucessed. Thanks \n";
		NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
		atm = new ATM();
		atm.setTwentyNum(initialTwenty);
		atm.setFiftyNum(initialFifty);
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		String indication = noteResult.getIndication();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		assertEquals(expectedIndication, indication);
	}
	
	@Test
	public void testMore50notDivisialbeBy50NotEnought50LeftNotDivisalbeBy20ITDivisiableBy20() {
		int testAmount = 240; 
		int initialFifty =1;
		int initialTwenty = 20; // enough for 40.
		int expectedTwenty = 12; // all give 20 notes. expect return 12 twenty notes
		int expectedFifty = 0;  // expect return 0 fifty notes.
		boolean expectedStatus = true;
		String expectedIndication = "Withdraw sucessed. Thanks \n";
		NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
		atm = new ATM();
		atm.setTwentyNum(initialTwenty);
		atm.setFiftyNum(initialFifty);
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		String indication = noteResult.getIndication();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		assertEquals(expectedIndication, indication);
	}
	
	@Test
	public void testMore50notDivisialbeBy50NotEnought50LeftNotDivisalbeBy20ITDivisiableBy20notEnough20() {
		int testAmount = 240; 
		int initialFifty =1;
		int initialTwenty = 10; // enough for 40.
		int expectedTwenty = 0; // all give 20 notes. expect return 12 twenty notes
		int expectedFifty = 0;  // expect return 0 fifty notes.
		boolean expectedStatus = false;
		String expectedIndication = "Not enough $20 notes, Sorry about this. \n";
		NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
		atm = new ATM();
		atm.setTwentyNum(initialTwenty);
		atm.setFiftyNum(initialFifty);
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		String indication = noteResult.getIndication();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		assertEquals(expectedIndication, indication);
	}
	
	
	// Test not divisialbe by 50 and 20
	@Test
	public void testForLess50NotDivisibalBy20And50() {
		int testAmount = 35; 
		int initialFifty =10;
		int initialTwenty = 10; // enough for 40.
		int expectedTwenty = 0; // all give 20 notes. expect return 12 twenty notes
		int expectedFifty = 0;  // expect return 0 fifty notes.
		boolean expectedStatus = false;
		String expectedIndictaion = "This ATM only provide $20 and $50 notes.\n Thanks. \n";
		NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
		atm = new ATM();
		atm.setTwentyNum(initialTwenty);
		atm.setFiftyNum(initialFifty);
		noteResult = atm.calculation(testAmount);
		int twentyNum = noteResult.getTwenty();
		int fiftyNum = noteResult.getFifty();
		boolean status = noteResult.getStatus();
		String indication = noteResult.getIndication();
		assertEquals(expectedTwenty, twentyNum);
		assertEquals(expectedFifty, fiftyNum);
		assertEquals(expectedStatus, status);
		assertEquals(expectedIndictaion, indication);
	}
	
	
	// Test not divisialbe by 50 and 20
		@Test
		public void testForMore50NotDivisibalBy20And50() {
			int testAmount = 195; 
			int initialFifty =10;
			int initialTwenty = 10; // enough for 40.
			int expectedTwenty = 0; // all give 20 notes. expect return 12 twenty notes
			int expectedFifty = 0;  // expect return 0 fifty notes.
			boolean expectedStatus = false;
			String expectedIndictaion = "This ATM only provide $20 and $50 notes.\n Thanks. \n";
			NoteResult noteResult; // we store the calculated number of 20 and 50 notes in a class instance
			atm = new ATM();
			atm.setTwentyNum(initialTwenty);
			atm.setFiftyNum(initialFifty);
			noteResult = atm.calculation(testAmount);
			int twentyNum = noteResult.getTwenty();
			int fiftyNum = noteResult.getFifty();
			boolean status = noteResult.getStatus();
			String indication = noteResult.getIndication();
			assertEquals(expectedTwenty, twentyNum);
			assertEquals(expectedFifty, fiftyNum);
			assertEquals(expectedStatus, status);
			assertEquals(expectedIndictaion, indication);
		}
	
	
		@Test
		public void testForWithDraw() { //success
			int testAmount = 440; 
			int initialFifty =100;
			int initialTwenty = 100; // enough for 40.
			int initialBalance = 2000;
			int expectedBalance = 1560; 
			int expectedLeftTwenty = 98; // 440 can be given 8x50 + 2+20
			int expectedLeftFifty = 92;  
			boolean expectedStatus = true;
			BankAccount account = new BankAccount();
			account.setBalance(testAmount);
			atm = new ATM();
			atm.setTwentyNum(initialTwenty);
			atm.setFiftyNum(initialFifty);
			WithdrawResult result = atm.withDraw(testAmount, account);
			int leftTwenty = atm.getTwentyNum();
			int leftFifty = atm.getFiftyNum();
			int balance = account.getBalance();
			String indication = result.getIndication();
			boolean status = result.getStatus();
			assertEquals(expectedLeftTwenty, leftTwenty);
			assertEquals(expectedLeftFifty, leftFifty);
			assertEquals(expectedStatus, status);
		}

}
