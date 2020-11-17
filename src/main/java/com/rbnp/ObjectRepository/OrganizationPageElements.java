package com.rbnp.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPageElements {

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganization;
	
	public WebElement getCreateOrganization()
	{
		return createOrganization;
				
	}
}
