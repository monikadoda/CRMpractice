package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginpageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginpageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		 loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginpageTitleTest()
	{
		String title=loginpage.loginpagevalidate();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void CrmlogoimgTest()
	{
		Boolean flag=loginpage.validateCrmImg();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest()
	{
	   homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	/*@AfterMethod
	public void peardown()
	{
		driver.close();
	}*/

}
