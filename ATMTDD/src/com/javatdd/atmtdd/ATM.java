package com.javatdd.atmtdd;

public class ATM {
	private int twentyNum = 0;
	private int fiftyNum = 0;

	public int getTwentyNum() {
		// TODO Auto-generated method stub
		return twentyNum;
	}

	public void setTwentyNum(int initialTwenty) {
		// TODO Auto-generated method stub
		twentyNum = initialTwenty;
	}

	public int getFiftyNum() {
		// TODO Auto-generated method stub
		return fiftyNum;
	}

	public void setFiftyNum(int initialFifty) {
		// TODO Auto-generated method stub
		fiftyNum = initialFifty;
	}
    // calculate the number of the fifty and twenty notes according to the input amount
	public NoteResult calculation(int testAmount) {
		// TODO Auto-generated method stub
		int calTwentyNum = 0;
		int calFiftyNum = 0;
		boolean status = false; // this is used to indicate whether the calculation is sucess or not
		int suggestedAmount =0; // this is the suggested amount when the calculation is failed.
		String indication="";
		if (testAmount % 50 ==0) { // if the amount can be divisable by 50
			calFiftyNum = testAmount/50;
			if (calFiftyNum > fiftyNum){ // if the left fifty notes are note enough
				calFiftyNum = fiftyNum; //give all the avaliable fifty to the user.
				testAmount -= 50* fiftyNum; //used to calculate the left money to divide 20
			    status = true;
			    indication ="withdraw success, Thanks. \n";
				if (testAmount % 20 ==0){ // if the  left amount is divisiable by 20
					calTwentyNum = testAmount/ 20;
					if(calTwentyNum > twentyNum){
						suggestedAmount = fiftyNum*50 + twentyNum*20;
						indication = String.format("Not engough notes, please withdraw the amount less than %d \n Thanks. \n", suggestedAmount);
						calTwentyNum =0;
						calFiftyNum =0;
						status = false;
					}
				}
				else{ //if the left amount is not divisable by 20
					calTwentyNum = 0;
					calFiftyNum = 0;
					status = false;
					indication = "This ATM only provide $20 and $50 notes.\n Thanks. \n";
					
				}
				
					
			}
		}
		else{  // if the amount is not divisable by 50
			calFiftyNum = testAmount / 50;
			if (calFiftyNum > fiftyNum){ // if the fifty notes are not enough
				calFiftyNum= fiftyNum;
				int leftAmount = testAmount - calFiftyNum * 50; 
				if (leftAmount % 20 != 0){ // if the left amount can not be divisialbe by twenty ,all notes give 20
					calTwentyNum = testAmount/20;
					calFiftyNum =0;
					
				}
				else { // left can not be divisibale by 20, it's wrong
		
					calTwentyNum = leftAmount / 20;
				}
				status = true;
				indication = "Withdraw sucessed. Thanks \n";
				if (calTwentyNum > twentyNum){
					calFiftyNum=0;
					calTwentyNum =0;
					status = false;
					indication = "Not enough $20 notes, Sorry about this. \n";
				}
			}
			else {	 //if fifty notes is enough
			if (testAmount % 20 == 0){ // if the amount is divisalbe by 20
				testAmount -= calFiftyNum*50;
				calTwentyNum = testAmount/20;
				status = true;
				indication = "Withdraw sucessed. Thanks \n";
				if (calTwentyNum > twentyNum){ //if the twenty notes are note enough
					calFiftyNum=0;
					calTwentyNum =0;
					status = false;
					indication = "Not enough $20 notes, Sorry about this. \n";
				}
			}
			else { // can not divde by 50 and 20
				calTwentyNum = 0;
				calFiftyNum = 0;
				status = false;
				indication = "This ATM only provide $20 and $50 notes.\n Thanks. \n";
			}
			}
		}
		return new NoteResult (calTwentyNum, calFiftyNum, status, indication);
	}

	public WithdrawResult withDraw(int testAmount, BankAccount account) {
		// TODO Auto-generated method stub
		int balance = account.getBalance();
		String wIndication = ""; // the indication for withdraw
		WithdrawResult wResult = new WithdrawResult();
		if (testAmount > balance){
			wIndication = String.format("Sorry your balance is not enough for %d dollars. \n",testAmount);
			wResult.setStatus(false);
			wResult.setBalance(balance);
			wResult.setIndication(wIndication); 
		}
		else{
			NoteResult noteresult = calculation (testAmount);
			int noteTwentyNum = noteresult.getTwenty();
			int noteFiftyNum = noteresult.getFifty();
			String indication = noteresult.getIndication();
			boolean status = noteresult.getStatus();
			boolean accountStatus;
			if (status == true){
				balance -= testAmount;
				wResult.setStatus(true);
			}
			else
				wResult.setStatus(false);
			account.setBalance(balance); // update account balance
			twentyNum-= noteTwentyNum;
			fiftyNum-=noteFiftyNum;
			wResult.setBalance(balance);
			wResult.setTwentyNum(noteTwentyNum);
			wResult.setFiftyNum(noteFiftyNum);
			wResult.setIndication(indication);
		}
		
		return wResult;
	}
	
	

	

}
