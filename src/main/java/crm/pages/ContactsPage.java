package crm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crm.baseclass.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLable;

	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
	WebElement company;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]")
	WebElement save;
	
	
	//Initializing page factory
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Actions
	
	public boolean verifyContactLable() {
		return contactsLable.isDisplayed();
	}
	
	
	  public void selectContactsByName(String name) {
		  Actions action = new Actions(driver);
		  action.moveToElement(driver.findElement(By.xpath("//th[contains(text(),'Status')]"))).build().perform();
	      driver.findElement(By.xpath("//td[@class]//a[text()=\'"+name+"']/../preceding-sibling::td[@class]//div[@class='ui fitted read-only checkbox']")).click();
	  
	  }
	 
	
	
		public void createNewContact( String status1 , String ft, String lt, String cmp) {
		
			driver.findElement(By.xpath("//div[@name='status']")).click();
	     List<WebElement> status=driver.findElements(By.xpath("//div[@class=\"visible menu transition\"]"));

	     for(WebElement selectStatus:status) {

             if(selectStatus.getText().contains(status1)) {

            	 selectStatus.click();

             }

                    }
		firstname.sendKeys(ft);
		lastname.sendKeys(lt);
		company.sendKeys(cmp);
		save.click();
		
	}
	
	
	
	
	
	
	
}
