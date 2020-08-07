


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.puma.qa.pages.HomePage;
import com.puma.qa.pages.LoginPage ;
import com.puma.qa.base.base;

public class LoginTest extends base {
	
	LoginPage loginPage;
	HomePage homepage;


	public LoginTest() throws Throwable  {
		super();
		
	}

	@BeforeMethod
	public void setUp() throws Throwable{
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "PUMA.COM | Forever Faster");
	}
	
	@Test(priority=2)
	
	public void ValidateLoginCredentialTest() {
		
		homepage= loginPage.LoginCredential(prop.getProperty("email"),prop.getProperty("Gender"));
		}
	
	@AfterMethod
	
	public void TearDown() throws InterruptedException {
		//Thread.sleep(2000);
		driver.quit();
		
	}
		
	
}
