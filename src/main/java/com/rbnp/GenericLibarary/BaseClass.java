package com.rbnp.GenericLibarary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.rbnp.ObjectRepository.HomePageElements;
import com.rbnp.ObjectRepository.LoginPageElements;

public class BaseClass {

	public static WebDriver driver;
	public DataUtility data = new DataUtility();
	public WebDriverCommonUtils wlib = new WebDriverCommonUtils();
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println(".........DataBase Connect.............");
	}
	@BeforeClass
	public void configBC() throws IOException
	{
		System.out.println("......Browser launching Starts........");
		String browser = data.getDataFromProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}/*else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckpdriver.exe");
			driver = new FirefoxDriver();
		}*/
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(data.getDataFromProperty("url"));
		System.out.println(".......Browser Lauching ends.......");
	}
	@BeforeMethod
	public void configBM() throws IOException
	{
		System.out.println("......Login Starts...........");
		
		LoginPageElements login = PageFactory.initElements(driver, LoginPageElements.class);
		login.loginToApp(data.getDataFromProperty("username"), data.getDataFromProperty("password"));
		System.out.println(".....Login ends........");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("......Logout Starts......");
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		hp.logOutFromApp();
		
		System.out.println("........Logout ends.........");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println(".......Browser close.........");
		driver.quit();
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println(".......DataBase Disconnect.........");
	}
}
