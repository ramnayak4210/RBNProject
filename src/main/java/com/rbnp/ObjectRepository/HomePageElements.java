package com.rbnp.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rbnp.GenericLibarary.BaseClass;

public class HomePageElements extends BaseClass{

	@FindBy(xpath="(//a[text()='Leads'])[1]")
	private WebElement leads;
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organizations;
	
	@FindBy(xpath="(//a[text()='Contacts'])[1]")
	private WebElement contacts;
	
	@FindBy(xpath="//span[text()=' Administrator']//parent::td[@class='genHeaderSmall']//following-sibling::td[1]//img")
	private WebElement signOutDD;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	public WebElement getLeads()
	{
		return leads;
	}
	
	public WebElement getOrganizations()
	{
		return organizations;
	}
	
	public WebElement getContacts()
	{
		return contacts;
	}
	
	public WebElement getSignOutDD()
	{
		return signOutDD;
	}
	
	public WebElement getSignOutLink()
	{
		return signOutLink;
	}
	
	public void logOutFromApp()
	{
		wlib.keepMouseOnElement(signOutDD);
		signOutLink.click();
	}
}
