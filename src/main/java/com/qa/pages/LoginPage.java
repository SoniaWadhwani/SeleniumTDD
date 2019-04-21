package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
//	@FindBy(xpath="//span[contains(text(),'Log In')]")
//	WebElement login;
	
	@FindBy(xpath="//a[contains(@href,'https://ui.freecrm.com')]")
	WebElement login;

	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='ui']//div[contains(@class,'ui fluid large blue submit button') and contains(text(),'Login')]")
	WebElement loginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void login(String un, String ps)
	{
		username.sendKeys(un);
		password.sendKeys(ps);
		loginBtn.click();
		
	}
	
}
