package week5.day2.ass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class serviceNowNewCaller {

	public static void main(String[] args) {

		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);	
		driver.get("https://dev112777.service-now.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Cathrine@005");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		//click All 
	    //shadow dom class
				Shadow shadow=new Shadow(driver);
			    shadow.setImplicitWait(20);
			    //note the find element syntax [findelementByXPath]
			    shadow.findElementByXPath("//div[@id='d6e462a5c3533010cbd77096e940dd8c']").click();
			    shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
			    shadow.findElementByXPath("//mark[text()='Callers']").click();
			    //switch to shadow and frame
			    WebElement findElementByXPath = shadow.findElementByXPath("//iframe[@title='Main Content']");
			    driver.switchTo().frame(findElementByXPath);
			    driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
			    driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Cathrine");
			    driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Selvaraj");
			    driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys("My First Automation Test");
			    driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("cat@gmail.com");
			    driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("12345");
			    driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("55555");
			    driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
			    //switch control back to parent page
			   // driver.switchTo().defaultContent();
			    //switch to shadow and frame
			   // WebElement findElementByXPath1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
			    //driver.switchTo().frame(findElementByXPath1);
			    //select class
			    WebElement findElement = shadow.findElementByXPath("//select[@class='form-control default-focus-outline']");
			    //findElement.click();
			    Select s=new Select(findElement);
			    s.selectByIndex(2);
			    //search box
			    shadow.findElementByXPath("//input[@class='form-control']").sendKeys("Cathrine");
			    String text = driver.findElement(By.xpath("//div[contains(text(),'Primary email device created for')]")).getText();
			    if(text.contains("Primary email device created for")) {
			    	System.out.println("verified");
			    }
			    else {
			    	System.out.println("not generated");
			    }
			    
			    
	}

}
