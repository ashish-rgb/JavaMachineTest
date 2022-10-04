package com.nissan.bean;

import java.util.*;

import com.nissan.bean.BankAcc;

public class BankMT {
	
	static Random rand = new Random();
	
	private static ArrayList<BankAcc> custist = new ArrayList<BankAcc>();
    
    static Scanner sc = new Scanner(System.in); 
    
    //Generating Random 9-Digit Account No
    static int generateAccNo(){
         int accNo= rand.nextInt(900000000) + 100000000;
         BankAcc checkAcc = isAccExists(accNo);
         
         if (checkAcc != null) {
        	 
 			// Providing new unmatched no
 			return generateAccNo();
 		}
         
         return accNo;
    }
    
    
    //Generating Random $-Digit Pin Number
    static int generateAtmPin(){
         int atmPin= rand.nextInt(9000) + 1000;
       
            return atmPin;
    }

    
    
    //Add Customers
	public static void addCustomer(){
		 
		BankAcc bankAcc = new BankAcc();
		
		bankAcc.setAccNo(generateAccNo());
		
	    System.out.print("Enter Customer Name: ");  
	    bankAcc.setCusName(sc.nextLine());
	    
        System.out.print("Enter Account type: (Savings/Current) ");  
        bankAcc.setAccType(sc.nextLine());
        
        System.out.print("Enter Balance: ");  
        long balance = sc.nextLong(); 
        
        while(balance < BankAcc.getMinBalance()){
        	
        	System.out.println("Plaese maintain minimum balance of "+ BankAcc.getMinBalance());
        	
        	balance = sc.nextLong();
        }
        bankAcc.setBalance(balance);
        
        
        System.out.print("Enter Mobile No: ");  
        bankAcc.setMobNo(sc.nextLong());
        
        System.out.print("Enter Email Id: ");  
        bankAcc.setEmailId(sc.next());
        
        bankAcc.setAtmPin(generateAtmPin());
        
        custist.add(bankAcc);
		
	}
	
	
    
	//update Customer
	public void updateCustomer(){
		
		int accNum;
		System.out.println("Please provide Account Number : ");
		accNum = sc.nextInt();
		
		BankAcc findAcc = isAccExists(accNum);
		
		if(findAcc != null){
			
			System.out.println("Enter New Mobile Number : ");
			findAcc.setMobNo(sc.nextLong());
			System.out.println("Enter New Email Id : ");
			findAcc.setEmailId(sc.nextLine());
			
			System.out.println("Account Updated Successfully");
		}else{
			System.out.println("No such Account Number Exists");
		}
		
	}
	
	//deleting an account 
	public static void deleteCustomer() {

		// Prompt for the Customer ID
		System.out.println("\tEnter Account No : ");
        int accNo = sc.nextInt();

		BankAcc findAcc = isAccExists(accNo);

		// Check for account with Account no
		if (findAcc != null) {

			findAcc.setAccNo(-1);
			

		} else {
			// Empty Message
			System.out.println("Account no not found");
		}

	}
	
	//Deposit
	public static void deposit() {  
        long amt;  
        
        int accNo = sc.nextInt();
        BankAcc bankAcc = isAccExists(accNo);
        
        if(bankAcc != null){
        	System.out.println("Enter the amount you want to deposit: ");  
            amt = sc.nextLong();
            
            if(amt > 50000){
            	System.out.print("Please enter your Pan Card Number");
            	bankAcc.setPanCard(sc.nextLine());
            }
            bankAcc.setBalance(bankAcc.getBalance() + amt);
            System.out.println(amt + " deposited successfully");
        }
        
    }
	
	
	//Withdraw
	public static void withdrawal() { 
		
        long amt;  
        
        int accNo = sc.nextInt();
        BankAcc bankAcc = isAccExists(accNo);
        
        if(bankAcc != null){
        	System.out.println("Enter the amount you want to withdraw: ");  
            amt = sc.nextLong();
            
            long avlbalance = (long) (bankAcc.getBalance() - BankAcc.getMinBalance());
            
            if (avlbalance >= amt) { 
            	if(amt>50000){
            	System.out.print("Please enter your Pan Card Number");
            	bankAcc.setPanCard(sc.nextLine());
            	}
            	avlbalance = avlbalance - amt;  
                System.out.println("Balance after withdrawal: " + avlbalance);  
            } else {  
                System.out.println("Insufficient funds..!!!" );  
            } 
        }
        
         
    }
	
	
	// 6. Show Balance of a Customer
		public static void showBalance() {

			// Prompt for the Customer ID
			System.out.print("\tEnter Customer No : ");

			int accountNo = Integer.parseInt(sc.nextLine());

			BankAcc findAccount = isAccExists(accountNo);

			if (findAccount != null) {
				System.out.print("\tEnter Your PIN : ");
				int accountPin = Integer.parseInt(sc.nextLine());

				byte attemptAllowed = 3;
				while ((attemptAllowed > 0) && validatePin(findAccount, accountPin)) {
					// Wrong PIN
					System.out.println("\tYou entered a wrong PIN, Try Again. "
							+ "You have " + (attemptAllowed - 1) + ""
							+ " attempt(s) left");
					System.out.print("\tEnter Your PIN : ");
				}

				if (attemptAllowed > 0) {
					// Displaying Balance
					System.out
							.println("Account No : " + findAccount.getAccNo());
					System.out.println("Ledger  Balance : "
							+ findAccount.getBalance());
					System.out.println("Available Balance : "
							+ (findAccount.getBalance() - BankAcc
									.getMinBalance()));
					System.out.println();

					// Get out of this method
					return;
				} else {
					System.out
							.println("\t Sorry you exceeded the limit. Try again later");
				}
			} else {
				// Empty Message
				System.out
						.println("\n\tSorry! There are no customer in the Bank with the Customer ID '"
								+ accountNo + "'");

			}
		}
	  
	
	//  Display the list of all Customers in the Bank
		public static void displayAllCustomer() {
			// Check for empty
			if (custist.size() > 0) {
				// Displaying the column name for the display table
				System.out.println("Ac No." + "Name" + "Type" + "Balance"+ 
						"Mobile" + "Email" + "PIN");
                 System.out.println("--------------------------------------------------------------------------");

				// Displaying each record
				for (BankAcc account : custist) {
					System.out.println(account);
				}
				System.out.println("\n");
			} else {
				// Empty Message
				System.out
						.println("\n\tSorry! There are no customer in the Bank.\n\tPlease Add Customers to view their detail(s)\n");
			}

		}
	
