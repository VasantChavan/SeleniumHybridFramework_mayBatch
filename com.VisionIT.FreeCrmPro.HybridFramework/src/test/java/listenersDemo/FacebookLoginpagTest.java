package listenersDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenersDemo.TestNGListenrs.class)
public class FacebookLoginpagTest {

	@Test
	public void verify_FB_LoginPage_Title() {

		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		String lgTitle = driver.getTitle();

		System.out.println("Login page title of the facebook is :" + lgTitle);

		if(lgTitle.equals("Facebook – log in or sign up")) {
			
			Assert.assertTrue(true);
		}
		
		else {
			Assert.assertTrue(false);
		}
		
		driver.quit();

	}

}
