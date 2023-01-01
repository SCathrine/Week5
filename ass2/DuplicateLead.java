package week5.day2.ass2;


import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DuplicateLead extends CommonClass {
	
    @Parameters({"flink", "phno", "dlink", "subbutton"})
	@Test
	public void duplicateLead(String flink,String phno,String dlink,String subbutton) throws InterruptedException {
		
		driver.findElement(By.linkText(flink)).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phno);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText(dlink)).click();
		driver.findElement(By.name(subbutton)).click();
		
}
}






