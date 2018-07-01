package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//pageFactory
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="button[contains(text(),'Sign Up')]")
	WebElement signup; 	
	 	 	
	@FindBy(xpath="img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	//initializing the page object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String loginpagevalidate()
	{
		return driver.getTitle();
	}
	
    public boolean validateCrmImg()
    {
    	return crmlogo.isDisplayed();
    }
    
    public HomePage login(String uname, String pass)
    {
    	username.sendKeys(uname);
    	password.sendKeys(pass);
    	login.click();
    	return new HomePage();
    }
}
