package crm.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import crm.util.WebEventListener;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/kartik/Desktop/EclipseWorkspace/FreeCRMTest/src/main/java/crm/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initializion() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/kartik/Desktop/Zip_file_installer/chromedriver_mac64/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/geckodriver");
			driver = new FirefoxDriver();
		}

		/************************************************
		 * Web driver fire event
		 ***************************************************/

		
		  e_driver= new EventFiringWebDriver(driver); 
		  eventListener=new WebEventListener(); 
		  e_driver.register(eventListener); 
		  driver=e_driver;
		
		/************************************************
		 * Web driver fire event
		 ***************************************************/

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
