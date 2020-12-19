package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.TestClass;
import Pages.HomePage;
import Pages.SearchPage;

public class SearchItemTest extends TestClass{

	@Test
	public void execute() {

		HomePage home=new HomePage();
		home.searchItem();
		SearchPage search=new SearchPage();
		Assert.assertEquals("\"laptop\"",search.getSearchText());
		//System.out.println(search.getSearchText());
	}

}
