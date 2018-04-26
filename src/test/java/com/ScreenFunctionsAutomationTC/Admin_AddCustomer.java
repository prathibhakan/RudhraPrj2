package com.ScreenFunctionsAutomationTC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.GenericFunctions.GenericFunctions;

public class Admin_AddCustomer extends GenericFunctions  { 

	// AddCustomer link under Customer Links in Admin Module 
	  @FindBy(how=How.XPATH,using="//a[text()='Add Customer']")
	   public static WebElement Admin_AddCustomer_lnk;
	 
	    //CustomerName TextBox in Add Customer Page in Admin Module 	
		@FindBy(how=How.XPATH,using="//input[@name='customer_name']")
	    public static WebElement Admin_Addcustomer_customername_edi;
		
        //Gender Radio Button in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//input[@name='customer_gender']")
	    public static WebElement  Admin_Addcustomer_Customergender_rdo;
		
		// DOB Field in Add Customer Page in Admin Module		
		@FindBy(how=How.XPATH,using="//input[@name='customer_dob']")
	    public static WebElement Admin_Addcustomer_Customerdob_edi;
		
		// Nominee TextBox in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//input[@name='customer_nominee']")
	    public static WebElement Admin_Addcustomer_Customernominee_edi;
		
		// Branch Dropdown in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//select[@name='branch']")
	    public static WebElement Admin_Addcustomer_branch_sel;
		
		// Account Type Dropdown in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//select[@name='customer_account']")
	    public static WebElement Admin_Addcustomer_Customeraccount_sel;
		
		// Minimum Amount TextBox in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//input[@name='initial']")
	    public static WebElement Admin_Addcustomer_initial_edi;
		
		// Address TextBox in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//textarea[@name='customer_address']")
	    public static WebElement Admin_Addcustomer_Customeraddress_txtarea;
		
		// Mobile TextBox in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//input[@name='customer_mobile']")
	    public static WebElement Admin_Addcustomer_Customermobile_edi;
		
		// Email TextBox in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//input[@name='customer_email']")
	    public static WebElement Admin_Addcustomer_Customeremail_edi;
		
		// Password TextBox in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//input[@name='customer_pwd']")
	    public static WebElement Admin_Addcustomer_Customerpwd_edi;
		
		// AddCustomer Button in Add Customer Page in Admin Module
		@FindBy(how=How.XPATH,using="//input[@name='add_customer']")
		public static WebElement Admin_Addcustomer_addcustomer_btn;  
		
