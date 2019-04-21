package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	}
