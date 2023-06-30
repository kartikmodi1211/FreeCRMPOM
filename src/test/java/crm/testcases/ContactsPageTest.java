package crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crm.baseclass.TestBase;
import crm.pages.ContactsPage;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	//String sheetName="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod 
	public void setUp() {
		initializion();
		loginPage= new LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLable() {
		Assert.assertTrue(contactsPage.verifyContactLable(),"contact lable is missing");
	
	}
	
	@Test(priority=2)
	public void selectSinglecontactTest() {
		contactsPage.selectContactsByName("Vandit Patel");
	}
	
	@Test(priority=3)
	public void selectMultiplecontactTest() {
		contactsPage.selectContactsByName("Tom Mark");
		contactsPage.selectContactsByName("Vandit Patel");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object Data [][] =TestUtil.getTestData("contacts");
		return Data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String status1,String ft, String lt, String cmp) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact( "New","parth","parth", "google");
		contactsPage.createNewContact(status1, ft, lt, cmp);
	}
	
	
	@AfterMethod
	public void teraDown() {
		driver.quit();
	}

}
