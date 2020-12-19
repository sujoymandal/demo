package Pages;

import org.openqa.selenium.By;

import BasePackage.BaseClass;

public class SearchPage extends BaseClass{
	
	private By searchItem=By.xpath("//*[@class='a-color-state a-text-bold']");
	
	public String getSearchText(){
		
		return getText(searchItem);		
	}

}
