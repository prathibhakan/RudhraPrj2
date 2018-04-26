package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.AddCustomer_Generic;
import com.ScreenFunctions.AdminLoginGeneric;

public class TC02_Admin_Add_Customer extends GenericFunctions{
	
	@Test
	public void  TC_Admin_AddCustomer(){
       GenericFunctions gnf=new GenericFunctions();
	   gnf.launchApplication("firefox");
	
	   AdminLoginGeneric adminLog=PageFactory.initElements(driver,AdminLoginGeneric.class);
	   adminLog.AdminLogin();
	   
	   AddCustomer_Generic addCustomer=PageFactory.initElements(driver,AddCustomer_Generic.class);
	   addCustomer.adminAddCustomer();
	   
   }
}
