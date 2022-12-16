package addContact;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomer {

	WebDriver driver;
	

	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@name='login']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[text()=' Dashboard ']");
	By CUSTOMERS_BUTTON_FIELD = By.xpath("//span[text()='Customers']");
	By ADD_CUSTOMER_FIELD = By.linkText("Add Customer");
	By ADD_CONTACTS_HEADER_FIELD = By.xpath("//h5[text()='Add Contact']");
	By FULL_NAME_FIELD = By.xpath("//input[@id='account']");
	By COMPANY_DROP_DOWN_FIELD = By.xpath("//select[@id='cid']");
	By EMAIL_FIELD = By.xpath("//input[@id='email']");
	By PHONE_FIELD = By.xpath("//input[@id='phone']");
	By ADDRESS_FIELD = By.xpath("//input[@id='address']");
	By CITY_FIELD = By.xpath("//input[@id='city']");
	By STATE_REGION_FIELD = By.xpath("//input[@id='state']");
	By ZIP_POSTAL_CODE_FILED =By.xpath("//input[@id='zip']");
	By COUNTRY_DROP_DOWN_FIELD = By.xpath("//select[@id='country']");
	By TAGS_SELECTION_FIELD = By.xpath("//select[@id='tags']");
	By CURENCY_FIELD = By.xpath("//select[@id='currency']");
	By GROUP_FIELD = By.xpath("//select[@id='group']");
	By SAVE_BUTTON = By.xpath("//button[@id='submit']");
	
	By LIST_CUSTOMERS_FIELD = By.linkText("List Customers");
	By SEARCH_BUTTON_FIELD = By.xpath("//input[@id='foo_filter']");
	
	
	
	
	
	

	@Before
	public void init() {

		
		System.setProperty("webdriver.chrome.driver", "driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/billing/?ng=admin/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		

	}

	//@Test
	public void logInTest() {

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

		String pageTitleText = driver.getTitle();
		Assert.assertEquals("Dashboard page not found", "Dashboard- iBilling", pageTitleText);

	}
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		
		logInTest();
		driver.findElement(CUSTOMERS_BUTTON_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		
		Thread.sleep(9000);
		
		//Assert.assertTrue("Add contact page not found", driver.findElement(ADD_CONTACTS_HEADER_FIELD).isDisplayed());
		driver.findElement(FULL_NAME_FIELD).sendKeys("supplier002");
		
		Select sel = new Select(driver.findElement(COMPANY_DROP_DOWN_FIELD));
		sel.selectByVisibleText("Amazon");
		
		driver.findElement(EMAIL_FIELD).sendKeys("logistics@amazon.com");
		driver.findElement(PHONE_FIELD).sendKeys("+1 800 000 0000");
		driver.findElement(ADDRESS_FIELD).sendKeys("3660 Thousand oaks");
		driver.findElement(CITY_FIELD).sendKeys("San Antonio");
		driver.findElement(STATE_REGION_FIELD).sendKeys("Txas");
		driver.findElement(ZIP_POSTAL_CODE_FILED).sendKeys("78247");
		Select sel1 = new Select(driver.findElement(COUNTRY_DROP_DOWN_FIELD));
		sel1.selectByVisibleText("United States");
		
		//Select sel4 = new Select(driver.findElement(TAGS_SELECTION_FIELD));
		//sel1.selectByVisibleText("adad");
		
		Select sel2 = new Select(driver.findElement(CURENCY_FIELD));
		sel2.selectByVisibleText("USD");
		
		Select sel3 = new Select(driver.findElement(GROUP_FIELD));
		sel3.selectByVisibleText("Selenium");
		
		
		Thread.sleep(3000);
		
		driver.findElement(SAVE_BUTTON).click();
		
		//logInTest();
		
		//driver.findElement(LIST_CUSTOMERS_FIELD).click();
		//driver.findElement(SEARCH_BUTTON_FIELD).sendKeys("adad");
		
		
		
		
	}

}
