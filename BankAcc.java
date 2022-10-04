package com.nissan.bean;

public class BankAcc {

	//instance variables
	private int accNo;  
    private String cusName;  
    private String accType;  
    private long balance;  
    private long mobNo;
    private String emailId;
    private int atmPin;
    private String panCard;
    
    
    private static long minBalance = 1000;
    
    //default constructor
	public BankAcc() {
		super();
	}

	//parameterized constructor
	public BankAcc(int accNo, String cusName, String accType, long balance,
			 long mobNo, String emailId, int atmPin,
			String panCard) {
		super();
		this.accNo = accNo;
		this.cusName = cusName;
		this.accType = accType;
		this.balance = balance;
		this.mobNo = mobNo;
		this.emailId = emailId;
		this.atmPin = atmPin;
		this.panCard = panCard;
	}

	
	//Getters and Setters
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public static double getMinBalance() {
		return minBalance;
	}

	public static void setMinBalance(long minBalance) {
		BankAcc.minBalance = minBalance;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	
	// override toString()
	@Override
	public String toString() {
		
		return "BankAcc [accNo=" + accNo + ", cusName=" + cusName
				+ ", accType=" + accType + ", balance=" + balance + ", mobNo="
				+ mobNo + ", emailId=" + emailId + ", atmPin=" + atmPin
				+ ", panCard=" + panCard + "]";
	}
    
    
	
}
