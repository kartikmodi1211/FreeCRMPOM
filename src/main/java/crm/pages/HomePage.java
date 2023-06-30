package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.baseclass.TestBase;

public class HomePage extends TestBase{
	

	
	//OR-webElements
	
	@FindBy(xpath = "//span[contains(text(),'Kartik Modi')]")
	@CacheLookup 
	WebElement userNameLable;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[3]/button[1]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="///span[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	
	
	
	//initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public String verifyHomePage() {
		return driver.getTitle();
	}
	
	public boolean verifyUsernameOnHomePage() {
		return userNameLable.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();	
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
		
	}
	
	
	public TaskPage clickOnTaskLink() {
		taskLink.click();
		return new TaskPage();
	}
	
	public void  clickOnNewContactLink() {
		
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
	}
	
	
	
	
	
	

}
