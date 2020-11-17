package com.rbnp.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadPageElements {

	@FindBy(css="img[title='Create Lead...']")
	private WebElement CreateLead;
	
	public WebElement getCreatedLead()
	{
		return CreateLead;
		
	}
}
