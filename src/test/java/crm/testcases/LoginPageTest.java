package crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.baseclass.TestBase;
import crm.pages.HomePage;
import crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializion();
		loginPage=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitelTest() {
		
		String titel =loginPage.validateLoginPageTitle();
		Assert.assertEquals(titel, "Cogmento CRM");
		
	}
	
	@Test(priority=2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
