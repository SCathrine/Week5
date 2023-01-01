package week5.day2.ass2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CommonClass {
	
	RemoteWebDriver driver;
	
	@Parameters({"url", "username","password","login","link","link2"})
	@BeforeMethod
	public void precondition(String url, String username, String password,String login,String link,String link2) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className(login)).click();
		driver.findElement(By.linkText(link)).click();
		driver.findElement(By.linkText(link2)).click();
	}
	
	@AfterMethod
	public void postconditions() {
		
		driver.close();
	}

}
