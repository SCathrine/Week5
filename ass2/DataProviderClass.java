package week5.day2.ass2;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="create")
	public Object[][] createleaddataset() {
		
		Object[][] data=new Object[2][4]; //old method
		
		data[0][0]="cathrine";
		data[0][1]="selvaraj";
		data[0][2]="S";
		data[0][3]="123";
		
		data[1][0]="angelique";
		data[1][1]="rayar";
		data[1][2]="M";
		data[1][3]="123456";
		
		return data;
	}
	
	@DataProvider(name="duplicate")
	public Object[][] duplicateleaddataset() {
		
	return new Object[][]  //new method
			
			{
				{"123"},
				{"123456"},
			};	
		
	}
	
	
	
	
	
	

}
