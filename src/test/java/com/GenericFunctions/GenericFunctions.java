package com.GenericFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class GenericFunctions extends TestNGListeners {

	public static WebDriver driver;

	/*************************************************
	 * 
	 * Function Name:launchApplication
	 * 
	 * Purpose:-This Function is used to launch the TM Online Banking System Application when ever
	 * the user is required
	 * 
	 * Input Parameters:-User must send in which browser does the application
	 * need to be launch
	 * 
	 * Output Parameters:-This method will return a boolean value stating whether
	 * the user logged into in the system
	 * 
	 * Author:-Veera Prathap Malepati
	 * 
	 * Creation date:-12/30/2017
	 **************************************************/

	public static boolean launchApplication(String browser) {

		boolean status = true;

		switch (browser.toLowerCase()) {
		case "ie":

			break;

		case "firefox":

			driver = new FirefoxDriver();

			String url = getCommontestdata("Url");

			System.out.println(url);

			driver.get(url);

			driver.manage().window().maximize();

			// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tm\\Downloads\\chromedriver.exe");

			driver = new ChromeDriver();
			String url1 = getCommontestdata("Url");
			System.out.println(url1);
			driver.manage().window().maximize();

			break;

		default:
			break;
		}

		return status;

	}

	/*************************************************
	 * 
	 * 
	 * Function Name:GetCommonTestdata
	 * 
	 * Purpose:-This function is used to get the common test data which can be
	 * accessed commonly for each testcase such as
	 * Environment,Url,Username,Password
	 * 
	 * Input Parameters:-User must send an argument stating what data that is
	 * required
	 * 
	 * Output Parameters:-This method will return a string value for the User
	 * given input(If data is not found it will return a null)
	 * 
	 * Author:-Veera Prathap Malepati
	 * 
	 * Creation date:-12/31/2017
	 **************************************************/

	public static String getCommontestdata(String data) {

		String strQuery = "Select " + data + " from CommonTestdata";

		System.out.println(strQuery);

		Recordset recordset;

		String fetcheddata = "";

		try {

			recordset = TestNGListeners.connection.executeQuery(strQuery);

			while (recordset.next()) {

				System.out.println("Data is found and the data is " + recordset.getField(data));

				fetcheddata = recordset.getField(data);
				break;

			}

			recordset.close();

		} catch (FilloException e) {

			System.out.println("No Records Found");
		}

		return fetcheddata;

	}

	/*************************************************
	 * Function Name:getdata
	 * 
	 * Purpose:-This function is used to get the data from excel sheet required
	 * for out TestCAse
	 * 
	 * Input Parameters:-User must send sheetName,userdata,iteration of excel
	 * file as parameters
	 * 
	 * Output Parameters:-This method will return a data from excel sheet based
	 * upon input parameters
	 * 
	 * Author:-Veera Prathap Malepati Creation date:-12/30/2017
	 **************************************************/

	public static String getdata(String sheetname, String userdata, int itr) {

		String strQuery = "Select " + userdata + " from " + sheetname + " where Tc_Name='" + crntclass
				+ "' and Iteration=" + itr;
		System.out.println(strQuery);

		Recordset recordset;

		String fetcheddata = "";

		try {

			recordset = TestNGListeners.connection.executeQuery(strQuery);

			while (recordset.next()) {

				System.out.println("Data is found and the data is " + recordset.getField(userdata));

				fetcheddata = recordset.getField(userdata);
				break;

			}

			recordset.close();

		} catch (FilloException e) {

			System.out.println("No Records Found");
		}

		return fetcheddata;

	}

	
	/*************************************************
	 * Function Name:waitForElement
	 * 
	 * Purpose:-This function is used to wait for an  element for 10 seconds
	 * 
	 * Input Parameters:-User must send WebElement as parameters
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the element got found or not
	 * 
	 * Author:-Veera Prathap Malepati Creation date:-12/30/2017
	 **************************************************/
	
	public static boolean waitForElement(WebElement element) {
		boolean status = true;
		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println("Wait is executing");
				Actions acc = new Actions(driver);
				acc.moveToElement(element).build().perform();

				System.out.println("Element Found");
				break;

			} catch (Exception e) {
				try {
					status = false;
					Thread.sleep(1000);

				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

			}
		}
		return status;
	}

	/*************************************************
	 * Function Name:setData
	 * 
	 * Purpose:-This function is used to set the data an element
	 * 
	 * Input Parameters:-User must send WebElement,data as parameters
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the element got set the data
	 * 
	 * Author:-Veera Prathap Malepati Creation date:-12/30/2017
	 **************************************************/
	public static boolean setData(WebElement element, String data) {
		boolean status = true;
		status = waitForElement(element);
		if (status) {
			try {
				element.click();
				element.clear();
				element.sendKeys(data);
			} catch (Exception e) {
				status = false;
			}
		}
		return status;
	}

	/*************************************************
	 * Function hoverAndClick
	 * 
	 * Purpose:-This function is to click on element found
	 * 
	 * Input Parameters:-User must send WebElement as input parameters
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the element got clicked or not
	 * 
	 * Author:-Rudra Creation date:-11/Apr/2017
	 **************************************************/
	
	public static boolean hoverAndClick(WebElement element) {

		boolean status = true;
		try {
			waitForElement(element);
			Actions acc = new Actions(driver);
			acc.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	
	
	public static void forceClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);

	}

	/*************************************************
	 * Function selectOption
	 * 
	 * Purpose:-This function is select the dropdown value from the list
	 * 
	 * Input Parameters:-User must send WebElement,optionData as input
	 * parameters
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the value got from the lsit
	 * 
	 * Author:-Rudra Creation date:-11/Apr/2017
	 **************************************************/

	public static boolean selectOption(WebElement element, String optionData) {
		boolean status = true;

		try {
			Select slct = new Select(element);
			slct.selectByVisibleText(optionData);
			System.out.println("Option" + optionData + "Selected Successfully for the Element " + element);
		} catch (Exception e) {
			status = false;
			System.out.println("Unable to Select the" + optionData + "for the Element " + element);
		}
		return status;
	}

	/*************************************************
	 * Function selectRadioButton
	 * 
	 * Purpose:-This function is select the radio button value 
	 * 
	 * Input Parameters:-User must send WebElement,value as input parameters
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the value got from the selected or not
	 * 
	 * Author:-Rudra Creation date:-11/Apr/2017
	 **************************************************/
	
	public static boolean selectRadioButton(WebElement element, String value) {
		boolean status = true;

		try {
			element = driver.findElement(By.xpath("//input[@type='radio' and @value='" + value + "']"));
			element.click();
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	
	/*************************************************
	 * Function delCustomerGeneric
	 * 
	 * Purpose:-This function is used to delete the Customer Record based on input parameters 
	 * 
	 * Input Parameters:-User must send Customer Name,Email as input parameters
	 * 
	 * Output Parameters:-This method will return a boolean value stating
	 * whether the appropriate record got deleted or not
	 * 
	 * Author:-Rudra Creation date:-11/Apr/2017
	 **************************************************/
	
	public static boolean delCustomerGeneric(String delName, String delEmail) {
		boolean status = true;
		WebElement ele = driver.findElement(By.xpath("//table[1]/tbody/tr/td[2][text()='"+delName+"']/following-sibling::td[7][text()='"+delEmail+"']/preceding-sibling::td[8]/input"));
		status = hoverAndClick(ele);

		return status;
	}
}
