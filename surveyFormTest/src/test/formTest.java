package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class formTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.out.println("This the start of test");
		String url = "https://nianziyi.github.io/data-survey-form-testing/";
		
		/*Chrome*/
		//System.setProperty("webdriver.chrome.driver","/Users/nianziyi/browserDriver/chromedriver");
		//ChromeDriver driver =new ChromeDriver();
		
		/*Firefox*/
		System.setProperty("webdriver.gecko.driver","/Users/nianziyi/browserDriver/geckodriver");
		driver =new FirefoxDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1,description="Test if user can locate to correct page")
	public void titleTest() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Data Survey Form";	
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	
	@Test(priority=2,description="Test if user can type in input fields")
	public void inputTest() {
		driver.findElement(By.id("firstname")).sendKeys("John");
		driver.findElement(By.id("lastname")).sendKeys("Davis");
		driver.findElement(By.id("title")).sendKeys("student");
		driver.findElement(By.id("height")).sendKeys("50");
		driver.findElement(By.id("phone")).sendKeys("1234567890");
		driver.findElement(By.id("address")).sendKeys("1600 Holloway Ave");
		driver.findElement(By.id("city")).sendKeys("San Francisco");
		driver.findElement(By.id("state")).sendKeys("CA");
		driver.findElement(By.id("zip")).sendKeys("94132");
		driver.findElement(By.id("service1")).click();
		driver.findElement(By.id("service3")).click();
		driver.findElement(By.id("service6")).click();
		driver.findElement(By.id("budget")).sendKeys("above $100");
		driver.findElement(By.id("emial")).sendKeys("your@email.com");
		driver.findElement(By.id("terms")).click();
	}
	
	@Test(priority=3,description="Test if user can submit form")
	public void submitTest() {
		driver.findElement(By.id("button")).click();
	}
	
	@Test(priority=4,description="Test if user's inputs can be captured correctly")
	public void resultTest() {
		Assert.assertEquals(driver.findElement(By.id("result-first")).getText(),"John");
		Assert.assertEquals(driver.findElement(By.id("result-last")).getText(),"Davis");
		Assert.assertEquals(driver.findElement(By.id("result-title")).getText(),"student");
		Assert.assertEquals(driver.findElement(By.id("result-height")).getText(),"50");
		Assert.assertEquals(driver.findElement(By.id("result-phone")).getText(),"1234567890");
		Assert.assertEquals(driver.findElement(By.id("result-address")).getText(),"1600 Holloway Ave");
		Assert.assertEquals(driver.findElement(By.id("result-city")).getText(),"San Francisco");
		Assert.assertEquals(driver.findElement(By.id("result-state")).getText(),"CA");
		Assert.assertEquals(driver.findElement(By.id("result-zip")).getText(),"94132");
		Assert.assertEquals(driver.findElement(By.id("result-service")).getText(),"E-mail, Facebook, Personal visit");
		Assert.assertEquals(driver.findElement(By.id("result-budget")).getText(),"above $100");
		Assert.assertEquals(driver.findElement(By.id("result-email")).getText(),"your@email.com");
	}
	
	@Test(priority=5,description="Test if the map can show successfully")
	public void mapTest() {
		driver.findElement(By.id("embedMap")).isDisplayed();
	}
	
	@AfterTest
	public void end() {
		driver.close();
		System.out.println("Test results are ready:");
		System.out.println();
	}
	
	
	
	
	
	
	
	
}
