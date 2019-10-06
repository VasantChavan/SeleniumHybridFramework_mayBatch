package com.VisionIT.FreeCrmPro.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.VisionIT.FreeCrmPro.PageObject.LoginPage;
import com.VisionIT.FreeCrmPro.TestBase.BaseClass;

public class LoginPageTC extends BaseClass {

	LoginPage login;

	@BeforeMethod
	public void setUp() {
		Reporter.log("Before navigating to browser, we are getting the browsername to launch respective browser.. ");
		
		String browserName=configDataProvider.getConfigProperties("chBrowser");
		String url=configDataProvider.getConfigProperties("url");
		
		Reporter.log("launching the browser:   "+ browserName, true);
		Reporter.log("Navigating to url:  "+ url, true );
		browserStartUp(browserName, url);
		
		Reporter.log("initializing login page object ", true);
		
		login = new LoginPage(driver);
		
	}

	/*@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		
		//logger=extent.createTest("Verify title of the loginpage test..");
		
		String actualPageTitle = login.verifyLoginPageTitle();
		System.out.println(actualPageTitle);
		
	}*/

	/*@Test(priority = 2)
	public void verifyCRMPROLogoTest() {
		Assert.assertTrue(login.verifyCRMPROLogo(), "CRMOPRO logo on login page is not displayed");
	}*/

	/*@Test(priority = 3)
	public void navigateToCreateAnAccountPageTest() {
		SignUpPage signUp = login.navigateToCreateAnAccountPage();

	}*/
	/*
	 * @Test(priority = 4) public void verifyloginToCrmProTest() { DashBoardPage
	 * dashBoard = login.verifyloginToCrmPro(prop.getProperty("username"),
	 * prop.getProperty("userpass")); }
	 */

	/*
	 * @Test(priority = 4) public void verifyloginToCrmProTest() {
	 * 
	 * String username= excelDataProvider.getStringCellData("login", 1, 0);
	 * 
	 * String userpwd= excelDataProvider.getStringCellData(4, 1, 1);
	 * 
	 * login.verifyloginToCrmPro(username,userpwd);
	 * 
	 * if(driver.getTitle().contains("CRMPRO")) {
	 * 
	 * Assert.assertTrue(true);
	 * 
	 * login.verifyLogoutCrmPro(); } else {
	 * 
	 * System.out.println("Not able to login into an application"); }
	 * 
	 * }
	 */

	@Test(priority = 4, dataProvider = "getExcelData")
	public void verifyloginToCrmProTest(String uname, String upwd) {
		
		Reporter.log("Create login Test before start it..", true);
		
		logger=extent.createTest("Veryfying crmpro login ...");
		
		logger.info("before going to login into crm ...");
		
		login.verifyloginToCrmPro(uname, upwd);
		
		//driver.switchTo().frame("mainpanel");
		
		boolean status=driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")).isDisplayed();
		if (status) {

			logger.pass("Login successfully....");
			Assert.assertTrue(true);

			//login.verifyLogoutCrmPro();
			
		} else {

			logger.fail("Login failed....");
			System.out.println("can't find element");
		
			Assert.assertTrue(false);
		}
		
		Reporter.log("login Test completed and checkout the results in reports..", true);

	}

	@DataProvider
	public Object[][] getExcelData() {

		Object[][] data = excelDataProvider.getExcelData("login");

		return data;
	}

}
