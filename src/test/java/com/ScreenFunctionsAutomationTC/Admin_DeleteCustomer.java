package com.ScreenFunctionsAutomationTC;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;
import com.sun.mail.imap.protocol.Status;

public class Admin_DeleteCustomer extends GenericFunctions{

	 //Delete Customer Link in Admin PAge 
	 @FindBy(how=How.XPATH,using="//a[@href='delete_customer.php']")
	 public static WebElement Admin_DeleteCustomer_lnk;
	 
	 //Delete Table 
	 @FindBy(how=How.XPATH,using="//table[1]")
	 public static WebElement Admin_DeleteCustomer_table;
	 
	//Delete Customer Details Button in Admin Delete Customer
	@FindBy(how=How.XPATH,using="//input[@name='submit2_id']")
    public static WebElement Admin_DeleteCustomerDetails_btn;
	
	public static void delCustomer(){
		boolean status =true;
		status=hoverAndClick(Admin_DeleteCustomer_lnk);
		if(status){
			System.out.println("Admin Delete Customer Link Clicked..");
			logEvent("Pass", "Admin Delete Customer Link Clicked..");
			//get the CustomerName from the excel file whom you want to delete
			String delN=getdata("DeleteCustomer", "DeleteName", 1);
			//get the CustomerEmail from the excel file whom you want to delete
			String delE=getdata("DeleteCustomer", "DeleteEmail", 1);
			
			status=delCustomerGeneric(delN,delE);
			
			if(status){
				System.out.println("Able to select the radiobutton/select record DeleteCustomer");
				logEvent("Pass", "Able to select the radiobutton/select record DeleteCustomer");
				status=hoverAndClick(Admin_DeleteCustomerDetails_btn);
			    if(status){
			    	System.out.println("Customer record deleted successfully");
			    	logEvent("Pass", "Customer record deleted successfully");
			    }
			    else{
			    	System.out.println("Customer record Not-Deleted ...");
			    	logEvent("Fail", "Customer record Not-Deleted ...");
			    }
			}
			else{
				System.out.println("User Not-Able to Delete the Customer");
				logEvent("Fail", "User Not-Able to Delete the Customer");
			}
		}
		else{
			System.out.println("Admin Link Not-Clicked..");
			logEvent("Fail", "Admin Link Not-Clicked..");
		}
	}
	
}

