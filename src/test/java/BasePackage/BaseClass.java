package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
	//public WebDriver driver;
	public static WebDriver driver=null;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String browser;

	//This is master class
	public BaseClass(){
		
		if(System.getenv("Browser")!=null && !System.getenv("Browser").isEmpty()){
			browser=System.getenv("Browser");
		}
		else
			browser=readProperty("Browser");
			if(driver == null){
			String url=readProperty("Url");
			String driverPath=System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			if(browser.equalsIgnoreCase("chrome")){
				driver=new ChromeDriver();
				
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(url);
			
			//Reporting
			//setReport();
			
			}
		}
	
	
	public String readProperty(String key){
		String value=null;
		String propPath=System.getProperty("user.dir")+"\\src\\test\\resources\\Property.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File(propPath));
			prop=new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
			} 
					
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return value;
	}
	
	
	
	
	public void clickElement(By element){

		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).click();
		
	}
	
	public void enterText(By element,String textToBeEntered){
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).sendKeys(textToBeEntered);
		
	}
	
	public String getText(By element){
		WebDriverWait wait=new WebDriverWait(driver,30);
		String text=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).getText();
		return text;
	}
	
	public boolean isElementDisplayed(By element){
		WebDriverWait wait=new WebDriverWait(driver,30);
		boolean present=false;
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			present=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return present;
	}
	
	
	public  String takeScreenshot(String name){
		String dest=System.getProperty("user.dir")+"\\screenshots\\"+name+".png";
		System.out.println(dest);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest;
	}
	
	public void quitBrowser(){
		//report.flush();
		driver.quit();
		driver=null;
	}
	
	public void setReport(){
		String reportPath=System.getProperty("user.dir")+"\\target\\TestReport.html";
		String configFilePath=System.getProperty("user.dir")+"\\src\\test\\resources\\ReportsConfig.xml";
		
		report=new ExtentReports(reportPath,true,DisplayOrder.OLDEST_FIRST);
		report.loadConfig(new File(configFilePath));
				
	}
	
	public static boolean setTestCase(String testCaseName){
		boolean testStatus=false;
		String sheetPath=System.getProperty("user.dir")+"\\src\\test\\resources\\TestManager.xlsx";
		try {
			FileInputStream fis=new FileInputStream(new File(sheetPath));
			
				XSSFWorkbook book=new XSSFWorkbook(fis);
				XSSFSheet sheet=book.getSheet("Run Master");
				int rowNum=sheet.getLastRowNum();
		//		System.out.println(rowNum);
				for(int i=1;i<=rowNum;i++){
					if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName)){
					if(sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase("Yes")){
						testStatus=true;
						break;
					}
					}
					////String s=sheet.getRow(i).getCell(0).getStringCellValue();
					//System.out.println(s);
				}
				
		}		
		 catch (Exception e) {
			e.printStackTrace();
		}
		return testStatus;
		
	}


}
