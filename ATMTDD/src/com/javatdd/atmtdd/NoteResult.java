package com.javatdd.atmtdd;

public class NoteResult {
	private int twentyNum;
	private int fiftyNum;
    private boolean status;
    private String indication;
    
    public NoteResult() {
    	twentyNum = 0;
    	fiftyNum = 0;
    	status = false;
    	indication ="";
    }
	public NoteResult(int calTwentyNum, int calFiftyNum, boolean status, String indication) {
		// TODO Auto-generated constructor stub
		twentyNum = calTwentyNum;
		fiftyNum = calFiftyNum;
		this.status = status;
		this.indication = indication;
	}

	
	public int getTwenty() {
		// TODO Auto-generated method stub
		return twentyNum;
	}

	public int getFifty() {
		// TODO Auto-generated method stub
		return fiftyNum;
	}

	public boolean getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	public String getIndication() {
		// TODO Auto-generated method stub
		return indication;
	}
	
	public void setTwentyNum(int twentyNum) {
		this.twentyNum = twentyNum;
	}
	
	public void setFiftyNum(int fiftyNum) {
		this.fiftyNum = fiftyNum;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setIndication(String indication) {
		this.indication = indication;
	}
	
	

}
