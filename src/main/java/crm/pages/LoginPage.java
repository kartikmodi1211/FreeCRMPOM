package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.baseclass.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory , Object repository 
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
     WebElement signUp; 
	

	public LoginPage() {
		
		PageFactory.initElements(driver,this);
	}
	
	//Actions , methods 
	
	public String validateLoginPageTitle(){
		 return driver.getTitle();
		  
	  }
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
