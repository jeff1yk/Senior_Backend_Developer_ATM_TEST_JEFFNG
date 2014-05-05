package com.javatdd.atmtdd;

import java.util.Scanner;

public class ATMDemo {
	public static void main(String args[]){
		ATM atm = new ATM(); 
		BankAccount account = new BankAccount();
		// atm initial variables
		int testAmount = 0;
		int twentyNum = 0;
		int fiftyNum = 0;
		
		// account initial balance
		int balance = 0;
		
		// balance display to cusotmer
		int leftBalance =0;
		
		// notes numbers of finty and twenty
		int nTwenty =0;
		int nFifty =0;
		boolean status = false;
		WithdrawResult wResult;
		String indication = "";
		System.out.println("This is An ATM machine simulation program\nPlease input the initial twenty notes in ATM: ");
		Scanner in = new Scanner(System.in);
		twentyNum = in.nextInt();
		
		System.out.println("\n Please input the initial fifty notes in ATM: ");
		fiftyNum = in.nextInt();
		System.out.println("\n Please input the initial balance in Account: ");
		balance = in.nextInt();
		System.out.println("\n Please input the amount of money you want to withdraw: ");
		testAmount=in.nextInt();
		atm.setFiftyNum(fiftyNum);
		atm.setTwentyNum(twentyNum);
		account.setBalance(balance);
		wResult = atm.withDraw(testAmount, account);
		indication = wResult.getIndication();
		System.out.println(indication);
		status = wResult.getStatus();
		if (status == true){
			leftBalance = account.getBalance();
		    nTwenty = wResult.getTwenty();
		    nFifty = wResult.getFifty();
		    
			System.out.println("You account balance: " + leftBalance);
			System.out.println("This withdraw amount: " + testAmount);
			System.out.println("Fifty notes give you: " + nFifty);
			System.out.println("Twenty notes gieve you: " + nTwenty);
			
			int leftTwenty = atm.getTwentyNum();
		    int leftFifty = atm.getFiftyNum();
			System.out.println("Please note the following is for simulation, this information will not show to customer");
			System.out.println("ATM still has "+ leftTwenty + " twenty dolloar notes");
			System.out.println("ATM still has "+ leftFifty+ " fifty dolloar notes");
		}
	   }
		

}
