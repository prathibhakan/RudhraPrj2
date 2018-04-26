package com.ScreenFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.GenericFunctions.GenericFunctions;

public class AdminLoginGeneric extends GenericFunctions{
	//UserName TextBox of LoginPage 
	@FindBy(how=How.XPATH,using="//input[@name='uname']")
    public static WebElement Admin_edi_Username;
	//Password TextBox of LoginPage 
	 @FindBy(how=How.XPATH,using="//input[@name='pwd']")
	 public static WebElement Admin_edi_Password;
	//Login Button  of LoginPage
	 @FindBy(how=How.XPATH,using="//input[@name='submitBtn']")
	 public static WebElement Admin_btn_Login;
	 
	
	 public static void AdminLogin(){
		 boolean status=true;
		 
		 status=waitForElement(Admin_edi_Username);
		 if(status)	{
			 System.out.println("UserName Found ..");
			 logEvent("Pass","UserName Found ..");
			 //get the userName name from the CommonTestData sheet	
			  String userName= getCommontestdata("Username");
			  status=setData(Admin_edi_Username,userName);
			   }
		else {
			System.out.println("UserName Not-Found ..");
			logEvent("Fail","UserName Not Found ..");
		}
		 
		 status=waitForElement(Admin_edi_Password);
		 if(status)	{
			 System.out.println("PAssword Found ..");
			 logEvent("Pass","Password Found ..");
			 //get the PAssword name from the CommonTestData sheet	
			  String passWord= getCommontestdata("Password");
			  status=setData(Admin_edi_Password,passWord);
		   }
		else {
			System.out.println("PAssword Not-Found ..");
			logEvent("Fail","Password Not-Found ..");
		  }
		 
		 status=hoverAndClick(Admin_btn_Login);
		 
		 if(status)	{
			 System.out.println("Admin Login Button Clicked ..");  
			 logEvent("Pass","Admin Login Button Clicked ..");  
			      try {
					  WebElement ele=driver.findElement(By.xpath("//a[@href='admin_hompage.php']"));
					  String text=ele.getText();
					 
					  SoftAssert sAss=new SoftAssert();
					  sAss.assertTrue(text.equals("Admin Home"));
					  System.out.println("Admin Home Page Entered..");
					  logEvent("Pass","Admin Home Page Entered..");
				} catch (Exception e) {
					   System.out.println("Admin Home Page Was Not-Entered..");
					   logEvent("Fail","Admin Home Page Was Not-Entered..");
				    }
			    }
		else {
			System.out.println("Admin Login Button Not-Found ..");
			logEvent("Fail","Admin Login Button Not-Found .."); 
		 }
	 }
}
