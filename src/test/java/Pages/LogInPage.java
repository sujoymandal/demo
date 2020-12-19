package Pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import BasePackage.BaseClass;

public class LogInPage extends BaseClass{
	
	private By loginText=By.xpath("//h1[normalize-space(text()='Login')]");
	
	
	public boolean checkLoginPage(){
		test.log(LogStatus.INFO, "checkLoginPage Started..");
		boolean present = false;
		present = isElementDisplayed(loginText);
		test.log(LogStatus.INFO, "checkLoginPage ended..");
		return present;
	}

}
