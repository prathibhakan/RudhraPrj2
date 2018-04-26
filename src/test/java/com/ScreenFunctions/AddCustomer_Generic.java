package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class AddCustomer_Generic extends GenericFunctions{

	@FindBy(how=How.XPATH,using="//a[text()='Add Customer']")
	public static WebElement Admin_Addcustomer_lnk;
	
	@FindBy(how=How.XPATH,using="//input[@name='customer_name']")
    public static WebElement Admin_Addcustomer_customername_edi;
    //
	@FindBy(how=How.XPATH,using="//input[@name='customer_gender']")
    public static java.util.List<WebElement> Admin_Addcustomer_Customergender_rdo;
	
	@FindBy(how=How.XPATH,using="//input[@name='customer_dob']")
    public static WebElement Admin_Addcustomer_Customerdob_edi;

	@FindBy(how=How.XPATH,using="//input[@name='customer_nominee']")
    public static WebElement Admin_Addcustomer_Customernominee_edi;
	
	@FindBy(how=How.XPATH,using="//select[@name='branch']/option[2]")
    public static WebElement Admin_Addcustomer_branch_sel;
	
	@FindBy(how=How.XPATH,using="//select[@name='customer_account']/option[2]")
    public static WebElement Admin_Addcustomer_Customeraccount_sel;
	
	@FindBy(how=How.XPATH,using="//input[@name='initial']")
    public static WebElement Admin_Addcustomer_initial_edi;
	
	@FindBy(how=How.XPATH,using="//textarea[@name='customer_address']")
    public static WebElement Admin_Addcustomer_Customeraddress_txtarea;
	
	@FindBy(how=How.XPATH,using="//input[@name='customer_mobile']")
    public static WebElement Admin_Addcustomer_Customermobile_edi;

	@FindBy(how=How.XPATH,using="//input[@name='customer_email']")
    public static WebElement Admin_Addcustomer_Customeremail_edi;

	@FindBy(how=How.XPATH,using="//input[@name='customer_pwd']")
    public static WebElement Admin_Addcustomer_Customerpwd_edi;
	
	@FindBy(how=How.XPATH,using="//input[@name='add_customer']")
	public static WebElement Admin_Addcustomer_addcustomer_btn;
	
	public static void adminAddCustomer(){
	 
		boolean status=true;
		status=hoverAndClick(Admin_Addcustomer_lnk);
		if(status) {
	       	System.out.println("Admin Add Customer Link Clicked Successfully..");	
	       	
	        //get the customer name from the testdata sheet
	    	String custName=getdata("AddCustomerData", "CustomerName", 1);
	    	//get the customer name from the testdata sheet	
	    	status=setData(Admin_Addcustomer_customername_edi,custName);
	    	
	    	
	    	//get the customer Gender from the testdata sheet
	    	String custGender=getdata("AddCustomerData", "Gender", 1);
	    	
	    	if(custGender=="M"){
	    		Admin_Addcustomer_Customergender_rdo.get(0).click();
	    	}
	    	else{
	    		Admin_Addcustomer_Customergender_rdo.get(1).click();
	    	}
	    	
	    	//get the customer DOB from the testdata sheet
	    	String custDOB=getdata("AddCustomerData", "CustomerDOB", 1);
	    	//get the customer DOB from the testdata sheet	
	    	status=setData(Admin_Addcustomer_Customerdob_edi,custDOB);
	    	
	    	//get the customer Nominee from the testdata sheet
	    	String custNominee=getdata("AddCustomerData", "CustomerNominee", 1);
	    	//get the customer Nominee from the testdata sheet	
	    	status=setData(Admin_Addcustomer_Customernominee_edi,custNominee);
	    	
	    	//get the customer MInimum Amount from the testdata sheet
	    	String custInitail=getdata("AddCustomerData", "CustomerInitial", 1);
	    	//get the customer MInimum Amount from the testdata sheet	
	    	status=setData(Admin_Addcustomer_initial_edi,custInitail);
	    	
	    	//get the customer Address from the testdata sheet
	    	String custAddress=getdata("AddCustomerData", "CustomerAddress", 1);
	    	//get the customer Address from the testdata sheet	
	    	status=setData(Admin_Addcustomer_Customeraddress_txtarea,custAddress);
	    	
	    	//get the customer Mobile from the testdata sheet
	    	String custMobile=getdata("AddCustomerData", "CustomerMobile", 1);
	    	//get the customer Mobile from the testdata sheet	
	    	status=setData(Admin_Addcustomer_Customermobile_edi,custMobile);
	    	
	    	//get the customer Email from the testdata sheet
	    	String custEmail=getdata("AddCustomerData", "CustomerEmail", 1);
	    	//get the customer Email from the testdata sheet	
	    	status=setData(Admin_Addcustomer_Customeremail_edi,custEmail);
	    	
	    	//get the customer Password from the testdata sheet
	    	String custPassword=getdata("AddCustomerData", "CustomerPassword", 1);
	    	//get the customer Password from the testdata sheet	
	    	status=setData(Admin_Addcustomer_Customerpwd_edi,custPassword);
	    	
	    	
	    	//Click on the AddCustomer Button 
	    	if(status){
	    		System.out.println("Admin Add CUstomer Button Clicked..");
	    	}
	    	else{
	    		System.out.println("Admin Add CUstomer Button Not-Clicked..");
	    	}
		}
		else{
			System.out.println("Admin Add Customer Link Not-Clicked Successfully..");
		}
		
		
		
	}
}