		//Enter Old Password
		@FindBy(how=How.XPATH,using="//input[@name='old_password']")
		public static WebElement Admin_ChangePassword_old_password_edi; 
		//Enter New Password
		@FindBy(how=How.XPATH,using="//input[@name='new_password']")
		public static WebElement Admin_ChangePassword_new_password_edi; 
		//Enter Again Password
		@FindBy(how=How.XPATH,using="//input[@name='again_password']")
		public static WebElement Admin_ChangePassword_again_password_edi; 
		//ChangePassword Button in ChangePassword Page
		@FindBy(how=How.XPATH,using="//input[@name='change_password']")
		public static WebElement Admin_ChangePassword_ChangePassword_btn;
		//ChangePassword Link in Admin Page
		@FindBy(how=How.XPATH,using="//a[@href='change_password.php']")
		public static WebElement Admin_ChangePassword_lnk;
		
		
		
//To Verify  AddCustomer Fields,Provide the data for fields	
	   public static void addCustomerLinkDetails(){
		  
		   boolean status=true;
			status=hoverAndClick(Admin_AddCustomer_lnk);
			
			if(status) {
		       	System.out.println("Admin AddCustomer Link Clicked Successfully..");
		        logEvent("Pass","Admin AddCustomer Link Clicked Successfully..");
		       	
		       	//To check whether Customer Name element found or not
		       	status=waitForElement(Admin_Addcustomer_customername_edi);
		       	
		    	if (status) {
		    		//get the customer name from the testdata sheet
		    		String custName = getdata("AddCustomerData", "CustomerName", 1);
					//set the customer name data
					status = setData(Admin_Addcustomer_customername_edi, custName);
					logEvent("Pass","Customer Name Entered..");
				}
		    	else {
		    		logEvent("Fail","Customer Name Not-Entered..");
		    	}
		    	
				//To check whether Customer DOB element found or not
		       	status=waitForElement(Admin_Addcustomer_Customerdob_edi);
		       	
		       	if(status){
		       	//get the customer DOB from the testdata sheet
		    	String custDOB=getdata("AddCustomerData", "CustomerDOB", 1);
		    	//set the customer DOB data
		    	status=setData(Admin_Addcustomer_Customerdob_edi,custDOB);
		    	logEvent("Pass","Customer DOB Entered..");
		   	   }
		       	else {
		       		logEvent("Fail","Customer DOB Not-Entered..");
		       	}
		       	
		    	//To check whether CustomerNominee  element found or not
		       	status=waitForElement(Admin_Addcustomer_Customernominee_edi);
		       	if(status){
		       	//get the CustomerNominee from the testdata sheet
		    	String custNominee=getdata("AddCustomerData", "CustomerNominee", 1);
		    	//set the cust Nominee data
		    	status=setData(Admin_Addcustomer_Customernominee_edi,custNominee);
		    	logEvent("Pass","Customer Nominee Entered..");
		      }
		       	else {
		       		logEvent("Fail","Customer Nominee Not-Entered..");
		       	}
		    	
		       	//To check whether Customer Initial  element found or not
		       	status=waitForElement(Admin_Addcustomer_initial_edi);
		       	if(status){
		       	//get the Customer Initial from the testdata sheet
		    	String CustomerInit=getdata("AddCustomerData", "CustomerInitial", 1);
		    	//set the Customer Initial data
		    	status=setData(Admin_Addcustomer_initial_edi,CustomerInit);
		    	logEvent("Pass","Customer Initial Entered..");
		       	}
		       	else {
		       		logEvent("Fail","Customer Initial Not-Entered..");
		       	}
		       	
		    	//To check whether Customer Address element found or not
		       	status=waitForElement(Admin_Addcustomer_Customeraddress_txtarea);
		       	if(status){
		       	//get the Customer Address from the testdata sheet
		    	String custAddress=getdata("AddCustomerData", "CustomerAddress", 1);
		    	//set the customer Address data
		    	status=setData(Admin_Addcustomer_Customeraddress_txtarea,custAddress);
		    	logEvent("Pass","Customer Address Entered..");
		        }
		       	else {
		       		logEvent("Fail","Customer Address Not-Entered..");
		       	}
		       	
		       	
		    	//To check whether Customer Mobile element found or not
		       	status=waitForElement(Admin_Addcustomer_Customermobile_edi);
		       	if(status){
		       	//get the Customer Mobile from the testdata sheet
		    	String custMobile=getdata("AddCustomerData", "CustomerMobile", 1);
		    	//set the customer Mobile data
		    	status=setData(Admin_Addcustomer_Customermobile_edi,custMobile);
		    	logEvent("Pass","Customer Mobile Entered..");
		   	   }
		       	else {
		       		logEvent("Fail","Customer Mobile Not-Entered..");
		       	}
		       	
		    	//To check whether Customer Email element found or not
		       	status=waitForElement(Admin_Addcustomer_Customeremail_edi);
		       	if(status){
		       	//get the Customer Email from the testdata sheet
		    	String custEmail=getdata("AddCustomerData", "CustomerEmail", 1);
		    	//set the customer Email data
		    	status=setData(Admin_Addcustomer_Customeremail_edi,custEmail);
		    	logEvent("Pass","Customer Email Entered..");
		     }
		       	else {
		       		logEvent("Fail","Customer Email Not-Entered..");
		       	}
		       	
		    	//To check whether Customer Password element found or not
		       	status=waitForElement(Admin_Addcustomer_Customerpwd_edi);
		       	if(status){
		       	//get the Customer Password from the testdata sheet
		    	String custPass=getdata("AddCustomerData", "CustomerPassword", 1);
		    	//set the customer Password data
		    	status=setData(Admin_Addcustomer_Customerpwd_edi,custPass);
		    	logEvent("Pass","Customer Password Entered..");
		      }
		       	else {
		       		logEvent("Fail","Customer Password Not-Entered..");
		       	}
		    	
		       	status=waitForElement(Admin_Addcustomer_branch_sel);
		    	if(status){
		       	//To select value in Branch DropDown list 
		       	String branchName=getdata("AddCustomerData", "Branch", 1);
		    	selectOption(Admin_Addcustomer_branch_sel,branchName);
		    	logEvent("Pass","Branch Value got selected");
		    	}
		    	else {
		    		logEvent("Fail","Branch Value Not-selected");
		    	}
		    	
		    	
		    	status=waitForElement(Admin_Addcustomer_Customeraccount_sel);
		    	if(status){
		    	//To select value in Account Type DropDown  list 
		    	String accType=getdata("AddCustomerData", "AccountType", 1);
		    	selectOption(Admin_Addcustomer_Customeraccount_sel,accType);
		    	logEvent("Pass","Account Type got selected");
		    	}
		    	else {
		    		logEvent("Fail","Account Type Not selected");
		    	}
		    	
		    	status=waitForElement(Admin_Addcustomer_Customergender_rdo);
		    	if(status){
		    	//To select value in Gender Radio Button
		    	String genderVal=getdata("AddCustomerData", "Gender", 1);
		    	selectRadioButton(Admin_Addcustomer_Customergender_rdo, genderVal);
		    	logEvent("Pass","Gender Value got selected");
		       }
		    	else {
		    		logEvent("Fail","Gender Value Not selected");
		    	}
		    	
		    	//status=hoverAndClick(Admin_Addcustomer_addcustomer_btn);
		    	if(status){
		    	  System.out.println("Add Customer Button Clicked Successfully..");
		    	  logEvent("Pass","Add Customer Button Clicked Successfully..");
		    	  }
		    	else {
		    		System.out.println("Add Customer Button Not-Clicked");
		    		logEvent("Fail","Add Customer Button Not-Clicked");
		    	}
		   }
			else{
				System.out.println("Admin AddCustomer Not-Link Clicked");
				logEvent("Fail","Admin AddCustomer Not-Link Clicked");
			}
	  }
	  
	   
	  
