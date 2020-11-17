package com.rbnp.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationInfoPageElements {

	@FindBy(xpath="//span[contains(text(),'Organization Information')]")
	private WebElement SuccessMsg;
	
	public WebElement getSuccessMsg()
	{
		return SuccessMsg;
		
	}
}
