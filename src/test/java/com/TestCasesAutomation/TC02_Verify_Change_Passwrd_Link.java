package com.TestCasesAutomation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.AdminLoginGeneric;
import com.ScreenFunctionsAutomationTC.Admin_AddCustomer;

public class TC02_Verify_Change_Passwrd_Link extends GenericFunctions{
          
	      @Test
	        public static void TC02_Verify_Change_Passwrd_Vaidation(){
	    	 //Launch the Application by passing browser name as Input Parameter
				GenericFunctions gnf=new GenericFunctions();
				gnf.launchApplication("firefox");
				
				//Initialise all elements of Login Page into our class using PageFactory Class 
				AdminLoginGeneric lgn=PageFactory.initElements(driver,AdminLoginGeneric.class);
				lgn.AdminLogin();
				
				Admin_AddCustomer chPasslnk=PageFactory.initElements(driver,Admin_AddCustomer.class);
				chPasslnk.changePassLinkVal();
				
	       }
}
