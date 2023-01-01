package week5.day2.ass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class serviceNowMobile {

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
			    shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog");
			    shadow.findElementByXPath("//mark[text()='Service Catalog']").click();
			    //1st shadow access iframe 
			    WebElement eframe= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
			    //switch to frame
			    driver.switchTo().frame(eframe);
			    driver.findElement(By.xpath("//img[@alt='Mobiles']")).click();
			    driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
			    driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
			    WebElement findElement = driver.findElement(By.xpath("//select[@id='IO:33494b069747011021983d1e6253af45']"));
			    findElement.click();
			    Select s=new Select(findElement);
			    
			    s.selectByValue("Unlimited");
			    driver.findElement(By.xpath("(//label[@class='radio-label'])[4]")).click();
			    driver.findElement(By.xpath("(//label[@class='radio-label'])[9]")).click();
			    driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
			    String text = driver.findElement(By.xpath("(//dl/dt)[1]")).getText();
			    String text1 = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
			    System.out.println(text1);
			    if(text.contains("Order Placed:")) {
			    	System.out.println("Order is Placed");
			    }
			    else {
			    	
			    	System.out.println("Order Not Placed");
			    }
	}

}
