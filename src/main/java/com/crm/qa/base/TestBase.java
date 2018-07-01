package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utility.Testutil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase()
	
	{
	try{
		prop = new Properties();
		FileInputStream ip=new FileInputStream("C://Users//Gagan//workspace//FreeCRMTestAutomation//src//main//java//com//crm//qa//config//config.properties");
		prop.load(ip);
		
	}catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}catch(IOException e)
	{
		e.printStackTrace();
	}
	
	
		
		
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("crome"))
		{
			System.setProperty("webdriver.crome.driver", "C://Users/Gagan/Downloads/chromedriver_win32.chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","C://Users/Gagan/Downloads/geckodriver-v0.17.0-win64/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(Testutil.Page_Load_Timeout, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Testutil.implicity_Wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
