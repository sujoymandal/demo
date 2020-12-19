package Pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import BasePackage.BaseClass;

public class HomePage extends BaseClass {

	private By PagmenuBtn = By.id("nav-hamburger-menu");

	private By mobileComputerMenu = By.xpath("//a/div[text()='Mobiles, Computers']");

	private By mobilePhone = By.xpath("//a[text()='All Mobile Phones']");

	private By mobileMenu = By.xpath("//a/span[normalize-space(text())='Mobiles & Accessories']");

	private By menFashion = By.xpath("//a/div[(text()=\"Men's Fashion\")]");
	
	private By tShirtPolo=By.xpath("//a[text()='T-shirts & Polos']");
	
	private By signInBtn=By.xpath("//span[text()='Hello. Sign in']");
	
	private By searchField=By.id("twotabsearchtextbox");
	
	private By submitBtn=By.xpath("//input[@value='Go']");

	public void gotoSignIn(){
		
		test.log(LogStatus.INFO, "gotoSignIn  Started..");

		clickElement(signInBtn);

		test.log(LogStatus.INFO, "gotoSignIn Ended..");
	}

	public void gotoMobileComputerMenu() {
		test.log(LogStatus.INFO, "gotoMobileComputerMenu  Started..");

		clickElement(PagmenuBtn);
		clickElement(mobileComputerMenu);

		test.log(LogStatus.INFO, "gotoMobileComputerMenu Ended..");
	}

	public void gotoMenFashionMenu() {
		test.log(LogStatus.INFO, "gotoMenFashionMenu started..");
		clickElement(PagmenuBtn);
		clickElement(menFashion);
		test.log(LogStatus.INFO, "gotoMenFashionMenu ended..");
	}

	public boolean gotoMobilePhone() {
		test.log(LogStatus.INFO, "gotoMobilePhone Started..");
		boolean present = false;
		gotoMobileComputerMenu();
		clickElement(mobilePhone);
		present = isElementDisplayed(mobileMenu);
		test.log(LogStatus.INFO, "gotoMobilePhone ended..");
		return present;

	}
	
	public void gotoTshirtPolos(){
		test.log(LogStatus.INFO, "gotoTshirtPolos started..");
		gotoMenFashionMenu();
		clickElement(tShirtPolo);
		test.log(LogStatus.INFO, "gotoTshirtPolos ended..");
	}
	
	public void searchItem(){
		//test.log(LogStatus.INFO, "searchItem started..");

		enterText(searchField, "laptop");
		clickElement(submitBtn);
		//test.log(LogStatus.INFO, "searchItem ended..");

	}

}
