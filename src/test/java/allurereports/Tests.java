package allurereports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class Tests extends BaseClass{
    
	WebDriver driver;
	
	
	@BeforeClass
	
	public void setup()
	{
		BaseClass bs = new BaseClass();
		bs.initialize_driver();
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1, description="verify Logo Presence on HomePage")
	@Description("verify Logo Presence on HomePage.................")
	@Epic("EP001")
	@Feature("Feature1: Logo")
	@Story("Story: Logo Presence")
	@Step("verify Logo Presence")
	@Severity(SeverityLevel.MINOR)
	public void logoPresence()
	{
		boolean disstatus=driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed();
		Assert.assertEquals(disstatus, true);
		
	}
	
	@Test(priority=2)
	@Description("verify Logo Presence on HomePage.................")
	@Epic("EP001")
	@Feature("Feature2: Logo")
	@Story("Story: Valid login")
	@Step("verify Login")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest()
	{
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("Email")).sendKeys("baba12@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("Baba@12345");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
	}
	
	@Test(priority=3)
	@Description("verify Logo Presence on HomePage.................")
	@Epic("EP001")
	@Feature("Feature3: Registration")
	@Story("Story: registration")
	@Step("verify Login")
	@Severity(SeverityLevel.NORMAL)
	public void regitrationTest()
	{
		throw new SkipException("Skipping this Test");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