	  //To Verify  AddCustomer Link exits or not
	   public static void addCustomerLinkVerify(){
	         boolean fstatus=true;
		    //Going to Check whether AddCustomer Link Found or Not 
		     fstatus=waitForElement(Admin_AddCustomer_lnk);
		   //Going to Check whether AddCustomer Link is Enabled  or Not
		     fstatus=Admin_AddCustomer_lnk.isEnabled();
		     if(fstatus){
		    	 System.out.println("AddCustomer Link Found can be Clickable..");
		    	 logEvent("Pass","AddCustomer Link Found can be Clickable..");
		    //CLick on the AddCustomer link to check whether it is clickable or Not  
		    	 fstatus=hoverAndClick(Admin_AddCustomer_lnk);
		    	 if(fstatus){
		    		 System.out.println("AddCustomer Link Clicked..");
		    		 logEvent("Pass","AddCustomer Link Clicked..");
		    	 }
		    	 else{
		    		 System.out.println("AddCustomer Not-Link Clicked..");
		    		 logEvent("Fail","AddCustomer Not-Link Clicked..");
		    	 }
		     }
		     else{
		    	 System.out.println("AddCustomer Not Be Clickable..");
		    	 logEvent("Fail","AddCustomer Not Be Clickable..");
		     }
	   }
	   
	   
	   
	   public static void changePassLinkVal(){
		   boolean status=true;
		   status=hoverAndClick(Admin_ChangePassword_lnk);
		   if(status){
		   System.out.println("Admin ChangePassword Link Clicked Successfully..");
		   List<WebElement> list=driver.findElements(By.cssSelector("input:invalid"));
		   int count=list.size();
		   System.out.println("Total No of In-valid fileds in ChangePassword Page :: "+count);
		   
		   //Old Password
		   String oldPass=getdata("ChangePasswordPage", "Enteroldpassword", 1);
	       status=setData(Admin_ChangePassword_old_password_edi,oldPass);
	       
	       //New Password
	       String newPass=getdata("ChangePasswordPage", "Enternewpassword", 1);
	       status=setData(Admin_ChangePassword_new_password_edi,newPass);
	       
	       /*//Again Password
	       String againPass=getdata("ChangePasswordPage", "EnterpasswordAgain", 1);
	       status=setData(Admin_ChangePassword_again_password_edi,againPass);*/
	       
	       status=hoverAndClick(Admin_ChangePassword_ChangePassword_btn);
	       
	       List<WebElement> list2=driver.findElements(By.cssSelector("input:invalid"));
	       int count2=list2.size();
	       System.out.println("No of Invalid fileds in After Click ChangePassword Page :: "+count2);
	       
	       if(count2==0){
	    	   System.out.println("User can Able to Validate Change Password Fields..");
	    	   logEvent("Pass", "User can Able to Validate Change Password Fields..");
	       }
	       else{
	    	   System.out.println("User Not-Able to Validate Change Password Fields");
	    	   logEvent("Fail", "User Not-Able to Validate Change Password Fields");
	          }
		   }
		   else {
			   System.out.println("Admin ChangePassword Link Not-Clicked..");
			   logEvent("Fail", "Admin ChangePassword Link Not-Clicked..");
		   }
	   }
}
