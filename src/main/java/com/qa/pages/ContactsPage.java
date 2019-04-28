package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath ="//a[@href='/contacts/new']")
	WebElement NewContactLink;
	
	@FindBy(name="first_name")
	WebElement FirstName;
	
	@FindBy(name="last_name")
	WebElement LastName;
	
	@FindBy(name="company")
	WebElement Company;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewContactsLink()
	{
		NewContactLink.click();
	}
	public void CreateNewContact(String fName, String lName, String company)
	{
		FirstName.sendKeys(fName);
		LastName.sendKeys(lName);
		Select sel = new Select(Company);
		sel.selectByVisibleText(company);
	}
	
	
}