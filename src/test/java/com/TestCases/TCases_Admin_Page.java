package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.AdminLoginGeneric;

public class TCases_Admin_Page extends GenericFunctions{
	@Test
	public void  TC_Login_Admin_Page(){
   
	   GenericFunctions gnf=new GenericFunctions();
	   gnf.launchApplication("firefox");
	   
	   AdminLoginGeneric adminLog=PageFactory.initElements(driver,AdminLoginGeneric.class);
	   adminLog.AdminLogin();
	}
	
	
}
