package com.javatdd.atmtdd;

public class WithdrawResult extends NoteResult{
	private int balance; 
	public WithdrawResult(int calTwentyNum, int calFiftyNum, boolean status,
			String indication) {
		super(calTwentyNum, calFiftyNum, status, indication);
		// TODO Auto-generated constructor stub
	}


	public WithdrawResult() {
		// TODO Auto-generated constructor stub
	}


	public void setBalance(int balance) {
		// TODO Auto-generated method stub
		this.balance = balance;
	}


	public int getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	
}
