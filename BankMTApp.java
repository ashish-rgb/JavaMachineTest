package com.nissan.app;

import java.util.Scanner;

import com.nissan.bean.BankMT;

public class BankMTApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);  
		 
	        BankMT customer = new BankMT();
	        
	        // loop runs until number 9 is not pressed to exit  
	        int ch;  
	        do {  
	            System.out.println("\n ***Banking System Application*** \n");  
	            
	            System.out.println("0. Add New Customers \n"
	                    +"1. Updating Customer Details \n"
	            		+"2. Deleting a Customer \n"
	            		+"3. Deposit the amount \n"
	            		+"4. Withdraw the amount \n"
	            		+"5. Show Balance of a Customer \n"
	            		+"6. Display the list of all Customers in the Bank \n"
	            		+"7. Display Customer Details of a specific Customer \n"
	            		+"8. Transferring Money from One Account to Another account \n"
	            		+"9.Exit ");  
	            
	            System.out.println("Enter your choice: ");  
	            
	            ch = sc.nextInt();  
	            
	                switch (ch) {  
	                
	                    case 0:  
	                    	System.out.println("Add New Customer");
	                        BankMT.addCustomer();
	                        break;  
	                        
	                    case 1:  
	                        System.out.print("Update Account: ");  
	                        customer.updateCustomer();
	                        break;  
	                        
	                    case 2:  
	                        System.out.println("Delete Account : ");  
	                        BankMT.deleteCustomer();
	                        
	                    case 3:  
	                        System.out.print("Deposit Money : ");  
	                         BankMT.deposit();
	                        break;  
	                        
	                    case 4:  
	                    	System.out.print("Withdraw Money : ");  
	                         BankMT.withdrawal();
	                        break;  
	                        
	                    case 5:  
	                    	System.out.print("Show Balance : ");  
	                         BankMT.showBalance();
	                        break;  
	                    
	                    case 6:  
	                    	System.out.print("Details of All Customers : ");  
	                         BankMT.displayAllCustomer();
	                        break; 
	                        
	                    case 7:  
	                    	System.out.print("Display Customer Details of a specific Customer : ");  
	                         BankMT.displayCustomer();
	                        break;  
	                        
	                    case 8:  
	                    	System.out.print("Transfer Money : ");  
	                         BankMT.transferMoney();
	                        break;  
	                        
	                    case 9:  
	                    	System.out.println("See you soon...");  
	                        System.exit(0);
	                        break;
	                       
	                    default:
	                    	System.out.println("Invalid choice");
	                }  
	            }  
	            while (ch != 9);  

	}

}
