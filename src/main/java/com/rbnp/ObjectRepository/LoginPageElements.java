package com.rbnp.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements {

	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement lgnBtn;
	
	@FindBy(xpath="//div[contains(text(),'You must specify a valid')]")
	private WebElement errMsg;
	
	public WebElement getUserName()
	{
		return username;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getLognBtn()
	{
		return lgnBtn;
	}
	
	public WebElement getErrMsg()
	{
		return errMsg;
	}
	
	public void loginToApp(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		lgnBtn.click();
	}
}
