package com.VisionIT.FreeCrmPro.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
	
		this.driver=driver;
	}
	
	public void verifyLogoutCrmPro()
	{
		driver.switchTo().frame("mainpanel");
	
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a")).click();
	
		driver.switchTo().defaultContent();
	}
}
