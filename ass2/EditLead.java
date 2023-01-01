package week5.day2.ass2;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditLead extends CommonClass{

	@Parameters({"pno","compname"})
	@Test
	public void editlead(String pno, String compname) throws InterruptedException {
		
	
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pno);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(compname);
		driver.findElement(By.name("submitButton")).click();
		
}
}





