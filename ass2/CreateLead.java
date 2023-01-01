package week5.day2.ass2;


//import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.openqa.selenium.chrome.ChromeDriver;


public class CreateLead extends CommonClass{
	
	@Parameters({"link3","cname", "fname", "lname", "ph", "sbutton"})
	@Test
	public void runcreatelead(String link3,String cname,String fname,String lname,String ph,String sbutton) {
		
		driver.findElement(By.linkText(link3)).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(ph);
		driver.findElement(By.name(sbutton)).click();
	
}
}






