package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'SONIA WADHWANI')]")
	WebElement user;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
		
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUserName()
	{
		return user.isDisplayed();
	}
	public void clickonContactsLink()
	{
		contactsLink.click();
	}

}