		// Display Customer Details of a specific Customer
		public static void displayCustomer() {

			// Prompt for the Customer ID
			System.out.print("\tEnter Account No : ");

			int accountNo = sc.nextInt();

			BankAcc findAccount = isAccExists(accountNo);

			if (findAccount != null) {
				// Displaying the column name for the display table
				System.out.println("Ac No." + "Name" + "Type" + "Balance"+ 
										"Mobile" + "Email" + "PIN");

				System.out.println("--------------------------------------------------------------------------");

				// Displaying Required record
				System.out.println(findAccount);
				System.out.println();

				// Get out of this method
				return;
			} else {
				// Empty Message
				System.out
						.println("\n\tSorry! There are no customer in the Bank with the Customer ID '"
								+ accountNo + "'");

			}

		}
		
		
		// 9. Transferring Money from One Account to Another account
		public static void transferMoney() {


			// Prompt for the Customer ID
			System.out.print("\tEnter Customer No (From Customer): ");

			int fromAccountNo = sc.nextInt();

			BankAcc fromFindAccount = isAccExists(fromAccountNo);

			if (fromFindAccount != null) {

				// Prompt for the Customer ID
				System.out.print("\tEnter Customer No (To Customer): ");

				int toAccoutNo = sc.nextInt();

				BankAcc toFindAccount = isAccExists(toAccoutNo);

				if (toFindAccount != null) {
					System.out.print("\tEnter Amount (To Transfer) : ");
					long transferAmount = Long.parseLong(sc.nextLine());

					while (transferAmount < 0) {

						System.out
								.println("\n\t---   Error : Please input +ve amount   ---");
						System.out.print("\tEnter Amount (To Transfer) : ");
						transferAmount = Long.parseLong(sc.nextLine());
					}

					long checkBal = fromFindAccount.getBalance()
							- transferAmount;

					if (checkBal > BankAcc.getMinBalance()) {

						// Debited
						fromFindAccount.setBalance(checkBal);

						// Credited
						toFindAccount.setBalance(toFindAccount
								.getBalance() + transferAmount);

						// Success Note
						
						System.out.println("\tSuccessfully transfered "
								+ transferAmount + " to Account No. : "
								+ toAccoutNo);

					} else {
						System.out.println("\tSorry! Insufficient Balance in your Account. Can't process the transaction");
					}

					System.out.print("\tEnter Your PIN : ");
					int accountPin = Integer.parseInt(sc.nextLine());

					byte attemptAllowed = 3;
					while ((attemptAllowed > 0)
							&& validatePin(fromFindAccount, accountPin)) {
						// Wrong PIN
						System.out
								.println("\tYou entered a wrong PIN, Try Again. You have "
										+ (attemptAllowed - 1) + " attempt(s) left");
						System.out.print("\tEnter Your PIN : ");
					}

					if (attemptAllowed > 0) {
						// Displaying Balance
						System.out.println("Account No : "
								+ fromFindAccount.getAccNo());
						System.out.println("Ledger  Balance : "
								+ fromFindAccount.getBalance());
						System.out.println("Available Balance : "
								+ (fromFindAccount.getBalance() - BankAcc
										.getMinBalance()));
						System.out.println();

						// Get out of this method
						return;
					} else {
						System.out
								.println("\t Sorry you exceeded the limit. Try again later");
					}
				} else {
					// Empty Message
					System.out
							.println("\n\tSorry! There are no customer in the Bank with the Customer ID '"
									+ fromFindAccount + "'");
				}

			} else {
				// Empty Message
				System.out
						.println("\n\tSorry! There are no customer in the Bank with the Customer ID '"
								+ fromFindAccount + "'");

			}

		}
		
	private static BankAcc isAccExists(int CustAcc) {
		
		for (BankAcc account : custist) {
			if (account.getAccNo() == CustAcc){
				return account;
			}
		}

		// Not Found
		return null;

	}
	
	// Method to validate PIN
		private static boolean validatePin(BankAcc account, int accountPin) {
			if (account.getAtmPin() == accountPin) {
				return true;
			}

			return false;
		}
	
}
