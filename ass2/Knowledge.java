package week5.day2.ass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class Knowledge {

	public static void main(String[] args) throws InterruptedException {
		
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
			    shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
			    shadow.findElementByXPath("//mark[text()='Knowledge']").click();
			    
			    //frame is inside of shadow dom---use shadow to access frame
			    WebElement findElementByXPath = shadow.findElementByXPath("//iframe[@title='Main Content']");
			    driver.switchTo().frame(findElementByXPath);
			    
			    driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
			    driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']")).sendKeys("IT");
			    driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']")).sendKeys("Java");
			    driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("Service Now Application Demo");
			    driver.findElement(By.xpath("//label[@id='label.ni.kb_knowledge.direct']")).click();
			    driver.findElement(By.xpath("//label[@id='label.ni.kb_knowledge.display_attachments']")).click();
			    
			    //switch to another frame2 inside frame1 -- so don't switch back to 'defaultContent()'.
			    
			
			    WebElement findElement = driver.findElement(By.xpath("//iframe[@id='kb_knowledge.text_ifr']"));
			    driver.switchTo().frame(findElement);
			    
			    driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("This is Article Page");
			    
			    //***PLZ HELP-UNABLE TO CLICK ON SUBMIT BUTTON***
			    
			    //driver.switchTo().defaultContent();
			    //driver.switchTo().frame("gsft_main");
			   // driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
			   // shadow.findElementByXPath("//button[@id='sysverb_insert_bottom']").click();
			    
			    
			    
			    
			    
			   
	}

}
