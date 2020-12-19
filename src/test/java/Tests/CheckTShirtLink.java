package Tests;

import BasePackage.TestClass;
import Pages.HomePage;
import Pages.TShirtPage;

public class CheckTShirtLink extends TestClass{

	@Override
	public void execute() {
		HomePage home=new HomePage();
		home.gotoTshirtPolos();
		TShirtPage tshirt=new TShirtPage();
		tshirt.gotoTShirt();
		
	}

}
