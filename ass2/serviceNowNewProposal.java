package week5.day2.ass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class serviceNowNewProposal {

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
			    shadow.findElementByXPath("//input[@id='filter']").sendKeys("My Proposals");
			    shadow.findElementByXPath("//mark[text()='My Proposals']").click();
			    WebElement findElementByXPath = shadow.findElementByXPath("//iframe[@title='Main Content']");
			    driver.switchTo().frame(findElementByXPath);
			    driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
			    driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("Automation Demo");
			    driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
			    String text = driver.findElement(By.xpath("//table/tbody/tr[2]/td[8]")).getText();
			    System.out.println("New Proposal Date&Time" +text);
			    driver.close();
	}

}
