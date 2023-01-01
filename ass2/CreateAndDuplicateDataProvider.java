package week5.day2.ass2;


//import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
//import org.openqa.selenium.chrome.ChromeDriver;


public class CreateAndDuplicateDataProvider extends CommonClassDataProvider{
	
	
	@Test(dataProvider="create",dataProviderClass=DataProviderClass.class)
	public void runcreatelead(String cname,String fname,String lname,String ph) {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(ph);
		driver.findElement(By.name("submitButton")).click();
	
}
	
	@Test(dataProvider="duplicate",dataProviderClass=DataProviderClass.class)
	public void duplicateLead(String phno) throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phno);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
}
	
	
}






