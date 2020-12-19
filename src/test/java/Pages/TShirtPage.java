package Pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import BasePackage.BaseClass;

public class TShirtPage extends BaseClass{
	
	private By tShirts=By.xpath("//a[text()='T-shirts']");
	
 
	public void gotoTShirt(){
		
		test.log(LogStatus.INFO, "gotoTShirt  Started..");

		clickElement(tShirts);

		test.log(LogStatus.INFO, "gotoTShirt Ended..");
	}

}
