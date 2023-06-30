package crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.baseclass.TestBase;
import crm.pages.ContactsPage;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.util.TestUtil;

public class HomePageTest extends TestBase{
      LoginPage loginPage;
      HomePage homePage;
      ContactsPage contactsPage;
	
	public HomePageTest() {
		
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initializion();
		loginPage =new LoginPage();
		contactsPage=new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
    @Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePage();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home page title not match");
		
  }
	
	@Test(priority=2)
	public void verifyUserNameOnHomepageTest() {
		Assert.assertTrue(homePage.verifyUsernameOnHomePage());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()  {
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	
	
	@AfterMethod
	public void teraDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}