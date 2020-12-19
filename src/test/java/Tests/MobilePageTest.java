package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.TestClass;
import Pages.HomePage;

public class MobilePageTest extends TestClass{



	@Test
	public void execute() {

		HomePage home=new HomePage();
		boolean test1=false;
		home.gotoMobilePhone();
		test1=home.gotoMobilePhone();
		Assert.assertTrue(test1);
	}
	
		
	
}
