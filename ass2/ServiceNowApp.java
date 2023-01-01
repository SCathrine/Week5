package week5.day2.ass2;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ServiceNowApp {

	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://dev112777.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Cathrine@005");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		//click All 
		//shadow dom class
		Shadow shadow=new Shadow(driver);
	    shadow.setImplicitWait(20);
	    //note the find element syntax [findelementByXPath]
	    shadow.findElementByXPath("//div[@id='d6e462a5c3533010cbd77096e940dd8c']").click();
	    shadow.findElementByXPath("//input[@id='filter']").sendKeys("System security");
	    shadow.findElementByXPath("//mark[text()='System Security']").click();
	    shadow.findElementByXPath("//mark[text()='System Security']").click();
	    Actions act=new Actions(driver);
	    act.scrollByAmount(0, 200).perform();
	    shadow.findElementByXPath("//span[text()='Users']").click();
	    
	    //*use shadow to switch to iframe element*
	    shadow.setImplicitWait(10);
	    WebElement eframe= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
	    driver.switchTo().frame(eframe);
	    
	    //click search box and enter admin
	    driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("admin");
	    driver.findElement(By.xpath("//a[text()='admin']")).click();
	
	    //check shadow dom/frame location in new page.
	    //if shadow in margin/outer ignore shadow dom. perform normal findelement xpath
	    //if find element gets highlighted in insepect--use normal xpath without shadow
	    driver.findElement(By.xpath("(//button[text()='Set Password'])[2]")).click();
	    driver.findElement(By.xpath("//button[text()='Generate']")).click();    
	    driver.findElement(By.xpath("//button[@id='copy_code']")).click();
	    String text = driver.findElement(By.xpath("//div[@id='divNotification']")).getText();
	    System.out.println(text);
	    if(text.contains("Password copied")) {
	    	System.out.println("Password Generated");
	    }
	    else {
	    	System.out.println("Password Not Generated");
	    }
	    
	    driver.findElement(By.xpath("//button[text()='Close']")).click();
	    driver.switchTo().defaultContent();
	    driver.close();
	    
	}

}
