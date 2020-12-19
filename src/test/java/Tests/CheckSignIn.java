package Tests;

import org.testng.Assert;

import BasePackage.TestClass;
import Pages.HomePage;
import Pages.LogInPage;

public class CheckSignIn extends TestClass{

	@Override
	public void execute() {

		HomePage home=new HomePage();
		home.gotoSignIn();
		LogInPage log=new LogInPage();
		Assert.assertTrue(log.checkLoginPage());
	}

}
