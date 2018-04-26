package com.TestCasesAutomation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.AdminLoginGeneric;
import com.ScreenFunctionsAutomationTC.Admin_AddCustomer;
import com.ScreenFunctionsAutomationTC.Admin_DeleteCustomer;

public class TC_03_Verify_Admin_DeleteCustomer extends GenericFunctions{
	 @Test
     public static void TC02_Verify_Del_Cust_Validation(){
 	 //Launch the Application by passing browser name as Input Parameter
			GenericFunctions gnf=new GenericFunctions();
			gnf.launchApplication("firefox");
			
			//Initialise all elements of Login Page into our class using PageFactory Class 
			AdminLoginGeneric lgn=PageFactory.initElements(driver,AdminLoginGeneric.class);
			lgn.AdminLogin();
			
			Admin_DeleteCustomer del=PageFactory.initElements(driver,Admin_DeleteCustomer.class);
			del.delCustomer();
    }
	 
}
