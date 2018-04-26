package com.TestCasesAutomation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.AdminLoginGeneric;
import com.ScreenFunctionsAutomationTC.Admin_AddCustomer;

public class TC01_Verify_AddCustomerLink extends GenericFunctions {

	@Test
	public static void TC01_Verify_AddCustomerLink_Admin() {

		// Launch the Application by passing browser name as Input Parameter
		    launchApplication("firefox");
		// Initialise all elements of Login Page into our class using
		// PageFactory Class
		AdminLoginGeneric lgn = PageFactory.initElements(driver, AdminLoginGeneric.class);
		lgn.AdminLogin();

		Admin_AddCustomer addCustomer = PageFactory.initElements(driver, Admin_AddCustomer.class);
		addCustomer.addCustomerLinkVerify();
      
	}

}
