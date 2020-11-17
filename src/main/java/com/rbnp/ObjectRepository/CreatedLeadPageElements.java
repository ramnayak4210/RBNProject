package com.rbnp.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatedLeadPageElements {

	@FindBy(name="lastname")
	private WebElement lastnameTb;
	
	@FindBy(name="company")
	private WebElement companynameTb;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getLastNameTb()
	{
		return lastnameTb;
	}
	
	public WebElement getCompanyNameTb()
	{
		return companynameTb;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}

}
