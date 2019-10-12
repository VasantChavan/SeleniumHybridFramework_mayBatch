package listenersDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyGoogleTitle {
	
	@Test
	public void verifyGoogleTitle()
	{
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		String lgTitle = driver.getTitle();
		
		System.out.println(lgTitle);
		
		driver.quit();
	}
}
