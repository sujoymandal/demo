package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.TestClass;
import Pages.HomePage;

public class MenFashionPageTest extends TestClass{
	
	
	
	@Override
	public void execute() {

		HomePage home=new HomePage();
		home.gotoMenFashionMenu();
		Assert.assertTrue(true);
	}
	
	


}
